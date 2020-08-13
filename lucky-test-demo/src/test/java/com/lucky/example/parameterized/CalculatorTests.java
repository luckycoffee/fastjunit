package com.lucky.example.parameterized;

import com.lucky.example.application.Calculator;
import com.lucky.example.domain.Gender;
import com.lucky.example.domain.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.AggregateWith;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author zhourj
 * @date 2020/8/13 9:51
 */
public class CalculatorTests {
	@Test
	@DisplayName("1 + 1 = 2")
	void addsTwoNumbers() {
		Calculator calculator = new Calculator();
		assertEquals(2, calculator.add(1, 1), "1 + 1 should equal 2");
	}

	@ParameterizedTest(name = "{0} + {1} = {2}")
	@CsvSource({
			"0,    1,   1",
			"1,    2,   3",
			"49,  51, 100",
			"1,  100, 101"
	})
	void add(int first, int second, int expectedResult) {
		Calculator calculator = new Calculator();
		assertEquals(expectedResult, calculator.add(first, second),
				() -> first + " + " + second + " should equal " + expectedResult);
	}

	@ParameterizedTest
	@CsvFileSource(resources = "/data/two-column.csv", numLinesToSkip = 1)
	void testWithCsvFileSource(String country, int reference) {
		assertNotNull(country);
		assertNotEquals(0, reference);
	}

	@ParameterizedTest
	@CsvSource({
			"Jane, Doe, F, 1990-05-20",
			"John, Doe, M, 1990-10-22"
	})
	void testWithArgumentsAggregator(@AggregateWith(PersonAggregator.class) Person person) {
		if (person.getFirstName().equals("Jane")) {
			assertEquals(Gender.F, person.getGender());
		}
		else {
			assertEquals(Gender.M, person.getGender());
		}
		assertEquals("Doe", person.getLastName());
		assertEquals(1990, person.getDateOfBirth().getYear());
	}

}
