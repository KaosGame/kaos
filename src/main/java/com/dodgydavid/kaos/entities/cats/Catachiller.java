package com.dodgydavid.kaos.entities.cats;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.LinkedList;
import java.util.Random;

import com.dodgydavid.kaos.entities.base.DamageableEntity;
import com.dodgydavid.kaos.entities.base.Entity;
import com.dodgydavid.kaos.entities.base.EntityDeathMessages;
import com.dodgydavid.kaos.entities.base.EntityID;
import com.dodgydavid.kaos.main.Game;
import com.dodgydavid.kaos.sound.Sounds;

public class Catachiller extends DamageableEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7795382367090279665L;

	public Catachiller(float x, float y) {
		super(x, y, 0, 0, 96, 64, EntityID.CATACHILLER, Game.CATACHILLER_TEXTRA_ALICE.getImageFrom(0, 0, 48, 32), 175,
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
		
		final float SPEED = -2.0f;
		
		this.xv = (float) ((float) (SPEED / distance) * diffX);
		this.yv = (float) ((float) (SPEED / distance) * diffY);
		
		
		Random random = new Random();
		
		if (
				this.getRectangle().intersects(Game.PLAYER.getRectangle()) &&
				random.nextBoolean() && !random.nextBoolean() && random.nextBoolean() && Math.random() < 0.50
				
			) {
			
			final float DAMAGE = 3f;
			
			Game.PLAYER.damage(DAMAGE, EntityDeathMessages.CATACHILLER);
			
			Game.SE_SOUND.setSound(Sounds.CATACHILLER_HISS);
			Game.SE_SOUND.play();
			
		}
		
		this.handleImage();
		
	}
	
	public void handleImage() {
		
		if (Game.isPositive(this.xv) && Game.isPositive(this.yv)) {
			
			this.image = Game.CATACHILLER_TEXTRA_ALICE.getImageFrom(0, 0, 48, 32);
			
		} else if (Game.isNegative(this.xv) && Game.isNegative(this.yv)) {
			
			this.image = Game.CATACHILLER_TEXTRA_ALICE.getImageFrom(48, 0, 48, 32);
			
		}
		
		if (Game.isPositive(this.xv) && Game.isNegative(this.yv)) {
			
			this.image = Game.CATACHILLER_TEXTRA_ALICE.getImageFrom(0, 0, 48, 32);
			
		}
		
		if (Game.isNegative(this.xv) && Game.isPositive(this.yv)) {
			
			this.image = Game.CATACHILLER_TEXTRA_ALICE.getImageFrom(48, 0, 48, 32);
			
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
	
	public static final void drawBossBar(Graphics2D g2d) {
		
		g2d.setColor(new Color(75, 75, 75));
		g2d.fillRect(276, 25, 216, 64);
		g2d.setColor(new Color(38, 38, 38));
		g2d.setStroke(new BasicStroke(2));
		g2d.drawRect(276, 25, 216, 64);
		
		g2d.setColor(new Color(75, (int) Math.round(Catachiller.get().getHealth() * 1.14), 0));
		g2d.fillRect(284, 31, (int) Math.round(Catachiller.get().getHealth() * 1.14), 48);
		
		g2d.setColor(new Color(0xC0C0C0));
		g2d.setStroke(new BasicStroke(2));
		g2d.drawRect(284, 31, 200, 48);
		
	}
	
	public static final boolean onScreen() {
		
		LinkedList<Entity> elist = Game.MAP_HANDLER().currentMap().getEntityHandler().getList();
		
		for (int i = 0; i < elist.size(); i++) {
			
			Entity e = elist.get(i);
			
			if (e.getId() == EntityID.CATACHILLER) return true;
			
		}
		
		return false;
		
	}
	
	public static final Catachiller get() {
		
		if (Catachiller.onScreen()) {
			
			LinkedList<Entity> elist = Game.MAP_HANDLER().currentMap().getEntityHandler().getList();
			
			for (int i = 0; i < elist.size(); i++) {
				
				Entity e = elist.get(i);
				
				if (e.getId() == EntityID.CATACHILLER) return ((Catachiller) e);
				
			}
			
		}
		
		return null;
		
	}

}
