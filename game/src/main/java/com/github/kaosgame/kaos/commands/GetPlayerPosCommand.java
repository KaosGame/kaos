package com.github.kaosgame.kaos.commands;

import com.github.kaosgame.kaos.commands.base.CommandBase;
import com.github.kaosgame.kaos.main.Game;

public class GetPlayerPosCommand implements CommandBase {

	@Override
	public void run(String commandText) {
		
		float[] pos = Game.PLAYER.getPos();
		
		this.print("Player X = " + pos[0]);
		this.print("Player Y = " + pos[1]);
		this.print("Current Map ID = " + Game.MAP_HANDLER().CURRENT_MAP_ID);
		this.print("Current dimension = " + Game.DIMENSION_HANDLER.CURRENT_DIMENSION_ID.toString());
		
	}

}
