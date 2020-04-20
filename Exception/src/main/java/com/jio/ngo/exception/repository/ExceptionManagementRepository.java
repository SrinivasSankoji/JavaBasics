<<<<<<< HEAD
package com.jio.ngo.exception.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jio.ngo.exception.model.ExceptionManagement;

public interface ExceptionManagementRepository extends JpaRepository<ExceptionManagement,Long>
{
	ExceptionManagement findByExceptionId(long exceptionId);
}
=======
package com.jio.ngo.exception.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jio.ngo.exception.model.ExceptionManagement;

public interface ExceptionManagementRepository extends JpaRepository<ExceptionManagement,Long>
{
	ExceptionManagement findByExceptionId(long exceptionId);
}
>>>>>>> 015877d33c416a44442258f23eac1907bde167c8
