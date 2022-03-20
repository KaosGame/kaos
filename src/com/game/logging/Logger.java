package com.game.logging;

import java.util.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
	
	private String text;
	
	public Logger() {
		
		this.text = new String("");
		
	}
	
	public <T> void logln(T t, LogType type) {
		
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/mm/yyyy hh:mm:ss");
		LocalDateTime localDateTime = LocalDateTime.now();
		
		Date date = new Date();
		
		long msTime = date.getTime();
		
		String dateString = String.format("%s : %d", dateTimeFormatter.format(localDateTime), msTime);
		
		
		String text = String.format("%s : %s :\t" + t.toString() + "\n", dateString, type.toString().toUpperCase());
		
		System.out.printf("Logger: %s", text);
		
		this.text.concat(text);
		
	}
	
	public <T> void log(T t, LogType type) {
		
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/mm/yyyy hh:mm:ss");
		LocalDateTime localDateTime = LocalDateTime.now();
		
		Date date = new Date();
		
		long msTime = date.getTime();
		
		String dateString = String.format("%s : %d", dateTimeFormatter.format(localDateTime), msTime);
		
		
		String text = String.format("%s : %s :\t" + t.toString(), dateString, type.toString().toUpperCase());
		
		System.out.printf("Logger: %s", text);
		
		this.text.concat(text);
		
	}
	
	
	
	public String getText() {
		
		return this.text;
		
	}
	

}
