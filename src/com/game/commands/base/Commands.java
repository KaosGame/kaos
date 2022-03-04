package com.game.commands.base;

import java.util.HashMap;

public class Commands {
	
	private static HashMap<String, CommandBase> COMMANDS = new HashMap<String, CommandBase>();
	
	
	public static void run(String command) {
		
		CommandBase c = Commands.COMMANDS.get(command.toLowerCase());
		
		if (c != null) c.run(command);
		if (c == null) System.out.println(command.toString() + " is not a command");
		
	}
	
	
	public static void add(String command, CommandBase base) {
		
		Commands.COMMANDS.put(command.toLowerCase(), base);
		
	}
	
}
