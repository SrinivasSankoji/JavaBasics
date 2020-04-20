package com.jio.ngo.winterbe.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private int price;
	private String name;

}
