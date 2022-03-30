package com.game.entities.bad;

import java.awt.image.BufferedImage;
import java.util.Random;

import com.game.entities.base.DamageableEntity;
import com.game.entities.base.EntityDeathMessages;
import com.game.entities.base.EntityID;
import com.game.main.Game;

public class ZombieEntity extends DamageableEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4707682148300966924L;

	public ZombieEntity(float x, float y, float xv, float yv, int width, int height, EntityID id, BufferedImage image,
			float health) {
		super(x, y, xv, yv, width, height, id, image, health);
		
	}
	
	public ZombieEntity(float x, float y, int width, int height, EntityID id, BufferedImage image) {
		super(x, y, 0f, 0f, width, height, id, image, 20f);
		
	}

	@Override
	public void die(EntityDeathMessages message) {
		
		Game.MAP_HANDLER().currentMap().getEntityHandler().remove(this);
		
	}

	@Override
	public void die() {
		
		Game.MAP_HANDLER().currentMap().getEntityHandler().remove(this);
		
	}

	@Override
	public void update() {
		
		this.x = Game.clamp(this.x, (float) (Game.WIDTH - this.width), 0f);
		this.y = Game.clamp(this.y, (float) (Game.HEIGHT - (float) (this.height * 1.3f)), 0f);
		
		Random random = new Random();
		
		if (
				this.getRectangle().intersects(Game.PLAYER.getRectangle()) &&
				random.nextBoolean() && !random.nextBoolean() && random.nextBoolean() && Math.random() < 0.50
				
			) {
			
			Game.PLAYER.damage(1f);
			
		}
		
	}

	@Override
	public void damage(float num, EntityDeathMessages deathType) {
		
		float tempHP = (float) (this.health - num);
		
		if (tempHP <= 0) {
			
			this.die(deathType);
			
		} else {
			
			this.health -= num;
			
		}
		
	}
	
	@Override
	public void damage(float num) {
		
		this.damage(num, null);
		
	}

}
