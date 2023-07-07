package com.dodgydavid.kaos.entities.cats;

import java.util.Random;

import com.dodgydavid.kaos.entities.base.DamageableEntity;
import com.dodgydavid.kaos.entities.base.EntityDeathMessages;
import com.dodgydavid.kaos.entities.base.EntityID;
import com.dodgydavid.kaos.main.Game;

public class Kittnasours extends DamageableEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5585019249871031644L;

	public Kittnasours(float x, float y) {
		super(x, y, 0, 0, 96, 64, EntityID.KITTNASOURS, Game.KITTNASOURS_TEXTRA_ALICE.getImageFrom(0, 0, 48, 32), 50,
				true);
		
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
		
		this.x += this.xv;
		this.y += this.yv;
		
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
				
			) {
			
			final float DAMAGE = 1.5f;
			
			Game.PLAYER.damage(DAMAGE, EntityDeathMessages.KITTNASOURS);
			
		}
		
		this.handleImage();
		
	}
	
	public void handleImage() {
		
		if (Game.isPositive(this.xv) && Game.isPositive(this.yv)) {
			
			this.image = Game.KITTNASOURS_TEXTRA_ALICE.getImageFrom(0, 0, 48, 32);
			
		} else if (Game.isNegative(this.xv) && Game.isNegative(this.yv)) {
			
			this.image = Game.KITTNASOURS_TEXTRA_ALICE.getImageFrom(48, 0, 48, 32);
			
		}
		
		if (Game.isPositive(this.xv) && Game.isNegative(this.yv)) {
			
			this.image = Game.KITTNASOURS_TEXTRA_ALICE.getImageFrom(0, 0, 48, 32);
			
		}
		
		if (Game.isNegative(this.xv) && Game.isPositive(this.yv)) {
			
			this.image = Game.KITTNASOURS_TEXTRA_ALICE.getImageFrom(48, 0, 48, 32);
			
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

}
