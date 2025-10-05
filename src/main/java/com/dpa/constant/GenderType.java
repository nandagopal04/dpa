package com.dpa.constant;

public enum GenderType {

	MALE("MALE"), FEMALE("FEMALE"), OTHER("OTHER");

	private String code;

	private GenderType(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

}
