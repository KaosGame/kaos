package com.game.loot.tables.items;

import com.game.entities.player.items.base.ItemID;
import com.game.entities.player.items.objects.Chest1Item;
import com.game.main.Game;

public class Chest1ItemLootTable {
	
	public static void makeLootAtRandom() {
		
		
		float[] pos = Game.getRandomItemPos();
		
		Game.addItemEntity(
							pos[0],
							pos[1],
							new Chest1Item(1, ItemID.CHEST_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(112, 0, 16, 16)),
							Game.ITEM_TEXTRA_ALICE.getImageFrom(112, 0, 16, 16),
							64
						);
		
	}

}
