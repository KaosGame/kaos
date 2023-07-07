package com.dodgydavid.kaos.commands;

import com.dodgydavid.kaos.commands.base.CommandBase;
import com.dodgydavid.kaos.main.Game;

public class GetNumberOfEntitiesCommand implements CommandBase {

	@Override
	public void run(String commandText) {
		
		this.print("The number of entities is " + Game.MAP_HANDLER().currentMap().getEntityHandler().getList().size());
		
	}

}
