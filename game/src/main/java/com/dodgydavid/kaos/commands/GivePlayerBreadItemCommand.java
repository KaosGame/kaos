package com.dodgydavid.kaos.commands;

import com.dodgydavid.kaos.commands.base.CommandBase;
import com.dodgydavid.kaos.entities.player.items.base.ItemID;
import com.dodgydavid.kaos.entities.player.items.food.BreadFoodItem;
import com.dodgydavid.kaos.main.Game;

public class GivePlayerBreadItemCommand implements CommandBase {

	@Override
	public void run(String commandText) {
		
		BreadFoodItem item = new BreadFoodItem(1, ItemID.BREAD_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(352, 0, 16, 16));
		
		Game.addItemOrItemEntity(item);
		
	}

}
