package com.game.commands;

import com.game.commands.base.CommandBase;

public class GameGCCommand implements CommandBase {

	@Override
	public void run(String commandText) {
		
		System.gc();
		
	}

}
