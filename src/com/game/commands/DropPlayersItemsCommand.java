package com.game.commands;

import com.game.commands.base.CommandBase;
import com.game.main.Game;

public class DropPlayersItemsCommand implements CommandBase {

	@Override
	public void run(String commandText) {
		
		Game.PLAYER.dropAllItems();
		
		this.print("Successfully dropped all items!");
		
	}

}
