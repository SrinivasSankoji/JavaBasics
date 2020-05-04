package com.jio.ngo.relationship.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jio.ngo.relationship.model.UserLog;
import com.jio.ngo.relationship.model.UserRelationship;
import com.jio.ngo.relationship.model.UsersContact;
import com.jio.ngo.relationship.repository.UserLogRepository;

@RestController
@RequestMapping("rest/users/log")
public class UserLogController 
{
	@Autowired
	UserLogRepository userLogRepository;
	
	@GetMapping("/all")
	public List<UserLog> getUsersContact()
	{
		return userLogRepository.findAll();
	}
	@GetMapping("/update/{name}")
	public List<UserLog> update(@PathVariable String name)
	{
		UserRelationship userRelationship=new UserRelationship();
		userRelationship.setName(name);
		userRelationship.setTeamName("Operations");
		userRelationship.setSalary(9000);
		
		List <UserLog> userLogList=new ArrayList<>();
		UserLog userLog1=new UserLog();
		userLog1.setLog("User Log Table");
		userLog1.setUserRelationship(userRelationship);
		userLogRepository.save(userLog1);
		
		UserLog userLog2=new UserLog();
		userLog2.setLog("User Log Model");
		userLogList.add(userLog1);
		userLogList.add(userLog2);
		userLog2.setUserRelationship(userRelationship);
		userLogRepository.save(userLog2);
		
		return userLogRepository.findAll();
	}
	

}
