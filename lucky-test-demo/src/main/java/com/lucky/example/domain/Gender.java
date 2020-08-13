package com.lucky.example.domain;

/**
 * @author zhourj
 * @date 2020/8/13 13:50
 */
public enum Gender {
	/**
	 * 女
	 */
	F("女"),
	/**
	 * 男
	 */
	M("男");
	/**
	 * 性别昵称
	 */
	private final String name;

	Gender(String name) {
		this.name = name;
	}
}
