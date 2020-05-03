package com.jio.ngo.relationship.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jio.ngo.relationship.model.UserRelationship;
import com.jio.ngo.relationship.model.UsersContact;
import com.jio.ngo.relationship.repository.UsersContactRepository;

@RestController
@RequestMapping("rest/userscontact")
public class UsersContactController 
{
	@Autowired
	UsersContactRepository usersContactRepository;
	
	@GetMapping("/all")
	public List<UsersContact> getUsersContact()
	{
		return usersContactRepository.findAll();
	}
	
	@GetMapping("/update/{name}")
	public List<UsersContact> update(@PathVariable String name)
	{
		UserRelationship userRelationship=new UserRelationship();
		userRelationship.setName(name);
		userRelationship.setTeamName("Asset Manager");
		userRelationship.setSalary(9000);
		
		UsersContact usersContact = new UsersContact();
		usersContact.setPhoneNo(771897368);
		usersContact.setUserRelationship(userRelationship);
		
		 usersContactRepository.save(usersContact);
		 return usersContactRepository.findAll();
	}

}
