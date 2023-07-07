package com.github.kaosgame.kaos.commands;

import com.github.kaosgame.kaos.commands.base.CommandBase;
import com.github.kaosgame.kaos.main.Game;

public class LogRandomGenSeedCommand implements CommandBase {

	@Override
	public void run(String commandText) {
		
		this.print(String.format("Random world gen seed is %d", Game.RANDOM.getSeed()));
		
	}

	

}
