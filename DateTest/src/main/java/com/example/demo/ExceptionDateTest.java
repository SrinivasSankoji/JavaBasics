<<<<<<< HEAD
package com.example.demo;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class ExceptionDateTest {

	public static void main(String[] args) 
	{
		String str = "12/03/2019";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
		LocalDate passedDate = LocalDate.parse(str, formatter);
		LocalDate currentDate = LocalDate.now();
		Period diff = Period.between(passedDate, currentDate);
		System.out.printf("Difference is %d years, %d months and %d days old", 
        diff.getYears(), diff.getMonths(), diff.getDays());
		long diffInDays = ChronoUnit.DAYS.between(passedDate, currentDate);
		System.out.println(" "  +diffInDays);

	}

}
=======
package com.example.demo;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class ExceptionDateTest {

	public static void main(String[] args) 
	{
		String str = "12/03/2019";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
		LocalDate passedDate = LocalDate.parse(str, formatter);
		LocalDate currentDate = LocalDate.now();
		Period diff = Period.between(passedDate, currentDate);
		System.out.printf("Difference is %d years, %d months and %d days old", 
        diff.getYears(), diff.getMonths(), diff.getDays());
		long diffInDays = ChronoUnit.DAYS.between(passedDate, currentDate);
		System.out.println(" "  +diffInDays);

	}

}
>>>>>>> 015877d33c416a44442258f23eac1907bde167c8
