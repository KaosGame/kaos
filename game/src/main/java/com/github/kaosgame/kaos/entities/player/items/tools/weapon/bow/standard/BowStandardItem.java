package com.github.kaosgame.kaos.entities.player.items.tools.weapon.bow.standard;

import java.awt.image.BufferedImage;
import java.util.LinkedList;

import com.github.kaosgame.kaos.entities.base.DamageableEntity;
import com.github.kaosgame.kaos.entities.base.Entity;
import com.github.kaosgame.kaos.entities.base.EntityID;
import com.github.kaosgame.kaos.entities.items.bow.standard.bullet.BowItemBulletItemEntity;
import com.github.kaosgame.kaos.entities.player.items.base.ItemID;
import com.github.kaosgame.kaos.entities.player.items.base.WeaponItem;
import com.github.kaosgame.kaos.main.Game;
import com.github.kaosgame.kaos.main.Updatable;

public class BowStandardItem extends WeaponItem<BowStandardItem> implements Updatable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8019936043804413795L;
	
	private long time;

	private BowStandardItem(int count, ItemID id, BufferedImage image, float damage, long time) {
		super(count, id, image, damage);
		this.time = time;
		
		
	}
	
	public BowStandardItem(int count, ItemID id, BufferedImage image) {
		super(count, id, image, 3.476f);
		this.time = 0L;
		
		
	}

	@Override
	public BowStandardItem cloneType() {
		return new BowStandardItem(this.count, this.id, this.image, this.damage, this.time);
	}

	@Override
	public void use() {
		
		if (this.time != 0L) return;
		
		this.time = 30L;
		
		float arrowX = Game.PLAYER.getX();
		float arrowY = Game.PLAYER.getY();
		
		final float SPEED = 5f;
		
		float[] tempV = this.aim(SPEED);
		
		if (tempV == null) return;
		
		float arrowXV = tempV[0];
		float arrowYV = tempV[1];
		
		
		
		if (arrowXV == 0f && arrowYV == 0f) return;
		
		BowItemBulletItemEntity bullet = new BowItemBulletItemEntity(arrowX, arrowY, arrowXV, arrowYV,
				64, 64, EntityID.PLAYER_BOW_BULLET, Game.BULLET_1_IMAGE_LOADER.getImage(), this.damage);
		
		
		Game.MAP_HANDLER().currentMap().getEntityHandler().add(bullet);
		
	}
	
	private float[] aim(float SPEED) {
		
		Float tx = null;
		Float ty = null;
		
		LinkedList<Entity> tempEntityList = Game.MAP_HANDLER().currentMap().getEntityHandler().getList();
		
		for (int i = 0; i < tempEntityList.size(); i++) {
			
			if (!(tempEntityList.get(i) instanceof DamageableEntity)) continue;
			
			DamageableEntity e = (DamageableEntity) tempEntityList.get(i);
			
			if (e.getId() == EntityID.PLAYER) continue;
			if (!e.isBad()) continue;
			
			tx = (Float) e.getX();
			ty = (Float) e.getY();
			
			break;
			
		}
		
		boolean exitBad = false;
		
		if (tx == null) exitBad = true;
		if (ty == null) exitBad = true;
		
		if (exitBad) this.time = 0L;
		
		if (exitBad) return null;
		
		float[] r = this.calculateArrowDirection(tx, ty, SPEED, Game.PLAYER.getX(), Game.PLAYER.getY());
		
		return r;
		
	}
	
	private float[] calculateArrowDirection(float targetX, float targetY, final float BASE_SPEED, float x, float y) {
		
		float diffX = (float) ((float) (x - targetX) - 8);
		float diffY = (float) ((float) (y - targetY) - 8);
		
		float distance = (float) Math.sqrt(
												
												(double) (
															(double) (
															
																(double) (
																		x - targetX
																		) *
																(double) (
																		x - targetX
																		)
															
															) + (double) (
																	
																	(double) (
																			y - targetY
																			) *
																	(double) (
																			y - targetY
																			)
																	
																	))
				
											);
		
		final float SPEED = -BASE_SPEED;
		
		float xv = (float) ((float) (SPEED / distance) * diffX);
		float yv = (float) ((float) (SPEED / distance) * diffY);
		
		float[] result = {xv, yv};
		
		return result;
		
	}

	@Override
	public void update() {
		
		if (this.time > 0L) {
			
			this.time--;
			
		}
		
	}

}
