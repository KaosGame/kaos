package com.dodgydavid.kaos.entities.monster.leath;


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

public final class MonsterLeath extends DamageableEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5810126510350532687L;
	public static final float HEALTH = 100f;
	public static final float DAMAGE = 3f;

	public MonsterLeath(float x, float y) {
		super(x, y, 0, 0, 256, 256, EntityID.MONSTER_LEATH, Game.MONSTER_LEATH_IMAGE_LOADER.getImage(), MonsterLeath.HEALTH, true);
		
		
	}

	@Override
	public void die(EntityDeathMessages message) {
		
		Game.SE_SOUND.setSound(Sounds.MONSTER_LEATH_END);
		Game.SE_SOUND.play();
		
		Game.PLAYER.addAttack(2L);
		Game.PLAYER.addDefence(3L);
		
		Game.MAP_HANDLER().currentMap().getEntityHandler().remove(this);
		
	}

	@Override
	public void die() {
		
		this.die(null);
		
	}

	@Override
	public void update() {
		
		
		Random random = new Random();
		
		if (
				random.nextBoolean() && !random.nextBoolean() && random.nextBoolean() && Math.random() < 0.50 &&
				random.nextBoolean()
			) {
			
			this.makeApple();
			
			this.damage(0.0001f);
			
		}
		
		
	}
	
	public void makeApple() {
		
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
		
		final float SPEED = -MonsterLeathLeathEntity.SPEED;
		
		float xv = (float) ((float) (SPEED / distance) * diffX);
		float yv = (float) ((float) (SPEED / distance) * diffY);
		
		MonsterLeathLeathEntity leath = new MonsterLeathLeathEntity(tempX, this.y, xv, yv, 32, 32);
		
		Game.MAP_HANDLER().currentMap().getEntityHandler().add(leath);
		
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
	
	public static final boolean onScreen() {
		
		LinkedList<Entity> elist = Game.MAP_HANDLER().currentMap().getEntityHandler().getList();
		
		for (int i = 0; i < elist.size(); i++) {
			
			Entity e = elist.get(i);
			
			if (e.getId() == EntityID.MONSTER_LEATH) return true;
			
		}
		
		return false;
		
	}
	
	public static final void drawBossBar(Graphics2D g2d) {
		
		g2d.setColor(new Color(75, 75, 75));
		g2d.fillRect(276, 25, 216, 64);
		g2d.setColor(new Color(38, 38, 38));
		g2d.setStroke(new BasicStroke(2));
		g2d.drawRect(276, 25, 216, 64);
		
		g2d.setColor(new Color(75, Math.round(MonsterLeath.getLeath().getHealth() * 2), 0));
		g2d.fillRect(284, 31, Math.round(MonsterLeath.getLeath().getHealth() * 2), 48);
		
		g2d.setColor(new Color(0xC0C0C0));
		g2d.setStroke(new BasicStroke(2));
		g2d.drawRect(284, 31, 200, 48);
		
	}
	
	public static final MonsterLeath getLeath() {
		
		if (MonsterLeath.onScreen()) {
			
			LinkedList<Entity> elist = Game.MAP_HANDLER().currentMap().getEntityHandler().getList();
			
			for (int i = 0; i < elist.size(); i++) {
				
				Entity e = elist.get(i);
				
				if (e.getId() == EntityID.MONSTER_LEATH) return ((MonsterLeath) e);
				
			}
			
		}
		
		return null;
		
	}

}
