package com.yantianpeng.G7Code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**

* @Description:    G7Http 请求帮助类

* @Author:        yantianpeng

* @CreateDate:     2018/11/27 下午4:54


*/
public class HttpSyncService {

    public static void main(String[] args) {

        Map<String,Object> map = new HashMap<>();
        map.put("foo","1");
        map.put("bar","2");
        map.put("baz","3");
        String secret="test";
        String sendPost = sendPost(new AllAdressUtil().
                getProperties("G7_interfaceurl"), map);
    }


    public static String sendPost(String url ,Map<String,Object> params){
        ParamUtil.sign(params,new AllAdressUtil().getProperties("G7_interfaceurl"));
        OutputStreamWriter out = null;
        BufferedReader in = null;
        StringBuilder result = new StringBuilder();
        try{
            URL realUrl = new URL(url);
            HttpURLConnection conn =(HttpURLConnection) realUrl.openConnection();
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // POST方法
            conn.setRequestMethod("POST");
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "deneb-core");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.connect();
            out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
            String dealParams = dealParams(params,url);
           // String decode = URLDecoder.decode(dealParams, "utf-8");
            out.write(dealParams);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result.append(line);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return  result.toString();
    }


    public static String dealParams(Map<String,Object> params,String url){
        StringBuilder  stringBuilder = null;
        if(params!=null){
            stringBuilder = new StringBuilder();
            for (Map.Entry<String,Object> entry:params.entrySet()) {
                try {
                    stringBuilder.append(entry.getKey()).append("=");
                    stringBuilder.append(URLEncoder.encode(entry.getValue()==null?"":entry.getValue().toString(),
                            "utf-8"));
                    stringBuilder.append("&");
                }catch (Exception ex){
                    throw  new RuntimeException(ex);
                }
            }
            if(stringBuilder.length()>=1)stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }

       return stringBuilder.toString();
    }
}
