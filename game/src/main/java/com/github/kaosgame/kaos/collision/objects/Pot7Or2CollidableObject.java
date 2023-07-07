package com.github.kaosgame.kaos.collision.objects;

import java.awt.Graphics2D;

import com.github.kaosgame.kaos.collision.objects.base.CollisionObject;
import com.github.kaosgame.kaos.collision.objects.base.ObjectType;
import com.github.kaosgame.kaos.entities.base.Entity;
import com.github.kaosgame.kaos.gui.Game7Or2GUI;
import com.github.kaosgame.kaos.main.Drawable;
import com.github.kaosgame.kaos.main.Game;

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
