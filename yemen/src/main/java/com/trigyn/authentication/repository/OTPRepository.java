package com.trigyn.authentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trigyn.authentication.model.OTP;

public interface OTPRepository extends JpaRepository<OTP, Long>
{

}
