package com.jacksen.java.java8;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.StringJoiner;


public class StringTest {
	
	public static void main(String[] args) {
		// 
		String[] banks = new String[]{ "Citibank", "Bank","America", "Chase"};
		String bankResult = String.join(",",banks);
		System.out.println("banks: " + bankResult);
		
		//
		List<String> companies = new ArrayList<>();
		companies.add("alibaba");
		companies.add("tecent");
		companies.add("baidu");
		
		String comp = String.join("--", companies);
		System.out.println(comp);
		
		
		/////
		
		//
		StringJoiner joiner = new StringJoiner(",", "(", ")");
		joiner.add("A");
		joiner.add("B");
		joiner.add("C");
		joiner.add("D");
		
		System.out.println(joiner.toString());
		
		joiner = new StringJoiner(".", "[","]");
		joiner.add("192");
		joiner.add("168");
		joiner.add("0");
		joiner.add("1");
		System.out.println("IP: " + joiner.toString());
		
		/////
		
		// ??
		List<String> abcdList = new ArrayList<>(Arrays.asList("a","b","c","d","e"));
//		abcdList.forEach(s -> System.out.println(s));
//		abcdList.forEach(System.out::println);
		
		
		
		//
		String str = "2016-09-02 14:34";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
		System.out.println(dateTime.getDayOfMonth()); 
		
		//
		Date now = new Date();
		Instant currentInstant = now.toInstant();
		LocalDateTime ldt = LocalDateTime.ofInstant(currentInstant,ZoneId.systemDefault());
		System.out.println(ldt.getHour());
		
		ZonedDateTime zdt = ldt.atZone(ZoneId.systemDefault());
		Date output= Date.from(zdt.toInstant());
		System.out.println(output.getYear());
	}

}
