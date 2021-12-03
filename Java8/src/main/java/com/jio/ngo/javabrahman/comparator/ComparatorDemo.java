package com.jio.ngo.javabrahman.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class ComparatorDemo {
	public static void main(String[] args) {
		Student s1=new Student(1, "Bhaumik", 23);
		Student s2=new Student(2, "Aadvik", 15);
		ArrayList<Student> list=new ArrayList<>();
		list.add(s1);
		list.add(s2);
		Comparator<Student> nameComparator = (c1, c2) -> {
			return c1.getName().compareTo(c2.getName());
		};
		Collections.sort(list,nameComparator);
		Collections.sort(list,Comparator.comparing(Student::getId).thenComparing(Student::getName));
		System.out.println(list);
		
	}
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Student implements Comparable<Student>{
	private int id;
    private String name;
    private int day;
    
	@Override
	public int compareTo(Student s1) {
		return this.day-s1.day;
		//return this.name.compareTo(s1.getName());
	}
}
/**class NameComparator implements Comparator<Student>
{
	@Override
	public int compare(Student s1, Student s2) {
		return s1.getName().compareTo(s2.getName());
	}
}**/
