package com.dodgydavid.kaos.commands;

import com.dodgydavid.kaos.commands.base.CommandBase;
import com.dodgydavid.kaos.entities.player.items.base.ItemID;
import com.dodgydavid.kaos.entities.player.items.food.MushroomStewFoodItem;
import com.dodgydavid.kaos.main.Game;

public class GivePlayerMushroomStewItemCommand implements CommandBase {

	@Override
	public void run(String commandText) {
		
		MushroomStewFoodItem item = new MushroomStewFoodItem(1, ItemID.MUSHROOM_STEW_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(320, 0, 16, 16));
		
		Game.addItemOrItemEntity(item);
		
	}

}
