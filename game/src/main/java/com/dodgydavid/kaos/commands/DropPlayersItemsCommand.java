package com.dodgydavid.kaos.commands;

import com.dodgydavid.kaos.commands.base.CommandBase;
import com.dodgydavid.kaos.main.Game;

public class DropPlayersItemsCommand implements CommandBase {

	@Override
	public void run(String commandText) {
		
		Game.PLAYER.dropAllItems();
		
		this.print("Successfully dropped all items!");
		
	}

}
