package com.game.commands;

import com.game.commands.base.CommandBase;

public class GameFMCommand implements CommandBase {

	@Override
	public void run(String commandText) {
		
		this.print("Free memory: " + Runtime.getRuntime().freeMemory());
		
	}

}
