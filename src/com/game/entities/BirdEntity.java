package com.game.entities;

import java.awt.image.BufferedImage;

import com.game.entities.base.Entity;
import com.game.entities.base.EntityID;
import com.game.main.Game;

public class BirdEntity extends Entity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5904504508649823371L;

	public BirdEntity(float x, float y, float xv, float yv, int width, int height, EntityID id, BufferedImage image) {
		
		super(x, y, xv, yv, width, height, id, image);
		
		
	}

	@Override
	public void update() {
		
		this.x += this.xv;
		this.y += this.yv;
		
		if (this.x > Game.WIDTH || this.x < 0 || this.y > Game.HEIGHT || this.y < 0) Game.MAP_HANDLER.currentMap().getEntityHandler().remove(this);
		
	}

}
