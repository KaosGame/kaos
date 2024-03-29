package com.github.kaosgame.kaos.entities.items.bow.standard.bullet;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

import com.github.kaosgame.kaos.entities.base.DamageableEntity;
import com.github.kaosgame.kaos.entities.base.Entity;
import com.github.kaosgame.kaos.entities.base.EntityDeathMessages;
import com.github.kaosgame.kaos.entities.base.EntityID;
import com.github.kaosgame.kaos.logging.LogType;
import com.github.kaosgame.kaos.main.Game;
import com.github.kaosgame.kaos.particles.ParticleTypes;
import com.github.kaosgame.kaos.particles.images.ImageParticleTypes;
import com.github.kaosgame.kaos.particles.images.ParticleImages;

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
				
				Game.logln("Player did " + Game.PLAYER.calculateAttackDamage(this.damage) + " to an entity", LogType.INFO);
				
				if (!e.getId().equals(EntityID.MONSTER_LEATH)) {
					
					this.makeDamageParticle(e.getX(), e.getY());
					
				} else {
					
					ImageParticleTypes.FALL_1.make((int) (e.getX() + e.getWidth()), e.getY(), 16, 16, null, null, ParticleImages.MONSTER_LEATH_ATTACK_1);
					
				}
				
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
	
	private void makeDamageParticle(float x, float y) {
		
		ParticleTypes.FALL_3.make(x, y, 8, 8, new Color(146, 0, 0), null, null);
		
	}
	
}
