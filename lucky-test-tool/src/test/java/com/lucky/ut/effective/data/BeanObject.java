package com.lucky.ut.effective.data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * @author zhourj
 * @date 2020/9/18 14:39
 */
public class BeanObject implements Serializable {
	private Long id;
	private String name;
	private Integer age;
	private Float cases;
	private Double money;
	private LocalDate birthDate;
	private SubBeanObject car;
	private List<SubBeanObject> friends;
	private SubBeanObject[] girlFriends;
	private SexEnum sex;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public SubBeanObject getCar() {
		return car;
	}

	public void setCar(SubBeanObject car) {
		this.car = car;
	}

	public List<SubBeanObject> getFriends() {
		return friends;
	}

	public void setFriends(List<SubBeanObject> friends) {
		this.friends = friends;
	}

	public SubBeanObject[] getGirlFriends() {
		return girlFriends;
	}

	public void setGirlFriends(SubBeanObject[] girlFriends) {
		this.girlFriends = girlFriends;
	}

	public SexEnum getSex() {
		return sex;
	}

	public void setSex(SexEnum sex) {
		this.sex = sex;
	}

	public Float getCases() {
		return cases;
	}

	public void setCases(Float cases) {
		this.cases = cases;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}
}
