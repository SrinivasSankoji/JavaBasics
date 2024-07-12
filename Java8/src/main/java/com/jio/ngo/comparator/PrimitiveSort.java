package com.jio.ngo.comparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PrimitiveSort {

	public static void main(String[] args) {
		
		int[] intArray= {5,9,1,10};
		Arrays.sort(intArray);
		System.out.println(Arrays.toString(intArray));
		Arrays.stream(intArray).sorted().forEach(System.out::println);
		
		String[] strArray= {"X", "P", "M", "O", "W"};
		Arrays.sort(strArray);
		System.out.println(Arrays.toString(strArray));
		Arrays.stream(strArray).sorted().forEach(System.out::println);
		
		List<String> strList=new ArrayList<String>();
		strList.add("A");
        strList.add("C");
        strList.add("B");
        strList.add("Z");
        strList.add("E");
        Collections.sort(strList,Comparator.reverseOrder());
        strList.stream().sorted(Comparator.naturalOrder()).forEach(System.out::println);
        
        
	}

}
