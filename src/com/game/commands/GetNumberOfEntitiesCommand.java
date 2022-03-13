package com.game.commands;

import com.game.commands.base.CommandBase;
import com.game.main.Game;

public class GetNumberOfEntitiesCommand implements CommandBase {

	@Override
	public void run(String commandText) {
		
		this.print("The number of entities is " + Game.MAP_HANDLER.currentMap().getEntityHandler().getList().size());
		
	}

}
