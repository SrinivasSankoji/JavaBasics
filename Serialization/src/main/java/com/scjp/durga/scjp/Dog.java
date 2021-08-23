package com.scjp.durga.scjp;

import java.io.Serializable;

import lombok.Data;

@Data
public class Dog implements Serializable {

	private static final long serialVersionUID = 1L;

	private int i = 10;
	private int j = 20;

}
