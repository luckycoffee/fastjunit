package com.lucky.example.testng;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * @author zhourj
 * @date 2020/8/25 18:14
 */
public class JunitEngineTest {
	@BeforeAll
	public static void setUp() {
		// code that will be invoked when this test is instantiated
	}

	@Test()
	public void aFastTest() {
		System.out.println("Fast test");
	}

	@Test()
	public void aSlowTest() {
		System.out.println("Slow test");
	}
}
