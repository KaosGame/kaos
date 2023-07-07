package com.github.kaosgame.kaos.commands;

import com.github.kaosgame.kaos.commands.base.CommandBase;
import com.github.kaosgame.kaos.entities.base.EntityDeathMessages;
import com.github.kaosgame.kaos.main.Game;

public class KillPlayerCommand implements CommandBase {

	@Override
	public void run(String commandText) {
		
		Game.PLAYER.die(EntityDeathMessages.COMMAND);
		
	}

}
