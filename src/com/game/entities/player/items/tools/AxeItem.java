package com.game.entities.player.items.tools;

import java.awt.image.BufferedImage;
import java.util.LinkedList;

import com.game.collision.objects.ChestTransparentObject;
import com.game.collision.objects.PlayerObject;
import com.game.collision.objects.base.CollisionObject;
import com.game.collision.objects.base.ObjectType;
import com.game.entities.player.items.base.ItemID;
import com.game.entities.player.items.base.WeaponItem;
import com.game.loot.tables.handler.LootTableHandler;
import com.game.loot.tables.handler.LootTableID;
import com.game.main.Game;

public class AxeItem extends WeaponItem<AxeItem> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6791978238671428013L;

	public AxeItem(int count, ItemID id, BufferedImage image, float damage) {
		
		super(count, id, image, damage);
		
		
	}
	
	public AxeItem(int count, ItemID id, BufferedImage image) {
		
		super(count, id, image, 1f);
		
		
	}

	@Override
	public void use() {
		
		LinkedList<CollisionObject> tempList = Game.MAP_HANDLER().currentMap().getObjectList();
		
		for (int i = 0; i < tempList.size(); i++) {
			
			CollisionObject tempObj = tempList.get(i);
			
			if (
					Game.getRectangle(
									(int) Game.PLAYER.getX(),
									(int) Game.PLAYER.getY(),
									Game.PLAYER.getWidth(),
									Game.PLAYER.getHeight()
					).intersects(tempObj.getRectangle())) {
				
				tempObj.collide();
				
			}
			
			if (
					Game.getRectangle(
									(int) Game.PLAYER.getX(),
									(int) Game.PLAYER.getY(),
									Game.PLAYER.getWidth(),
									Game.PLAYER.getHeight()
					).intersects(tempObj.getRectangle()) &&
					tempObj.getType() == ObjectType.TREE_1 &&
					Math.random() < 0.50
				) {
				
				Game.MAP_HANDLER().currentMap().removeObject(tempObj);
				
				LootTableHandler.createLootAtRandom(LootTableID.TREE_1_LOOT);
				
			}
			
			if (
					Game.getRectangle(
									(int) Game.PLAYER.getX(),
									(int) Game.PLAYER.getY(),
									Game.PLAYER.getWidth(),
									Game.PLAYER.getHeight()
					).intersects(tempObj.getRectangle()) &&
					tempObj.getType() == ObjectType.WOOD_1 &&
					Math.random() < 0.50 &&
					tempObj instanceof PlayerObject
				) {
				
				Game.MAP_HANDLER().currentMap().removeObject(tempObj);
				
				
				LootTableHandler.createLootAtRandom(LootTableID.WOOD_1_LOOT);
				
				
			}
			
			if (
					Game.getRectangle(
									(int) Game.PLAYER.getX(),
									(int) Game.PLAYER.getY(),
									Game.PLAYER.getWidth(),
									Game.PLAYER.getHeight()
					).intersects(tempObj.getRectangle()) &&
					tempObj.getType() == ObjectType.APPLE_TREE_1 &&
					Math.random() < 0.50
				) {
				
				Game.MAP_HANDLER().currentMap().removeObject(tempObj);
				
				LootTableHandler.createLootAtRandom(LootTableID.APPLE_TREE_1_LOOT);
				
			}
			
			if (
					Game.getRectangle(
									(int) Game.PLAYER.getX(),
									(int) Game.PLAYER.getY(),
									Game.PLAYER.getWidth(),
									Game.PLAYER.getHeight()
					).intersects(tempObj.getRectangle()) &&
					tempObj.getType() == ObjectType.CHEST &&
					Math.random() < 0.50 && tempObj instanceof ChestTransparentObject
				) {
				
				ChestTransparentObject chest = (ChestTransparentObject) tempObj;
				
				LootTableHandler.createLootAtRandom(LootTableID.CHEST_1);
				
				chest.breakItem();
				
				Game.MAP_HANDLER().currentMap().removeObject(tempObj);
				
			}
			
			if (
					Game.getRectangle(
									(int) Game.PLAYER.getX(),
									(int) Game.PLAYER.getY(),
									Game.PLAYER.getWidth(),
									Game.PLAYER.getHeight()
					).intersects(tempObj.getRectangle()) &&
					tempObj.getType() == ObjectType.SIGN_1 &&
					Math.random() < 0.50
				) {
				
				Game.MAP_HANDLER().currentMap().removeObject(tempObj);
				
				LootTableHandler.createLootAtRandom(LootTableID.SIGN_1);
				
			}
			
		}
		
	}

	@Override
	public AxeItem cloneType() {
		
		return new AxeItem(this.count, this.id, this.image, this.damage);
		
	}


}
