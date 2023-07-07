package com.dodgydavid.kaos.entities;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.LinkedList;

import com.dodgydavid.kaos.entities.base.DamageableEntity;
import com.dodgydavid.kaos.entities.base.Entity;
import com.dodgydavid.kaos.entities.base.EntityDeathMessages;
import com.dodgydavid.kaos.entities.base.EntityID;
import com.dodgydavid.kaos.main.Game;
import com.dodgydavid.kaos.particles.ParticleTypes;
import com.dodgydavid.kaos.particles.images.ImageParticleTypes;
import com.dodgydavid.kaos.particles.images.ParticleImages;
import com.dodgydavid.kaos.sound.Sounds;

public class IsawawabubEntity extends DamageableEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6537179158372953782L;
	
	public static final float DAMAGE = 17.82f;
	public static final float SPEED = 7.1475f;
	public static final float HEALTH = 250;
	
	private long timeToAttack;
	private long timeInAttack;
	private boolean isAttacking;
	
	private int targetX;
	private int targetY;

	public IsawawabubEntity(float x, float y) {
		super(x, y, 0, 0, 128, 128, EntityID.ISAWAWABUB, Game.ISAWAWABUB_TEXTRA_ALICE.getImageFrom(0, 0, 32, 32), 250, true);
		
		this.timeToAttack = 300L; // max 300 time to the next attack
		this.timeInAttack = 0L; // max 75 when the attack started
		this.isAttacking = false; // is in an attack
		this.targetX = 0;
		this.targetY = 0;
	
	}

	@Override
	public void die(EntityDeathMessages message) {
		
		Game.SE_SOUND.setSound(Sounds.ISAWAWABUB_END);
		Game.SE_SOUND.play();
		
		Game.MAP_HANDLER().currentMap().getEntityHandler().remove(this);
		
		Game.PLAYER.addAttack(3L);
		Game.PLAYER.addDefence(4L);
		
	}

	@Override
	public void die() {
		
		this.die(null);
		
	}

	@Override
	public void update() {
		
		this.timeToAttack--;
		this.timeInAttack--;
		
		if (this.timeToAttack <= 0) {
			
			this.timeInAttack = 75;
			this.timeToAttack = 300;
			
			this.isAttacking = true;
			
			
		}
		
		
		if (this.isAttacking && this.timeInAttack <= 0) {
			
			float tempX = (float) (this.x + (float) (this.width - 64));
			
			float diffX = (float) ((float) (tempX - Game.PLAYER.getX()) - 8);
			float diffY = (float) ((float) (this.y - Game.PLAYER.getY()) - 8);
			
			float distance = (float) Math.sqrt(
													
													(double) (
																(double) (
																
																	(double) (
																			tempX - Game.PLAYER.getX()	
																			) *
																	(double) (
																			tempX - Game.PLAYER.getX()	
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
			
			final float SPEED = -IsawawabubEntity.SPEED;
			
			float xv = (float) ((float) (SPEED / distance) * diffX);
			float yv = (float) ((float) (SPEED / distance) * diffY);
			
			this.xv = xv;
			this.yv = yv;
			
			this.isAttacking = false;
			
			this.targetX = Math.round(Game.PLAYER.getX());
			this.targetY = Math.round(Game.PLAYER.getY());
			
			Game.SE_SOUND.setSound(Sounds.ISAWAWABUB_ATTACK);
			Game.SE_SOUND.play();
			
			ImageParticleTypes.FALL_1.make(this.x, this.y, 16, 16, null, null, ParticleImages.SMOKE_1);
			
			
		}
		
		if (this.getRectangle().intersects(Game.PLAYER.getRectangle())) {
			
			this.isAttacking = false;
			this.timeToAttack = 300;
			
			this.xv = 0;
			this.yv = 0;
			
			Game.PLAYER.damage(IsawawabubEntity.DAMAGE, EntityDeathMessages.ISAWAWABUB);
			
		}
		
		if (
				
				Game.aroundNumber((int) this.x, this.targetX, 48) &&
				Game.aroundNumber((int) this.y, this.targetY, 48)
				
				
			) {
			
			
			this.xv = 0;
			this.yv = 0;
			
			
		}
			
			
		
		this.x += this.xv;
		this.y += this.yv;
		
		this.handleImage();
		
		this.x = Game.clamp(this.x, (float) (Game.WIDTH - this.width), 0f);
		this.y = Game.clamp(this.y, (float) (Game.HEIGHT - (float) (this.height * 1.1f)), 0f);
		
		
	}

	@Override
	public void damage(float num, EntityDeathMessages deathType) {
		
		float tempHP = (float) (this.health - num);
		
		if (tempHP <= 0) {
			
			this.die(deathType);
			
		} else {
			
			this.health -= num;
			
		}
		
		ParticleTypes.FALL_3.make(this.x, this.y, 8, 8, new Color(75, 0, 0), null, null);
		
	}

	@Override
	public void damage(float num) {
		
		this.damage(num, null);
		
	}
	
	public void handleImage() {
		
		if (Game.isPositive(this.xv) && Game.isPositive(this.yv)) {
			
			this.image = Game.ISAWAWABUB_TEXTRA_ALICE.getImageFrom(0, 0, 32, 32);
			
		} else if (Game.isNegative(this.xv) && Game.isNegative(this.yv)) {
			
			this.image = Game.ISAWAWABUB_TEXTRA_ALICE.getImageFrom(32, 0, 32, 32);
			
		}
		
		if (Game.isPositive(this.xv) && Game.isNegative(this.yv)) {
			
			this.image = Game.ISAWAWABUB_TEXTRA_ALICE.getImageFrom(0, 0, 32, 32);
			
		}
		
		if (Game.isNegative(this.xv) && Game.isPositive(this.yv)) {
			
			this.image = Game.ISAWAWABUB_TEXTRA_ALICE.getImageFrom(32, 0, 32, 32);
			
		}
		
	}
	
	public static final boolean onScreen() {
		
		LinkedList<Entity> elist = Game.MAP_HANDLER().currentMap().getEntityHandler().getList();
		
		for (int i = 0; i < elist.size(); i++) {
			
			Entity e = elist.get(i);
			
			if (e.getId() == EntityID.ISAWAWABUB) return true;
			
		}
		
		return false;
		
	}
	
	public static final IsawawabubEntity get() {
		
		if (IsawawabubEntity.onScreen()) {
			
			LinkedList<Entity> elist = Game.MAP_HANDLER().currentMap().getEntityHandler().getList();
			
			for (int i = 0; i < elist.size(); i++) {
				
				Entity e = elist.get(i);
				
				if (e.getId() == EntityID.ISAWAWABUB) return ((IsawawabubEntity) e);
				
			}
			
		}
		
		return null;
		
	}
	
	public static final void drawBossBar(Graphics2D g2d) {
		
		g2d.setColor(new Color(75, 75, 75));
		g2d.fillRect(276, 25, 216, 64);
		g2d.setColor(new Color(38, 38, 38));
		g2d.setStroke(new BasicStroke(2));
		g2d.drawRect(276, 25, 216, 64);
		
		g2d.setColor(new Color(75, Math.round((IsawawabubEntity.get().getHealth() / 25) * 20), 0));
		g2d.fillRect(284, 31, Math.round((IsawawabubEntity.get().getHealth() / 25) * 20), 48);
		
		g2d.setColor(new Color(0xC0C0C0));
		g2d.setStroke(new BasicStroke(2));
		g2d.drawRect(284, 31, 200, 48);
		
	}

	public long getTimeToAttack() {
		return timeToAttack;
	}

	public void setTimeToAttack(long timeToAttack) {
		this.timeToAttack = timeToAttack;
	}

	public long getTimeInAttack() {
		return timeInAttack;
	}

	public void setTimeInAttack(long timeInAttack) {
		this.timeInAttack = timeInAttack;
	}

	public boolean isAttacking() {
		return isAttacking;
	}

	public void setAttacking(boolean isAttacking) {
		this.isAttacking = isAttacking;
	}

	public int getTargetX() {
		return targetX;
	}

	public void setTargetX(int targetX) {
		this.targetX = targetX;
	}

	public int getTargetY() {
		return targetY;
	}

	public void setTargetY(int targetY) {
		this.targetY = targetY;
	}


}
