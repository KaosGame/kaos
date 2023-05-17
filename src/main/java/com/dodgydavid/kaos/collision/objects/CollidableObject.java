package com.dodgydavid.kaos.collision.objects;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.dodgydavid.kaos.annotations.Empty;
import com.dodgydavid.kaos.annotations.Unused;
import com.dodgydavid.kaos.collision.objects.base.CollisionObject;
import com.dodgydavid.kaos.collision.objects.base.ObjectType;
import com.dodgydavid.kaos.entities.base.Entity;
import com.dodgydavid.kaos.main.Drawable;

public class CollidableObject extends CollisionObject implements Drawable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2260707677425910302L;

	public CollidableObject(int x, int y, int width, int height, ObjectType type, BufferedImage image) {
		
		super(x, y, width, height, type, image, false);
		
		
	}
	
	@Unused
	@Empty
	@Override
	public void collide(Entity e) {
		
		
		
	}
	
	@Override
	public void draw(Graphics2D g2d) {
		
		g2d.drawImage(this.image, this.x, this.y, this.width, this.height, null);
		
	}

}
