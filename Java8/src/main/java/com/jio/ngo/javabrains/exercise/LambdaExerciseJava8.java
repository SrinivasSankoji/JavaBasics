package com.jio.ngo.javabrains.exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

import com.jio.ngo.javabrains.model.Person;

public class LambdaExerciseJava8 {

	public static void main(String[] args) 
	{
		List<Person> people=Arrays.asList(
				new Person("Charles","Dickens",60),
				new Person("Lewis","Caroll",60),
				new Person("Thomas","Carlyle",60),
				new Person("Charlotte","Bronte",60),
				new Person("Matthew","Arnold",60));
		
		
		//Sort by Last Name 
		Collections.sort(people,(p1,p2) -> p1.getLastName().compareTo(p2.getLastName()));
		
		//Print all the Elements of the List Using Pass by Behavior
		printConditionally(people,p -> true);
		
		//Display Last Name that Begins with C Using Pass by Behavior
		//printConditionally(people, p -> p.getLastName().startsWith("C"));
		
	}
	
	private static void printConditionally(List<Person> people,Predicate<Person> predicate) 
	{
		for (Person person : people) {
			if(predicate.test(person)) {
			System.out.println(person);
			}
		}
	}

}
