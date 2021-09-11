package com.jio.ngo.beginnersbook.optional;

import java.util.Optional;

public class IsPresentDemo {

	public static void main(String[] args) {
		//declaring the String Array and not initializing the values.By default it will be null.
		String[] result=new String[10];
		//String subResult=result[9].substring(2, 5);
		//System.out.println(subResult); // It will throw NPE as values are not initialized
		
		Optional<String> nullCheck=Optional.ofNullable(result[9]);
		if(nullCheck.isPresent())
		{
			String subResult=result[9].substring(2, 5);
			System.out.println(subResult);
		}
		else
		{
			System.out.println("Cannot be NUll");
		}
	}

}
