package com.jio.ngo.relationship.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jio.ngo.relationship.model.UserRelationship;
import com.jio.ngo.relationship.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UsersController 
{
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/all")
	public List<UserRelationship> findAll()
	{
		return userRepository.findAll();
	}
	
	@GetMapping("/{name}")
	public UserRelationship findByName(@PathVariable String name)
	{
		return userRepository.findByName(name);
	}
	
	@PostMapping("/load")
	public UserRelationship load(@RequestBody UserRelationship userRelationship)
	{
		 userRepository.save(userRelationship);
		 return userRepository.findByName(userRelationship.getName());
	}
}
