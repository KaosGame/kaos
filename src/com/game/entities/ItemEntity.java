package com.game.entities;

import java.awt.image.BufferedImage;
import java.util.LinkedList;

import com.game.collision.objects.base.CollisionObject;
import com.game.entities.base.Entity;
import com.game.entities.base.EntityID;
import com.game.entities.player.items.base.Item;
import com.game.main.Game;

public class ItemEntity extends Entity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2657561911904129356L;
	
	private Item<?> item;

	public ItemEntity(float x, float y, float xv, float yv, int width, int height, EntityID id, BufferedImage image, Item<?> item) {
		
		super(x, y, xv, yv, width, height, id, image);
		this.item = item;
		
		
	}

	@Override
	public void update() {
		
		this.x = Game.clamp(this.x, (float) (Game.WIDTH - this.width), 0f);
		this.y = Game.clamp(this.y, (float) (Game.HEIGHT - (float) (this.height * 1.3f)), 0f);
		
		if (
				this.getRectangle().intersects(Game.PLAYER.getRectangle()) &&
				Game.PLAYER.getHotbar().returnBooleanAndAddItem(this.item)
			) Game.MAP_HANDLER().currentMap().getEntityHandler().remove(this);
		
		
		LinkedList<CollisionObject> tempList = Game.MAP_HANDLER().currentMap().getObjectList();
		
		for (int i = 0; i < tempList.size(); i++) {
			
			CollisionObject tempObj = tempList.get(i);
			
			if (
					this.getRectangle().intersects(tempObj.getRectangle()) &&
					!tempObj.getType().isTRANSPARENT()
				) {
				
				float[] pos = Game.getRandomItemPos(this.x, this.y);
				
				this.x = pos[0];
				this.y = pos[1];
				
			}
			
		}
		
	}

	public Item<?> getItem() {
		
		return this.item;
		
	}

	public void setItem(Item<?> item) {
		
		this.item = item;
		
	}
	
}
