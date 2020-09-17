package com.lucky;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author zhourj
 * @date 2020/8/25 18:14
 */
public class NgEngineTest {
	@BeforeClass
	public void setUp() {
		// code that will be invoked when this test is instantiated
		System.out.println("setUp");
	}

	@Test(groups = { "fast" })
	public void aFastTest() {
		System.out.println("Fast test");
	}

	@Test(groups = { "slow" })
	public void aSlowTest() {
		System.out.println("Slow test");
	}
}
