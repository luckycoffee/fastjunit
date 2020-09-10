package com.lucky.example.jmockit;

import java.util.Locale;

/**
 * @author zhourj
 * @date 2020/9/10 11:03
 */
public class HelloJMockit {
	// 向JMockit打招呼
	public String sayHello() {
		Locale locale = Locale.getDefault();
		if (locale.equals(Locale.CHINA)) {
			// 在中国，就说中文
			return "你好，JMockit!";
		} else {
			// 在其它国家，就说英文
			return "Hello，JMockit!";
		}
	}
}
