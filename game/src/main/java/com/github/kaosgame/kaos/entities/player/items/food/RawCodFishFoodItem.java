package com.github.kaosgame.kaos.entities.player.items.food;

import java.awt.image.BufferedImage;

import com.github.kaosgame.kaos.entities.player.items.base.FoodItem;
import com.github.kaosgame.kaos.entities.player.items.base.ItemID;

public class RawCodFishFoodItem extends FoodItem<RawCodFishFoodItem> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5422718513498920168L;

	private RawCodFishFoodItem(int count, ItemID id, BufferedImage image, int hungerValue) {
		super(count, id, image, hungerValue);

	
	}
	
	public RawCodFishFoodItem(int count, ItemID id, BufferedImage image) {
		super(count, id, image, 7);

	
	}

	@Override
	public RawCodFishFoodItem cloneType() {
		return new RawCodFishFoodItem(this.count, this.id, this.image, this.hungerValue);
	}

}
