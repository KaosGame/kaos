package com.dodgydavid.kaos.commands.base;

import com.dodgydavid.kaos.logging.LogType;
import com.dodgydavid.kaos.main.Game;

public interface CommandBase {
	
	public abstract void run(String commandText);
	
	public default <T> void print(T text) { 
		
		Game.logln("Command output: " + text.toString(), LogType.COMMAND_OUTPUT);
		
	}

}
