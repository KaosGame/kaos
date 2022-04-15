package com.game.entities.player.items.tools;

import java.awt.image.BufferedImage;
import java.util.LinkedList;

import com.game.collision.objects.ChestTransparentObject;
import com.game.collision.objects.PlayerObject;
import com.game.collision.objects.base.CollisionObject;
import com.game.collision.objects.base.ObjectType;
import com.game.entities.base.DamageableEntity;
import com.game.entities.base.Entity;
import com.game.entities.base.EntityID;
import com.game.entities.player.items.base.ItemID;
import com.game.entities.player.items.base.WeaponItem;
import com.game.logging.LogType;
import com.game.loot.tables.handler.LootTableHandler;
import com.game.loot.tables.handler.LootTableID;
import com.game.main.Game;

public class AxeItem extends WeaponItem<AxeItem> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6791978238671428013L;

	private AxeItem(int count, ItemID id, BufferedImage image, float damage) {
		
		super(count, id, image, damage);
		
		
	}
	
	public AxeItem(int count, ItemID id, BufferedImage image) {
		
		super(count, id, image, 2f);
		
		
	}

	@Override
	public void use() {
		
		LinkedList<CollisionObject> tempObjList = Game.MAP_HANDLER().currentMap().getObjectList();
		
		for (int i = 0; i < tempObjList.size(); i++) {
			
			CollisionObject tempObj = tempObjList.get(i);
			
			
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
		
		LinkedList<Entity> tempEList = Game.MAP_HANDLER().currentMap().getEntityHandler().getList();
		
		for (int i = 0; i < tempEList.size(); i++) {
			
			Entity e = tempEList.get(i);
			
			if (e.equals(Game.PLAYER)) continue;
			
			if (e instanceof DamageableEntity && Game.PLAYER.getRectangle().intersects(e.getRectangle())
					&& e.getId() == EntityID.ZOMBIE && Math.random() < 0.50) {
				
				((DamageableEntity) e).damage(this.damage);
				Game.logln(String.format("Player did %f to a zombie with the health of %f!", this.damage,
						((DamageableEntity) e).getHealth()), LogType.INFO);
				
			}
			
		}
		
	}

	@Override
	public AxeItem cloneType() {
		
		return new AxeItem(this.count, this.id, this.image, this.damage);
		
	}


}
