package com.github.kaosgame.kaos.loot.tables.items;

import java.util.Random;

import com.github.kaosgame.kaos.entities.player.items.base.ItemID;
import com.github.kaosgame.kaos.entities.player.items.food.Apple1Item;
import com.github.kaosgame.kaos.entities.player.items.objects.AppleTree1Item;
import com.github.kaosgame.kaos.entities.player.items.objects.Wood1Item;
import com.github.kaosgame.kaos.main.Game;

public class AppleTree1ItemLootTable {
	
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
							new AppleTree1Item((int) (random.nextInt(2) + 1), ItemID.APPLE_TREE_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(48, 0, 16, 16)),
							Game.ITEM_TEXTRA_ALICE.getImageFrom(48, 0, 16, 16),
							64
						);
		
		pos = Game.getRandomItemPos();
		
		Game.addItemEntity(
				pos[0],
				pos[1],
				new Apple1Item((int) (random.nextInt(6) + 1), ItemID.APPLE_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(64, 0, 16, 16)),
				Game.ITEM_TEXTRA_ALICE.getImageFrom(64, 0, 16, 16),
				64
			);
		
	}

}
