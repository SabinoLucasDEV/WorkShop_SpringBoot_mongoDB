package com.sabino.WorkShop.DTO;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.sabino.WorkShop.Domain.User;


public class UserDto implements Serializable {
	private static final long serialVersionUID = 1L;

	
	
	private String id;
	private String name;
	private String email;
	
	public UserDto() {}
	
	@JsonCreator
	public UserDto(User obj) {
	id = obj.getId();
	name = obj.getName();
	email = obj.getEmail();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
