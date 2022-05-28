package com.example.demo.enums;

public enum GenderEnum {
	FEMALE("F"),
	MALE("M");
	private String code;
	GenderEnum(String code){
		this.code=code;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
}
