package com.github.kaosgame.kaos.particles;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.Serializable;

import com.github.kaosgame.kaos.main.Drawable;
import com.github.kaosgame.kaos.main.Game;
import com.github.kaosgame.kaos.main.Updatable;

public class Particle implements Drawable, Updatable, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -533241015671516982L;
	
	protected double x;
	protected double y;
	
	protected double xv;
	protected double yv;
	
	protected int width;
	protected int height;
	
	protected Color color;
	
	protected long time;
	
	protected Runnable onEnd;
	protected Runnable onUpdate;
	
	public Particle(double x, double y, double xv, double yv, int width, int height, Color color, long time,
			Runnable onEnd, Runnable onUpdate) {
		super();
		this.x = x;
		this.y = y;
		this.xv = xv;
		this.yv = yv;
		this.width = width;
		this.height = height;
		this.color = color;
		this.time = time;
		this.onEnd = onEnd;
		this.onUpdate = onUpdate;
	}

	@Override
	public void update() {
		
		this.time--;
		
		this.x += this.xv;
		this.y += this.yv;
		
		if (this.time <= 0) {
			
			Game.MAP_HANDLER().currentMap().getParticleList().remove(this);
			
			if (this.onEnd != null) this.onEnd.run();
			
			return;
			
		}
		
		
		if (this.onUpdate != null) this.onUpdate.run();
		
	}
	
	@Override
	public void draw(Graphics2D g2d) {
		
		g2d.setColor(this.color);
		g2d.fillRect((int) this.x, (int) this.y, this.width, this.height);
		
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getXv() {
		return xv;
	}

	public void setXv(double xv) {
		this.xv = xv;
	}

	public double getYv() {
		return yv;
	}

	public void setYv(double yv) {
		this.yv = yv;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public Runnable getOnEnd() {
		return onEnd;
	}

	public void setOnEnd(Runnable onEnd) {
		this.onEnd = onEnd;
	}

	public Runnable getOnUpdate() {
		return onUpdate;
	}

	public void setOnUpdate(Runnable onUpdate) {
		this.onUpdate = onUpdate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + height;
		result = prime * result + ((onEnd == null) ? 0 : onEnd.hashCode());
		result = prime * result + ((onUpdate == null) ? 0 : onUpdate.hashCode());
		result = prime * result + (int) (time ^ (time >>> 32));
		result = prime * result + width;
		long temp;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(xv);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(yv);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Particle other = (Particle) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (height != other.height)
			return false;
		if (onEnd == null) {
			if (other.onEnd != null)
				return false;
		} else if (!onEnd.equals(other.onEnd))
			return false;
		if (onUpdate == null) {
			if (other.onUpdate != null)
				return false;
		} else if (!onUpdate.equals(other.onUpdate))
			return false;
		if (time != other.time)
			return false;
		if (width != other.width)
			return false;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		if (Double.doubleToLongBits(xv) != Double.doubleToLongBits(other.xv))
			return false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
			return false;
		if (Double.doubleToLongBits(yv) != Double.doubleToLongBits(other.yv))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Particle [x=" + x + ", y=" + y + ", xv=" + xv + ", yv=" + yv + ", width=" + width + ", height=" + height
				+ ", color=" + color + ", time=" + time + ", onEnd=" + onEnd + ", onUpdate=" + onUpdate + "]";
	}



}
