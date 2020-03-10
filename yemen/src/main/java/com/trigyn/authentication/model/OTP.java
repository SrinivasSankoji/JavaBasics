package com.trigyn.authentication.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "LOGIN_OTP")
public class OTP implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="OTP_ID")
	private Long otpId;
	
	@Column(name="OTP")
	private Long oneTimePassword;
	
	@Column(name="OTP_EXPIRED")
	private String otpExpired;
	
	@Column(name="OTP_GEN_TIME")
	private Date otpGeneratedTime;
	
	@Column(name="WRONG_OTP_ATTEMPT")
	private Long wrongOTPAttempt;
	
	@Column(name="USER_ID")
	private Long userId;

}
