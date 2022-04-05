package com.game.entities.player.items.food;

import java.awt.image.BufferedImage;

import com.game.entities.player.items.base.FoodItem;
import com.game.entities.player.items.base.ItemID;

public class BreadFoodItem extends FoodItem<BreadFoodItem> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4010802467797487052L;

	private BreadFoodItem(int count, ItemID id, BufferedImage image, int hungerValue) {
		
		super(count, id, image, hungerValue);
		
		
	}
	
	public BreadFoodItem(int count, ItemID id, BufferedImage image) {
		
		super(count, id, image, 3);
		
		
	}

	@Override
	public BreadFoodItem cloneType() {
		return new BreadFoodItem(this.count, this.id, this.image, this.hungerValue);
	}

}
