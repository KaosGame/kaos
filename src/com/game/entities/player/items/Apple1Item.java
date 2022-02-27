package com.game.entities.player.items;

import java.awt.image.BufferedImage;

import com.game.entities.player.Player;
import com.game.main.Game;

public class Apple1Item extends FoodItem<Apple1Item> {

	public Apple1Item(int count, ItemID id, BufferedImage image) {
		
		super(count, id, image, 3);
		
		
	}

	@Override
	public Apple1Item cloneType() {
		return new Apple1Item(this.count, this.id, this.image);
	}

	@Override
	public void eat() {
		
		if (Game.PLAYER.getHunger() != Player.MAX_HUNGER) {
			
			this.count--;
			
			if (this.count <= 0) Game.PLAYER.getHotbar().list[Game.PLAYER.getHotbar().currentItemIndex] = null;
			
			Game.PLAYER.addHungerValue(this.hungerValue);
			
			
		}
		
	}

}
