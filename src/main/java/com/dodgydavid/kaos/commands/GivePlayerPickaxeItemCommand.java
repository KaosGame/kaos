package com.dodgydavid.kaos.commands;

import com.dodgydavid.kaos.commands.base.CommandBase;
import com.dodgydavid.kaos.entities.player.items.base.ItemID;
import com.dodgydavid.kaos.entities.player.items.tools.PickaxeItem;
import com.dodgydavid.kaos.main.Game;

public class GivePlayerPickaxeItemCommand implements CommandBase {

	@Override
	public void run(String commandText) {
		
		PickaxeItem item = new PickaxeItem(1, ItemID.PICKAXE_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(144, 0, 16, 16));
		
		if (!Game.PLAYER.getHotbar().returnBooleanAndAddItem(item)) {
			
			Game.makeItemAtRandomWithItem(item);
			
		}
		
	}

}
