package com.jio.ngo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

@SpringBootApplication
@EnableEncryptableProperties
public class CrudBackendApplication implements CommandLineRunner
{
	
	
	public static void main(String[] args) {
		SpringApplication.run(CrudBackendApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception 
	{
		//userRepository.save(new User("one", "one"));
		//userRepository.save(new User("two", "one"));
		//userRepository.save(new User("three", "one"));
		
	}
}
