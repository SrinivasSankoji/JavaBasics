package com.interview.demo.srinivas;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CapGemini {

	public static void main(String[] args) {
		/**
		 * 
		 */
		int[] intArray= {3,11,45,111,0,77,167,198,40};
		List<String> result=Arrays.stream(intArray).mapToObj(Integer::toString).filter(num -> num.startsWith("1")).collect(Collectors.toList());
		System.out.println(result);
		
		
	}

}
