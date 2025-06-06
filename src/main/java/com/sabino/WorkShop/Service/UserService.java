package com.sabino.WorkShop.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sabino.WorkShop.DTO.UserDto;
import com.sabino.WorkShop.Domain.User;
import com.sabino.WorkShop.Repository.UserRepository;
import com.sabino.WorkShop.Service.Exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	public UserRepository repo;

	public List<User> findAll() {
		return repo.findAll();
	}
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		}
	
	public User insert(User obj) {
		return repo.insert(obj);
		
	}
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	public User update(User obj) {
		User newObj = findById(obj.getId());
		upData(newObj, obj);
		return repo.save(newObj);
	}
	 
	private void upData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
		
	}
	public User fromDTO(UserDto	 objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
}
