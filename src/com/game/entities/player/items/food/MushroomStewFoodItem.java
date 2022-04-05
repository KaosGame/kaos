package com.game.entities.player.items.food;

import java.awt.image.BufferedImage;

import com.game.entities.player.Player;
import com.game.entities.player.items.BowlItem;
import com.game.entities.player.items.base.FoodItem;
import com.game.entities.player.items.base.ItemID;
import com.game.main.Game;

public class MushroomStewFoodItem extends FoodItem<MushroomStewFoodItem> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2280068672785510982L;

	private MushroomStewFoodItem(int count, ItemID id, BufferedImage image, int hungerValue) {
		
		super(count, id, image, hungerValue);
		
		
		
	}
	
	public MushroomStewFoodItem(int count, ItemID id, BufferedImage image) {
		
		super(count, id, image, 10);
		
		
		
	}

	@Override
	public MushroomStewFoodItem cloneType() {
		return new MushroomStewFoodItem(this.count, this.id, this.image, this.hungerValue);
	}
	
	@Override
	public void eat() {
		
		if (Game.PLAYER.getHunger() != Player.MAX_HUNGER) {
			
			this.count--;
			
			if (this.count <= 0) Game.PLAYER.getHotbar().list[Game.PLAYER.getHotbar().currentItemIndex] = null;
			
			Game.PLAYER.addHungerValue(this.hungerValue);
			
			BowlItem bowl = new BowlItem(1, ItemID.BOWL_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(336, 0, 16, 16));
			
			Game.addItemOrItemEntity(bowl);
			
			
		}
		
	}

}
