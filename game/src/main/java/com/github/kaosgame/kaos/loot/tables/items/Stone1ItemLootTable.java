package com.github.kaosgame.kaos.loot.tables.items;

import com.github.kaosgame.kaos.entities.player.items.base.ItemID;
import com.github.kaosgame.kaos.entities.player.items.objects.Stone1Item;
import com.github.kaosgame.kaos.main.Game;

public class Stone1ItemLootTable {
	
	public static void makeLootAtRandom() {
		
		float[] pos = Game.getRandomItemPos();
		
		Game.addItemEntity(
							pos[0],
							pos[1],
							new Stone1Item(1, ItemID.STONE_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(160, 0, 16, 16)),
							Game.ITEM_TEXTRA_ALICE.getImageFrom(160, 0, 16, 16),
							64
						);
		
	}

}
