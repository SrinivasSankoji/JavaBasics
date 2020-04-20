package com.jio.ngo.winterbe.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.jio.ngo.winterbe.model.Book;
import com.jio.ngo.winterbe.model.Writer;

public class WinterbeFlatMap {

	public static void main(String[] args) 
	{
		//flatMapWithList();
		flatMapWithArray();
	}

	private static void flatMapWithArray() 
	{
		Integer[][] data = {{1,2},{3,4},{5,6}};
		Arrays.stream(data).flatMap(row -> Arrays.stream(row)).filter(num ->num%2==0)
		.forEach(System.out::println);
	}

	/**
	 * FlatMap to get
	 * List Form The Object
	 */
	@SuppressWarnings("unused")
	private static void flatMapWithList() 
	{
		List<Book> books = Arrays.asList(new Book(10, "AAA"), new Book(20, "BBB"));
    	Writer w1 = new Writer("Mohan", books);
    	books = Arrays.asList(new Book(30, "XXX"), new Book(15, "ZZZ"));
    	Writer w2 = new Writer("Sohan", books); 
    	List<Writer> writers = Arrays.asList(w1, w2);
    	
    	List<Book> result=writers.stream()
    	.flatMap(writer ->writer.getBooks().stream())
    	.collect(Collectors.toList());
    	result.forEach(book->System.out.println(book));
	}

}
