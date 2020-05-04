package com.jio.ngo.relationship.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.jio.ngo.relationship.model.UserLog;

@Component
public interface UserLogRepository extends JpaRepository<UserLog, Long>
{

}
