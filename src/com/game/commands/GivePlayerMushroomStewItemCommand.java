package com.game.commands;

import com.game.commands.base.CommandBase;
import com.game.entities.player.items.base.ItemID;
import com.game.entities.player.items.food.MushroomStewFoodItem;
import com.game.main.Game;

public class GivePlayerMushroomStewItemCommand implements CommandBase {

	@Override
	public void run(String commandText) {
		
		MushroomStewFoodItem item = new MushroomStewFoodItem(1, ItemID.MUSHROOM_STEW_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(320, 0, 16, 16));
		
		Game.addItemOrItemEntity(item);
		
	}

}
