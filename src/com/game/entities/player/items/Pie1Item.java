package com.game.entities.player.items;

import java.awt.image.BufferedImage;

import com.game.entities.player.items.base.FoodItem;
import com.game.entities.player.items.base.ItemID;

public class Pie1Item extends FoodItem<Pie1Item> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3106363030778503545L;

	public Pie1Item(int count, ItemID id, BufferedImage image) {
		
		super(count, id, image, 2);
		
		
	}

	@Override
	public Pie1Item cloneType() {
		return new Pie1Item(this.count, this.id, this.image);
	}

}
