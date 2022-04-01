package com.game.commands;

import com.game.commands.base.CommandBase;
import com.game.main.Game;

public class LogRandomGenSeedCommand implements CommandBase {

	@Override
	public void run(String commandText) {
		
		this.print(String.format("Random world gen seed is %d", Game.RANDOM.getSeed()));
		
	}

	

}
