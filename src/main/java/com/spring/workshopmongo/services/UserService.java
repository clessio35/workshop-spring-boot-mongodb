package com.spring.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.workshopmongo.domain.User;
import com.spring.workshopmongo.repository.UserRepository;
import com.spring.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	public List<User> findAll() {
		return repo.findAll();
	}
	
	public Optional<User> findById(String id) {
		Optional<User> user = repo.findById(id);
		if(user == null) {
			throw new ObjectNotFoundException("Object not found");
		}
		return user;
	}
}
