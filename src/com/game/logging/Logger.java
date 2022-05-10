package com.game.logging;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Logger {
	
	
	public <T> void logln(T t, LogType type) {
		
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/YYYY hh:mm:ss a");
		LocalDateTime localDateTime = LocalDateTime.now();
		
		Date date = new Date();
		
		long msTime = date.getTime();
		
		String dateString = String.format("%s : %d", dateTimeFormatter.format(localDateTime), msTime);
		
		
		String text = String.format("%s : %s\t: " + t.toString() + "\n", dateString, type == null ? LogType.LOG : type.toString().toUpperCase());
		
		System.out.printf("Logger: %s", text);
		
	}
	
	public <T> void log(T t, LogType type) {
		
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/YYYY hh:mm:ss a");
		LocalDateTime localDateTime = LocalDateTime.now();
		
		Date date = new Date();
		
		long msTime = date.getTime();
		
		String dateString = String.format("%s : %d", dateTimeFormatter.format(localDateTime), msTime);
		
		
		String text = String.format("%s : %s\t: " + t.toString(), dateString, type == null ? LogType.LOG : type.toString().toUpperCase());
		
		System.out.printf("Logger: %s", text);
		
		
	}
	

}
