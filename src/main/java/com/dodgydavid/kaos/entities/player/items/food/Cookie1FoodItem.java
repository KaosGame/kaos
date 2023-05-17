package com.dodgydavid.kaos.entities.player.items.food;

import java.awt.image.BufferedImage;

import com.dodgydavid.kaos.entities.player.items.base.FoodItem;
import com.dodgydavid.kaos.entities.player.items.base.ItemID;

public class Cookie1FoodItem extends FoodItem<Cookie1FoodItem> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -926791740907513438L;

	public Cookie1FoodItem(int count, ItemID id, BufferedImage image) {
		
		super(count, id, image, 4);
		
		
	}

	@Override
	public Cookie1FoodItem cloneType() {
		return new Cookie1FoodItem(this.count, this.id, this.image);
	}

}
