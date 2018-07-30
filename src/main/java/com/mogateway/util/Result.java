package com.mogateway.util;

public class Result implements java.io.Serializable{

	private static final long serialVersionUID = 3893342682938650130L;

	
	private String code = "40001";
	
	private String message = "系统内部故障"; 
	
    private Object data;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
    
	public void addError(String code, String message){
		this.code = code;
		this.message = message;
	}
	public void addSuccess(Object data){
		this.data = data;
		this.message = "操作成功";
		this.code = "0";
	}
	
}
