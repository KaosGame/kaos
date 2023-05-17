package com.dodgydavid.kaos.loot.tables.items;

import com.dodgydavid.kaos.entities.player.items.base.ItemID;
import com.dodgydavid.kaos.entities.player.items.objects.GoldOre1Item;
import com.dodgydavid.kaos.main.Game;

public class GoldOre1ItemLootTable {
	
	public static void makeLootAtRandom() {
		
		float[] pos = Game.getRandomItemPos();
		
		Game.addItemEntity(
							pos[0],
							pos[1],
							new GoldOre1Item(1, ItemID.GOLD_ORE_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(192, 0, 16, 16)),
							Game.ITEM_TEXTRA_ALICE.getImageFrom(192, 0, 16, 16),
							64
						);
		
	}

}
