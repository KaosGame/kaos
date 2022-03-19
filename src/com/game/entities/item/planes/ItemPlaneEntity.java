package com.game.entities.item.planes;

import java.awt.image.BufferedImage;
import java.util.Random;

import com.game.entities.base.Entity;
import com.game.entities.base.EntityID;
import com.game.main.Game;
import com.game.random.RandomChance;
import com.game.spawning.base.Spawnable;

public class ItemPlaneEntity extends Entity implements Spawnable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -670746536482714788L;
	private boolean showChest;
	private boolean droppedChest;
	
	public ItemPlaneEntity(float x, float y, float xv, float yv, int width, int height, EntityID id,
			BufferedImage image, boolean showChest) {
		
		super(x, y, xv, yv, width, height, id, image);
		this.showChest = showChest;
		this.droppedChest = false;
		
		
	}
	
	public ItemPlaneEntity() {
		
		this(0, 0, 0, 0, 0, 0, null, null, true);
		
	}

	@Override
	public void update() {
		
		
		this.xv = -2;
		
		this.updateV();
		
		if (this.x > Game.WIDTH || this.x < 0f || this.y > Game.HEIGHT || this.y < 0f || (this.xv == 0f && this.yv == 0f)) Game.MAP_HANDLER.currentMap().getEntityHandler().remove(this);
		
		Random random = new Random();
		
		if (
				random.nextBoolean() && !random.nextBoolean() &&
				random.nextBoolean() && !random.nextBoolean() &&
				random.nextBoolean() && !random.nextBoolean() &&
				random.nextBoolean() && !random.nextBoolean() &&
				!this.droppedChest
			) {
			
			this.droppedChest = true;
			this.showChest = false;
			
			
			Game.addEntity(new ItemPlaneFallingChestEntity(this.x, (float) (this.y + this.height), 0, 0, 64, 64, EntityID.ITEM_PLANE_FALLING_CHEST, Game.OBJECT_TEXTRA_ALICE.getImageFrom(16, 0, 16, 16)));
			
			
		}
		
		if (this.showChest) {
			
			this.image = Game.PLANE_TEXTRA_ALICE.getImageFrom(16, 0, 16, 16);
			
		} else {
			
			this.image = Game.PLANE_TEXTRA_ALICE.getImageFrom(0, 0, 16, 16);
			
		}
		
		
	}

	private void updateV() {
		
		this.x += this.xv;
		this.y += this.yv;
		
	}

	public boolean isShowingChest() {
		return this.showChest;
	}

	public void setShowChest(boolean showChest) {
		this.showChest = showChest;
	}

	public boolean hasDroppedChest() {
		return droppedChest;
	}

	public void setDroppedChest(boolean droppedChest) {
		this.droppedChest = droppedChest;
	}
	
	@Override
	public void randomSpawn() {
		
		Random random = new Random();
		RandomChance chance = new RandomChance();
		
		if (
				random.nextBoolean() && !random.nextBoolean() && random.nextBoolean() && !random.nextBoolean() && random.nextBoolean() && !random.nextBoolean() &&
				random.nextBoolean() && !random.nextBoolean() && chance.firstChoose(0.25) && random.nextBoolean()
			) {
			
			this.spawn();
			
		}
		
	}

	@Override
	public void spawn() {
		
		Game.MAP_HANDLER.currentMap().getEntityHandler().add(new ItemPlaneEntity((int) (Game.WIDTH - 64), 0, 0, 0, 64, 64, EntityID.ITEM_PLANE, Game.PLANE_TEXTRA_ALICE.getImageFrom(16, 0, 16, 16), true));
		
	}	
	
}
