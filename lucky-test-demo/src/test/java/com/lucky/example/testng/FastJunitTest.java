package com.lucky.example.testng;


import com.lucky.testng.TestNg;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

	@TestNg(groups = { "fast" })
	public void testNgTest() {
		System.out.println("Fast test");
	}

	@org.testng.annotations.Test(groups = { "fast" })
	public void testNg() {
		System.out.println("Fast test");
	}

}
