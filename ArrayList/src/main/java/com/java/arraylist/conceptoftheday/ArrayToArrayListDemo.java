package com.java.arraylist.conceptoftheday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayToArrayListDemo {

	public static void main(String[] args) {
		String[] array={"ANDROID", "JSP", "JAVA", "STRUTS", "HADOOP", "JSF"};
		ArrayList<String> methodOne=new ArrayList<>(Arrays.asList(array));
		System.out.println(methodOne);
		
		ArrayList<String> methodTwo=new ArrayList<>();
		Collections.addAll(methodTwo, array);
		
		/* ArrayList addAll() */
		methodTwo.addAll(Arrays.asList(array));

		/* Streams from Java8 */
		List<String> methodFour=Arrays.stream(array).collect(Collectors.toList());
		System.out.println(methodFour);
		
		Object[] objectArray=methodFour.toArray();
		System.out.println(objectArray.length);
		
		String x="aabcababacaabaaababa";
		String y="ab";
		String[] res=x.split(y);
		System.out.println(res.length);
		
	}

}
