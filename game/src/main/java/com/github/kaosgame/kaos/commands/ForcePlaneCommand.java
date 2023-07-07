package com.github.kaosgame.kaos.commands;

import com.github.kaosgame.kaos.commands.base.CommandBase;
import com.github.kaosgame.kaos.entities.base.EntityID;
import com.github.kaosgame.kaos.entities.item.planes.ItemPlaneEntity;
import com.github.kaosgame.kaos.main.Game;

public class ForcePlaneCommand implements CommandBase {

	@Override
	public void run(String commandText) {
		
		Game.MAP_HANDLER().currentMap().getEntityHandler().add(new ItemPlaneEntity((int) (Game.WIDTH - 64), 0, 0, 0, 64, 64, EntityID.ITEM_PLANE, Game.PLANE_TEXTRA_ALICE.getImageFrom(16, 0, 16, 16), true));
		
	}

}
