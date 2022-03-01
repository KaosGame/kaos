package com.game.commands.base;

public interface CommandBase {
	
	public abstract void run(String commandText);
	
	public default <T> void print(T text) { 
		
		System.out.println("Command output: " + text.toString());
		
	}

}
