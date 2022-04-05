package com.game.commands.base;

import com.game.logging.LogType;
import com.game.main.Game;

public interface CommandBase {
	
	public abstract void run(String commandText);
	
	public default <T> void print(T text) { 
		
		Game.logln("Command output: " + text.toString(), LogType.COMMAND_OUTPUT);
		
	}

}
