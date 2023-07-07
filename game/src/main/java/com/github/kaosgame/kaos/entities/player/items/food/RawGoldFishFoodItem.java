package com.github.kaosgame.kaos.entities.player.items.food;

import java.awt.image.BufferedImage;

import com.github.kaosgame.kaos.entities.player.items.base.FoodItem;
import com.github.kaosgame.kaos.entities.player.items.base.ItemID;

public class RawGoldFishFoodItem extends FoodItem<RawGoldFishFoodItem> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1197826228869806562L;

	private RawGoldFishFoodItem(int count, ItemID id, BufferedImage image, int hungerValue) {
		super(count, id, image, hungerValue);
		
		
	}
	
	public RawGoldFishFoodItem(int count, ItemID id, BufferedImage image) {
		super(count, id, image, 3);
		
		
	}

	@Override
	public RawGoldFishFoodItem cloneType() {
		return new RawGoldFishFoodItem(this.count, this.id, this.image, this.hungerValue);
	}

}
