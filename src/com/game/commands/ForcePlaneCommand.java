package com.game.commands;

import com.game.commands.base.CommandBase;
import com.game.entities.base.EntityID;
import com.game.entities.item.planes.ItemPlaneEntity;
import com.game.main.Game;
import com.game.random.RandomChance;

public class ForcePlaneCommand implements CommandBase {

	@Override
	public void run(String commandText) {
		
		RandomChance random = new RandomChance();
		
		if (!random.lastChoose(0.5)) {
			
			Game.MAP_HANDLER.currentMap().getEntityHandler().add(new ItemPlaneEntity((int) (Game.WIDTH - 64), 0, 0, 0, 64, 64, EntityID.ITEM_PLANE, Game.PLANE_TEXTRA_ALICE.getImageFrom(0, 0, 16, 16), false));
			
		} else {
			
			Game.MAP_HANDLER.currentMap().getEntityHandler().add(new ItemPlaneEntity((int) (Game.WIDTH - 64), 0, 0, 0, 64, 64, EntityID.ITEM_PLANE, Game.PLANE_TEXTRA_ALICE.getImageFrom(16, 0, 16, 16), true));
			
		}
		
	}

}
