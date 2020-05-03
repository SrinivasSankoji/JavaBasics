package com.jio.ngo.relationship.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.jio.ngo.relationship.model.UserRelationship;

@Component
public interface UserRepository extends JpaRepository<UserRelationship, Long>
{
	UserRelationship findByName(String name);
}
