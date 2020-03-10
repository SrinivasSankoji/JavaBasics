package com.trigyn.authentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trigyn.authentication.model.Role;

public interface RoleRepository extends JpaRepository<Role,Long>
{
	
}
