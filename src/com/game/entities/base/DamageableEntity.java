package com.game.entities.base;

import java.awt.image.BufferedImage;

public abstract class DamageableEntity extends Entity implements Dieable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3184490594396339674L;
	
	protected float health;
	protected final boolean bad;

	public DamageableEntity(float x, float y, float xv, float yv, int width, int height, EntityID id,
			BufferedImage image, float health, boolean bad) {
		
		super(x, y, xv, yv, width, height, id, image);
		this.health = health;
		this.bad = bad;
		
		
		
	}
	
	public abstract void damage(float num, EntityDeathMessages deathType);
	public abstract void damage(float num);

	public float getHealth() {
		return this.health;
	}

	public void setHealth(float health) {
		this.health = health;
	}
	
	public boolean isBad() {
		return this.bad;
	}

}
