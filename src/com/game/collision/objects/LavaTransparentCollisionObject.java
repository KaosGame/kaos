package com.game.collision.objects;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.game.collision.objects.base.CollisionObject;
import com.game.collision.objects.base.ObjectType;
import com.game.entities.base.DamageableEntity;
import com.game.entities.base.Entity;
import com.game.entities.base.EntityDeathMessages;
import com.game.main.Drawable;
import com.game.random.RandomChance;

public class LavaTransparentCollisionObject extends CollisionObject implements Drawable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1468060883266213497L;

	public LavaTransparentCollisionObject(int x, int y, int width, int height, ObjectType type, BufferedImage image) {
		
		super(x, y, width, height, type, image, true);
		
		
	}

	@Override
	public void draw(Graphics2D g2d) {
		
		g2d.drawImage(this.image, this.x, this.y, this.width, this.height, null);
		
	}

	@Override
	public void collide(Entity e) {
		
		RandomChance chance = new RandomChance();
		
		if (chance.lastChoose(0.35) && chance.lastChoose(0.76)) {
			
			if (e instanceof DamageableEntity) ((DamageableEntity) e).damage(1.864f, EntityDeathMessages.LAVA);
			
		}
		
	}

}
