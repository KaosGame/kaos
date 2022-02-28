package com.game.entities.player.items;

import java.awt.image.BufferedImage;

public class Apple1Item extends FoodItem<Apple1Item> {

	public Apple1Item(int count, ItemID id, BufferedImage image) {
		
		super(count, id, image, 3);
		
		
	}

	@Override
	public Apple1Item cloneType() {
		return new Apple1Item(this.count, this.id, this.image);
	}

}
