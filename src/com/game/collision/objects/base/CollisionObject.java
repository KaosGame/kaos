package com.game.collision.objects.base;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.Serializable;

import com.game.entities.base.Entity;
import com.game.gui.base.GUI;

public abstract class CollisionObject implements Serializable {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3250218174640775534L;
	
	protected int x;
	protected int y;
	
	protected int width;
	protected int height;
	
	protected ObjectType type;
	protected transient BufferedImage image;
	
	protected GUI gui;
	
	protected final boolean playerPlaced;
	
	
	
	public CollisionObject(int x, int y, int width, int height, ObjectType type, BufferedImage image, final boolean playerPlaced) {
		
		super();
		
		this.x = x;
		this.y = y;
		
		this.width = width;
		this.height = height;
		
		this.type = type;
		this.image = image;
		
		this.playerPlaced = playerPlaced;
		
		this.gui = null;
		
	}
	
	public CollisionObject(int x, int y, int width, int height, ObjectType type, BufferedImage image, final boolean playerPlaced, GUI gui) {
		
		super();
		
		this.x = x;
		this.y = y;
		
		this.width = width;
		this.height = height;
		
		this.type = type;
		this.image = image;
		
		this.playerPlaced = playerPlaced;
		
		this.gui = gui;
		
	}
	
	public abstract void collide(Entity e);

	public int getX() {
		return this.x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return this.y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return this.width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return this.height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public ObjectType getType() {
		return this.type;
	}

	public void setType(ObjectType type) {
		this.type = type;
	}

	public BufferedImage getImage() {
		return this.image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}
	
	public Rectangle getRectangle() {
		
		return new Rectangle(this.x, this.y, this.width, this.height);
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + height;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + width;
		result = prime * result + x;
		result = prime * result + y;
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
		CollisionObject other = (CollisionObject) obj;
		if (height != other.height)
			return false;
		if (type != other.type)
			return false;
		if (width != other.width)
			return false;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CollisionObject [x=" + x + ", y=" + y + ", width=" + width + ", height=" + height + ", type=" + type
				+ "]";
	}

	public boolean isPlayerPlaced() {
		return playerPlaced;
	}

	public GUI getGui() {
		return gui;
	}

	public void setGui(GUI gui) {
		this.gui = gui;
	}
	
	

}
