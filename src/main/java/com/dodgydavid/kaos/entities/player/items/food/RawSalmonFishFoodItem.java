package com.dodgydavid.kaos.entities.player.items.food;

import java.awt.image.BufferedImage;

import com.dodgydavid.kaos.entities.player.items.base.FoodItem;
import com.dodgydavid.kaos.entities.player.items.base.ItemID;

public class RawSalmonFishFoodItem extends FoodItem<RawSalmonFishFoodItem> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 867924087059162493L;

	private RawSalmonFishFoodItem(int count, ItemID id, BufferedImage image, int hungerValue) {
		super(count, id, image, hungerValue);
		
		
	}
	
	public RawSalmonFishFoodItem(int count, ItemID id, BufferedImage image) {
		super(count, id, image, 6);

	
	}

	@Override
	public RawSalmonFishFoodItem cloneType() {
		return new RawSalmonFishFoodItem(this.count, this.id, this.image);
	}

}
