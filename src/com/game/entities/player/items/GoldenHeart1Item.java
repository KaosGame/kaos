package com.game.entities.player.items;

import com.game.effects.BetterAttackDamgeEffect1;
import com.game.effects.FastGenerationEffect1;
import com.game.effects.ResistanceEffect1;
import com.game.entities.player.items.base.Item;
import com.game.entities.player.items.base.ItemID;
import com.game.main.Game;

public class GoldenHeart1Item extends Item<GoldenHeart1Item> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1750906574817737411L;

	public GoldenHeart1Item(int count) {
		super(count, ItemID.GOLDEN_HEART_1_ITEM, Game.ITEM_TEXTRA_ALICE.getImageFrom(144, 16, 16, 16));
		
	}

	@Override
	public GoldenHeart1Item cloneType() {
		return new GoldenHeart1Item(this.count);
	}

	@Override
	public void use() {
		
		this.count--;
		
		if (this.count <= 0) Game.PLAYER.getHotbar().list[Game.PLAYER.getHotbar().currentItemIndex] = null;
		
		GoldenHeart1Item.giveEffects();
		
	}
	
	public static final void giveEffects() {
		
		Game.PLAYER.getEffectHandler().add(new FastGenerationEffect1(5, 7200));
		Game.PLAYER.getEffectHandler().add(new ResistanceEffect1(2, 5400));
		Game.PLAYER.getEffectHandler().add(new BetterAttackDamgeEffect1(3, 5400));
		
	}

}
