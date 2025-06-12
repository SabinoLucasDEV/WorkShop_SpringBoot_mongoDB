package com.sabino.WorkShop.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sabino.WorkShop.Domain.Post;
import com.sabino.WorkShop.Domain.User;
import com.sabino.WorkShop.Repository.PostRepository;
import com.sabino.WorkShop.Service.Exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	public PostRepository repo;

	public List<Post> findAll() {
		return repo.findAll();
	}
	
	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		}
	
	public List<Post> findByTitle(String text) {
		 return repo.findByTitleContainingIgnoreCase(text);
	}
}
