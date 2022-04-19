package com.game.entities;

import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Random;

import com.game.collision.objects.base.CollisionObject;
import com.game.collision.objects.base.ObjectType;
import com.game.entities.base.DamageableEntity;
import com.game.entities.base.EntityDeathMessages;
import com.game.entities.base.EntityID;
import com.game.logging.LogType;
import com.game.main.Game;
import com.game.spawning.base.Spawnable;

public class AxolotlEntity extends DamageableEntity implements Spawnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8507241084184406062L;
	
	public static final float SPEED = 1f;
	
	private long targetTime;
	private long waterTime;
	private float[] targetPos;

	public AxolotlEntity(float x, float y, int width, int height, EntityID id, BufferedImage image) {
		
		super(x, y, 0, 0, width, height, id, image, 5f, false);
		this.targetTime = 0L;
		this.waterTime = 10800L;
		this.targetPos = new float[2];
		this.handleMoving();
		
		
		
	}

	public AxolotlEntity() {
		
		super(0, 0, 0, 0, 0, 0, null, null, 0, false);
		this.targetTime = 0L;
		this.waterTime = 10800L;
		this.targetPos = new float[2];
		
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
	public void damage(float num, EntityDeathMessages deathType) {
		
		if (deathType == EntityDeathMessages.WATER_DROWNED || deathType == EntityDeathMessages.WATER_FALL) return;
		
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
	public void update() {
		
		boolean inWater = true;
		
		LinkedList<CollisionObject> tempCollList = Game.MAP_HANDLER().currentMap().getObjectList();
		
		for (int i = 0; i < tempCollList.size(); i++) {
			
			CollisionObject o = tempCollList.get(i);
			
			if (o.getType() == ObjectType.WATER && this.getRectangle().intersects(o.getRectangle())) inWater = true;
			
			if (o.getType() != ObjectType.WATER && this.getRectangle().intersects(o.getRectangle())) inWater = false;
			
		}
		
		if (!Game.touchingSomethingTheTrueOne(this.getRectangle())) inWater = false;
		
		if (inWater) {
			
			this.waterTime = 10800L;
			
		} else {
			
			this.waterTime--;
			
		}
		
		this.handleWaterTime();
		
		this.handleMoving();
		
		this.handleImage();
		
		if (this.x > Game.WIDTH || this.x < 0f || this.y > Game.HEIGHT || this.y < 0f) this.die();
		
		final float OLD_X = this.x;
		final float OLD_Y = this.y;
		
		this.x += this.xv;
		this.y += this.yv;
		
		this.handleCollidableObjects(OLD_X, OLD_Y);
		
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
	
	public void handleImage() {
		
		if (Game.isPositive(this.xv) && Game.isPositive(this.yv)) {
			
			this.image = Game.AXOLOTL_TEXTRA_ALICE.getImageFrom(0, 0, 16, 16);
			
		} else if (Game.isNegative(this.xv) && Game.isNegative(this.yv)) {
			
			this.image = Game.AXOLOTL_TEXTRA_ALICE.getImageFrom(16, 0, 16, 16);
			
		}
		
		if (Game.isPositive(this.xv) && Game.isNegative(this.yv)) {
			
			this.image = Game.AXOLOTL_TEXTRA_ALICE.getImageFrom(0, 0, 16, 16);
			
		}
		
		if (Game.isNegative(this.xv) && Game.isPositive(this.yv)) {
			
			this.image = Game.AXOLOTL_TEXTRA_ALICE.getImageFrom(16, 0, 16, 16);
			
		}
		
	}

	private void handleWaterTime() {
		
		if (this.waterTime <= 0L) {
			
			this.die();
			
		}
		
	}

	private void handleMoving() {
		
		this.targetTime--;
		
		if ((this.targetTime <= 0L) || (Game.aroundNumber(Math.round(this.x), Math.round(this.targetPos[0]), 10)
				&& Game.aroundNumber(Math.round(this.y), Math.round(this.targetPos[1]), 10))) {
			
			this.targetTime = 7200L;
			
			float[] target = Game.getRandomPosNotInStuff(this.width, this.height);
			
			this.targetPos = target;
			
		}
		
		float[] newV = Game.calculateDirection(this.targetPos[0], this.targetPos[1], AxolotlEntity.SPEED, this.x, this.y);
		
		this.xv = newV[0];
		this.yv = newV[1];
		
		
	}

	@Override
	public void randomSpawn() {
		
		Random random = new Random();
		
		if (
				random.nextBoolean() && !random.nextBoolean() && random.nextBoolean() && !random.nextBoolean() && random.nextBoolean() && !random.nextBoolean() &&
				random.nextBoolean() && !random.nextBoolean() && random.nextBoolean() && Math.random() < 0.50
			) {
			
			this.spawn();
			
		}
		
	}

	@Override
	public void spawn() {
		
		Random random = new Random();
		
		float[] offset = {random.nextInt(Game.WIDTH), random.nextInt(Game.HEIGHT)};
		
		AxolotlEntity axolotl = new AxolotlEntity(offset[0], offset[1], 64, 64, EntityID.AXOLOTL,
				Game.AXOLOTL_TEXTRA_ALICE.getImageFrom(0, 0, 16, 16));
		
		axolotl.setPos(Game.clamp(axolotl.getX(), (float) (Game.WIDTH - axolotl.getWidth()), 0f),
				Game.clamp(axolotl.getY(), (float) (Game.HEIGHT - (float) (axolotl.getHeight() * 1.3f)), 0f));
		
		int times = 0;
		
		while (!axolotl.inWaterTest()) {
			
			times++;
			
			if (times >= 25) return;
			
			float[] pos = Game.getRandomItemPos(axolotl.getX(), axolotl.getY());
			
			axolotl.setPos(pos);
			
			axolotl.setPos(Game.clamp(axolotl.getX(), (float) (Game.WIDTH - axolotl.getWidth()), 0f),
					Game.clamp(axolotl.getY(), (float) (Game.HEIGHT - (float) (axolotl.getHeight() * 1.3f)), 0f));
			
			
		}
		
		Game.addEntity(axolotl);
		
		Game.logln("New axolotl summoned successfully", LogType.SUCCESS);
		
	}
	
	public void setPos(float[] pos) {
		
		this.setPos(pos[0], pos[1]);
		
	}
	
	public void setPos(float x, float y) {
		
		this.x = x;
		this.y = y;
		
	}
	
	public boolean inWaterTest() {
		
		LinkedList<CollisionObject> tempCollList = Game.MAP_HANDLER().currentMap().getObjectList();
		
		for (int i = 0; i < tempCollList.size(); i++) {
			
			CollisionObject o = tempCollList.get(i);
			
			if (o.getType() == ObjectType.WATER && this.getRectangle().intersects(o.getRectangle())) return true;
			
		}
		
		return false;
		
	}
	
}
