package com.github.kaosgame.kaos.commands;

import com.github.kaosgame.kaos.commands.base.CommandBase;
import com.github.kaosgame.kaos.entities.player.items.base.ItemID;
import com.github.kaosgame.kaos.entities.player.items.food.BreadFoodItem;
import com.github.kaosgame.kaos.main.Game;

public class GivePlayerBreadItemCommand implements CommandBase {

	@Override
	public void run(String commandText) {
		
		BreadFoodItem item = new BreadFoodItem(1, ItemID.BREAD_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(352, 0, 16, 16));
		
		Game.addItemOrItemEntity(item);
		
	}

}
