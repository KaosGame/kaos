package com.game.commands;

import com.game.commands.base.CommandBase;
import com.game.entities.player.items.base.ItemID;
import com.game.entities.player.items.tools.PickaxeItem;
import com.game.main.Game;

public class GivePlayerPickaxeItemCommand implements CommandBase {

	@Override
	public void run(String commandText) {
		
		PickaxeItem item = new PickaxeItem(1, ItemID.PICKAXE_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(144, 0, 16, 16));
		
		if (!Game.PLAYER.getHotbar().returnBooleanAndAddItem(item)) {
			
			Game.makeItemAtRandomWithItem(item);
			
		}
		
	}

}
