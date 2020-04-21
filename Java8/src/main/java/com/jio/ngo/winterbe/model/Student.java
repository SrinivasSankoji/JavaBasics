package com.jio.ngo.winterbe.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	
	private String name;
    private int age;
    private String className;

}
