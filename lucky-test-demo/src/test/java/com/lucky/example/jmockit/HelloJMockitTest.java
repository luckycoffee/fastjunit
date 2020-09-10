package com.lucky.example.jmockit;

import mockit.Expectations;
import mockit.Mock;
import mockit.MockUp;
import mockit.integration.junit5.JMockitExtension;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Locale;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author zhourj
 * @date 2020/9/10 11:06
 */
@ExtendWith(JMockitExtension.class)
public class HelloJMockitTest {
	/**
	 * 测试场景：当前是在中国
	 */
	@Test
	public void testSayHelloAtChina() {
		new MockUp<Locale>(){
			@Mock
			public Locale getDefault() {
				// 假设当前位置是在中国
				return Locale.CHINA;
			}
		};
		// 断言说中文
		assertEquals("你好，JMockit!",(new HelloJMockit()).sayHello());

	}

	/**
	 * 测试场景：当前是在美国
	 */
	@Test
	public void testSayHelloAtUS() {
		new MockUp<Locale>(){
			@Mock
			public Locale getDefault() {
				// 假设当前位置是在美国
				return Locale.US;
			}
		};

		// 断言说英文
		assertEquals("Hello，JMockit!",(new HelloJMockit()).sayHello());
	}

	@Test
	public void aa(){
		HelloJMockit helloJMockit = new HelloJMockit();
		new Expectations(helloJMockit) {
			{
				helloJMockit.sayHello();
				result = "hi";
			}
		};
		assertEquals("hi",helloJMockit.sayHello());
	}
}
