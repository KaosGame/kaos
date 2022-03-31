package com.game.collision.objects;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.game.annotations.Empty;
import com.game.annotations.Unused;
import com.game.collision.objects.base.CollisionObject;
import com.game.collision.objects.base.ObjectType;
import com.game.entities.base.Entity;
import com.game.main.Drawable;

public class TextSignObject extends CollisionObject implements Drawable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4486559343751644333L;
	
	private String text;
	private Color textColor;
	private Font textFont;
	
	private int xOff;
	private int yOff;

	public TextSignObject(int x, int y, int width, int height, ObjectType type, BufferedImage image, String text, Color textColor, Font textFont) {
		
		super(x, y, width, height, type, image);
		this.text = text;
		this.textColor = textColor;
		this.textFont = textFont;
		this.xOff = 0;
		this.yOff = 0;
		
	}
	
	public TextSignObject(int x, int y, int width, int height, ObjectType type, BufferedImage image, String text, Color textColor, Font textFont, int xOff, int yOff) {
		
		super(x, y, width, height, type, image);
		this.text = text;
		this.textColor = textColor;
		this.textFont = textFont;
		this.xOff = xOff;
		this.yOff = yOff;
		
	}
	
	@Empty
	@Unused
	@Override
	public void collide(Entity e) {
		
		
		
	}

	public String getText() {
		
		return this.text;
		
	}

	public void setText(String text) {
		
		this.text = text;
		
	}

	@Override
	public void draw(Graphics2D g2d) {
		
		g2d.drawImage(this.image, this.x, this.y, this.width, this.height, null);
		g2d.setFont(this.textFont);
		g2d.setColor(this.textColor);
		g2d.drawString(this.text, (int) (this.x + this.xOff), (int) (this.y + this.yOff));
		
		
	}

	public Color getTextColor() {
		
		return this.textColor;
		
	}

	public void setTextColor(Color textColor) {
		
		this.textColor = textColor;
		
	}

	public Font getTextFont() {
		
		return this.textFont;
		
	}

	public void setTextFont(Font textFont) {
		
		this.textFont = textFont;
		
	}

	public int getxOff() {
		
		return this.xOff;
		
	}

	public void setxOff(int xOff) {
		
		this.xOff = xOff;
		
	}

	public int getyOff() {
		
		return this.yOff;
		
	}

	public void setyOff(int yOff) {
		
		this.yOff = yOff;
		
	}
	
	

}
