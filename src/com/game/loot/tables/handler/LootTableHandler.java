package com.game.loot.tables.handler;

import com.game.loot.tables.items.AppleTree1ItemLootTable;
import com.game.loot.tables.items.Chest1ItemLootTable;
import com.game.loot.tables.items.DiamondOre1ItemLootTable;
import com.game.loot.tables.items.GoldOre1ItemLootTable;
import com.game.loot.tables.items.IronOre1ItemLootTable;
import com.game.loot.tables.items.Sign1ItemLootTable;
import com.game.loot.tables.items.Stone1ItemLootTable;
import com.game.loot.tables.items.Tree1ItemLootTable;
import com.game.loot.tables.items.Wood1ItemLootTable;

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
				
			case CHEST_1:
				
				Chest1ItemLootTable.makeLootAtRandom();
				
				break;
				
			case SIGN_1:
				
				
				Sign1ItemLootTable.makeLootAtRandom();
				
				break;
				
			case STONE_1:
				
				Stone1ItemLootTable.makeLootAtRandom();
				
				break;
				
			case IRON_ORE_1:
				
				IronOre1ItemLootTable.makeLootAtRandom();
				
				break;
				
				
			case GOLD_ORE_1:
				
				GoldOre1ItemLootTable.makeLootAtRandom();
				
				break;
				
			case DIAMOND_ORE_1:
				
				DiamondOre1ItemLootTable.makeLootAtRandom();
				
				break;
				
			
		}
		
	}

}
