package com.game.entities.player.items;

import java.awt.image.BufferedImage;
import java.util.LinkedList;

import com.game.collision.objects.CollisionObject;
import com.game.collision.objects.ObjectType;
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
				
			}
			
		}
		
	}

}
