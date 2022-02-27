package com.game.entities.player.items;

import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Random;

import com.game.collision.objects.CollisionObject;
import com.game.collision.objects.ObjectType;
import com.game.collision.objects.PlayerObject;
import com.game.main.Game;
import com.game.maps.MapHandler;

public class AxeItem extends WeaponItem<AxeItem> {

	public AxeItem(int count, ItemID id, BufferedImage image, float damage) {
		
		super(count, id, image, damage);
		
		
	}

	@Override
	public void use() {
		
		LinkedList<CollisionObject> tempList = MapHandler.currentMap().getObjectList();
		
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
				
				MapHandler.currentMap().removeObject(tempObj);
				
				Random random = new Random();
				
				float[] pos = this.getRandomItemPos();
				
				Game.addItemEntity(
									pos[0],
									pos[1],
									new Wood1Item((int) (random.nextInt(5) + 2), ItemID.WOOD_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(16, 0, 16, 16)),
									Game.ITEM_TEXTRA_ALICE.getImageFrom(16, 0, 16, 16),
									64
								);
				
				pos = this.getRandomItemPos();
				
				Game.addItemEntity(
									pos[0],
									pos[1],
									new Tree1Item((int) (random.nextInt(2) + 1), ItemID.TREE_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(32, 0, 16, 16)),
									Game.ITEM_TEXTRA_ALICE.getImageFrom(32, 0, 16, 16),
									64
								);
				
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
				
				MapHandler.currentMap().removeObject(tempObj);
				
				float[] pos = this.getRandomItemPos();
				
				Game.addItemEntity(
									pos[0],
									pos[1],
									new Wood1Item(1, ItemID.WOOD_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(16, 0, 16, 16)),
									Game.ITEM_TEXTRA_ALICE.getImageFrom(16, 0, 16, 16),
									64
								);
				
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
				
				MapHandler.currentMap().removeObject(tempObj);
				
				Random random = new Random();
				
				float[] pos = this.getRandomItemPos();
				
				Game.addItemEntity(
									pos[0],
									pos[1],
									new Wood1Item((int) (random.nextInt(5) + 2), ItemID.WOOD_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(16, 0, 16, 16)),
									Game.ITEM_TEXTRA_ALICE.getImageFrom(16, 0, 16, 16),
									64
								);
				
				pos = this.getRandomItemPos();
				
				Game.addItemEntity(
									pos[0],
									pos[1],
									new AppleTree1Item((int) (random.nextInt(2) + 1), ItemID.APPLE_TREE_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(48, 0, 16, 16)),
									Game.ITEM_TEXTRA_ALICE.getImageFrom(48, 0, 16, 16),
									64
								);
				
				pos = this.getRandomItemPos();
				
				Game.addItemEntity(
						pos[0],
						pos[1],
						new Apple1Item((int) (random.nextInt(6) + 1), ItemID.APPLE_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(64, 0, 16, 16)),
						Game.ITEM_TEXTRA_ALICE.getImageFrom(64, 0, 16, 16),
						64
					);
				
			}
			
		}
		
	}
	
	private float[] getRandomItemPos() {
		
		Random random = new Random();
		
		float itemX = 0f;
		float itemY = 0f;
		
		final int OFFSET = 128; 
		
		if (random.nextBoolean()) {
			
			itemX = (float) (Game.PLAYER.getX() + random.nextInt((int) (OFFSET + 1)));
			
		} else {
			
			itemX = (float) (Game.PLAYER.getX() + (float) (random.nextInt((int) (OFFSET + 1)) * -1f));
			
		}
		
		if (random.nextBoolean()) {
			
			itemY = (float) (Game.PLAYER.getY() + random.nextInt((int) (OFFSET + 1)));
			
		} else {
			
			itemY = (float) (Game.PLAYER.getY() + (float) (random.nextInt((int) (OFFSET + 1)) * -1f));
			
		}
		
		float[] res = {itemX, itemY};
		
		return res;
		
	}

	@Override
	public AxeItem cloneType() {
		
		return new AxeItem(this.count, this.id, this.image, this.damage);
		
	}


}
