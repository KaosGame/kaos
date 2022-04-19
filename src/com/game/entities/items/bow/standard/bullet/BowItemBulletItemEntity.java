package com.game.entities.items.bow.standard.bullet;

import java.awt.image.BufferedImage;
import java.util.LinkedList;

import com.game.entities.base.DamageableEntity;
import com.game.entities.base.Entity;
import com.game.entities.base.EntityDeathMessages;
import com.game.entities.base.EntityID;
import com.game.logging.LogType;
import com.game.main.Game;

public class BowItemBulletItemEntity extends Entity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2672493654550174629L;
	
	private float damage;

	public BowItemBulletItemEntity(float x, float y, float xv, float yv, int width, int height, EntityID id,
			BufferedImage image, float damage) {
		
		super(x, y, xv, yv, width, height, id, image);
		this.setDamage(damage);
		Game.logln("Player shot a bullet", LogType.INFO);
		
		
		
	}

	@Override
	public void update() {
		
		LinkedList<Entity> tempEntityList = Game.MAP_HANDLER().currentMap().getEntityHandler().getList();
		
		for (int i = 0; i < tempEntityList.size(); i++) {
			
			if (!(tempEntityList.get(i) instanceof DamageableEntity)) continue;
			
			DamageableEntity e = (DamageableEntity) tempEntityList.get(i);
			
			if (e.getId() == EntityID.PLAYER) continue;
			
			if (this.getRectangle().intersects(e.getRectangle())) {
				
				e.damage(Game.PLAYER.calculateAttackDamage(this.damage), EntityDeathMessages.PLAYER_BOW_STANDARD_BULLET);
				
				Game.MAP_HANDLER().currentMap().getEntityHandler().remove(this);
				
				Game.logln("Player did " + this.damage + " to an entity", LogType.INFO);
				
				break;
				
			}
			
		}
		
		this.x += this.xv;
		this.y += this.yv;
		
		if (this.x > Game.WIDTH || this.x < 0f || this.y > Game.HEIGHT || this.y < 0f
				|| (this.xv == 0f && this.yv == 0f))
			Game.MAP_HANDLER().currentMap().getEntityHandler().remove(this);
		
	}

	public float getDamage() {
		return this.damage;
	}

	public void setDamage(float damage) {
		this.damage = damage;
	}

}
