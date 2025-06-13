package com.sabino.WorkShop;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.aggregation.ArithmeticOperators.Add;

import com.sabino.WorkShop.DTO.AuthorDTO;
import com.sabino.WorkShop.DTO.ComentDTO;
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
		postRepsitory.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepsitory.saveAll( Arrays.asList(maria,alex,bob));
		
		Post post = new Post(null, new AuthorDTO(maria) , sdf.parse("21/03/2018"), "Partiu viagem", "to indo viajar");
		Post post2 = new Post(null, new AuthorDTO(maria) , sdf.parse("21/03/2018"), "bom dia", "acordei");
		
		
		ComentDTO c1 = new ComentDTO("Boa viagem mano!", sdf.parse("21/03/2018"), new AuthorDTO(alex));
		ComentDTO c2 = new ComentDTO("Aproveite", sdf.parse("22/03/2018"), new AuthorDTO(bob));
		ComentDTO c3 = new ComentDTO("Tenha um ótimo dia!", sdf.parse("23/03/2018"), new AuthorDTO(alex));
		
		post.getComents().addAll(Arrays.asList(c1, c2));
		post2.getComents().addAll(Arrays.asList(c3));
		
		postRepsitory.saveAll(Arrays.asList(post, post2));
		
		maria.getPosts().addAll(Arrays.asList(post));
		userRepsitory.save(maria);
		
		
		
	}

}
