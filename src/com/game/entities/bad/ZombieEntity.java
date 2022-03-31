package com.game.entities.bad;

import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Random;

import com.game.collision.objects.CollidableObject;
import com.game.collision.objects.CollidableWallObject;
import com.game.collision.objects.PlayerObject;
import com.game.collision.objects.base.CollisionObject;
import com.game.collision.objects.base.ObjectType;
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
		
		final float OLD_X = this.x;
		final float OLD_Y = this.y;
		
		
		this.addVPos();
		
		this.x = Game.clamp(this.x, (float) (Game.WIDTH - this.width), 0f);
		this.y = Game.clamp(this.y, (float) (Game.HEIGHT - (float) (this.height * 1.3f)), 0f);
		
		this.handleCollidableObjects(OLD_X, OLD_Y);
		
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
		
		final float SPEED = -1.0f;
		
		this.xv = (float) ((float) (SPEED / distance) * diffX);
		this.yv = (float) ((float) (SPEED / distance) * diffY);
		
		
		Random random = new Random();
		
		if (
				this.getRectangle().intersects(Game.PLAYER.getRectangle()) &&
				random.nextBoolean() && !random.nextBoolean() && random.nextBoolean() && Math.random() < 0.50
				
			) Game.PLAYER.damage(1f, EntityDeathMessages.ZOMBIE);
		
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
	
	private void handleCollidableObjects(final float OLD_X, final float OLD_Y) {
		
		LinkedList<CollisionObject> tempList = Game.MAP_HANDLER().currentMap().getObjectList();
		
		for (int i = 0; i < tempList.size(); i++) {
			
			CollisionObject tempObj = tempList.get(i);
			
			if (this.getRectangle().intersects(tempObj.getRectangle())) {
				
				tempObj.collide(this);
				
			}
			
			if (
					(
						tempObj.getType() == ObjectType.WALL ||
						tempObj.getType() == ObjectType.STONE_1 ||
						tempObj.getType() == ObjectType.IRON_ORE_1 ||
						tempObj.getType() == ObjectType.GOLD_ORE_1 ||
						tempObj.getType() == ObjectType.DIAMOND_ORE_1
							
					) &&
					(tempObj instanceof CollidableObject || tempObj instanceof CollidableWallObject) &&
					this.getRectangle().intersects(tempObj.getRectangle()) &&
					!tempObj.getType().isTRANSPARENT()
				) {
				
				this.x = OLD_X;
				this.y = OLD_Y;
				
			}
			
			if (
					
					(
							tempObj.getType() == ObjectType.WALL ||
							tempObj.getType() == ObjectType.STONE_1 ||
							tempObj.getType() == ObjectType.IRON_ORE_1 ||
							tempObj.getType() == ObjectType.GOLD_ORE_1 ||
							tempObj.getType() == ObjectType.DIAMOND_ORE_1
								
					) &&
					tempObj instanceof PlayerObject &&
					this.getRectangle().intersects(tempObj.getRectangle()) &&
					!tempObj.getType().isTRANSPARENT()
					
				) {
				
				this.x = OLD_X;
				this.y = OLD_Y;
				
			}
			
		}
		
	}
	
	private void addVPos() {
		
		this.x += this.xv;
		this.y += this.yv;
		
	}

}
