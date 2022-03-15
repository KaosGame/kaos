package com.game.loot.tables;

import com.game.entities.player.items.base.ItemID;
import com.game.entities.player.items.objects.Wood1Item;
import com.game.main.Game;

public class Wood1ItemLootTable {
	
	public static void makeLootAtRandom() {
		
		float[] pos = Game.getRandomItemPos();
		
		Game.addItemEntity(
				pos[0],
				pos[1],
				new Wood1Item(1, ItemID.WOOD_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(16, 0, 16, 16)),
				Game.ITEM_TEXTRA_ALICE.getImageFrom(16, 0, 16, 16),
				64
			);
		
	}

}
