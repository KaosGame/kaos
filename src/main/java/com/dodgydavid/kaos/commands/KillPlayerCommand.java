package com.dodgydavid.kaos.commands;

import com.dodgydavid.kaos.commands.base.CommandBase;
import com.dodgydavid.kaos.entities.base.EntityDeathMessages;
import com.dodgydavid.kaos.main.Game;

public class KillPlayerCommand implements CommandBase {

	@Override
	public void run(String commandText) {
		
		Game.PLAYER.die(EntityDeathMessages.COMMAND);
		
	}

}
