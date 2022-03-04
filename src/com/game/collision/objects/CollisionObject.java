package com.game.collision.objects;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.Serializable;

public abstract class CollisionObject implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6886433752352944048L;
	
	protected int x;
	protected int y;
	
	protected int width;
	protected int height;
	
	protected ObjectType type;
	transient BufferedImage image;
	
	
	
	
	public CollisionObject(int x, int y, int width, int height, ObjectType type, BufferedImage image) {
		
		super();
		
		this.x = x;
		this.y = y;
		
		this.width = width;
		this.height = height;
		
		this.type = type;
		this.image = image;
		
	}
	
	public abstract void collide();

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
	
	

}
