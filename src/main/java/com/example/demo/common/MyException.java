package com.example.demo.common;

public class MyException extends RuntimeException {

    public MyException(String code, String msg) {
        this.setCode(code);
        this.setMsg(msg);
    }

    public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	private String code;
    private String msg;

    // getter & setter
}