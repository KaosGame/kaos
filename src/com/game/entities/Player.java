package com.game.entities;

import java.awt.image.BufferedImage;
import java.util.Arrays;

import com.game.main.Game;

public class Player extends Entity {
	
	public static final float DEFAULT_SPEED = 4f;
	public static final float DASH_SPEED = (float) (Player.DEFAULT_SPEED * 2.5f);

	public static float SPEED = Player.DEFAULT_SPEED;
	
	private boolean[] keysDown;

	public Player(float x, float y, float xv, float yv, int width, int height, EntityID id, BufferedImage image) {
		
		super(x, y, xv, yv, width, height, id, image);
		
		
		this.keysDown = new boolean[4];
		Arrays.fill(this.keysDown, false);
		
		
		
		
	}

	@Override
	public void update() {
		
		final float OLD_X = this.x;
		final float OLD_Y = this.y;
		
		
		this.updatePosV();
		
		this.addVPos();
		
		this.x = Game.clamp(this.x, (float) (Game.WIDTH - this.width), 0f);
		this.y = Game.clamp(this.y, (float) (Game.HEIGHT - (float) (this.height * 1.3f)), 0f);
		
	}

	private void addVPos() {
		
		this.x += this.xv;
		this.y += this.yv;
		
	}

	private void updatePosV() {
		
		if (this.keysDown[0]) {
			
			this.yv = (float) (Player.SPEED * -1f);
			
		}
		
		if (this.keysDown[1]) {
			
			this.yv = Player.SPEED;
			
		}
		
		if (this.keysDown[2]) {
			
			this.xv = (float) (Player.SPEED * -1f);
			
		}
		
		if (this.keysDown[3]) {
			
			this.xv = Player.SPEED;
			
		}
		
		if (!this.keysDown[0] && !this.keysDown[1]) {
			
			this.yv = 0f;
			
		}
		
		if (!this.keysDown[2] && !this.keysDown[3]) {
			
			this.xv = 0f;
			
		}
		
	}

	public void setKeyDownAt(int index, boolean value) {
		
		this.keysDown[index] = value;
		
	}
	
	public boolean[] getKeysDown() {
		return this.keysDown;
	}

	public void setKeysDown(boolean[] keysDown) {
		this.keysDown = keysDown;
	}
	
	
	
	

}
