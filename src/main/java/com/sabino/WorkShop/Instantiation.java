package com.sabino.WorkShop;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.sabino.WorkShop.Domain.Post;
import com.sabino.WorkShop.Domain.User;
import com.sabino.WorkShop.Repository.PostRepository;
import com.sabino.WorkShop.Repository.UserRepository;

@Configuration
public class Instantiation  implements CommandLineRunner{

	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	@Autowired
	private UserRepository userRepsitory;
	
	@Autowired
	private PostRepository postRepsitory;
	
	
	
	@Override
	public void run(String... args) throws Exception {
		userRepsitory.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		Post post = new Post(null, maria , sdf.parse("21/03/2018"), "Partiu viagem", "to indo viajar");
		Post post2 = new Post(null, alex , sdf.parse("21/03/2018"), "bom dia", "acordei");
		
		userRepsitory.saveAll( Arrays.asList(maria,alex,bob));
		postRepsitory.saveAll(Arrays.asList(post, post2));
		
		
	}

}
