package com.trigyn.authentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trigyn.authentication.model.AuditLog;

public interface AuditLogRepository extends JpaRepository<AuditLog, Long>
{

}
