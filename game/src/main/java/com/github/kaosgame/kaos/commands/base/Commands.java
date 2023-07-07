package com.github.kaosgame.kaos.commands.base;

import java.util.HashMap;

import com.github.kaosgame.kaos.logging.LogType;
import com.github.kaosgame.kaos.main.Game;

public class Commands {
	
	private static HashMap<String, CommandBase> COMMANDS = new HashMap<String, CommandBase>();
	private static HashMap<CommandBase, String> COMMANDS_TEXT = new HashMap<CommandBase, String>();
	
	
	public static void run(String command) {
		
		CommandBase c = Commands.COMMANDS.get(command.toLowerCase());
		
		if (c != null) {
			
			c.run(command);
			Game.logln(String.format("%s command run", Commands.COMMANDS_TEXT.get(c)), LogType.INFO);
			
		}
		
		if (c == null) Game.logln(String.format("%s is not a command", command.toString()), LogType.POSSIBLY_BAD);
		
	}
	
	
	public static void add(String command, CommandBase base) {
		
		Commands.COMMANDS.put(command.toLowerCase(), base);
		Commands.COMMANDS_TEXT.put(base, command);
		
	}
	
}
