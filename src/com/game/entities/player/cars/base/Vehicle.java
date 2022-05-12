package com.game.entities.player.cars.base;

import java.awt.image.BufferedImage;

import com.game.entities.base.Entity;
import com.game.entities.base.EntityID;

public abstract class Vehicle extends Entity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -81784892157611768L;
	
	private float speed;
	
	public Vehicle(float x, float y, float xv, float yv, int width, int height, EntityID id, BufferedImage image, float speed) {
		super(x, y, xv, yv, width, height, id, image);
		this.setSpeed(speed);
		
		
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

}
