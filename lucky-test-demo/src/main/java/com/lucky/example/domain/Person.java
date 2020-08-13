package com.lucky.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

/**
 * @author zhourj
 * @date 2020/8/13 13:36
 */
@Data
@AllArgsConstructor
public class Person {
	private String firstName;
	private String lastName;
	private Gender gender;
	private LocalDate dateOfBirth;

}
