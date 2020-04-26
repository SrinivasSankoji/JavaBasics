package com.jio.ngo.sambamedia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jio.ngo.sambamedia.entities.User;

public interface UserRepository  extends JpaRepository<User, Long>{

}
