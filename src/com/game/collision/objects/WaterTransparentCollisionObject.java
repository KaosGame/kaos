package com.game.collision.objects;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.game.collision.objects.base.CollisionObject;
import com.game.collision.objects.base.ObjectType;
import com.game.entities.base.EntityDeathMessages;
import com.game.main.Drawable;
import com.game.main.Game;
import com.game.random.RandomChance;

public class WaterTransparentCollisionObject extends CollisionObject implements Drawable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1468060883266213497L;

	public WaterTransparentCollisionObject(int x, int y, int width, int height, ObjectType type, BufferedImage image) {
		
		super(x, y, width, height, type, image);
		
		
	}

	@Override
	public void draw(Graphics2D g2d) {
		
		g2d.drawImage(this.image, this.x, this.y, this.width, this.height, null);
		
	}

	@Override
	public void collide() {
		
		RandomChance chance = new RandomChance();
		
		if (chance.lastChoose(0.35) && chance.lastChoose(0.76)) {
			
			EntityDeathMessages edm = chance.firstChoose(0.50) ? EntityDeathMessages.WATER_DROWNED : EntityDeathMessages.WATER_FALL;
			
			Game.PLAYER.damage(1.4f, edm);
			
		}
		
	}

}
