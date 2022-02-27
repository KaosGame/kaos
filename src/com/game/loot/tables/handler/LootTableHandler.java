package com.game.loot.tables.handler;

import com.game.loot.tables.AppleTree1ItemLootTable;
import com.game.loot.tables.Tree1ItemLootTable;
import com.game.loot.tables.Wood1ItemLootTable;

public class LootTableHandler {
	
	public static void createLootAtRandom(LootTableID loot) {
		
		switch (loot) {
		
			case TREE_1_LOOT:
				
				
				Tree1ItemLootTable.makeLootAtRandom();
				
				
				break;
				
				
			
			case WOOD_1_LOOT:
				
				Wood1ItemLootTable.makeLootAtRandom();
				
				break;
				
			case APPLE_TREE_1_LOOT:
				
				AppleTree1ItemLootTable.makeLootAtRandom();
				
				break;
				
			default:
				
				break;
				
			
		}
		
	}

}
