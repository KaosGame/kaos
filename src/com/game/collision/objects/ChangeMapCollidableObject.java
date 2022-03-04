package com.game.collision.objects;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.game.main.Drawable;
import com.game.main.Game;

public class ChangeMapCollidableObject extends CollisionObject implements Drawable {
	
	private int loadMapID;

	public ChangeMapCollidableObject(int x, int y, int width, int height, ObjectType type, BufferedImage image, int loadMapID) {
		
		super(x, y, width, height, type, image);
		this.loadMapID = loadMapID;
		
	}

	@Override
	public void collide() {
		
		Game.MAP_HANDLER.CURRENT_MAP_ID = this.loadMapID;
		Game.resetPlayerPosToCenter();
		
	}

	public int getLoadMapID() {
		
		return this.loadMapID;
		
	}

	public void setLoadMapID(int loadMapID) {
		
		this.loadMapID = loadMapID;
		
	}
	
	@Override
	public void draw(Graphics2D g2d) {
		
		g2d.drawImage(this.image, this.x, this.y, this.width, this.height, null);
		
	}

}
