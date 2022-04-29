package com.cjpnice.todo.utils;

import java.io.Serializable;

/**
 * @author cjpnice
 */
public class Result implements Serializable {
	//状态,成功：200，失败：-1
	private int code;
	//消息
	private String message;
	//数据
	private Object data;
	//get、set方法


	@Override
	public String toString() {
		return "Result{" +
				"code=" + code +
				", message='" + message + '\'' +
				", data=" + data +
				'}';
	}
	public static Result success(Object o, String msg){
		Result result = new Result();
		result.setCode(200);
		result.setMessage(msg);
		result.setData(o);
		return result;
	}
	public static Result error(Object o, String msg){
		Result result = new Result();
		result.setCode(-1);
		result.setMessage(msg);
		result.setData(o);
		return result;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
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
}
