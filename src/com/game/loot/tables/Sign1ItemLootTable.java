package com.game.loot.tables;

import com.game.entities.player.items.base.ItemID;
import com.game.entities.player.items.objects.Sign1Item;
import com.game.main.Game;

public class Sign1ItemLootTable {
	
	public static void makeLootAtRandom() {
		
		float[] pos = Game.getRandomItemPos();
		
		Game.addItemEntity(
							pos[0],
							pos[1],
							new Sign1Item(1, ItemID.SIGN_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(128, 0, 16, 16)),
							Game.ITEM_TEXTRA_ALICE.getImageFrom(128, 0, 16, 16),
							64
						);
		
	}

}
