package com.dodgydavid.kaos.collision.objects;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.dodgydavid.kaos.collision.objects.base.CollisionObject;
import com.dodgydavid.kaos.collision.objects.base.ObjectType;
import com.dodgydavid.kaos.entities.base.DamageableEntity;
import com.dodgydavid.kaos.entities.base.Entity;
import com.dodgydavid.kaos.entities.base.EntityDeathMessages;
import com.dodgydavid.kaos.main.Drawable;
import com.dodgydavid.kaos.random.RandomChance;

public class WaterTransparentCollisionObject extends CollisionObject implements Drawable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1468060883266213497L;

	public WaterTransparentCollisionObject(int x, int y, int width, int height, ObjectType type, BufferedImage image) {
		
		super(x, y, width, height, type, image, true);
		
		
	}

	@Override
	public void draw(Graphics2D g2d) {
		
		g2d.drawImage(this.image, this.x, this.y, this.width, this.height, null);
		
	}

	@Override
	public void collide(Entity e) {
		
		RandomChance chance = new RandomChance();
		
		if (chance.alotOfBooleans() && chance.lastChoose(0.31)) {
			
			EntityDeathMessages edm = chance.firstChoose(0.50) ? EntityDeathMessages.WATER_DROWNED : EntityDeathMessages.WATER_FALL;
			
			if (e instanceof DamageableEntity) ((DamageableEntity) e).damage(1.4f, edm);
			
		}
		
	}

}
