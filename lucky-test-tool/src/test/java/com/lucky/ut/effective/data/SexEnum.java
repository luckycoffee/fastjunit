package com.lucky.ut.effective.data;

/**
 * @author zhourj
 * @date 2020/9/21 10:17
 */
public enum SexEnum {
	MAN("1","男"),
	FEMALE("0","女");
	private String code;
	private String name;

	SexEnum(String code,String name){
		this.code = code;
		this.name = name;
	}
}
