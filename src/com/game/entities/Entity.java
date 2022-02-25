package com.game.entities;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.game.main.Drawable;
import com.game.main.Updatable;

public abstract class Entity implements Drawable, Updatable {
	
	protected float x;
	protected float y;
	protected float xv;
	protected float yv;
	
	protected int width;
	protected int height;
	
	protected EntityID id;
	protected BufferedImage image;
	
	
	
	
	public Entity(float x, float y, float xv, float yv, int width, int height, EntityID id, BufferedImage image) {
		
		super();
		
		
		this.x = x;
		this.y = y;
		this.xv = xv;
		this.yv = yv;
		this.width = width;
		this.height = height;
		this.id = id;
		this.image = image;
		
		
	}

	@Override
	public void draw(Graphics2D g2d) {
		
		g2d.drawImage(this.image, (int) this.x, (int) this.y, this.width, this.height, null);
		
	}

	public float getX() {
		return this.x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return this.y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getXv() {
		return this.xv;
	}

	public void setXv(float xv) {
		this.xv = xv;
	}

	public float getYv() {
		return this.yv;
	}

	public void setYv(float yv) {
		this.yv = yv;
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

	public EntityID getId() {
		return this.id;
	}

	public void setId(EntityID id) {
		this.id = id;
	}

	public BufferedImage getImage() {
		return this.image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}
	
	public Rectangle getRectangle() {
		
		return new Rectangle((int) this.x, (int) this.y, this.width, this.height);
		
	}
	
	

}
