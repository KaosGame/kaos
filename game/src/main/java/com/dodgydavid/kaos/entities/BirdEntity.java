package com.dodgydavid.kaos.entities;

import java.awt.image.BufferedImage;
import java.util.Random;

import com.dodgydavid.kaos.entities.base.Entity;
import com.dodgydavid.kaos.entities.base.EntityID;
import com.dodgydavid.kaos.logging.LogType;
import com.dodgydavid.kaos.main.Game;
import com.dodgydavid.kaos.spawning.base.Spawnable;

public class BirdEntity extends Entity implements Spawnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5410627734673087911L;

	public BirdEntity(float x, float y, float xv, float yv, int width, int height, EntityID id, BufferedImage image) {
		
		super(x, y, xv, yv, width, height, id, image);
		
		
	}
	
	public BirdEntity() {
		
		super(0, 0, 0, 0, 0, 0, null, null);
		
		
	}

	@Override
	public void update() {
		
		this.x += this.xv;
		this.y += this.yv;
		
		if (this.x > Game.WIDTH || this.x < 0f || this.y > Game.HEIGHT || this.y < 0f || (this.xv == 0f && this.yv == 0f)) Game.MAP_HANDLER().currentMap().getEntityHandler().remove(this);
		
	}

	@Override
	public void spawn() {
		
		Random random = new Random();
		
		boolean dir1 = random.nextBoolean();
		boolean dir2 = random.nextBoolean();
		
		boolean willDir1 = random.nextBoolean();
		boolean willDir2 = random.nextBoolean();
		
		if (random.nextBoolean() && !random.nextBoolean()) {
			
			BirdEntity e = new BirdEntity(random.nextInt(Game.WIDTH), random.nextInt(Game.HEIGHT), 0, 0, 64, 64, EntityID.BIRD, Game.BIRD_TEXTRA_ALICE.getImageFrom(0, 0, 16, 16));
			
			float tempXv = 1f;
			float tempYv = 1f;
			
			if (willDir1 && dir1) {
				
				tempXv = -1f;
				
			}
			
			if (!willDir1) {
				
				tempXv = 0f;
				
			}
			
			if (willDir2 && dir2) {
				
				tempYv = -1f;
				
			}
			
			if (!willDir2) {
				
				tempYv = 0f;
				
			}
			
			e.setXv(tempXv);
			e.setYv(tempYv);
			
			Game.MAP_HANDLER().currentMap().getEntityHandler().add(e);
			
			Game.logln("New Bird Summoned successfully", LogType.SUCCESS);
			
			
		}
		
	}
	
	@Override
	public void randomSpawn() {
		
		Random random = new Random();
		
		if (
				random.nextBoolean() && !random.nextBoolean() && random.nextBoolean() && !random.nextBoolean() && random.nextBoolean() && !random.nextBoolean()
			) {
			
			this.spawn();
			
		}
		
	}

}
