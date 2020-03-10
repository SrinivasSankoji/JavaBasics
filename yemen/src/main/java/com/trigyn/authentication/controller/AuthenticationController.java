package com.trigyn.authentication.controller;

import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Supplier;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.trigyn.authentication.dto.UserRequest;
import com.trigyn.authentication.model.AuditLog;
import com.trigyn.authentication.model.OTP;
import com.trigyn.authentication.model.User;
import com.trigyn.authentication.repository.AuditLogRepository;
import com.trigyn.authentication.repository.OTPRepository;
import com.trigyn.authentication.repository.RoleRepository;
import com.trigyn.authentication.repository.UserRepository;
import com.trigyn.mail.model.Email;

@RestController
public class AuthenticationController 
{
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository  roleRepository;
	
	@Autowired
	AuditLogRepository auditLogRepository;
	
	@Autowired
	OTPRepository otpRepository;
	
	@Autowired
	Email email;
	
	@PostMapping("/saveUserDetails")
	public User saveUserDetails(@Valid @RequestBody UserRequest userRequest,
			HttpServletRequest request) 
	{
		User result = null;
		try {
			User user = convertUser.apply(userRequest);
			result = userRepository.save(user);
			return result;
		} catch (Exception e) {
		}
		return result;
	}
	
	@PostMapping("/getUserDetails")
	public List<User> getUserDetails(@Valid @RequestBody UserRequest userRequest,
			HttpServletRequest request) 
	{
		List<User> userDetails=userRepository.findByUserNameAndPassword(userRequest.getUserName(), userRequest.getPassword());
		if(!userDetails.isEmpty())
		{
			try {
				auditLogRepository.save(createAuditLog(request, userDetails.get(0)));
				String oneTimePassword = generateOTP.get();
				mailSenderDetails.get().send(sendMail(userDetails.get(0), oneTimePassword));
				otpRepository.save(persistOTP(oneTimePassword, userDetails.get(0)));
			} catch (Exception e) {
			}
		}
		return userDetails;
	}
	
	private OTP persistOTP(String otp,User user) 
	{
		return OTP.builder().oneTimePassword(Long.valueOf(otp)).userId(user.getUserId()).build();
	}

	private AuditLog createAuditLog(HttpServletRequest request, User user) 
	{
		return AuditLog.builder().ipAddress(request.getRemoteAddr()).resourceName(user.getUserName())
				.userId(user.getUserId()).build();
	}

	private SimpleMailMessage sendMail(User user,String otp) 
	{
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom(user.getEmail());
		mailMessage.setTo("santosh@gamil.com");
		mailMessage.setSubject("Generated OTP : " + user.getFirstName());
		mailMessage.setText(otp);
		return mailMessage;
	}

	Function<UserRequest, User> convertUser = new Function<UserRequest, User>() 
	{
		public User apply(UserRequest userRequest) {
			return User.builder().userName(userRequest.getUserName()).firstName(userRequest.getFirstName())
					.lastName(userRequest.getLastName()).password(userRequest.getPassword())
					.email(userRequest.getEmail()).isActive(userRequest.getIsActive())
					.createdBy(userRequest.getCreatedBy()).updatedBy(userRequest.getUpdatedBy())
					.build();
		}
	};
	
	Supplier<String> generateOTP =() ->
	{
	    Random rnd = new Random();
	    int number = rnd.nextInt(999999);
	    return String.format("%06d", number);
	};
	
	Supplier<JavaMailSenderImpl> mailSenderDetails = () -> {
	JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	mailSender.setHost(this.email.getHost());
	mailSender.setPort(this.email.getPort());
	mailSender.setUsername(this.email.getUsername());
	mailSender.setPassword(this.email.getPassword());
	return mailSender;
	};
	
	
}
