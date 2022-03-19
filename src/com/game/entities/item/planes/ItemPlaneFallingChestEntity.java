package com.game.entities.item.planes;

import java.awt.image.BufferedImage;
import java.util.Random;
import java.util.Stack;

import com.game.collision.objects.ChestTransparentObject;
import com.game.collision.objects.base.ObjectType;
import com.game.entities.base.Entity;
import com.game.entities.base.EntityID;
import com.game.entities.player.items.base.Item;
import com.game.loot.tables.handler.LootTableHandler;
import com.game.main.Game;

public class ItemPlaneFallingChestEntity extends Entity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -283532944593755698L;

	public ItemPlaneFallingChestEntity(float x, float y, float xv, float yv, int width, int height, EntityID id,
			BufferedImage image) {
		super(x, y, xv, yv, width, height, id, image);
		
		
	}

	@Override
	public void update() {
		
		this.yv = 1;
		
		this.updateV();
		
		if (this.x > Game.WIDTH || this.x < 0f || this.y > Game.HEIGHT || this.y < 0f || (this.xv == 0f && this.yv == 0f)) Game.MAP_HANDLER.currentMap().getEntityHandler().remove(this);
		
		Random random = new Random();
		
		if (
				random.nextBoolean() && !random.nextBoolean() && random.nextBoolean() && !random.nextBoolean() &&
				random.nextBoolean() && !random.nextBoolean() && random.nextBoolean()
			) {
			
			Item<?>[] list = LootTableHandler.returnRandomLootItemsForFallingChestFromItemPlane();
			
			Stack<Item<?>> stack = new Stack<Item<?>>();
			
			for (int i = 0; i < list.length; i++) if (list[i] != null) stack.push(list[i]);
			
			Game.addObject(new ChestTransparentObject((int) this.x, (int) this.y, 64, 64, ObjectType.CHEST, Game.OBJECT_TEXTRA_ALICE.getImageFrom(16, 0, 16, 16), stack));
			
			Game.removeEntity(this);
			
		}
		
	}

	private void updateV() {
		
		this.x += this.xv;
		this.y += this.yv;
		
	}

}
