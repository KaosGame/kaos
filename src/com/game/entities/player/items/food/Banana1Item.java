package com.game.entities.player.items.food;

import java.awt.image.BufferedImage;

import com.game.entities.player.items.base.FoodItem;
import com.game.entities.player.items.base.ItemID;

public class Banana1Item extends FoodItem<Banana1Item> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5240819092036143102L;

	public Banana1Item(int count, ItemID id, BufferedImage image) {
		
		super(count, id, image, 3);
		
		
	}

	@Override
	public Banana1Item cloneType() {
		return new Banana1Item(this.count, this.id, this.image);
	}

}
