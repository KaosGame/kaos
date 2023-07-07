package com.github.kaosgame.kaos.commands;

import com.github.kaosgame.kaos.commands.base.CommandBase;
import com.github.kaosgame.kaos.main.Game;

public class GetNumberOfEntitiesCommand implements CommandBase {

	@Override
	public void run(String commandText) {
		
		this.print("The number of entities is " + Game.MAP_HANDLER().currentMap().getEntityHandler().getList().size());
		
	}

}
