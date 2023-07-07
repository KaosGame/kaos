package com.github.kaosgame.kaos.entities.player.items.food;

import java.awt.image.BufferedImage;

import com.github.kaosgame.kaos.entities.player.items.base.FoodItem;
import com.github.kaosgame.kaos.entities.player.items.base.ItemID;

public class BurgerFoodItem extends FoodItem<BurgerFoodItem> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4573646357649366963L;

	private BurgerFoodItem(int count, ItemID id, BufferedImage image, int hungerValue) {
		super(count, id, image, hungerValue);
		
		
	}
	
	public BurgerFoodItem(int count, ItemID id, BufferedImage image) {
		super(count, id, image, 7);

	
	}

	@Override
	public BurgerFoodItem cloneType() {
		return new BurgerFoodItem(this.count, this.id, this.image, this.hungerValue);
	}

}
