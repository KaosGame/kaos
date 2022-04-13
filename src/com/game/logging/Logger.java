package com.game.logging;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.swing.JFileChooser;

public class Logger {
	
	private String text;
	
	public Logger() {
		
		this.text = new String("");
		
	}
	
	public <T> void logln(T t, LogType type) {
		
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/YYYY hh:mm:ss");
		LocalDateTime localDateTime = LocalDateTime.now();
		
		Date date = new Date();
		
		long msTime = date.getTime();
		
		String dateString = String.format("%s : %d", dateTimeFormatter.format(localDateTime), msTime);
		
		
		String text = String.format("%s : %s\t: " + t.toString() + "\n", dateString, type == null ? LogType.LOG : type.toString().toUpperCase());
		
		System.out.printf("Logger: %s", text);
		
		this.text = this.text.concat(text);
		
	}
	
	public <T> void log(T t, LogType type) {
		
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/YYYY hh:mm:ss");
		LocalDateTime localDateTime = LocalDateTime.now();
		
		Date date = new Date();
		
		long msTime = date.getTime();
		
		String dateString = String.format("%s : %d", dateTimeFormatter.format(localDateTime), msTime);
		
		
		String text = String.format("%s : %s\t: " + t.toString(), dateString, type == null ? LogType.LOG : type.toString().toUpperCase());
		
		System.out.printf("Logger: %s", text);
		
		this.text = this.text.concat(text);
		
	}
	
	public String getText() {
		
		return this.text;
		
	}
	
	public void saveLogFile() throws IOException {
		
		JFileChooser fileChooser = new JFileChooser();
		
		int res = fileChooser.showSaveDialog(null);
		
		if (res == JFileChooser.APPROVE_OPTION) {
			
			FileWriter file = new FileWriter(fileChooser.getSelectedFile().getAbsolutePath());
			
			BufferedWriter writer = new BufferedWriter(file);
			
			writer.write(this.text);
			
			writer.close();
			
		}
		
	}

}
