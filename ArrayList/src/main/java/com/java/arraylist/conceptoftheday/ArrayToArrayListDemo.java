package com.java.arraylist.conceptoftheday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayToArrayListDemo {

	public static void main(String[] args) {
		String[] array={"ANDROID", "JSP", "JAVA", "STRUTS", "HADOOP", "JSF"};
		/* Convert String Array to ArrayList */
		ArrayList<String> methodOne=new ArrayList<>(Arrays.asList(array));
		System.out.println(methodOne);

		/* Convert String Array to ArrayList using Collections */
		ArrayList<String> methodTwo=new ArrayList<>();
		Collections.addAll(methodTwo, array);
		/* ArrayList addAll() */
		methodTwo.addAll(Arrays.asList(array));

		/* Convert String Array to ArrayList using Streams */
		List<String> methodFour=Arrays.stream(array).collect(Collectors.toList());
		System.out.println(methodFour);

		/* Convert ArrayList to Array */
		Object[] objectArray=methodFour.toArray();
		System.out.println(objectArray.length);
		
		String x="aabcababacaabaaababa";
		String y="ab";
		String[] res=x.split(y);
		System.out.println(res.length);
		
	}

}
