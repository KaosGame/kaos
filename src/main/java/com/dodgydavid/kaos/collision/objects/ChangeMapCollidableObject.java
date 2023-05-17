package com.dodgydavid.kaos.collision.objects;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.dodgydavid.kaos.collision.objects.base.CollisionObject;
import com.dodgydavid.kaos.collision.objects.base.ObjectType;
import com.dodgydavid.kaos.entities.base.Entity;
import com.dodgydavid.kaos.entities.base.EntityID;
import com.dodgydavid.kaos.entities.player.Player;
import com.dodgydavid.kaos.main.Drawable;
import com.dodgydavid.kaos.main.Game;

public class ChangeMapCollidableObject extends CollisionObject implements Drawable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1398257669261204022L;
	
	private int loadMapID;

	public ChangeMapCollidableObject(int x, int y, int width, int height, ObjectType type, BufferedImage image, int loadMapID) {
		
		super(x, y, width, height, type, image, false);
		this.loadMapID = loadMapID;
		
	}

	@Override
	public void collide(Entity e) {
		
		if (e instanceof Player && e.getId() == EntityID.PLAYER) {
			
			Game.MAP_HANDLER().CURRENT_MAP_ID = this.loadMapID;
			Game.resetPlayerPosToCenter();
			
		}
		
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
