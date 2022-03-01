package com.game.entities;

import java.awt.image.BufferedImage;

import com.game.entities.player.items.base.Item;
import com.game.main.Game;
import com.game.maps.MapHandler;

public class ItemEntity extends Entity {
	
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
			) MapHandler.currentMap().getEntityHandler().remove(this);
		
	}

	public Item<?> getItem() {
		
		return this.item;
		
	}

	public void setItem(Item<?> item) {
		
		this.item = item;
		
	}
	
}
