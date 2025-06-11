package com.sabino.WorkShop.Resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sabino.WorkShop.DTO.UserDto;
import com.sabino.WorkShop.Domain.Post;
import com.sabino.WorkShop.Domain.User;
import com.sabino.WorkShop.Service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	public UserService service;
	
	@GetMapping
	public ResponseEntity<List<UserDto>> findAll() {
		List<User> list = service.findAll();
		List<UserDto> listDto = list.stream().map(x -> new UserDto(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
		
		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDto> findById(@PathVariable String id) {
		User user = service.findById(id);
		UserDto userDto = new UserDto(user);
		return ResponseEntity.ok().body(userDto);
		
		
	}
	@PostMapping
	public ResponseEntity<Void> Insert(@RequestBody UserDto obj) {
		
		User user = service.fromDTO(obj);
		service.insert(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
		
		
	}
	@DeleteMapping(value = "/{id}")
 	public ResponseEntity<Void> delete(@PathVariable String id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@RequestBody UserDto obj,@PathVariable String id) {
		User user = service.fromDTO(obj);
		user.setId(id);
		service.update(user);
		return ResponseEntity.noContent().build();
		
		
	}
	@GetMapping(value = "/{id}/posts")
	public ResponseEntity<List<Post>> findPost(@PathVariable String id) {
		User user = service.findById(id);
		return ResponseEntity.ok().body(user.getPosts());
		
		
	}
	

}
