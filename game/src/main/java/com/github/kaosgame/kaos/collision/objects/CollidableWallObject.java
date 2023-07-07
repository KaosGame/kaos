package com.github.kaosgame.kaos.collision.objects;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.github.kaosgame.kaos.collision.objects.base.CollisionObject;
import com.github.kaosgame.kaos.collision.objects.base.ObjectType;
import com.github.kaosgame.kaos.entities.base.Entity;
import com.github.kaosgame.kaos.main.Drawable;
import com.github.kaosgame.kaos.main.Game;

public class CollidableWallObject extends CollisionObject implements Drawable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7534898427950934830L;

	public static enum ImageBase {
		
		TYPE_1(Game.OBJECT_TEXTRA_ALICE.getImageFrom(64, 0, 16, 16)),
		TYPE_2(Game.OBJECT_TEXTRA_ALICE.getImageFrom(32, 0, 16, 16)),
		TYPE_3(Game.OBJECT_TEXTRA_ALICE.getImageFrom(48, 0, 16, 16)),
		TYPE_4(Game.OBJECT_TEXTRA_ALICE.getImageFrom(80, 0, 16, 16));

		private final BufferedImage IMAGE;
		
		private ImageBase(final BufferedImage IMAGE) {
			
			this.IMAGE = IMAGE;
			
		}
		
		public BufferedImage getIMAGE() {
			
			return this.IMAGE;
			
		}

	}

	private CollidableWallObject.ImageBase imageType;
	
	public CollidableWallObject(int x, int y, int width, int height, ObjectType type, BufferedImage image, CollidableWallObject.ImageBase imageType) {
		
		super(x, y, width, height, type, image, false);
		
		this.imageType = imageType;
		
		
	}
	
	@Override
	public void collide(Entity e) {
		
		
		
	}

	public CollidableWallObject.ImageBase getImageType() {
		return this.imageType;
	}

	public void setImageType(CollidableWallObject.ImageBase imageType) {
		this.imageType = imageType;
	}

	@Override
	public void draw(Graphics2D g2d) {
		
		g2d.drawImage(this.image, this.x, this.y, this.width, this.height, null);
		
	}
	
	

}
