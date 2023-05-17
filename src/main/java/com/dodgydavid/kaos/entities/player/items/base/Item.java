package com.dodgydavid.kaos.entities.player.items.base;

import java.awt.image.BufferedImage;
import java.io.Serializable;

import com.dodgydavid.kaos.main.CloneableType;

public abstract class Item<CT> implements CloneableType<CT>, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -890486929127632571L;

	public static final int MAX_COUNT = 320;
	
	protected int count;
	
	protected ItemID id;
	
	transient protected BufferedImage image;
	
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + count;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item<?> other = (Item<?>) obj;
		if (count != other.count)
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	

}
