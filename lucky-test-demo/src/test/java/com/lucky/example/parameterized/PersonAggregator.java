package com.lucky.example.parameterized;

import com.lucky.example.domain.Gender;
import com.lucky.example.domain.Person;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.aggregator.ArgumentsAggregator;

import java.time.LocalDate;

/**
 * @author zhourj
 * @date 2020/8/13 13:35
 */
public class PersonAggregator implements ArgumentsAggregator {
	@Override
	public Person aggregateArguments(ArgumentsAccessor arguments, ParameterContext context) {
		return new Person(arguments.getString(0),
				arguments.getString(1),
				arguments.get(2, Gender.class),
				arguments.get(3, LocalDate.class));
	}
}
