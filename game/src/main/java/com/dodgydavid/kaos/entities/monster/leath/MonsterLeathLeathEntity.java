package com.dodgydavid.kaos.entities.monster.leath;

import java.util.LinkedList;

import com.dodgydavid.kaos.entities.base.DamageableEntity;
import com.dodgydavid.kaos.entities.base.Entity;
import com.dodgydavid.kaos.entities.base.EntityDeathMessages;
import com.dodgydavid.kaos.entities.base.EntityID;
import com.dodgydavid.kaos.main.Game;

public class MonsterLeathLeathEntity extends Entity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 689913183199232120L;
	
	public static final float SPEED = 2.5f;

	public MonsterLeathLeathEntity(float x, float y, float xv, float yv, int width, int height) {
		super(x, y, xv, yv, width, height, EntityID.MONSTER_LEATH_LEATH, Game.ITEM_TEXTRA_ALICE.getImageFrom(64, 0, 16, 16));
		
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
			
			if (e.getId() == EntityID.MONSTER_LEATH) continue; 
			
			if (this.getRectangle().intersects(e.getRectangle())) {
				
				e.damage(MonsterLeath.DAMAGE, EntityDeathMessages.MONSTER_LEATH);
				
				Game.MAP_HANDLER().currentMap().getEntityHandler().remove(this);
				
				
				return;
				
			}
			
		}
		
		if (this.getRectangle().intersects(Game.PLAYER.getRectangle())) {
			
			Game.PLAYER.damage(MonsterLeath.DAMAGE, EntityDeathMessages.MONSTER_LEATH);
			
			Game.MAP_HANDLER().currentMap().getEntityHandler().remove(this);
			
			
			return;
			
		}
		
	}

}
