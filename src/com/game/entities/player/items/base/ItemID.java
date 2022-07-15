package com.game.entities.player.items.base;

import java.awt.Color;

public enum ItemID {
	
	AXE_1(new Color(0x000000)),
	WOOD_1(new Color(0x000000)),
	TREE_1(new Color(0x000000)),
	APPLE_TREE_1(new Color(0x000000)),
	APPLE_1(new Color(0x000000)),
	PIE_1(new Color(0x000000)),
	TACO_1(new Color(0x000000)),
	CHEST_1(new Color(0x000000)),
	SIGN_1(new Color(0x000000)),
	PICKAXE_1(new Color(0x000000)),
	STONE_1(new Color(0x000000)),
	IRON_ORE_1(new Color(0x000000)),
	GOLD_ORE_1(new Color(0x000000)),
	DIAMOND_ORE_1(new Color(0x000000)),
	ORANGE_JUCE_1(new Color(0x000000)),
	BANANA_1(new Color(0x000000)),
	HEART_1(new Color(0x000000)),
	MEDKIT_1(new Color(0x000000)),
	RED_MUSHROOM_1(new Color(0x000000)),
	COOKIE_1(new Color(0x000000)),
	MUSHROOM_STEW_1(new Color(0x000000)),
	BOWL_1(new Color(0x000000)),
	BREAD_1(new Color(0x000000)),
	MONEY_BAG_1(new Color(0x000000)),
	MONEY_BAG_2(new Color(0x000000)),
	MONEY_BAG_3(new Color(0x000000)),
	FISHING_ROD_1(new Color(0x000000)),
	GOLD_FISH_1(new Color(0x000000)),
	BLUE_FISH_1(new Color(0x000000)),
	SALMON_FISH_1(new Color(0x000000)),
	COD_FISH_1(new Color(0x000000)),
	SWORD_1(new Color(0x000000)),
	PIZZA_1(new Color(0x000000)),
	BURGER_1(new Color(0x000000)),
	FISH_LAND_TELEPORTER_1(new Color(0x000000)),
	BOW_1(new Color(0x000000)),
	BOW_2(new Color(0x000000)),
	SWIMMING_EFFECT_1(new Color(0x000000)),
	BETTER_ATTACK_DAMAGE_EFFECT_1(new Color(0x000000)),
	FAST_GENERATION_EFFECT_1(new Color(0x000000)),
	POSION_EFFECT_1(new Color(0x000000)),
	RESISTANCE_EFFECT_1(new Color(0x000000)),
	BOMB(new Color(0x888888)),
	WATER_BOWL(new Color(0x000000)),
	LAVA_BOWL(new Color(0x000000)),
	LEAF_BLOWER(new Color(0x000000)),
	BANK_MASK_ITEM(new Color(0x000000));
	
	private final Color COLOR;
	
	private ItemID(final Color COLOR) {
		
		this.COLOR = COLOR;
		
	}
	
	public Color getColor() {
		
		return this.COLOR;
		
	}
	

}
