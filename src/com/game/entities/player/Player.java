package com.game.entities.player;

import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.LinkedList;

import com.game.collision.objects.CollidableObject;
import com.game.collision.objects.CollisionObject;
import com.game.collision.objects.ObjectType;
import com.game.entities.Entity;
import com.game.entities.EntityID;
import com.game.main.Game;
import com.game.maps.MapHandler;

public class Player extends Entity {
	
	public static final float DEFAULT_SPEED = 4f;
	public static final float DASH_SPEED = (float) (Player.DEFAULT_SPEED * 2.5f);
	
	public static final int MAX_HUNGER = 20;
	public static final int MIN_HUNGER = 0;

	public static float SPEED = Player.DEFAULT_SPEED;
	
	private boolean[] keysDown;

	private PlayerHotbar hotbar;
	
	private int hunger;
	
	
	public Player(float x, float y, float xv, float yv, int width, int height, EntityID id, BufferedImage image) {
		
		super(x, y, xv, yv, width, height, id, image);
		
		this.hunger = Player.MAX_HUNGER;
		
		this.keysDown = new boolean[4];
		Arrays.fill(this.keysDown, false);
		
		this.hotbar = new PlayerHotbar();
		
		
	}

	@Override
	public void update() {
		
		final float OLD_X = this.x;
		final float OLD_Y = this.y;
		
		
		this.updatePosV();
		
		this.addVPos();
		
		this.handleCollidableObjects(OLD_X, OLD_Y);
		
		this.x = Game.clamp(this.x, (float) (Game.WIDTH - this.width), 0f);
		this.y = Game.clamp(this.y, (float) (Game.HEIGHT - (float) (this.height * 1.3f)), 0f);
		
	}

	private void handleCollidableObjects(final float OLD_X, final float OLD_Y) {
		
		LinkedList<CollisionObject> tempList = MapHandler.currentMap().getObjectList();
		
		for (int i = 0; i < tempList.size(); i++) {
			
			CollisionObject tempObj = tempList.get(i);
			
			if (this.getRectangle().intersects(tempObj.getRectangle())) {
				
				tempObj.collide();
				
			}
			
			if (
					tempObj.getType() == ObjectType.WALL &&
					tempObj instanceof CollidableObject &&
					this.getRectangle().intersects(tempObj.getRectangle()) &&
					!tempObj.getType().isTRANSPARENT()
				) {
				
				this.x = OLD_X;
				this.y = OLD_Y;
				
			}
			
		}
		
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

	public PlayerHotbar getHotbar() {
		return this.hotbar;
	}

	public void setHotbar(PlayerHotbar hotbar) {
		this.hotbar = hotbar;
	}
	
	public void useItem() {
		
		this.hotbar.useCurrentItem();
		
	}

	public int getHunger() {
		return this.hunger;
	}

	public void setHunger(int hunger) {
		this.hunger = hunger;
	}
	
	public void addHungerValue(int hunger) {
		
		this.hunger += hunger;
		this.hunger = Game.clamp(this.hunger, Player.MAX_HUNGER, Player.MIN_HUNGER);
		
	}
	
	public void removeHungerValue(int hunger) {
		
		this.hunger -= hunger;
		this.hunger = Game.clamp(this.hunger, Player.MAX_HUNGER, Player.MIN_HUNGER);
		
	}

}
