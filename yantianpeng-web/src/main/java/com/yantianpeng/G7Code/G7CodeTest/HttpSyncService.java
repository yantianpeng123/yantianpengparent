package com.yantianpeng.G7Code.G7CodeTest;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.http.NoHttpResponseException;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;


public class HttpSyncService{
	private static PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
	private static CloseableHttpClient httpClient =  null;
	static {
		cm.setMaxTotal(128);
		cm.setDefaultMaxPerRoute(64);
		httpClient = HttpClients.custom()
				.setConnectionManager(cm)
				.build();
	}
	public static String requestGet(String routerUrl, Map<String,Object> params) throws Exception {
		return requestPost(routerUrl,params);
	}
	public static String requestPost(String routerUrl, Map<String,Object> params) throws Exception {
		CloseableHttpResponse  rs  = null;
		String result = null;
		final HttpPost httpPost = new HttpPost(routerUrl);
		try {
			httpPost.addHeader("User-Agent", "deneb-client");
			httpPost.setEntity(dealParams(params,routerUrl));
			rs = httpClient.execute(httpPost);
			if(rs.getStatusLine().getStatusCode()!=200) {
				httpPost.releaseConnection();
				throw new RouterException(100010,"服务状态异常，"+rs.getStatusLine().getStatusCode());
			}
			result =  EntityUtils.toString(rs.getEntity(), "UTF-8");
		}catch (NoHttpResponseException e) {
			httpPost.releaseConnection();
			result = retryHttpPost(params, routerUrl);
		}catch (ParseException | IOException e) {
			httpPost.releaseConnection();
			throw new RuntimeException(e);
		}
		finally{
			httpPost.releaseConnection();
			if(rs!=null) {
				try {
					rs.close();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
		}
		return result;
	}
	private static String retryHttpPost(Map<String,Object> params,String url) throws ParseException, IOException{
		CloseableHttpResponse  rs  = null;
		CloseableHttpClient client = HttpClients.createDefault();
		final HttpPost post = new HttpPost(url);
		String result = null;
		try {
			post.addHeader("User-Agent", "deneb-core");
			post.setEntity(dealParams(params,url));
			rs = client.execute(post);
			if(rs.getStatusLine().getStatusCode()!=200) {
				post.releaseConnection();
				throw new RouterException(100010,"服务状态异常，"+rs.getStatusLine().getStatusCode());
			}
			result = EntityUtils.toString(rs.getEntity(), "UTF-8");
		}catch (NoHttpResponseException e) {
			post.releaseConnection();
			throw new RouterException(100010,"地址无响应");
		}
		catch (IOException e) {
			throw new RuntimeException(e);
		}finally{
			post.releaseConnection();
			client.close();
			if(rs!=null) {
				try {
					rs.close();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
		}
		return result;
	}
	private static StringEntity dealParams(Map<String,Object> params,String url) {
		StringBuilder sb = null;
		if(params!=null){
			sb =new StringBuilder();
			for(Entry<String, Object> e : params.entrySet()){
				try {
					sb.append(e.getKey())
					.append("=")
					.append(URLEncoder.encode(e.getValue()==null?"":e.getValue().toString(), "UTF-8"))
					.append("&");
				} catch (Exception ex) {
					throw new RuntimeException(ex);
				}
			}
			if(sb.length()>=1)
			sb.deleteCharAt(sb.length()-1);
		}
		StringEntity entity;
		try {
			entity = new StringEntity(sb.toString(),"UTF-8");
			entity.setContentType("application/x-www-form-urlencoded;charset=utf-8");
			entity.setContentEncoding("UTF-8");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return entity;
	}
}