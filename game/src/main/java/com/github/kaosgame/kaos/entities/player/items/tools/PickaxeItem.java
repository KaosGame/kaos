package com.github.kaosgame.kaos.entities.player.items.tools;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

import com.github.kaosgame.kaos.collision.objects.base.CollisionObject;
import com.github.kaosgame.kaos.collision.objects.base.ObjectType;
import com.github.kaosgame.kaos.entities.player.items.base.Item;
import com.github.kaosgame.kaos.entities.player.items.base.ItemID;
import com.github.kaosgame.kaos.loot.tables.handler.LootTableHandler;
import com.github.kaosgame.kaos.loot.tables.handler.LootTableID;
import com.github.kaosgame.kaos.main.Game;
import com.github.kaosgame.kaos.particles.ParticleTypes;

public class PickaxeItem extends Item<PickaxeItem> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1689015135055082665L;

	public PickaxeItem(int count, ItemID id, BufferedImage image) {
		
		super(count, id, image);
		
		
	}
	
	private void makeStoneParticle() {
		
		ParticleTypes.FALL_1.make((double) (Game.PLAYER.getX() + 32), (double) (Game.PLAYER.getY() + 32), 8, 8, new Color(0xc0c0c0), null, null);
		
	}

	@Override
	public PickaxeItem cloneType() {
		return new PickaxeItem(this.count, this.id, this.image);
	}

	@Override
	public void use() {
		
		LinkedList<CollisionObject> tempList = Game.MAP_HANDLER().currentMap().getObjectList();
		
		for (int i = 0; i < tempList.size(); i++) {
			
			CollisionObject tempObj = tempList.get(i);
			
			if (
							tempObj.getType() == ObjectType.STONE_1 ||
							tempObj.getType() == ObjectType.IRON_ORE_1 ||
							tempObj.getType() == ObjectType.GOLD_ORE_1 ||
							tempObj.getType() == ObjectType.DIAMOND_ORE_1
				) {
				
				Rectangle rect = Game.getRectangle((int) (tempObj.getX() - 10), (int) (tempObj.getY() - 10), (int) (tempObj.getWidth() + 20), (int) (tempObj.getHeight() + 20));
				
				if (
						Game.PLAYER.getRectangle().intersects(rect) &&
						Math.random() < 0.50 &&
						tempObj.getType() == ObjectType.STONE_1
						
					) {
					
					Game.MAP_HANDLER().currentMap().removeObject(tempObj);
					
					LootTableHandler.createLootAtRandom(LootTableID.STONE_1);
					this.makeStoneParticle();
					
				}
				
				if (
						Game.PLAYER.getRectangle().intersects(rect) &&
						Math.random() < 0.50 &&
						tempObj.getType() == ObjectType.IRON_ORE_1
						
					) {
					
					Game.MAP_HANDLER().currentMap().removeObject(tempObj);
					
					LootTableHandler.createLootAtRandom(LootTableID.IRON_ORE_1);
					this.makeStoneParticle();
					
				}
				
				if (
						Game.PLAYER.getRectangle().intersects(rect) &&
						Math.random() < 0.50 &&
						tempObj.getType() == ObjectType.GOLD_ORE_1
						
					) {
					
					Game.MAP_HANDLER().currentMap().removeObject(tempObj);
					
					LootTableHandler.createLootAtRandom(LootTableID.GOLD_ORE_1);
					this.makeStoneParticle();
					
				}
				
				if (
						Game.PLAYER.getRectangle().intersects(rect) &&
						Math.random() < 0.50 &&
						tempObj.getType() == ObjectType.DIAMOND_ORE_1
						
					) {
					
					Game.MAP_HANDLER().currentMap().removeObject(tempObj);
					
					LootTableHandler.createLootAtRandom(LootTableID.DIAMOND_ORE_1);
					this.makeStoneParticle();
					
				}
				
			}
			
		}
		
	}

}
