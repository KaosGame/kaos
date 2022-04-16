package com.game.entities.bad.zombie.rock;

import java.awt.image.BufferedImage;
import java.util.LinkedList;

import com.game.entities.base.DamageableEntity;
import com.game.entities.base.Entity;
import com.game.entities.base.EntityDeathMessages;
import com.game.entities.base.EntityID;
import com.game.logging.LogType;
import com.game.main.Game;

public class RockZombieRockEntity extends Entity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3368297906039098787L;
	
	public static final float DAMAGE = 2.5f;
	public static final float SPEED = 2.5f;

	public RockZombieRockEntity(float x, float y, float xv, float yv, int width, int height, EntityID id,
			BufferedImage image) {
		super(x, y, xv, yv, width, height, id, image);
		
		
	}

	@Override
	public void update() {
		
		this.x += this.xv;
		this.y += this.yv;
		
		if (this.x > Game.WIDTH || this.x < 0f || this.y > Game.HEIGHT || this.y < 0f
				|| (this.xv == 0f && this.yv == 0f)) Game.MAP_HANDLER().currentMap().getEntityHandler().remove(this);
		
		LinkedList<Entity> tempEList = Game.MAP_HANDLER().currentMap().getEntityHandler().getList();
		
		for (int i = 0; i < tempEList.size(); i++) {
			
			if (!(tempEList.get(i) instanceof DamageableEntity)) continue;
			
			DamageableEntity e = (DamageableEntity) tempEList.get(i);
			
			if (e.getId() == EntityID.ROCK_ZOMBIE) continue; 
			
			if (this.getRectangle().intersects(e.getRectangle())) {
				
				e.damage(RockZombieRockEntity.DAMAGE, EntityDeathMessages.ROCK_ZOMBIE_ROCK);
				
				Game.MAP_HANDLER().currentMap().getEntityHandler().remove(this);
				
				Game.logln(String.format("Entity hit by rock and did %f damage!", RockZombieRockEntity.DAMAGE), LogType.SUCCESS);
				
				return;
				
			}
			
		}
		
		if (this.getRectangle().intersects(Game.PLAYER.getRectangle())) {
			
			Game.PLAYER.damage(RockZombieRockEntity.DAMAGE, EntityDeathMessages.ROCK_ZOMBIE_ROCK);
			
			Game.MAP_HANDLER().currentMap().getEntityHandler().remove(this);
			
			Game.logln(String.format("Player hit by rock and did %f damage!", Game.PLAYER.calculateDamage(RockZombieRockEntity.DAMAGE)), LogType.SUCCESS);
			
			return;
			
		}
		
	}

}
