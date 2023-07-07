package com.github.kaosgame.kaos.entities.player.items.food;

import java.awt.image.BufferedImage;

import com.github.kaosgame.kaos.entities.player.items.base.FoodItem;
import com.github.kaosgame.kaos.entities.player.items.base.ItemID;

public class PizzaFoodItem extends FoodItem<PizzaFoodItem> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1787750760714438276L;

	private PizzaFoodItem(int count, ItemID id, BufferedImage image, int hungerValue) {
		super(count, id, image, hungerValue);
		
		
	}
	
	public PizzaFoodItem(int count, ItemID id, BufferedImage image) {
		super(count, id, image, 9);
		
		
	}

	@Override
	public PizzaFoodItem cloneType() {
		return new PizzaFoodItem(this.count, this.id, this.image, this.hungerValue);
	}

}
