package com.game.entities.player;

import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.JOptionPane;

import com.game.collision.objects.CollidableObject;
import com.game.collision.objects.CollisionObject;
import com.game.collision.objects.ObjectType;
import com.game.entities.Dieable;
import com.game.entities.Entity;
import com.game.entities.EntityDeathMessages;
import com.game.entities.EntityID;
import com.game.entities.player.items.base.Item;
import com.game.main.Game;
import com.game.maps.MapHandler;

public class Player extends Entity implements Dieable {
	
	public static final float DEFAULT_SPEED = 4f;
	public static final float DASH_SPEED = (float) (Player.DEFAULT_SPEED * 2.5f);
	
	public static final int MAX_HUNGER = 20;
	public static final int MIN_HUNGER = 0;
	
	public static final float MAX_HEALTH = 20;
	public static final float MIN_HEALTH = 0;

	public static float SPEED = Player.DEFAULT_SPEED;
	
	private boolean[] keysDown;
	private boolean dashKeyDown;

	private PlayerHotbar hotbar;
	
	private int hunger;
	private float health;
	
	
	public Player(float x, float y, float xv, float yv, int width, int height, EntityID id, BufferedImage image) {
		
		super(x, y, xv, yv, width, height, id, image);
		
		this.hunger = Player.MAX_HUNGER;
		this.health = Player.MAX_HEALTH;
		
		this.dashKeyDown = false;
		
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
		
		this.handleHunger();
		this.handleHungerValue();
		
		this.dieIfNeeded();
		
	}

	private void dieIfNeeded() {
		
		if (this.health == 0 && this.hunger == 0) this.die(EntityDeathMessages.STARVING);
		
	}

	private void handleHungerValue() {
		
		Random random = new Random();
		
		if (
				this.hunger == Player.MIN_HUNGER &&
				Math.random() < 0.1 &&
				Math.random() > 0.1 &&
				Math.random() < 0.1 &&
				Math.random() > 0.1 &&
				random.nextBoolean() &&
				!random.nextBoolean()
			) {
			
			this.removeHealth(1f);
			
			
		}
		
		if (this.hunger == Player.MIN_HUNGER) {
			
			Player.SPEED = Player.DEFAULT_SPEED;
			
		}
		
	}
	
	public void removeHealth(float val) {
		
		this.health -= val;
		this.health = Game.clamp(this.health, Player.MAX_HEALTH, Player.MIN_HEALTH);
		
	}
	
	public void addHealth(float val) {
		
		this.health += val;
		this.health = Game.clamp(this.health, Player.MAX_HEALTH, Player.MIN_HEALTH);
		
	}

	private void handleHunger() {
		
		Random random = new Random();
		
		if (
				this.dashKeyDown &&
				Math.random() < 0.1 &&
				Math.random() > 0.1 &&
				random.nextBoolean() &&
				!random.nextBoolean() &&
				(this.xv != 0 || this.yv != 0)
			) {
			
			this.removeHungerValue(1);
			
		}
		
		if (
				Math.random() < 0.1 &&
				Math.random() > 0.1 &&
				random.nextBoolean() &&
				!random.nextBoolean() &&
				this.hunger == Player.MAX_HUNGER &&
				this.health != Player.MAX_HEALTH
			) {
			
			this.addHealth(1);
			
			if (random.nextBoolean() && !random.nextBoolean()) {
				
				this.removeHungerValue(1);
				
			}
			
		}
		
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

	public boolean hasDashKeyDown() {
		return this.dashKeyDown;
	}

	public void setDashKeyDown(boolean dashKeyDown) {
		this.dashKeyDown = dashKeyDown;
	}

	public float getHealth() {
		return this.health;
	}

	public void setHealth(float health) {
		this.health = health;
	}

	@Override
	public void die(EntityDeathMessages message) {
		
		this.health = Player.MAX_HEALTH;
		this.hunger = Player.MAX_HUNGER;
		
		this.dropAllItems();
		
		JOptionPane.showMessageDialog(null, message.getDeathMessage(), "Info", JOptionPane.INFORMATION_MESSAGE);
		
		MapHandler.CURRENT_MAP_ID = 0;
		
		Game.resetPlayerPosToCenter();
		
	}
	
	public void dropAllItems() {
		
		for (int i = 0; i < this.hotbar.list.length; i++) {
			
			Item<?> item = this.hotbar.list[i];
			
			if (item == null) continue;
			
			Game.makeItemAtRandomWithItem(item);
			
			this.hotbar.list[i] = null;
			
		}
		
	}
	
	

}
