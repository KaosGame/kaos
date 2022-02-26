package com.game.entities.player.items;

import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Random;

import com.game.collision.objects.CollisionObject;
import com.game.collision.objects.ObjectType;
import com.game.collision.objects.PlayerObject;
import com.game.main.Game;
import com.game.maps.MapHandler;

public class AxeItem extends WeaponItem {

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
				
				Game.PLAYER.getHotbar().addItem(new Wood1Item((int) (random.nextInt(5) + 2), ItemID.WOOD_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(16, 0, 16, 16)));
				Game.PLAYER.getHotbar().addItem(new Tree1Item((int) (random.nextInt(2) + 1), ItemID.TREE_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(32, 0, 16, 16)));
				
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
				
				Game.PLAYER.getHotbar().addItem(new Wood1Item(1, ItemID.WOOD_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(16, 0, 16, 16)));
				
			}
			
		}
		
	}

}
