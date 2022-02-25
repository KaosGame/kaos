package com.game.collision.objects;

import java.awt.image.BufferedImage;

import com.game.annotations.Empty;
import com.game.annotations.Unused;

public class CollidableObject extends CollisionObject {

	public CollidableObject(int x, int y, int width, int height, ObjectType type, BufferedImage image) {
		
		super(x, y, width, height, type, image);
		
		
	}
	
	@Unused
	@Empty
	@Override
	public void collide() {
		
		
		
	}

}
