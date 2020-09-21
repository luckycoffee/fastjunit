package com.lucky.ut.effective.data.category;

import java.time.LocalDateTime;

/**
 * @author zhourj
 * @date 2020/9/18 12:16
 */
public class LocalDateTimeProvider implements Provider<LocalDateTime> {

	public LocalDateTimeProvider(String ... params){

	}
	@Override
	public LocalDateTime generate() {
		return LocalDateTime.now();
	}
}
