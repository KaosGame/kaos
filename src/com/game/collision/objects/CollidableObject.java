package com.game.collision.objects;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.game.annotations.Empty;
import com.game.annotations.Unused;
import com.game.main.Drawable;

public class CollidableObject extends CollisionObject implements Drawable {

	public CollidableObject(int x, int y, int width, int height, ObjectType type, BufferedImage image) {
		
		super(x, y, width, height, type, image);
		
		
	}
	
	@Unused
	@Empty
	@Override
	public void collide() {
		
		
		
	}
	
	@Override
	public void draw(Graphics2D g2d) {
		
		g2d.drawImage(this.image, this.x, this.y, this.width, this.height, null);
		
	}

}
