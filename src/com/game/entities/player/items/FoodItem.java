package com.game.entities.player.items;

import java.awt.image.BufferedImage;

public abstract class FoodItem<CT> extends Item<CT> {
	
	protected int hungerValue;

	public FoodItem(int count, ItemID id, BufferedImage image, int hungerValue) {
		
		super(count, id, image);
		this.hungerValue = hungerValue;
		
		
	}
	
	@Override
	public void use() {
		
		this.eat();
		
	}
	
	public abstract void eat();

	public int getHungerValue() {
		
		return this.hungerValue;
		
	}

	public void setHungerValue(int hungerValue) {
		
		this.hungerValue = hungerValue;
		
	}
	
	

}
