package com.game.collision.objects;

import java.awt.image.BufferedImage;

import com.game.main.Game;
import com.game.maps.MapHandler;

public class ChangeMapCollidableObject extends CollisionObject {
	
	private int loadMapID;

	public ChangeMapCollidableObject(int x, int y, int width, int height, ObjectType type, BufferedImage image, int loadMapID) {
		
		super(x, y, width, height, type, image);
		this.loadMapID = loadMapID;
		
	}

	@Override
	public void collide() {
		
		MapHandler.CURRENT_MAP_ID = this.loadMapID;
		Game.resetPlayerPosToCenter();
		
	}

	public int getLoadMapID() {
		
		return this.loadMapID;
		
	}

	public void setLoadMapID(int loadMapID) {
		
		this.loadMapID = loadMapID;
		
	}
	
	

}
