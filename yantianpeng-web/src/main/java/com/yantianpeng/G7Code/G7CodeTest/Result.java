package com.yantianpeng.G7Code.G7CodeTest;

import java.util.Map;

public class Result {
	private int code;
	private String message;
	private Map<String,Object> params;
	private Object data;
	
	public Result() {
		code = 0;
	}
	public Result(int code) {
		this.code = code;
		this.message = "";
	}	
	public Result(int code, String msg) {
		this.code = code;
		this.message = msg;
	}
	public Result(Object data) {
		this();
		setData(data);
	}	
	public Object getData() {
		return data;
	}
	@Override
	public String toString() {
		return "{\"code\":" + code + ", \"message\":" + message + ", \"params\":"
				+ params + ", \"data\":" + data + "}";
	}
	public void setData(Object data) {
		this.data = data;
	}
	public int getCode() {
		return code;
	}
	public String getMessage() {
		return message;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Map<String,Object> getParams() {
		return params;
	}
	public void setParams(Map<String,Object> params) {
		this.params = params;
	}
}
