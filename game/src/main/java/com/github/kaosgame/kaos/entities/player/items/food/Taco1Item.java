package com.github.kaosgame.kaos.entities.player.items.food;

import java.awt.image.BufferedImage;

import com.github.kaosgame.kaos.entities.player.items.base.FoodItem;
import com.github.kaosgame.kaos.entities.player.items.base.ItemID;

public class Taco1Item extends FoodItem<Taco1Item> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1089658874853726262L;

	public Taco1Item(int count, ItemID id, BufferedImage image) {
		
		super(count, id, image, 4);
		
		
	}

	@Override
	public Taco1Item cloneType() {
		
		return new Taco1Item(this.count, this.id, this.image);
		
	}

}
