package com.game.entities.player.items;

import java.awt.image.BufferedImage;

public abstract class Item {
	
	protected int count;
	
	protected ItemID id;
	protected BufferedImage image;
	
	public Item(int count, ItemID id, BufferedImage image) {
		
		super();
		
		this.count = count;
		this.id = id;
		this.image = image;
	}
	
	public abstract void use();

	public int getCount() {
		
		return this.count;
		
	}

	public void setCount(int count) {
		
		this.count = count;
		
	}

	public ItemID getId() {
		
		return this.id;
		
	}

	public void setId(ItemID id) {
		
		this.id = id;
		
	}

	public BufferedImage getImage() {
		
		return this.image;
		
	}

	public void setImage(BufferedImage image) {
		
		this.image = image;
		
	}
	

}