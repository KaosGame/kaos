package com.game.logging;

public class Logger {
	
	
	public <T> void logln(T t, LogType type) {
		
		
		String text = String.format("%s\t: " + t.toString() + "\n", type == null ? LogType.LOG : type.toString().toUpperCase());
		
		System.out.print(text);
		
	}
	
	public <T> void log(T t, LogType type) {
		
		
		String text = String.format("%s\t: " + t.toString() + "\n", type == null ? LogType.LOG : type.toString().toUpperCase());
		
		System.out.print(text);
		
		
	}
	

}
