package com.game.commands;

import com.game.commands.base.CommandBase;
import com.game.main.Game;

public class GetPlayerPosCommand implements CommandBase {

	@Override
	public void run(String commandText) {
		
		float[] pos = Game.PLAYER.getPos();
		
		this.print("Player X = " + pos[0]);
		this.print("Player Y = " + pos[1]);
		this.print("Current Map ID = " + Game.MAP_HANDLER.CURRENT_MAP_ID);
		
	}

}
