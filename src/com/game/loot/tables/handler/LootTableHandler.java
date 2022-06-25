package com.game.loot.tables.handler;

import java.util.Arrays;
import java.util.Random;

import com.game.effects.BetterAttackDamgeEffect1;
import com.game.effects.FastGenerationEffect1;
import com.game.effects.PoisonEffect1;
import com.game.effects.ResistanceEffect1;
import com.game.effects.SwimmingEffect1;
import com.game.effects.base.EffectID;
import com.game.entities.player.items.Heart1Item;
import com.game.entities.player.items.Medkit1Item;
import com.game.entities.player.items.base.Item;
import com.game.entities.player.items.base.ItemID;
import com.game.entities.player.items.food.Apple1Item;
import com.game.entities.player.items.food.Banana1Item;
import com.game.entities.player.items.food.Cookie1FoodItem;
import com.game.entities.player.items.food.MushroomStewFoodItem;
import com.game.entities.player.items.food.OrangeJuce1Item;
import com.game.entities.player.items.food.Pie1Item;
import com.game.entities.player.items.food.RawBlueFishFoodItem;
import com.game.entities.player.items.food.RawCodFishFoodItem;
import com.game.entities.player.items.food.RawGoldFishFoodItem;
import com.game.entities.player.items.food.RawSalmonFishFoodItem;
import com.game.entities.player.items.food.Taco1Item;
import com.game.entities.player.items.fun.LeafBlower;
import com.game.entities.player.items.money.bags.MoneyBag1Item;
import com.game.entities.player.items.money.bags.MoneyBag2Item;
import com.game.entities.player.items.money.bags.MoneyBag3Item;
import com.game.entities.player.items.objects.AppleTree1Item;
import com.game.entities.player.items.objects.DiamondOre1Item;
import com.game.entities.player.items.objects.GoldOre1Item;
import com.game.entities.player.items.objects.IronOre1Item;
import com.game.entities.player.items.objects.Stone1Item;
import com.game.entities.player.items.objects.Tree1Item;
import com.game.entities.player.items.objects.Wood1Item;
import com.game.entities.player.items.potions.BetterAttackDamageEffect1PotionItem;
import com.game.entities.player.items.potions.FastGenerationEffect1PotionItem;
import com.game.entities.player.items.potions.PosionEffect1PotionItem;
import com.game.entities.player.items.potions.ResistanceEffect1PotionItem;
import com.game.entities.player.items.potions.SwimmingEffect1PotionItem;
import com.game.entities.player.items.tools.FishingRodItem;
import com.game.entities.player.items.tools.PickaxeItem;
import com.game.entities.player.items.tools.weapon.AxeItem;
import com.game.entities.player.items.tools.weapon.bow.advanced.BowAdvanceItem;
import com.game.entities.player.items.tools.weapon.bow.standard.BowStandardItem;
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
						
						listOfItems[i] = new OrangeJuce1Item(countOfFood, ItemID.ORANGE_JUCE_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(224, 0, 16, 16));
						
					} else if (chance.firstChoose(0.15)) {
						
						listOfItems[i] = new Pie1Item(countOfFood, ItemID.PIE_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(80, 0, 16, 16));
						
					} else if (chance.firstChoose(0.10)) {
						
						listOfItems[i] = new Taco1Item(countOfFood, ItemID.TACO_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(96, 0, 16, 16));
						
					} else if (chance.firstChoose(0.19563)) {
						
						listOfItems[i] = new Cookie1FoodItem(countOfFood, ItemID.COOKIE_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(304, 0, 16, 16));
						
					} else {
						
						if (chance.lastChoose(0.50)) {
							
							listOfItems[i] = new Banana1Item(countOfFood, ItemID.BANANA_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(240, 0, 16, 16));
							
						} else {
							
							listOfItems[i] = new Apple1Item(countOfFood, ItemID.APPLE_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(64, 0, 16, 16));
							
						}
						
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
					
					if (chance.firstChoose(0.45)) {
						
						listOfItems[i] = new AxeItem(COUNT, ItemID.AXE_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(0, 0, 16, 16));
						
					} else if (chance.firstChoose(0.25)) {
						
						listOfItems[i] = new FishingRodItem(COUNT, ItemID.FISHING_ROD_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(416, 0, 16, 16));
						
					} else if (chance.firstChoose(0.312)) {
						
						if (chance.firstChoose(0.23)) {
							
							listOfItems[i] = new BowAdvanceItem(COUNT, ItemID.BOW_2, Game.ITEM_TEXTRA_ALICE.getImageFrom(64, 16, 16, 16)); 
							
						} else {
							
							listOfItems[i] = new BowStandardItem(COUNT, ItemID.BOW_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(48, 16, 16, 16));
							
						}
						
					} else if (chance.firstChoose(0.3125)) {
						
						listOfItems[i] = new PickaxeItem(COUNT, ItemID.PICKAXE_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(144, 0, 16, 16));
						
					} else {
						
						listOfItems[i] = new LeafBlower(COUNT);
						
					}
					
				} else if (chance.firstChoose(0.41)) {
					
					// Ores and stone
					
					int count = (int) (random.nextInt(3) + 1);
					
					if (chance.firstChoose(0.17)) {
						
						listOfItems[i] = new IronOre1Item(count, ItemID.IRON_ORE_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(176, 0, 16, 16));
						
					} else if (chance.firstChoose(0.14)) {
						
						listOfItems[i] = new GoldOre1Item(count, ItemID.GOLD_ORE_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(192, 0, 16, 16));
						
					} else if (chance.firstChoose(0.10)) {
						
						listOfItems[i] = new DiamondOre1Item(count, ItemID.DIAMOND_ORE_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(208, 0, 16, 16));
						
					} else {
						
						listOfItems[i] = new Stone1Item(count, ItemID.STONE_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(160, 0, 16, 16));
						
					}
					
				} else if (chance.firstChoose(0.26)) {
					
					// Medkit
					
					int count = (int) (random.nextInt(3) + 1);
					
					listOfItems[i] = new Medkit1Item(count, ItemID.MEDKIT_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(256, 0, 16, 16));
					
				} else if (chance.firstChoose(0.42)) {
					
					// Money bags
					
					int count = (int) (random.nextInt(10) + 1);
					
					if (chance.firstChoose(0.25)) {
						
						listOfItems[i] = new MoneyBag2Item(count, ItemID.MONEY_BAG_2, Game.ITEM_TEXTRA_ALICE.getImageFrom(384, 0, 16, 16));
						
					} else if (chance.firstChoose(0.15)) {
						
						listOfItems[i] = new MoneyBag3Item(count, ItemID.MONEY_BAG_3, Game.ITEM_TEXTRA_ALICE.getImageFrom(400, 0, 16, 16));
						
					} else {
						
						listOfItems[i] = new MoneyBag1Item(count, ItemID.MONEY_BAG_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(368, 0, 16, 16));
						
					}
					
				}
				
			}
			
		} while (Game.arrayContains(listOfItems, null));
		
		return listOfItems;
		
	}
	
	public static Item<?>[] returnRandomLootItemsForMedkit1() {
		
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
						
						listOfItems[i] = new OrangeJuce1Item(countOfFood, ItemID.ORANGE_JUCE_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(224, 0, 16, 16));
						
					} else if (chance.firstChoose(0.15)) {
						
						listOfItems[i] = new Pie1Item(countOfFood, ItemID.PIE_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(80, 0, 16, 16));
						
					} else if (chance.firstChoose(0.10)) {
						
						listOfItems[i] = new Taco1Item(countOfFood, ItemID.TACO_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(96, 0, 16, 16));
						
					} else {
						
						if (chance.lastChoose(0.50)) {
							
							listOfItems[i] = new Banana1Item(countOfFood, ItemID.BANANA_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(240, 0, 16, 16));
							
						} else {
							
							listOfItems[i] = new Apple1Item(countOfFood, ItemID.APPLE_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(64, 0, 16, 16));
							
						}
						
					}
					
				} else if (chance.firstChoose(0.28)) {
					
					// Tools
					
					final int COUNT = 1;
					
					if (chance.firstChoose(0.50)) {
						
						listOfItems[i] = new AxeItem(COUNT, ItemID.AXE_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(0, 0, 16, 16));
						
					} else if (chance.firstChoose(0.25)) {
						
						listOfItems[i] = new FishingRodItem(COUNT, ItemID.FISHING_ROD_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(416, 0, 16, 16));
						
					} else {
						
						listOfItems[i] = new PickaxeItem(COUNT, ItemID.PICKAXE_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(144, 0, 16, 16));
						
					}
					
				} else if (chance.firstChoose(0.17)) {
					
					// Heart
					
					int count = (int) (random.nextInt(4) + 1);
					
					listOfItems[i] = new Heart1Item(count, ItemID.HEART_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(272, 0, 16, 16));
					
				}
				
			}
			
		} while (Game.arrayContains(listOfItems, null));
		
		return listOfItems;
		
	}

	public static Item<?> returnRandomLootItemForFishingRodItem() {
		
		Item<?> item = null;
		
		RandomChance chance = new RandomChance();
		
		final int COUNT = 1;
		
		do {
			
			if (chance.firstChoose(0.75)) {
				
				// Fish
				
				if (chance.firstChoose(0.20)) {
					
					// Gold fish
					
					item = new RawGoldFishFoodItem(COUNT, ItemID.GOLD_FISH_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(432, 0, 16, 16));
					
				} else if (chance.firstChoose(0.27)) {
					
					// Salmon
					
					item = new RawSalmonFishFoodItem(COUNT, ItemID.SALMON_FISH_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(464, 0, 16, 16));
					
				} else if (chance.firstChoose(0.34)) {
					
					// Cod
					
					item = new RawCodFishFoodItem(COUNT, ItemID.COD_FISH_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(480, 0, 16, 16));
					
				} else {
					
					// Bluefish
					
					item = new RawBlueFishFoodItem(COUNT, ItemID.BLUE_FISH_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(448, 0, 16, 16));
					
				}
				
			} else if (chance.firstChoose(0.10)) {
				
				if (chance.firstChoose(0.42)) {
					
					// Money bags
					
					if (chance.firstChoose(0.25)) {
						
						item = new MoneyBag2Item(COUNT, ItemID.MONEY_BAG_2, Game.ITEM_TEXTRA_ALICE.getImageFrom(384, 0, 16, 16));
						
					} else if (chance.firstChoose(0.15)) {
						
						item = new MoneyBag3Item(COUNT, ItemID.MONEY_BAG_3, Game.ITEM_TEXTRA_ALICE.getImageFrom(400, 0, 16, 16));
						
					} else {
						
						item = new MoneyBag1Item(COUNT, ItemID.MONEY_BAG_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(368, 0, 16, 16));
						
					}
					
				}
				
			} else if (chance.firstChoose(0.15)) {
				
				// Food
				
				if (chance.firstChoose(0.25)) {
					
					item = new OrangeJuce1Item(COUNT, ItemID.ORANGE_JUCE_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(224, 0, 16, 16));
					
				} else if (chance.firstChoose(0.15)) {
					
					item = new Pie1Item(COUNT, ItemID.PIE_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(80, 0, 16, 16));
					
				} else if (chance.firstChoose(0.10)) {
					
					item = new Taco1Item(COUNT, ItemID.TACO_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(96, 0, 16, 16));
					
				} else if (chance.firstChoose(0.19563)) {
					
					item = new Cookie1FoodItem(COUNT, ItemID.COOKIE_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(304, 0, 16, 16));
					
				} else if (chance.firstChoose(0.1856)) {
					
					item = new MushroomStewFoodItem(COUNT, ItemID.MUSHROOM_STEW_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(320, 0, 16, 16));
					
				} else {
					
					if (chance.lastChoose(0.50)) {
						
						item = new Banana1Item(COUNT, ItemID.BANANA_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(240, 0, 16, 16));
						
					} else {
						
						item = new Apple1Item(COUNT, ItemID.APPLE_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(64, 0, 16, 16));
						
					}
					
				}
				
			} else if (chance.firstChoose(0.21)) {
				
				// Tools
				
				if (chance.firstChoose(0.45)) {
					
					item = new AxeItem(COUNT, ItemID.AXE_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(0, 0, 16, 16));
					
				} else if (chance.firstChoose(0.25)) {
					
					item = new FishingRodItem(COUNT, ItemID.FISHING_ROD_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(416, 0, 16, 16));
					
				} else if (chance.firstChoose(0.312)) {
					
					if (chance.firstChoose(0.23)) {
						
						item = new BowAdvanceItem(COUNT, ItemID.BOW_2, Game.ITEM_TEXTRA_ALICE.getImageFrom(64, 16, 16, 16)); 
						
					} else {
						
						item = new BowStandardItem(COUNT, ItemID.BOW_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(48, 16, 16, 16));
						
					}
					
				} else {
					
					item = new PickaxeItem(COUNT, ItemID.PICKAXE_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(144, 0, 16, 16));
					
				}
				
			} else if (chance.firstChoose(0.32)) {
				
				// Potions
				
				EffectID effect = Game.getRandomItemFrom(EffectID.values());
				
				Random random = new Random();
				
				final int LEVEL = (int) (random.nextInt(4) + 1);
				
				switch (effect) {
				
					case ATTACK_1:
						item = new BetterAttackDamageEffect1PotionItem(COUNT, new BetterAttackDamgeEffect1(LEVEL, 1800));
						break;
						
					case FAST_REGENERATION_1:
						item = new FastGenerationEffect1PotionItem(COUNT, new FastGenerationEffect1(LEVEL, 1800));
						break;
						
					case POISON_1:
						item = new PosionEffect1PotionItem(COUNT, new PoisonEffect1(LEVEL, 1800));
						break;
						
					case RESISTANCE_1:
						item = new ResistanceEffect1PotionItem(COUNT, new ResistanceEffect1(LEVEL, 1800));
						break;
						
					case SWIMMING_1:
						item = new SwimmingEffect1PotionItem(COUNT, new SwimmingEffect1(LEVEL, 1800));
						break;
				
				}
				
				
			}
			
		} while (item == null);
		
		return item;
		
	}
	
	public static Item<?> returnRandomLootItemForWarZombie() {
		
		Item<?> item = null;
		
		RandomChance chance = new RandomChance();
		
		final int COUNT = 1;
		
		do {
			
			if (chance.firstChoose(0.75)) {
				
				// Fish
				
				if (chance.firstChoose(0.20)) {
					
					// Gold fish
					
					item = new RawGoldFishFoodItem(COUNT, ItemID.GOLD_FISH_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(432, 0, 16, 16));
					
				} else if (chance.firstChoose(0.27)) {
					
					// Salmon
					
					item = new RawSalmonFishFoodItem(COUNT, ItemID.SALMON_FISH_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(464, 0, 16, 16));
					
				} else if (chance.firstChoose(0.34)) {
					
					// Cod
					
					item = new RawCodFishFoodItem(COUNT, ItemID.COD_FISH_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(480, 0, 16, 16));
					
				} else {
					
					// Bluefish
					
					item = new RawBlueFishFoodItem(COUNT, ItemID.BLUE_FISH_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(448, 0, 16, 16));
					
				}
				
			} else if (chance.firstChoose(0.10)) {
				
				if (chance.firstChoose(0.42)) {
					
					// Money bags
					
					if (chance.firstChoose(0.25)) {
						
						item = new MoneyBag2Item(COUNT, ItemID.MONEY_BAG_2, Game.ITEM_TEXTRA_ALICE.getImageFrom(384, 0, 16, 16));
						
					} else if (chance.firstChoose(0.15)) {
						
						item = new MoneyBag3Item(COUNT, ItemID.MONEY_BAG_3, Game.ITEM_TEXTRA_ALICE.getImageFrom(400, 0, 16, 16));
						
					} else {
						
						item = new MoneyBag1Item(COUNT, ItemID.MONEY_BAG_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(368, 0, 16, 16));
						
					}
					
				}
				
			} else if (chance.firstChoose(0.15)) {
				
				// Food
				
				if (chance.firstChoose(0.25)) {
					
					item = new OrangeJuce1Item(COUNT, ItemID.ORANGE_JUCE_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(224, 0, 16, 16));
					
				} else if (chance.firstChoose(0.15)) {
					
					item = new Pie1Item(COUNT, ItemID.PIE_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(80, 0, 16, 16));
					
				} else if (chance.firstChoose(0.10)) {
					
					item = new Taco1Item(COUNT, ItemID.TACO_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(96, 0, 16, 16));
					
				} else if (chance.firstChoose(0.19563)) {
					
					item = new Cookie1FoodItem(COUNT, ItemID.COOKIE_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(304, 0, 16, 16));
					
				} else if (chance.firstChoose(0.1856)) {
					
					item = new MushroomStewFoodItem(COUNT, ItemID.MUSHROOM_STEW_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(320, 0, 16, 16));
					
				} else {
					
					if (chance.lastChoose(0.50)) {
						
						item = new Banana1Item(COUNT, ItemID.BANANA_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(240, 0, 16, 16));
						
					} else {
						
						item = new Apple1Item(COUNT, ItemID.APPLE_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(64, 0, 16, 16));
						
					}
					
				}
				
			} else if (chance.firstChoose(0.21)) {
				
				// Tools
				
				if (chance.firstChoose(0.45)) {
					
					item = new AxeItem(COUNT, ItemID.AXE_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(0, 0, 16, 16));
					
				} else if (chance.firstChoose(0.25)) {
					
					item = new FishingRodItem(COUNT, ItemID.FISHING_ROD_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(416, 0, 16, 16));
					
				} else if (chance.firstChoose(0.312)) {
					
					if (chance.firstChoose(0.23)) {
						
						item = new BowAdvanceItem(COUNT, ItemID.BOW_2, Game.ITEM_TEXTRA_ALICE.getImageFrom(64, 16, 16, 16)); 
						
					} else {
						
						item = new BowStandardItem(COUNT, ItemID.BOW_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(48, 16, 16, 16));
						
					}
					
				} else {
					
					item = new PickaxeItem(COUNT, ItemID.PICKAXE_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(144, 0, 16, 16));
					
				}
				
			} else if (chance.firstChoose(0.32)) {
				
				// Potions
				
				EffectID effect = Game.getRandomItemFrom(EffectID.values());
				
				Random random = new Random();
				
				final int LEVEL = (int) (random.nextInt(4) + 1);
				
				switch (effect) {
				
					case ATTACK_1:
						item = new BetterAttackDamageEffect1PotionItem(COUNT, new BetterAttackDamgeEffect1(LEVEL, 1800));
						break;
						
					case FAST_REGENERATION_1:
						item = new FastGenerationEffect1PotionItem(COUNT, new FastGenerationEffect1(LEVEL, 1800));
						break;
						
					case POISON_1:
						item = new PosionEffect1PotionItem(COUNT, new PoisonEffect1(LEVEL, 1800));
						break;
						
					case RESISTANCE_1:
						item = new ResistanceEffect1PotionItem(COUNT, new ResistanceEffect1(LEVEL, 1800));
						break;
						
					case SWIMMING_1:
						item = new SwimmingEffect1PotionItem(COUNT, new SwimmingEffect1(LEVEL, 1800));
						break;
				
				}
				
				
			} else if (chance.firstChoose(0.41)) {
				
				// Ores and stone
				
				
				if (chance.firstChoose(0.17)) {
					
					item = new IronOre1Item(COUNT, ItemID.IRON_ORE_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(176, 0, 16, 16));
					
				} else if (chance.firstChoose(0.14)) {
					
					item = new GoldOre1Item(COUNT, ItemID.GOLD_ORE_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(192, 0, 16, 16));
					
				} else if (chance.firstChoose(0.10)) {
					
					item = new DiamondOre1Item(COUNT, ItemID.DIAMOND_ORE_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(208, 0, 16, 16));
					
				} else {
					
					item = new Stone1Item(COUNT, ItemID.STONE_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(160, 0, 16, 16));
					
				}
				
			} else if (chance.firstChoose(0.4)) {
				
				item = new Wood1Item(COUNT, ItemID.WOOD_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(16, 0, 16, 16));
				
			}
			
		} while (item == null);
		
		return item;
		
	}

}
