package com.dodgydavid.kaos.entities.player.items.tools.weapon;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

import com.dodgydavid.kaos.entities.base.DamageableEntity;
import com.dodgydavid.kaos.entities.base.Entity;
import com.dodgydavid.kaos.entities.base.EntityID;
import com.dodgydavid.kaos.entities.player.items.base.ItemID;
import com.dodgydavid.kaos.entities.player.items.base.WeaponItem;
import com.dodgydavid.kaos.main.Game;
import com.dodgydavid.kaos.particles.ParticleTypes;
import com.dodgydavid.kaos.particles.images.ImageParticleTypes;
import com.dodgydavid.kaos.particles.images.ParticleImages;

public class SwordItem extends WeaponItem<SwordItem> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 480082285209695321L;

	public SwordItem(int count, ItemID id, BufferedImage image) {
		super(count, id, image, 1.43412f);
		
		
	}
	
	private SwordItem(int count, ItemID id, BufferedImage image, float damage) {
		super(count, id, image, damage);
		
		
	}

	@Override
	public SwordItem cloneType() {
		return new SwordItem(this.count, this.id, this.image, this.damage);
	}

	@Override
	public void use() {
		
		LinkedList<Entity> tempEList = Game.MAP_HANDLER().currentMap().getEntityHandler().getList();
		
		for (int i = 0; i < tempEList.size(); i++) {
			
			Entity e = tempEList.get(i);
			
			if (e.equals(Game.PLAYER)) continue;
			
			if (e instanceof DamageableEntity && Game.PLAYER.getRectangle().intersects(e.getRectangle()) && Math.random() < 0.50) {
				
				((DamageableEntity) e).damage(Game.PLAYER.calculateAttackDamage(this.damage));
				
				if (!e.getId().equals(EntityID.MONSTER_LEATH)) {
					
					this.makeDamageParticle(e.getX(), e.getY());
					
				} else {
					
					ImageParticleTypes.FALL_1.make((int) (e.getX() + e.getWidth()), e.getY(), 16, 16, null, null, ParticleImages.MONSTER_LEATH_ATTACK_1);
					
				}
				
			}
			
		}
		
	}
	
	private void makeDamageParticle(float x, float y) {
		
		ParticleTypes.FALL_3.make(x, y, 8, 8, new Color(140, 0, 0), null, null);
		
	}

}
