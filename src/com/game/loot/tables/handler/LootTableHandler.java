package com.game.loot.tables.handler;

import java.util.Arrays;
import java.util.Random;

import com.game.entities.player.items.base.Item;
import com.game.entities.player.items.base.ItemID;
import com.game.entities.player.items.food.Apple1Item;
import com.game.entities.player.items.food.OrangeJuce1Item;
import com.game.entities.player.items.food.Pie1Item;
import com.game.entities.player.items.food.Taco1Item;
import com.game.entities.player.items.objects.AppleTree1Item;
import com.game.entities.player.items.objects.Tree1Item;
import com.game.entities.player.items.tools.AxeItem;
import com.game.entities.player.items.tools.PickaxeItem;
import com.game.loot.tables.items.AppleTree1ItemLootTable;
import com.game.loot.tables.items.Chest1ItemLootTable;
import com.game.loot.tables.items.DiamondOre1ItemLootTable;
import com.game.loot.tables.items.GoldOre1ItemLootTable;
import com.game.loot.tables.items.IronOre1ItemLootTable;
import com.game.loot.tables.items.Sign1ItemLootTable;
import com.game.loot.tables.items.Stone1ItemLootTable;
import com.game.loot.tables.items.Tree1ItemLootTable;
import com.game.loot.tables.items.Wood1ItemLootTable;
import com.game.main.Game;
import com.game.random.RandomChance;

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
	
	public static Item<?>[] returnRandomLootItemsForFallingChestFromItemPlane() {
		
		Random random = new Random();
		
		Item<?>[] listOfItems = new Item<?>[(int) (random.nextInt(10) + 1)];
		
		Arrays.fill(listOfItems, null);
		
		do {
			
			for (int i = 0; i < listOfItems.length; i++) {
				
				RandomChance chance = new RandomChance();
				
				if (chance.firstChoose(0.25)) {
					
					// Food
					
					int countOfFood = (int) (random.nextInt(15) + 1);
					
					if (chance.firstChoose(0.25)) {
						
						listOfItems[i] = new Apple1Item(countOfFood, ItemID.APPLE_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(64, 0, 16, 16));
						
					} else if (chance.firstChoose(0.15)) {
						
						listOfItems[i] = new Pie1Item(countOfFood, ItemID.PIE_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(80, 0, 16, 16));
						
					} else if (chance.firstChoose(0.10)) {
						
						listOfItems[i] = new Taco1Item(countOfFood, ItemID.TACO_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(96, 0, 16, 16));
						
					} else {
						
						listOfItems[i] = new OrangeJuce1Item(countOfFood, ItemID.ORANGE_JUCE_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(224, 0, 16, 16));
						
					}
					
				} else if (chance.firstChoose(0.37)) {
					
					// Trees
					
					int countOfTrees = (int) (random.nextInt(2) + 1);
					
					if (chance.firstChoose(0.50)) {
						
						listOfItems[i] = new AppleTree1Item(countOfTrees, ItemID.APPLE_TREE_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(48, 0, 16, 16));
						
					} else {
						
						listOfItems[i] = new Tree1Item(countOfTrees, ItemID.TREE_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(32, 0, 16, 16));
						
					}
					
				} else if (chance.firstChoose(0.28)) {
					
					// Tools
					
					final int COUNT = 1;
					
					if (chance.firstChoose(0.50)) {
						
						listOfItems[i] = new AxeItem(COUNT, ItemID.AXE_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(0, 0, 16, 16));
						
					} else {
						
						listOfItems[i] = new PickaxeItem(COUNT, ItemID.PICKAXE_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(144, 0, 16, 16));
						
					}
					
				}
				
			}
			
		} while (Game.arrayContains(listOfItems, null));
		
		return listOfItems;
		
	}

}
