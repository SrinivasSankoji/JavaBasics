package com.trigyn.authentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trigyn.authentication.model.User;

public interface UserRepository extends JpaRepository<User,Long>
{
	
}
