package com.yantianpeng.G7Code.G7CodeTest;
import java.util.Map;

import com.alibaba.fastjson.JSON;

public class HttpService  {
	/**
	 * 调用指定方法
	 * @param routerUrl deneb地址
	 * @param appkey appkey
	 * @param method 要调用的方法名
	 * @param appsecret appsecret
	 * @param params 自定义参数集
	 * @return
	 */
	public static Result callFuntion(String routerUrl, String appkey,String method ,String appsecret, Map<String,Object> params)  {
		params = ParamUtils.dealParams(params, method, appkey, appsecret);
		try{
			return dealData(params, routerUrl);
		}catch(RouterException e){
			Result r = new Result();
			r.setCode(e.getCode());
			r.setMessage(e.getMessage());
			r.setData("");
			r.setParams(params);
			return r;
		}
	}
	
	private  static  Result dealData( Map<String,Object> params,String routerUrl) {
		Result result = new Result();
		String data = null;
		try{
			data = HttpSyncService.requestPost(routerUrl, params);
			
			Map<String,Object> map = JSON.parseObject(data);
			if(map !=null
					&&
					(map.containsKey("code")
							||map.containsKey("data")
							||map.containsKey("message"))){
				result.setCode(map.get("code")==null?0:(int)Float.parseFloat(map.get("code").toString()));
				result.setData(map.get("data"));
				result.setMessage(map.get("message")==null?"null":map.get("message").toString());
			}else{
				result.setData(data);
				result.setMessage("调用成功");
			}
		}catch(Exception e){
			e.printStackTrace();
			result.setCode(100011);
			result.setData(data);
			result.setMessage("参数异常,请检查参数!");
		}
		return result;
	}
}
