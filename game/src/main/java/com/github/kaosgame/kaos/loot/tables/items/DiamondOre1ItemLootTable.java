package com.github.kaosgame.kaos.loot.tables.items;

import com.github.kaosgame.kaos.entities.player.items.base.ItemID;
import com.github.kaosgame.kaos.entities.player.items.objects.DiamondOre1Item;
import com.github.kaosgame.kaos.main.Game;

public class DiamondOre1ItemLootTable {
	
	public static void makeLootAtRandom() {
		
		float[] pos = Game.getRandomItemPos();
		
		Game.addItemEntity(
							pos[0],
							pos[1],
							new DiamondOre1Item(1, ItemID.DIAMOND_ORE_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(208, 0, 16, 16)),
							Game.ITEM_TEXTRA_ALICE.getImageFrom(208, 0, 16, 16),
							64
						);
		
	}

}
