package org.ic4j.samples.helloworld;

import java.io.Serializable;

public class Fisher implements Serializable {

	private static final long serialVersionUID = 3443780811711094611L;

	private String id;
	private String city;
	private String name;

	private int age;

	public Fisher() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
