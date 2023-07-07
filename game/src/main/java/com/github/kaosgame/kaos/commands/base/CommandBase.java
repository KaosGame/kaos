package com.github.kaosgame.kaos.commands.base;

import com.github.kaosgame.kaos.logging.LogType;
import com.github.kaosgame.kaos.main.Game;

public interface CommandBase {
	
	public abstract void run(String commandText);
	
	public default <T> void print(T text) { 
		
		Game.logln("Command output: " + text.toString(), LogType.COMMAND_OUTPUT);
		
	}

}
