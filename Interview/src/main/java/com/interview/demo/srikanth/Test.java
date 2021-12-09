package com.interview.demo.srikanth;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test {

	public static void main(String[] args) {
		List<Employee> empList=Arrays.asList(new Employee(1,"A",25),
				new Employee(1,"B",26),
				new Employee(2,"C",27),
				new Employee(1,"D",28),
				new Employee(3,"E",27));
		
		List<Employee> result=empList.stream().distinct().collect(Collectors.toList());
		System.out.println(result);
		
		//select d.dept,max(e.sal) from department d join employee e where department d where d.eid=e.eid;
	}

}
