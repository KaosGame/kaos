package com.game.collision.objects;

import java.awt.Graphics2D;

import com.game.collision.objects.base.CollisionObject;
import com.game.collision.objects.base.ObjectType;
import com.game.entities.base.Entity;
import com.game.gui.Game7Or2GUI;
import com.game.main.Drawable;
import com.game.main.Game;

public class Pot7Or2CollidableObject extends CollisionObject implements Drawable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5139263216019402909L;

	public Pot7Or2CollidableObject(int x, int y) {
		super(x, y, 96, 96, ObjectType.POT_7_OR_2, Game.POT_7_OR_2_IMAGE_LOADER.getImage(), true, new Game7Or2GUI());
		
	}

	@Override
	public void collide(Entity e) {
		
	}
	
	@Override
	public void draw(Graphics2D g2d) {
		
		g2d.drawImage(this.image, this.x, this.y, this.width, this.height, null);
		
	}

}
