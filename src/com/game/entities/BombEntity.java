
package com.game.entities;

import java.awt.Rectangle;
import java.util.LinkedList;

import com.game.collision.objects.base.CollisionObject;
import com.game.entities.base.DamageableEntity;
import com.game.entities.base.Entity;
import com.game.entities.base.EntityDeathMessages;
import com.game.entities.base.EntityID;
import com.game.main.Game;
import com.game.particles.images.ImageParticleTypes;
import com.game.particles.images.ParticleImages;
import com.game.sound.Sounds;

public class BombEntity extends Entity {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7510923351012305342L;

	public static final float DAMAGE = 10f;
	
	private byte frameState;
	private long time;
	private long tempTime;
	
	public BombEntity(float x, float y, int width, int height) {
		super(x, y, 0, 0, width, height, EntityID.BOMB, Game.BOMB_TEXTRA_ALICE.getImageFrom(0, 0, 16, 16));
		this.frameState = (byte) 0;
		this.time = 1800L;
		this.tempTime = 500L;
		
	}

	@Override
	public void update() {
		this.time--;
		this.tempTime--;
		
		if (this.tempTime <= 0) {
			
			this.tempTime = 500L;
			
			this.frameState++;
			
			Game.SE_SOUND.setSound(Sounds.BOMB_FIZZ);
			Game.SE_SOUND.play();
			
			this.frameState = Game.clamp(this.frameState, (byte) 2, (byte) 0);
			
			switch (this.frameState) {
			
				case 0:
					this.image = Game.BOMB_TEXTRA_ALICE.getImageFrom(0, 0, 16, 16);
					break;
					
				case 1:
					this.image = Game.BOMB_TEXTRA_ALICE.getImageFrom(16, 0, 16, 16);
					break;
					
				case 2:
					this.image = Game.BOMB_TEXTRA_ALICE.getImageFrom(32, 0, 16, 16);
					break;
			
			}
			
		}
		
		if (this.time <= 0) this.blowup();
		
		
	}
	
	public void blowup() {
		
		Rectangle rect = new Rectangle((int) ((int) this.x - 128), (int) ((int) this.y - 128), (int) (this.width + 256),
				(int) (this.height + 256));
		
		LinkedList<CollisionObject> objList = Game.MAP_HANDLER().currentMap().getObjectList();
		
		for (int i = 0; i < objList.size(); i++) {
			
			CollisionObject o = objList.get(i);
			
			if (rect.intersects(o.getRectangle()) && o.isPlayerPlaced()) {
				
				Game.MAP_HANDLER().currentMap().getObjectList().remove(o);
				
			}
			
		}
		
		LinkedList<Entity> entityList = Game.MAP_HANDLER().currentMap().getEntityHandler().getList();
		
		for (int i = 0; i < entityList.size(); i++) {
			
			Entity e = entityList.get(i);
			
			if (e instanceof DamageableEntity) {
				
				((DamageableEntity) e).damage(BombEntity.DAMAGE, EntityDeathMessages.BOMB);
				
			}
			
		}
		
		if (rect.intersects(Game.PLAYER.getRectangle())) Game.PLAYER.damage(BombEntity.DAMAGE, EntityDeathMessages.BOMB);
		
		ImageParticleTypes.FALL_1.make(this.x, this.y, 16, 16, null, null, ParticleImages.SMOKE_1);
		ImageParticleTypes.FALL_1.make((double) (this.x - 32), (double) (this.y - 32), 16, 16, null, null, ParticleImages.SMOKE_1);
		ImageParticleTypes.FALL_1.make((double) (this.x - 32), (double) (this.y + 64), 16, 16, null, null, ParticleImages.SMOKE_1);
		ImageParticleTypes.FALL_1.make((double) (this.x + 32), (double) (this.y + 64), 16, 16, null, null, ParticleImages.SMOKE_1);
		ImageParticleTypes.FALL_1.make((double) (this.x - 128), (double) (this.y - 128), 16, 16, null, null, ParticleImages.SMOKE_1);
		ImageParticleTypes.FALL_1.make((double) (this.x - 128), (double) (this.y - 64), 16, 16, null, null, ParticleImages.SMOKE_1);
		ImageParticleTypes.FALL_1.make((double) (this.x - 64), (double) (this.y - 128), 16, 16, null, null, ParticleImages.SMOKE_1);
		ImageParticleTypes.FALL_1.make((double) (this.width + 256), (double) (this.height + 256), 16, 16, null, null, ParticleImages.SMOKE_1);
		
		Game.MAP_HANDLER().currentMap().getEntityHandler().getList().remove(this);
		
		Game.SE_SOUND.setSound(Sounds.BOMB_BOOM);
		Game.SE_SOUND.play();
		
	}

	public byte getFrameState() {
		return frameState;
	}

	public void setFrameState(byte frameState) {
		this.frameState = frameState;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public long getTempTime() {
		return tempTime;
	}

	public void setTempTime(long tempTime) {
		this.tempTime = tempTime;
	}

}
