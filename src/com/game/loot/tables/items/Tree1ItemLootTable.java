package com.game.loot.tables.items;

import java.util.Random;

import com.game.entities.player.items.base.ItemID;
import com.game.entities.player.items.objects.Tree1Item;
import com.game.entities.player.items.objects.Wood1Item;
import com.game.main.Game;

public class Tree1ItemLootTable {
	
	public static void makeLootAtRandom() {
		
		Random random = new Random();
		
		float[] pos = Game.getRandomItemPos();
		
		Game.addItemEntity(
				pos[0],
				pos[1],
				new Wood1Item((int) (random.nextInt(5) + 2), ItemID.WOOD_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(16, 0, 16, 16)),
				Game.ITEM_TEXTRA_ALICE.getImageFrom(16, 0, 16, 16),
				64
			);

		pos = Game.getRandomItemPos();
		
		Game.addItemEntity(
							pos[0],
							pos[1],
							new Tree1Item((int) (random.nextInt(2) + 1), ItemID.TREE_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(32, 0, 16, 16)),
							Game.ITEM_TEXTRA_ALICE.getImageFrom(32, 0, 16, 16),
							64
						);
		
	}

}
