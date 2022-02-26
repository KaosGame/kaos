package com.game.entities.player.items;

import java.awt.image.BufferedImage;

public abstract class WeaponItem extends Item {
	
	protected float damage;

	public WeaponItem(int count, ItemID id, BufferedImage image, float damage) {
		
		super(count, id, image);
		this.damage = damage;
		
	}

	public float getDamage() {
		
		return this.damage;
		
	}

	public void setDamage(float damage) {
		
		this.damage = damage;
		
	}
	
	

}
