package com.trigyn.authentication.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "LOGIN_OTP",schema = "yemen")
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class OTP implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OTP_SEQ")
    @SequenceGenerator(sequenceName = "LOGIN_OTP_SEQ", allocationSize = 1, name = "OTP_SEQ")
	@Column(name="\"OTP_ID\"")
	private Long otpId;
	
	@Column(name="\"OTP\"")
	private Long oneTimePassword;
	
	@Column(name="\"OTP_EXPIRED\"")
	private String otpExpired;
	
	@Column(name="\"OTP_GEN_TIME\"")
	@CreationTimestamp
	private Date otpGeneratedTime;
	
	@Column(name="\"WRONG_OTP_ATTEMPT\"")
	private Long wrongOTPAttempt;
	
	@Column(name="\"USER_ID\"")
	private Long userId;

}
