package com.github.kaosgame.kaos.commands;

import com.github.kaosgame.kaos.commands.base.CommandBase;
import com.github.kaosgame.kaos.entities.player.items.bad.food.RedMushroom1FoodItem;
import com.github.kaosgame.kaos.entities.player.items.base.ItemID;
import com.github.kaosgame.kaos.main.Game;

public class GivePlayerRedMushroomItemCommand implements CommandBase {

	@Override
	public void run(String commandText) {
		
		RedMushroom1FoodItem item = new RedMushroom1FoodItem(1, ItemID.RED_MUSHROOM_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(288, 0, 16, 16));
		
		Game.addItemOrItemEntity(item);
		
	}

}
