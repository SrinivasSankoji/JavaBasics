package com.jio.ngo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jio.ngo.entities.User;

public interface UserRepository  extends JpaRepository<User, Long>{

}
