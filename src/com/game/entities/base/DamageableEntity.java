package com.game.entities.base;

import java.awt.image.BufferedImage;

public abstract class DamageableEntity extends Entity implements Dieable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3184490594396339674L;
	
	protected float health;

	public DamageableEntity(float x, float y, float xv, float yv, int width, int height, EntityID id,
			BufferedImage image, float health) {
		
		super(x, y, xv, yv, width, height, id, image);
		this.health = health;
		
		
		
	}
	
	public abstract void damage(float num, EntityDeathMessages deathType);

}
