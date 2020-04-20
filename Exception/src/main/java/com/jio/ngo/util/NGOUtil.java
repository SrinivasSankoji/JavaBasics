<<<<<<< HEAD
package com.jio.ngo.util;

import java.lang.reflect.Constructor;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.HandlerMapping;

import com.jio.ngo.common.NGOResponse;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author Srinivas Chary
 * All Methods in the Class
 * Should Start with convert
 */
@Slf4j
public class NGOUtil 
{
	public static String printNull(Object date){
		if(date == null || "NULL".equalsIgnoreCase(String.valueOf(date))) {
			return "";
		}else {
			return String.valueOf(date);
		}
	}
	public static BigDecimal printLongNull(Object data){
		if(data == null || "NULL".equalsIgnoreCase(String.valueOf(data))) {
			return new BigDecimal(0);
		}else if(data instanceof BigDecimal){
			return ((BigDecimal) data);
		}
		else {
			return (BigDecimal)data;
		}
	}
	public static String dateToNGOResponseDate(Date date)
	{
		if(date!=null) {
		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy HH:mm:SS");
        String formatteddate = DATE_FORMAT.format(date);
		return formatteddate;}
		else{return "";}
	}
	public static String dateToS3S4ReportDate(Date date)
	{
		if(date!=null) {
		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MMM");
        String formatteddate = DATE_FORMAT.format(date);
		return formatteddate;
		}
		else{return "";}
	}
	
	public static String convertToTimeSheetDate(String date) throws ParseException
	{
		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
        Date formatteddate = DATE_FORMAT.parse(date);
        SimpleDateFormat STRING_FORMAT = new SimpleDateFormat("dd-MM");
        String formattedString = STRING_FORMAT.format(formatteddate);
		return formattedString;
	}
	
	public static String dateToStartTime(String date) throws ParseException
	{
		if(date!=null) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date formatteddate = dateFormat.parse(date);
        SimpleDateFormat stringFormat = new SimpleDateFormat("yyyyMMdd 00:00:00");
        String formattedString = stringFormat.format(formatteddate);
		return formattedString;}
		else{return "";}
	}
	public static String dateToEndTime(String date) throws ParseException
	{
		if(date!=null) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date formatteddate = dateFormat.parse(date);
        SimpleDateFormat stringFormat = new SimpleDateFormat("yyyyMMdd 23:59:59");
        String formattedString = stringFormat.format(formatteddate);
		return formattedString;}
		else{return "";}
	}
	
	public static String convertStringToTrim(String name)
	{
		if (name != null)
		return name.trim();
		else
		return "";
	}
	
	public static String convertStringToLtrimRTrim(String name)
	{
		if (name != null)
		return name.trim();
		else
		return "";
	}
	public static Long dateToSeconds(String date1) throws ParseException
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		Date reference = dateFormat.parse("00:00:00");
		Date date = dateFormat.parse(date1);
		long seconds = (date.getTime() - reference.getTime()) / 1000L;
		return seconds;
	}
	
	public static String dateToKPIReportDate(Date date)
	{
		if(date!=null) {
		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-YYYY");
        String formatteddate = DATE_FORMAT.format(date);
		return formatteddate;}
		else {return "";}
	} 
	
	public static String convertToJoiningDate(String date) throws ParseException
	{
		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd",Locale.ENGLISH);
        Date formatteddate = DATE_FORMAT.parse(date);
        SimpleDateFormat STRING_FORMAT = new SimpleDateFormat("dd-MM-yyyy",Locale.ENGLISH);
        String formattedString = STRING_FORMAT.format(formatteddate);
		return formattedString;
	}
	
	public static String elasticsearchDate(LocalDateTime ld) {
		ld = ld.minusHours(5);
		ld = ld.minusMinutes(30);
		System.out.println("LD >> "+ld);
		String month = ld.getMonthValue()+"";
		String dayOfMonth = ld.getDayOfMonth()+"";
		if(month.length() == 1) {
			month = "0"+month;
		}
		if(dayOfMonth.length() == 1) {
			dayOfMonth = "0"+dayOfMonth;
		}
		
		return ld.getYear()+"."+month+"."+dayOfMonth;
	}
	
	public static ResponseEntity<NGOResponse> ngoRepsonse(HttpServletRequest request,Class<?> cls,Object object)
	{
		String path = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
		log.info("Executed "+path+ " in "+cls.getSimpleName());
		NGOResponse response = new NGOResponse();
		response.getResponseHeader().setPath(path);
		response.getResponseHeader().setTimestamp(NGOUtil.dateToNGOResponseDate(new Date()));
		response.setResponsePayload(object);
		return new ResponseEntity<NGOResponse>(response, HttpStatus.OK);
	}
	
	@SuppressWarnings("unchecked")
	public static <T> List<T> getResultList(Query query, Class<T> type){
	  List<Object[]> records = query.getResultList();
	  return convertToObject(type, records);
	}
	
	public static <T> List<T> convertToObject(Class<T> type, List<Object[]> records){
	   List<T> result = new LinkedList<>();
	   for(Object[] record : records){
	   result.add(convertToList(type, record));}
	   return result;
	}
	
	public static <T> T convertToList(Class<T> type, Object[] tuple){
	   List<Class<?>> tupleTypes = new ArrayList<>();
	   for(Object field : tuple){
	   tupleTypes.add(field.getClass());}
	   try {
	   Constructor<T> ctor = type.getConstructor(tupleTypes.toArray(new Class<?>[tuple.length]));
	   return ctor.newInstance(tuple);
	   } catch (Exception e) {
	   throw new RuntimeException(e);}
	}
	
	public static String humanReadableByteCount(long bytes, boolean si) {
	    int unit = si ? 1000 : 1024;
	    if (bytes < unit) return bytes + " B";
	    int exp = (int) (Math.log(bytes) / Math.log(unit));
	    String pre = (si ? "kMGTPE" : "KMGTPE").charAt(exp-1) + (si ? "" : "i");
	    return String.format("%.1f %sB", bytes / Math.pow(unit, exp), pre);
	}
	public static String mySqlStartTime(String date) throws ParseException
	{
		if(date!=null) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date formatteddate = dateFormat.parse(date);
        SimpleDateFormat stringFormat = new SimpleDateFormat("yyyy-MM-dd 08:00:00");
        String formattedString = stringFormat.format(formatteddate);
		return formattedString;}
		else{return "";}
	}
	public static String mySqlMidTime(String date) throws ParseException
	{
		if(date!=null) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date formatteddate = dateFormat.parse(date);
        SimpleDateFormat stringFormat = new SimpleDateFormat("yyyy-MM-dd 20:00:00");
        String formattedString = stringFormat.format(formatteddate);
		return formattedString;}
		else{return "";}
	}
	public static String mySqlEndTime(String date) throws ParseException
	{
		if(date!=null) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date formatteddate = dateFormat.parse(date);
        SimpleDateFormat stringFormat = new SimpleDateFormat("yyyy-MM-dd 07:59:59");
        String formattedString = stringFormat.format(formatteddate);
		return formattedString;}
		else{return "";}
	}
	
	public static Long convertDateToTimeStamp(String toStringDate) {
		Long timestamp = new Date().getTime();
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
			Date parsedDate = dateFormat.parse(toStringDate);
			timestamp = parsedDate.getTime();
		} catch (Exception e) {
			e.getMessage();
		}
		return timestamp;
	}
	
	public static Long convertSQLDateToTimeStamp(String toStringDate) {
		Long timestamp = 0L;
		try {
			SimpleDateFormat simpleDateFormatple = new SimpleDateFormat("dd-MMM-yy HH:mm:ss");
			Date date = simpleDateFormatple.parse(toStringDate);
			timestamp = date.getTime();
		} catch (Exception e) {
			e.getMessage();
		}
		return timestamp;
	}
	
	public static boolean isValidFormat(String format, String value, Locale locale) {
	    LocalDateTime ldt = null;
	    DateTimeFormatter fomatter = DateTimeFormatter.ofPattern(format, locale);

	    try {
	        ldt = LocalDateTime.parse(value, fomatter);
	        String result = ldt.format(fomatter);
	        return result.equals(value);
	    } catch (DateTimeParseException e) {
	        try {
	            LocalDate ld = LocalDate.parse(value, fomatter);
	            String result = ld.format(fomatter);
	            return result.equals(value);
	        } catch (DateTimeParseException exp) {
	            try {
	                LocalTime lt = LocalTime.parse(value, fomatter);
	                String result = lt.format(fomatter);
	                return result.equals(value);
	            } catch (DateTimeParseException e2) {
	                // Debugging purposes
	                //e2.printStackTrace();
	            }
	        }
	    }

	    return false;
	}
	
	/*
	 * public static void main(String[] args) {
	 * //System.out.println("Is Valid date >> "+isValidFormat("yyyyMMdd hh:mm",
	 * "20130925 21:30", Locale.ENGLISH)); }
	 */
	
	public static int addTotalToDynamicQuery(List<Map<String, Object>> list,String key)
	{
		return list.stream()
		.flatMap(map -> map.entrySet().stream())
		.filter(map -> map.getKey().equalsIgnoreCase(key))
		.mapToInt(map -> Integer.valueOf(map.getValue().toString())).sum();
	}
	
}
=======
package com.jio.ngo.util;

import java.lang.reflect.Constructor;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.HandlerMapping;

import com.jio.ngo.common.NGOResponse;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author Srinivas Chary
 * All Methods in the Class
 * Should Start with convert
 */
@Slf4j
public class NGOUtil 
{
	public static String printNull(Object date){
		if(date == null || "NULL".equalsIgnoreCase(String.valueOf(date))) {
			return "";
		}else {
			return String.valueOf(date);
		}
	}
	public static BigDecimal printLongNull(Object data){
		if(data == null || "NULL".equalsIgnoreCase(String.valueOf(data))) {
			return new BigDecimal(0);
		}else if(data instanceof BigDecimal){
			return ((BigDecimal) data);
		}
		else {
			return (BigDecimal)data;
		}
	}
	public static String dateToNGOResponseDate(Date date)
	{
		if(date!=null) {
		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy HH:mm:SS");
        String formatteddate = DATE_FORMAT.format(date);
		return formatteddate;}
		else{return "";}
	}
	public static String dateToS3S4ReportDate(Date date)
	{
		if(date!=null) {
		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MMM");
        String formatteddate = DATE_FORMAT.format(date);
		return formatteddate;
		}
		else{return "";}
	}
	
	public static String convertToTimeSheetDate(String date) throws ParseException
	{
		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
        Date formatteddate = DATE_FORMAT.parse(date);
        SimpleDateFormat STRING_FORMAT = new SimpleDateFormat("dd-MM");
        String formattedString = STRING_FORMAT.format(formatteddate);
		return formattedString;
	}
	
	public static String dateToStartTime(String date) throws ParseException
	{
		if(date!=null) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date formatteddate = dateFormat.parse(date);
        SimpleDateFormat stringFormat = new SimpleDateFormat("yyyyMMdd 00:00:00");
        String formattedString = stringFormat.format(formatteddate);
		return formattedString;}
		else{return "";}
	}
	public static String dateToEndTime(String date) throws ParseException
	{
		if(date!=null) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date formatteddate = dateFormat.parse(date);
        SimpleDateFormat stringFormat = new SimpleDateFormat("yyyyMMdd 23:59:59");
        String formattedString = stringFormat.format(formatteddate);
		return formattedString;}
		else{return "";}
	}
	
	public static String convertStringToTrim(String name)
	{
		if (name != null)
		return name.trim();
		else
		return "";
	}
	
	public static String convertStringToLtrimRTrim(String name)
	{
		if (name != null)
		return name.trim();
		else
		return "";
	}
	public static Long dateToSeconds(String date1) throws ParseException
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		Date reference = dateFormat.parse("00:00:00");
		Date date = dateFormat.parse(date1);
		long seconds = (date.getTime() - reference.getTime()) / 1000L;
		return seconds;
	}
	
	public static String dateToKPIReportDate(Date date)
	{
		if(date!=null) {
		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-YYYY");
        String formatteddate = DATE_FORMAT.format(date);
		return formatteddate;}
		else {return "";}
	} 
	
	public static String convertToJoiningDate(String date) throws ParseException
	{
		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd",Locale.ENGLISH);
        Date formatteddate = DATE_FORMAT.parse(date);
        SimpleDateFormat STRING_FORMAT = new SimpleDateFormat("dd-MM-yyyy",Locale.ENGLISH);
        String formattedString = STRING_FORMAT.format(formatteddate);
		return formattedString;
	}
	
	public static String elasticsearchDate(LocalDateTime ld) {
		ld = ld.minusHours(5);
		ld = ld.minusMinutes(30);
		System.out.println("LD >> "+ld);
		String month = ld.getMonthValue()+"";
		String dayOfMonth = ld.getDayOfMonth()+"";
		if(month.length() == 1) {
			month = "0"+month;
		}
		if(dayOfMonth.length() == 1) {
			dayOfMonth = "0"+dayOfMonth;
		}
		
		return ld.getYear()+"."+month+"."+dayOfMonth;
	}
	
	public static ResponseEntity<NGOResponse> ngoRepsonse(HttpServletRequest request,Class<?> cls,Object object)
	{
		String path = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
		log.info("Executed "+path+ " in "+cls.getSimpleName());
		NGOResponse response = new NGOResponse();
		response.getResponseHeader().setPath(path);
		response.getResponseHeader().setTimestamp(NGOUtil.dateToNGOResponseDate(new Date()));
		response.setResponsePayload(object);
		return new ResponseEntity<NGOResponse>(response, HttpStatus.OK);
	}
	
	@SuppressWarnings("unchecked")
	public static <T> List<T> getResultList(Query query, Class<T> type){
	  List<Object[]> records = query.getResultList();
	  return convertToObject(type, records);
	}
	
	public static <T> List<T> convertToObject(Class<T> type, List<Object[]> records){
	   List<T> result = new LinkedList<>();
	   for(Object[] record : records){
	   result.add(convertToList(type, record));}
	   return result;
	}
	
	public static <T> T convertToList(Class<T> type, Object[] tuple){
	   List<Class<?>> tupleTypes = new ArrayList<>();
	   for(Object field : tuple){
	   tupleTypes.add(field.getClass());}
	   try {
	   Constructor<T> ctor = type.getConstructor(tupleTypes.toArray(new Class<?>[tuple.length]));
	   return ctor.newInstance(tuple);
	   } catch (Exception e) {
	   throw new RuntimeException(e);}
	}
	
	public static String humanReadableByteCount(long bytes, boolean si) {
	    int unit = si ? 1000 : 1024;
	    if (bytes < unit) return bytes + " B";
	    int exp = (int) (Math.log(bytes) / Math.log(unit));
	    String pre = (si ? "kMGTPE" : "KMGTPE").charAt(exp-1) + (si ? "" : "i");
	    return String.format("%.1f %sB", bytes / Math.pow(unit, exp), pre);
	}
	public static String mySqlStartTime(String date) throws ParseException
	{
		if(date!=null) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date formatteddate = dateFormat.parse(date);
        SimpleDateFormat stringFormat = new SimpleDateFormat("yyyy-MM-dd 08:00:00");
        String formattedString = stringFormat.format(formatteddate);
		return formattedString;}
		else{return "";}
	}
	public static String mySqlMidTime(String date) throws ParseException
	{
		if(date!=null) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date formatteddate = dateFormat.parse(date);
        SimpleDateFormat stringFormat = new SimpleDateFormat("yyyy-MM-dd 20:00:00");
        String formattedString = stringFormat.format(formatteddate);
		return formattedString;}
		else{return "";}
	}
	public static String mySqlEndTime(String date) throws ParseException
	{
		if(date!=null) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date formatteddate = dateFormat.parse(date);
        SimpleDateFormat stringFormat = new SimpleDateFormat("yyyy-MM-dd 07:59:59");
        String formattedString = stringFormat.format(formatteddate);
		return formattedString;}
		else{return "";}
	}
	
	public static Long convertDateToTimeStamp(String toStringDate) {
		Long timestamp = new Date().getTime();
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
			Date parsedDate = dateFormat.parse(toStringDate);
			timestamp = parsedDate.getTime();
		} catch (Exception e) {
			e.getMessage();
		}
		return timestamp;
	}
	
	public static Long convertSQLDateToTimeStamp(String toStringDate) {
		Long timestamp = 0L;
		try {
			SimpleDateFormat simpleDateFormatple = new SimpleDateFormat("dd-MMM-yy HH:mm:ss");
			Date date = simpleDateFormatple.parse(toStringDate);
			timestamp = date.getTime();
		} catch (Exception e) {
			e.getMessage();
		}
		return timestamp;
	}
	
	public static boolean isValidFormat(String format, String value, Locale locale) {
	    LocalDateTime ldt = null;
	    DateTimeFormatter fomatter = DateTimeFormatter.ofPattern(format, locale);

	    try {
	        ldt = LocalDateTime.parse(value, fomatter);
	        String result = ldt.format(fomatter);
	        return result.equals(value);
	    } catch (DateTimeParseException e) {
	        try {
	            LocalDate ld = LocalDate.parse(value, fomatter);
	            String result = ld.format(fomatter);
	            return result.equals(value);
	        } catch (DateTimeParseException exp) {
	            try {
	                LocalTime lt = LocalTime.parse(value, fomatter);
	                String result = lt.format(fomatter);
	                return result.equals(value);
	            } catch (DateTimeParseException e2) {
	                // Debugging purposes
	                //e2.printStackTrace();
	            }
	        }
	    }

	    return false;
	}
	
	/*
	 * public static void main(String[] args) {
	 * //System.out.println("Is Valid date >> "+isValidFormat("yyyyMMdd hh:mm",
	 * "20130925 21:30", Locale.ENGLISH)); }
	 */
	
	public static int addTotalToDynamicQuery(List<Map<String, Object>> list,String key)
	{
		return list.stream()
		.flatMap(map -> map.entrySet().stream())
		.filter(map -> map.getKey().equalsIgnoreCase(key))
		.mapToInt(map -> Integer.valueOf(map.getValue().toString())).sum();
	}
	
}
>>>>>>> 015877d33c416a44442258f23eac1907bde167c8
