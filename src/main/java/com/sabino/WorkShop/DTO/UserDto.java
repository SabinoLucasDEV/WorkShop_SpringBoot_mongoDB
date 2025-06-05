package com.sabino.WorkShop.DTO;

import java.beans.Beans;
import java.beans.beancontext.BeanContext;

import org.springframework.context.support.BeanDefinitionDsl.BeanSupplierContext;
import org.yaml.snakeyaml.introspector.BeanAccess;

import com.sabino.WorkShop.Domain.User;

public class UserDto {

	
	
	private String id;
	private String name;
	private String email;
	
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
