package com.example.demo;

import java.text.SimpleDateFormat;
/**
 * @author Srinvas Sankoji
 */
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class ExceptionDateTest {

	public static void main(String[] args) 
	{
		String str = "12/03/2019";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
		LocalDate passedDate = LocalDate.parse(str, formatter);
		LocalDate currentDate = LocalDate.now();
		Period diff = Period.between(passedDate, currentDate);
		//System.out.printf("Difference is %d years, %d months and %d days old", 
        //diff.getYears(), diff.getMonths(), diff.getDays());
		//long diffInDays = ChronoUnit.DAYS.between(passedDate, currentDate);
		//System.out.println(" "  +diffInDays);
		
		String str1 = "Jul 27 2020";
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("MMM dd yyyy");
		LocalDate passedDate1 = LocalDate.parse(str1, formatter1);
		LocalDate currentDate1 = LocalDate.now();
		//Period diff1 = Period.between(passedDate1, currentDate1);
		//long diffInDays1 = ChronoUnit.DAYS.between(passedDate1, currentDate1);
		//System.out.println(passedDate1.isEqual(currentDate1));
		
		/**
		 * Convert Date from one Format 
		 * to another Format
		 */
		String dateInString = "27-10-2021";
		//System.out.println(convertDateFromoneFormat(dateInString));
		System.out.println(addDays(dateInString));
		
		/**LocalDate now = LocalDate.now();
		DateTimeFormatter eroasterPattern = DateTimeFormatter.ofPattern("yyyyMMdd");
		String roasterDate = now.format(eroasterPattern);
		System.out.println("Roaster Date : "+roasterDate.toUpperCase());**/
	}

	private static String convertDateFromoneFormat(String dateInString)
	{
		DateTimeFormatter oldPattern= new DateTimeFormatterBuilder().parseCaseInsensitive()
				.appendPattern("dd-MM-yyyy").toFormatter();
		DateTimeFormatter newPattern = DateTimeFormatter.ofPattern("yyyy-M-d");
		LocalDate localDate = LocalDate.parse(dateInString, oldPattern);
		String formattedString = localDate.format(newPattern);
		return formattedString;		
	}
	
	/**
	 * Adding Day to the Date 
	 * @param dateInString
	 * @return String
	 */
	private static String addDays(String dateInString) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate localDate = LocalDate.parse(dateInString, formatter);
		LocalDate newDate = localDate.plusDays(1);
		return DateTimeFormatter.ofPattern("dd-MM-yyyy").format(newDate);
		
	}
}
