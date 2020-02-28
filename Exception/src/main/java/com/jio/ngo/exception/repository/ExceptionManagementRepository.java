package com.jio.ngo.exception.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jio.ngo.exception.model.ExceptionManagement;

public interface ExceptionManagementRepository extends JpaRepository<ExceptionManagement,Long>
{
	ExceptionManagement findByExceptionId(long exceptionId);
}
