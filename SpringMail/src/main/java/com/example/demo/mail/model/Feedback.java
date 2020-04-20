<<<<<<< HEAD
package com.example.demo.mail.model;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class Feedback implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@NotNull
    private String name;

    @NotNull
    @Email
    private String email;

    @NotNull
    @Min(10)
    private String feedback;


}
=======
package com.example.demo.mail.model;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class Feedback implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@NotNull
    private String name;

    @NotNull
    @Email
    private String email;

    @NotNull
    @Min(10)
    private String feedback;


}
>>>>>>> 015877d33c416a44442258f23eac1907bde167c8
