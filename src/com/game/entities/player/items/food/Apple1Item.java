package com.game.entities.player.items.food;

import java.awt.image.BufferedImage;

import com.game.entities.player.items.base.FoodItem;
import com.game.entities.player.items.base.ItemID;

public class Apple1Item extends FoodItem<Apple1Item> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6509771826426839999L;

	public Apple1Item(int count, ItemID id, BufferedImage image) {
		
		super(count, id, image, 3);
		
		
	}

	@Override
	public Apple1Item cloneType() {
		return new Apple1Item(this.count, this.id, this.image);
	}

}
