package com.game.entities.player.items;

import java.awt.image.BufferedImage;

public class Pie1Item extends FoodItem<Pie1Item> {

	public Pie1Item(int count, ItemID id, BufferedImage image) {
		
		super(count, id, image, 2);
		
		
	}

	@Override
	public Pie1Item cloneType() {
		return new Pie1Item(this.count, this.id, this.image);
	}

}
