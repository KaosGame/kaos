package com.github.kaosgame.kaos.commands;

import com.github.kaosgame.kaos.commands.base.CommandBase;
import com.github.kaosgame.kaos.main.Game;

public class DropPlayersItemsCommand implements CommandBase {

	@Override
	public void run(String commandText) {
		
		Game.PLAYER.dropAllItems();
		
		this.print("Successfully dropped all items!");
		
	}

}
