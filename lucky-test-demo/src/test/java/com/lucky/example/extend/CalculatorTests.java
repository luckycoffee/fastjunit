package com.lucky.example.extend;

import com.lucky.example.application.Calculator;
import com.lucky.ut.effective.annotation.LuckyTest;
import com.lucky.ut.effective.extend.RandomParametersExtension;
import com.lucky.ut.effective.runner.LuckyRunner;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author zhourj
 * @date 2020/8/13 9:51
 */
@LuckyRunner
public class CalculatorTests {

	@LuckyTest(description = "自定义的测试注解")
	void addsTwoNumbers() {
		Calculator calculator = new Calculator();
		assertEquals(2, calculator.add(1, 1), "1 + 1 should equal 2");
	}

	@ExtendWith(RandomParametersExtension.class)
	@Test
	void test(@RandomParametersExtension.Random int i) {
		// ...
	}

	@LuckyTest(description = "测试max方法")
	void testMax() {
		Calculator calculator = new Calculator();
		assertEquals(2, calculator.max(1, 2));
	}

}
