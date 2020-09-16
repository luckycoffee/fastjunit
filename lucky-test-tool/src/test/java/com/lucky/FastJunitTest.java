package com.lucky;

import org.junit.jupiter.api.*;

/**
 * @author zhourj
 * @date 2020/8/25 18:14
 */
public class FastJunitTest {
	@BeforeAll
	public static void setUp() {
		// code that will be invoked when this test is instantiated
	}

	@Test
	@DisplayName("单元测试-Example-1")
	public void exampleTest1() {
		Assertions.assertTrue(true);
	}

	@Test
	@DisplayName("单元测试-Example-2")
	public void exampleTest2() {
		Assertions.assertTrue(true);
	}

	@org.testng.annotations.Test(groups = { "fast" })
	@Disabled
	public void luckyTestNgTest() {
		System.out.println("luckyTestNgTest");
	}

}
