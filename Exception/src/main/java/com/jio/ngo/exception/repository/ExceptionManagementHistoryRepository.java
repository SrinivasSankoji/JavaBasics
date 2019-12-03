package com.jio.ngo.exception.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jio.ngo.exception.model.ExceptionManagementHistory;

public interface ExceptionManagementHistoryRepository extends JpaRepository<ExceptionManagementHistory, Long>
{
	
}

