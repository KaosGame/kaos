package com.game.commands;

import com.game.commands.base.CommandBase;
import com.game.entities.base.EntityDeathMessages;
import com.game.main.Game;

public class KillPlayerCommand implements CommandBase {

	@Override
	public void run(String commandText) {
		
		Game.PLAYER.die(EntityDeathMessages.COMMAND);
		
	}

}
