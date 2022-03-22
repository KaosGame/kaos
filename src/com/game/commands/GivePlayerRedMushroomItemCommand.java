package com.game.commands;

import com.game.commands.base.CommandBase;
import com.game.entities.player.items.bad.food.RedMushroom1FoodItem;
import com.game.entities.player.items.base.ItemID;
import com.game.main.Game;

public class GivePlayerRedMushroomItemCommand implements CommandBase {

	@Override
	public void run(String commandText) {
		
		RedMushroom1FoodItem item = new RedMushroom1FoodItem(1, ItemID.RED_MUSHROOM_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(288, 0, 16, 16));
		
		Game.addItemOrItemEntity(item);
		
	}

}
