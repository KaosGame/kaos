package com.game.entities.base;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.Serializable;

import com.game.main.Drawable;
import com.game.main.Updatable;

public abstract class Entity implements Drawable, Updatable, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2958734346042384939L;
	
	protected float x;
	protected float y;
	protected float xv;
	protected float yv;
	
	protected int width;
	protected int height;
	
	protected EntityID id;
	transient protected BufferedImage image;
	
	
	
	
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + height;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + width;
		result = prime * result + Float.floatToIntBits(x);
		result = prime * result + Float.floatToIntBits(xv);
		result = prime * result + Float.floatToIntBits(y);
		result = prime * result + Float.floatToIntBits(yv);
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
		Entity other = (Entity) obj;
		if (height != other.height)
			return false;
		if (id != other.id)
			return false;
		if (width != other.width)
			return false;
		if (Float.floatToIntBits(x) != Float.floatToIntBits(other.x))
			return false;
		if (Float.floatToIntBits(xv) != Float.floatToIntBits(other.xv))
			return false;
		if (Float.floatToIntBits(y) != Float.floatToIntBits(other.y))
			return false;
		if (Float.floatToIntBits(yv) != Float.floatToIntBits(other.yv))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Entity [x=" + x + ", y=" + y + ", xv=" + xv + ", yv=" + yv + ", width=" + width + ", height=" + height
				+ ", id=" + id + ", image=" + image + "]";
	}
	
	

}
