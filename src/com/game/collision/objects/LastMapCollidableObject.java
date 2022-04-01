package com.game.collision.objects;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.game.collision.objects.base.CollisionObject;
import com.game.collision.objects.base.ObjectType;
import com.game.entities.base.Entity;
import com.game.entities.base.EntityID;
import com.game.entities.player.Player;
import com.game.main.Drawable;
import com.game.main.Game;

public class LastMapCollidableObject extends CollisionObject implements Drawable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1398257669261204022L;
	

	public LastMapCollidableObject(int x, int y, int width, int height, ObjectType type, BufferedImage image) {
		
		super(x, y, width, height, type, image);
		
	}

	@Override
	public void collide(Entity e) {
		
		if (e instanceof Player && e.getId() == EntityID.PLAYER) {
			
			Game.MAP_HANDLER().CURRENT_MAP_ID = (int) (Game.MAP_HANDLER().CURRENT_MAP_ID - 1);
			Game.resetPlayerPosToCenter();
			
		}
		
	}
	
	@Override
	public void draw(Graphics2D g2d) {
		
		g2d.drawImage(this.image, this.x, this.y, this.width, this.height, null);
		
	}

}
