package com.github.kaosgame.kaos.entities.player.items.fun;

import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.Random;

import com.github.kaosgame.kaos.entities.base.Entity;
import com.github.kaosgame.kaos.entities.player.items.base.Item;
import com.github.kaosgame.kaos.entities.player.items.base.ItemID;
import com.github.kaosgame.kaos.main.Game;
import com.github.kaosgame.kaos.particles.images.ImageParticleTypes;
import com.github.kaosgame.kaos.particles.images.ParticleImages;
import com.github.kaosgame.kaos.sound.Sounds;

public class LeafBlower extends Item<LeafBlower> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6362094108887362765L;

	public LeafBlower(int count) {
		super(count, ItemID.LEAF_BLOWER, Game.ITEM_TEXTRA_ALICE.getImageFrom(112, 16, 16, 16));
	}

	@Override
	public LeafBlower cloneType() {
		return new LeafBlower(this.count);
	}

	@Override
	public void use() {
		
		float dirX = 0;
		float dirY = 0;
		
		Random random = new Random();
		
		if (random.nextBoolean()) {
			
			dirX = 1;
			dirY = 0;
			
		} else if (random.nextBoolean()) {
			
			dirX = -1;
			dirY = 0;
			
		} else if (random.nextBoolean()) {
			
			dirY = 1;
			dirX = 0;
			
		} else if (random.nextBoolean()) {
			
			dirY = -1;
			dirX = 0;
			
		} else if (random.nextBoolean()) {
			
			dirX = 1;
			dirY = 0;
			
		} else if (random.nextBoolean()) {
			
			dirX = 0;
			dirY = 1;
			
		} else if (random.nextBoolean()) {
			
			dirX = 1;
			dirY = 1;
			
		} else if (random.nextBoolean()) {
			
			dirX = -1;
			dirY = -1;
			
		} else if (random.nextBoolean()) {
			
			dirX = 1;
			dirY = -1;
			
		} else {
			
			dirX = -1;
			dirY = 1;
			
		}
		
		ImageParticleTypes.FALL_1.make(Game.PLAYER.getX(), Game.PLAYER.getY(), 16, 16, null, null, ParticleImages.SMOKE_1);
		
		LinkedList<Entity> el = Game.MAP_HANDLER().currentMap().getEntityHandler().getList();
		
		Rectangle rect = new Rectangle((int) (Game.PLAYER.getX() - 64), (int) (Game.PLAYER.getY() - 64), (int) (Game.PLAYER.getWidth() + 128), (int) (Game.PLAYER.getHeight() + 128));
		
		for (int i = 0; i < el.size(); i++) {
			
			Entity e = el.get(i);
			
			if (!e.canMove()) continue;
			
			if (e.getRectangle().intersects(rect)) {
				
				float cx = e.getX();
				float cy = e.getY();
				
				float ndx = (float) (dirX * 128);
				float ndy = (float) (dirY * 128);
				
				float nx = (float) (cx + ndx);
				float ny = (float) (cy + ndy);
				
				e.setX(nx);
				e.setY(ny);
				
				ImageParticleTypes.FALL_1.make(cx, cy, 16, 16, null, null, ParticleImages.SMOKE_1);
				
			}
			
		}
		
		Game.SE_SOUND.setSound(Sounds.LEAF_BLOWER_MOVE);
		Game.SE_SOUND.play();
		
	}

}
