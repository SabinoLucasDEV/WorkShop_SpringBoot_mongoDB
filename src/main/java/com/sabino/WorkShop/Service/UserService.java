package com.sabino.WorkShop.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sabino.WorkShop.Domain.User;
import com.sabino.WorkShop.Repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	public UserRepository repo;

	public List<User> findAll() {
		return repo.findAll();
	}
}
