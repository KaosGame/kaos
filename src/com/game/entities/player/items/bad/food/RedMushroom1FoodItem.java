package com.game.entities.player.items.bad.food;

import java.awt.image.BufferedImage;

import com.game.entities.base.EntityDeathMessages;
import com.game.entities.player.Player;
import com.game.entities.player.items.base.FoodItem;
import com.game.entities.player.items.base.ItemID;
import com.game.main.Game;

public class RedMushroom1FoodItem extends FoodItem<RedMushroom1FoodItem> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7289204832181470987L;
	
	private final float damage;

	public RedMushroom1FoodItem(int count, ItemID id, BufferedImage image) {
		
		super(count, id, image, 1);
		this.damage = 2f;
		
		
	}

	@Override
	public RedMushroom1FoodItem cloneType() {
		return new RedMushroom1FoodItem(this.count, this.id, this.image);
	}
	
	@Override
	public void eat() {
		
		if (Game.PLAYER.getHunger() != Player.MAX_HUNGER) {
			
			this.count--;
			
			if (this.count <= 0) Game.PLAYER.getHotbar().list[Game.PLAYER.getHotbar().currentItemIndex] = null;
			
			Game.PLAYER.addHungerValue(this.hungerValue);
			
			float tempHP = (float) (Game.PLAYER.getHealth() - this.damage);
			
			boolean willDie = (tempHP <= 0f);
			
			if (willDie) {
				
				Game.PLAYER.die(EntityDeathMessages.RED_MUSHROOM);
				
			} else {
				
				Game.PLAYER.removeHealth(this.damage);
				
			}
			
			
		}
		
	}

}
