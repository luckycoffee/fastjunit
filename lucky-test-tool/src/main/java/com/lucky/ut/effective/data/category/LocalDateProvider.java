package com.lucky.ut.effective.data.category;

import java.time.LocalDate;

/**
 * @author zhourj
 * @date 2020/9/18 12:16
 */
public class LocalDateProvider implements Provider<LocalDate> {
	public LocalDateProvider(String ... params){

	}

	@Override
	public LocalDate generate() {
		return LocalDate.now();
	}
}
