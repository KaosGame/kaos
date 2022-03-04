package com.game.entities.player.items.base;

import java.awt.image.BufferedImage;

import com.game.entities.player.Player;
import com.game.main.Game;

public abstract class FoodItem<CT> extends Item<CT> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7680095722181226342L;
	
	protected int hungerValue;

	public FoodItem(int count, ItemID id, BufferedImage image, int hungerValue) {
		
		super(count, id, image);
		this.hungerValue = hungerValue;
		
		
	}
	
	@Override
	public void use() {
		
		this.eat();
		
	}
	
	public void eat() {
		
		if (Game.PLAYER.getHunger() != Player.MAX_HUNGER) {
			
			this.count--;
			
			if (this.count <= 0) Game.PLAYER.getHotbar().list[Game.PLAYER.getHotbar().currentItemIndex] = null;
			
			Game.PLAYER.addHungerValue(this.hungerValue);
			
			
		}
		
	}

	public int getHungerValue() {
		
		return this.hungerValue;
		
	}

	public void setHungerValue(int hungerValue) {
		
		this.hungerValue = hungerValue;
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + hungerValue;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		FoodItem<?> other = (FoodItem<?>) obj;
		if (hungerValue != other.hungerValue)
			return false;
		return true;
	}
	
	
	

}
