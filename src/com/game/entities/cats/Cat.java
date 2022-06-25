package com.game.entities.cats;

import java.util.LinkedList;
import java.util.Random;

import com.game.entities.base.DamageableEntity;
import com.game.entities.base.Entity;
import com.game.entities.base.EntityDeathMessages;
import com.game.entities.base.EntityID;
import com.game.main.Game;
import com.game.spawning.base.Spawnable;

public class Cat extends DamageableEntity implements Spawnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -687918089084105282L;
	
	public static final float SPEED = 1.5846f;
	public static final int MAX_CATS_ON_SCREEN = 3;
	
	private float targetX;
	private float targetY;
	
	public Cat(float x, float y) {
		super(x, y, 0, 0, 64, 64, EntityID.CAT, Game.CAT_TEXTRA_ALICE.getImageFrom(0, 0, 32, 32), 20, false);
		
		
		this.findTarget();
		
		
	}

	public Cat() {
		super(0, 0, 0, 0, 64, 64, null, null, 0, false);
		
	}
	
	private void findTarget() {
		
		Random random = new Random();
		
		final int OFFSET = 32;
		
		float tx = (float) ((int) random.nextInt(((int) Game.WIDTH - OFFSET)) + OFFSET);
		float ty = (float) ((int) random.nextInt(((int) Game.HEIGHT - OFFSET)) + OFFSET);
		
		this.targetX = tx;
		this.targetY = ty;
		
	}
	

	@Override
	public void die(EntityDeathMessages message) {
		
		this.die();
		
	}

	@Override
	public void die() {
		
		Random random = new Random();
		
		final int OFFSET = 32;
		
		float tx = (float) ((int) random.nextInt(((int) Game.WIDTH - OFFSET)) + OFFSET);
		float ty = (float) ((int) random.nextInt(((int) Game.HEIGHT - OFFSET)) + OFFSET);
		
		Game.addEntity(new Kittnasours(tx, ty));
		
		Game.MAP_HANDLER().currentMap().getEntityHandler().remove(this);
		
	}

	@Override
	public void update() {
		
		float[] directions = Game.calculateDirection(this.targetX, this.targetY, Cat.SPEED, this.x, this.y);
		
		this.xv = directions[0];
		this.yv = directions[1];
		
		this.updateImage();
		
		
		boolean goodTargetX = Game.aroundNumber((int) this.x, (int) this.targetX, 16);
		boolean goodTargetY = Game.aroundNumber((int) this.y, (int) this.targetY, 16);
		
		if (goodTargetX && goodTargetY) {
			
			this.findTarget();
			
		}
		
		
		this.x += this.xv;
		this.y += this.yv;
		
		
	}

	public void updateImage() {
		
		if (Game.isPositive(this.xv) && Game.isPositive(this.yv)) {

			this.image = Game.CAT_TEXTRA_ALICE.getImageFrom(0, 0, 32, 32);

		} else if (Game.isNegative(this.xv) && Game.isNegative(this.yv)) {

			this.image = Game.CAT_TEXTRA_ALICE.getImageFrom(32, 0, 32, 32);

		}

		if (Game.isPositive(this.xv) && Game.isNegative(this.yv)) {

			this.image = Game.CAT_TEXTRA_ALICE.getImageFrom(0, 0, 32, 32);

		}

		if (Game.isNegative(this.xv) && Game.isPositive(this.yv)) {

			this.image = Game.CAT_TEXTRA_ALICE.getImageFrom(32, 0, 32, 32);

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

		float tempHP = (float) (this.health - num);
		
		if (tempHP <= 0) {
			
			this.die();
			
		} else {
			
			this.health -= num;
			
		}
		
	}
	
	public static int catCount() {
		
		int cats = 0;
		
		LinkedList<Entity> el = Game.MAP_HANDLER().currentMap().getEntityHandler().getList();
		
		for (int i = 0; i < el.size(); i++) if (el.get(i).getId().equals(EntityID.CAT)) cats++;
		
		
		return cats;
		
	}

	@Override
	public void spawn() {
		
		if (Cat.catCount() < Cat.MAX_CATS_ON_SCREEN) {
			
			Random random = new Random();
			
			final int OFFSET = 32;
			
			float x = (float) ((int) random.nextInt(((int) Game.WIDTH - OFFSET)) + OFFSET);
			float y = (float) ((int) random.nextInt(((int) Game.HEIGHT - OFFSET)) + OFFSET);
			
			Game.MAP_HANDLER().currentMap().getEntityHandler().add(new Cat(x, y));
			
		}
		
	}
	
	public void randomSpawn() {
		
		Random random = new Random();
		
		if (
				random.nextBoolean() && !random.nextBoolean() && random.nextBoolean() && !random.nextBoolean() && random.nextBoolean() && !random.nextBoolean() &&
				random.nextBoolean() && !random.nextBoolean() && random.nextBoolean() && !random.nextBoolean()
			) {
			
			this.spawn();
			
		}
		
	}

	
	
}
