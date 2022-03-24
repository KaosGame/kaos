package com.game.entities.item.planes;

import java.awt.image.BufferedImage;
import java.util.Random;
import java.util.Stack;

import com.game.collision.objects.ChestTransparentObject;
import com.game.collision.objects.base.ObjectType;
import com.game.entities.base.Entity;
import com.game.entities.base.EntityID;
import com.game.entities.player.items.base.Item;
import com.game.logging.LogType;
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
		
		if (this.x >= (float) (Game.WIDTH - this.width) || this.x <= 0f) {
			
			Game.MAP_HANDLER().currentMap().getEntityHandler().remove(this);
			Game.logln("Removed " + this.getClass(), LogType.SUCCESS);
			
		}
		
		if (this.y >= (float) (Game.HEIGHT - (float) (this.height * 1.4f)) || this.y <= 0f) {
			
			Game.MAP_HANDLER().currentMap().getEntityHandler().remove(this);
			Game.logln("Removed " + this.getClass(), LogType.SUCCESS);
			
		}
		
		Random random = new Random();
		
		if (
				random.nextBoolean() && !random.nextBoolean() && random.nextBoolean() && !random.nextBoolean() &&
				random.nextBoolean() && !random.nextBoolean() && random.nextBoolean()
			) {
			
			if (!Game.touchingSomething(this.getRectangle())) {
				
				Item<?>[] list = LootTableHandler.returnRandomLootItemsForFallingChestFromItemPlane();
				
				Stack<Item<?>> stack = new Stack<Item<?>>();
				
				for (int i = 0; i < list.length; i++) if (list[i] != null) stack.push(list[i]);
				
				Game.addObject(new ChestTransparentObject((int) this.x, (int) this.y, 64, 64, ObjectType.CHEST, Game.OBJECT_TEXTRA_ALICE.getImageFrom(16, 0, 16, 16), stack));
				
				Game.logln(String.format("Falling Item Plane Falling Chest droped at X: %f, Y: %f", this.x, this.y), LogType.SUCCESS);
				
				Game.removeEntity(this);
				
			}
			
		}
		
	}

	private void updateV() {
		
		this.x += this.xv;
		this.y += this.yv;
		
	}

}
