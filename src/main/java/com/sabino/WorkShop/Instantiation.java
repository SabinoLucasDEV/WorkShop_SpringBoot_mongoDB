package com.sabino.WorkShop;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.sabino.WorkShop.Domain.User;
import com.sabino.WorkShop.Repository.UserRepository;
import com.sabino.WorkShop.Service.UserService;

@Configuration
public class Instantiation  implements CommandLineRunner{

	@Autowired
	private UserRepository userRepsitory;
	
	
	
	
	@Override
	public void run(String... args) throws Exception {
		userRepsitory.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepsitory.saveAll( Arrays.asList(maria,alex,bob));
		
		
	}

}
