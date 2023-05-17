package com.dodgydavid.kaos.commands;

import com.dodgydavid.kaos.commands.base.CommandBase;
import com.dodgydavid.kaos.entities.player.items.bad.food.RedMushroom1FoodItem;
import com.dodgydavid.kaos.entities.player.items.base.ItemID;
import com.dodgydavid.kaos.main.Game;

public class GivePlayerRedMushroomItemCommand implements CommandBase {

	@Override
	public void run(String commandText) {
		
		RedMushroom1FoodItem item = new RedMushroom1FoodItem(1, ItemID.RED_MUSHROOM_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(288, 0, 16, 16));
		
		Game.addItemOrItemEntity(item);
		
	}

}
