package com.game.entities.bad.zombie.rock;

import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Random;

import com.game.collision.objects.base.CollisionObject;
import com.game.entities.base.DamageableEntity;
import com.game.entities.base.EntityDeathMessages;
import com.game.entities.base.EntityID;
import com.game.logging.LogType;
import com.game.main.Game;
import com.game.spawning.base.Spawnable;

public class RockZombieEntity extends DamageableEntity implements Spawnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5057396293343730943L;

	public RockZombieEntity(float x, float y, float xv, float yv, int width, int height, EntityID id,
			BufferedImage image) {
		super(x, y, xv, yv, width, height, id, image, 12.5f);
		
		
	}
	
	public RockZombieEntity() {
		
		this(0, 0, 0, 0, 0, 0, null, null);
		
		
	}

	@Override
	public void die(EntityDeathMessages message) {
		
		this.die();
		
	}

	@Override
	public void die() {
		
		Game.MAP_HANDLER().currentMap().getEntityHandler().remove(this);
		
	}

	@Override
	public void update() {
		
		final float OLD_X = this.x;
		final float OLD_Y = this.y;
		
		Random random = new Random();
		
		if (
				random.nextBoolean() && !random.nextBoolean() && random.nextBoolean() && Math.random() < 0.50 &&
				random.nextBoolean() && !random.nextBoolean() && Math.random() < 0.50
			) this.makeRock();
		
		
		if (
				random.nextBoolean() && !random.nextBoolean() && random.nextBoolean() && !random.nextBoolean() &&
				random.nextBoolean() && !random.nextBoolean()
			) {
				
			byte dir = (byte) (random.nextInt(4));
			
			
			switch (dir) {
			
				case 0: // Up
					this.y -= this.height;
					break;
					
				case 1: // Down
					this.y += this.height;
					break;
					
				case 2: // Left
					this.x -= this.width;
					break;
					
				case 3: // Right
					this.x += this.width;
					break;
			
			}
				
		}
				
				
		this.handleCollidableObjects(OLD_X, OLD_Y);
		
		this.x = Game.clamp(this.x, (float) (Game.WIDTH - this.width), 0f);
		this.y = Game.clamp(this.y, (float) (Game.HEIGHT - (float) (this.height * 1.3f)), 0f);
		
	}
	
	private void makeRock() {
		
		float diffX = (float) ((float) (this.x - Game.PLAYER.getX()) - 8);
		float diffY = (float) ((float) (this.y - Game.PLAYER.getY()) - 8);
		
		float distance = (float) Math.sqrt(
												
												(double) (
															(double) (
															
																(double) (
																		this.x - Game.PLAYER.getX()	
																		) *
																(double) (
																		this.x - Game.PLAYER.getX()	
																		)
															
															) + (double) (
																	
																	(double) (
																			this.y - Game.PLAYER.getY()	
																			) *
																	(double) (
																			this.y - Game.PLAYER.getY()	
																			)
																	
																	))
				
											);
		
		final float SPEED = -RockZombieRockEntity.SPEED;
		
		float xv = (float) ((float) (SPEED / distance) * diffX);
		float yv = (float) ((float) (SPEED / distance) * diffY);
		
		RockZombieRockEntity rock = new RockZombieRockEntity(this.x, this.y, xv, yv, 64, 64, EntityID.ROCK_ZOMBIE_ROCK,
				Game.ZOMBIE_TEXTRA_ALICE.getImageFrom(16, 0, 16, 16));
		
		Game.MAP_HANDLER().currentMap().getEntityHandler().add(rock);
		
		Game.logln("Rock shot", LogType.SUCCESS);
		
	}
	
	private void handleCollidableObjects(final float OLD_X, final float OLD_Y) {
		
		LinkedList<CollisionObject> tempList = Game.MAP_HANDLER().currentMap().getObjectList();
		
		for (int i = 0; i < tempList.size(); i++) {
			
			CollisionObject tempObj = tempList.get(i);
			
			if (this.getRectangle().intersects(tempObj.getRectangle())) {
				
				tempObj.collide(this);
				
			}
			
			if (
					this.getRectangle().intersects(tempObj.getRectangle()) &&
					!tempObj.getType().isTRANSPARENT()
				) {
				
				this.x = OLD_X;
				this.y = OLD_Y;
				
			}
			
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
	
	@Override
	public void randomSpawn() {
		
		Random random = new Random();
		
		if (
				random.nextBoolean() && !random.nextBoolean() && random.nextBoolean() && !random.nextBoolean() && random.nextBoolean() && !random.nextBoolean() &&
				random.nextBoolean() && !random.nextBoolean() && random.nextBoolean() && !random.nextBoolean() && Math.random() < 0.50
			) {
			
			this.spawn();
			
		}
		
	}
	
	@Override
	public void spawn() {
		
		Random random = new Random();
		
		float[] offset = {random.nextInt(Game.WIDTH), random.nextInt(Game.HEIGHT)};
		
		RockZombieEntity zombie = new RockZombieEntity(offset[0], offset[1], 0, 0, 64, 64, EntityID.ROCK_ZOMBIE, Game.ZOMBIE_TEXTRA_ALICE.getImageFrom(32, 0, 16, 16));
		
		while (Game.touchingSomething(zombie.getRectangle())) {
			
			float[] pos = Game.getRandomItemPos(zombie.getX(), zombie.getY());
			
			zombie.setPos(pos);
			
		}
		
		Game.addEntity(zombie);
		
		Game.logln("New rock zombie summoned successfully", LogType.SUCCESS);
		
	}
	
	public void setPos(float x, float y) {
		
		this.x = x;
		this.y = y;
		
	}
	
	public void setPos(float[] pos) {
		
		this.setPos(pos[0], pos[1]);
		
	}

}

