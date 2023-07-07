package com.github.kaosgame.kaos.commands;

import com.github.kaosgame.kaos.commands.base.CommandBase;
import com.github.kaosgame.kaos.entities.player.items.base.ItemID;
import com.github.kaosgame.kaos.entities.player.items.food.MushroomStewFoodItem;
import com.github.kaosgame.kaos.main.Game;

public class GivePlayerMushroomStewItemCommand implements CommandBase {

	@Override
	public void run(String commandText) {
		
		MushroomStewFoodItem item = new MushroomStewFoodItem(1, ItemID.MUSHROOM_STEW_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(320, 0, 16, 16));
		
		Game.addItemOrItemEntity(item);
		
	}

}
