package com.ensimag.banknetwork.server.bank;

import com.ensimag.api.bank.IUser;

public class User implements IUser {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3298627352760948734L;

	private String name;
	private String firstName;
	private String age;
	
	public User(String name, String firstName, String age) {
		super();
		this.name = name;
		this.firstName = firstName;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getAge() {
		return age;
	}

}
