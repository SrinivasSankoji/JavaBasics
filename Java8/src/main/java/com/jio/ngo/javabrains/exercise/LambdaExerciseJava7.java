package com.jio.ngo.javabrains.exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.jio.ngo.javabrains.model.Person;

public class LambdaExerciseJava7 
{
	
	public static void main(String[] args) 
	{
		List<Person> people=Arrays.asList(
				new Person("Charles","Dickens",60),
				new Person("Lewis","Caroll",60),
				new Person("Thomas","Carlyle",60),
				new Person("Charlotte","Bronte",60),
				new Person("Matthew","Arnold",60));
		
		
		//Sort by Last Name 
		Collections.sort(people,new Comparator<Person>() {

			@Override
			public int compare(Person p1, Person p2) {
				return p1.getLastName().compareTo(p2.getLastName());
			}
		});
		
		//Print all the Elements of the List Using Pass by Behavior
		printConditionally(people,new Condition() {
			
			@Override
			public boolean test(Person person) {
				return true;
			}
		});
		
		//Display Last Name that Begins with C Using Pass by Behavior
		printConditionally(people, new Condition() {
			@Override
			public boolean test(Person person) {
				return person.getLastName().startsWith("C");
			}
		});
		
	}

	private static void printConditionally(List<Person> people,Condition condition) 
	{
		for (Person person : people) {
			if(condition.test(person)) {
			System.out.println(person);
			}
		}
	}

	private static void printAll(List<Person> people) {
		for (Person person : people) {
			System.out.println(person);
		}
	}
	
	private static void printNameBeginsWithC(List<Person> people) 
	{
		System.out.println("Last Name Begins With C  ..........");
		for (Person person : people) {
			if(person.getLastName().startsWith("C")) {
			System.out.println(person);
			}
		}
	}

}
