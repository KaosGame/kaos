package com.game.entities.player.items.food;

import java.awt.image.BufferedImage;

import com.game.entities.player.items.base.FoodItem;
import com.game.entities.player.items.base.ItemID;

public class RawBlueFishFoodItem extends FoodItem<RawBlueFishFoodItem> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -166479882436279772L;

	private RawBlueFishFoodItem(int count, ItemID id, BufferedImage image, int hungerValue) {
		super(count, id, image, hungerValue);
		
		
	}
	
	public RawBlueFishFoodItem(int count, ItemID id, BufferedImage image) {
		super(count, id, image, 4);
		
		
	}

	@Override
	public RawBlueFishFoodItem cloneType() {
		return new RawBlueFishFoodItem(this.count, this.id, this.image, this.hungerValue);
	}

}
