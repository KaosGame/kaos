package com.dodgydavid.kaos.commands;

import com.dodgydavid.kaos.commands.base.CommandBase;
import com.dodgydavid.kaos.main.Game;

public class LogRandomGenSeedCommand implements CommandBase {

	@Override
	public void run(String commandText) {
		
		this.print(String.format("Random world gen seed is %d", Game.RANDOM.getSeed()));
		
	}

	

}
