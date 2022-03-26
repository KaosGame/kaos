package com.game.entities.player;

import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.JOptionPane;

import com.game.collision.objects.CollidableObject;
import com.game.collision.objects.CollidableWallObject;
import com.game.collision.objects.PlayerObject;
import com.game.collision.objects.base.CollisionObject;
import com.game.collision.objects.base.ObjectType;
import com.game.entities.base.DamageableEntity;
import com.game.entities.base.Entity;
import com.game.entities.base.EntityDeathMessages;
import com.game.entities.base.EntityID;
import com.game.entities.player.items.base.Item;
import com.game.entities.vilagers.VillagerEntity;
import com.game.logging.LogType;
import com.game.main.CloneableType;
import com.game.main.Game;

public class Player extends DamageableEntity implements Serializable, CloneableType<Player> {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3962554415862002362L;
	
	
	public static final float DEFAULT_SPEED = 4f;
	public static final float DASH_SPEED = (float) (Player.DEFAULT_SPEED * 2.5f);
	public static final float ORANGE_JUCE_1_SPEED = (float) (Player.DEFAULT_SPEED * 1.952f);
	
	public static final int MAX_HUNGER = 20;
	public static final int MIN_HUNGER = 0;
	
	public static final float MAX_HEALTH = 20;
	public static final float MIN_HEALTH = 0;

	public static float SPEED = Player.DEFAULT_SPEED;
	
	private boolean[] keysDown;
	
	private boolean dashKeyDown;

	private PlayerHotbar hotbar;
	
	private int hunger;
	
	private long coins;
	
	
	public Player(float x, float y, float xv, float yv, int width, int height, EntityID id, BufferedImage image) {
		
		super(x, y, xv, yv, width, height, id, image, Player.MAX_HEALTH);
		
		this.hunger = Player.MAX_HUNGER;
		this.health = Player.MAX_HEALTH;
		
		this.dashKeyDown = false;
		
		this.keysDown = new boolean[4];
		Arrays.fill(this.keysDown, false);
		
		this.hotbar = new PlayerHotbar();
		
		this.coins = 0L;
		
		
	}
	
	

	private Player(float x, float y, float xv, float yv, int width, int height, EntityID id, BufferedImage image,
			boolean[] keysDown, boolean dashKeyDown, PlayerHotbar hotbar, int hunger, float health, long coins) {
		
		super(x, y, xv, yv, width, height, id, image, health);
		
		this.keysDown = keysDown;
		this.dashKeyDown = dashKeyDown;
		this.hotbar = hotbar;
		this.hunger = hunger;
		this.coins = coins;
		
		
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
	
	public void trade() {
		
		for (int i = 0; i < Game.MAP_HANDLER().currentMap().getEntityHandler().getList().size(); i++) {
			
			Entity e = Game.MAP_HANDLER().currentMap().getEntityHandler().get(i);
			
			if (e instanceof VillagerEntity && e.getRectangle().intersects(this.getRectangle())) {
				
				((VillagerEntity) e).trade();
				
			}
			
		}
		
	}
	
	public void tradeAll() {
		
		for (int i = 0; i < Game.MAP_HANDLER().currentMap().getEntityHandler().getList().size(); i++) {
			
			Entity e = Game.MAP_HANDLER().currentMap().getEntityHandler().get(i);
			
			if (e instanceof VillagerEntity && e.getRectangle().intersects(this.getRectangle())) {
				
				((VillagerEntity) e).tradeAll();
				
			}
			
		}
		
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
				Math.random() < 0.48 &&
				Math.random() > 0.48 &&
				random.nextBoolean() &&
				!random.nextBoolean()
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
		
		LinkedList<CollisionObject> tempList = Game.MAP_HANDLER().currentMap().getObjectList();
		
		for (int i = 0; i < tempList.size(); i++) {
			
			CollisionObject tempObj = tempList.get(i);
			
			if (this.getRectangle().intersects(tempObj.getRectangle())) {
				
				tempObj.collide();
				
			}
			
			if (
					(
						tempObj.getType() == ObjectType.WALL ||
						tempObj.getType() == ObjectType.STONE_1 ||
						tempObj.getType() == ObjectType.IRON_ORE_1 ||
						tempObj.getType() == ObjectType.GOLD_ORE_1 ||
						tempObj.getType() == ObjectType.DIAMOND_ORE_1
							
					) &&
					(tempObj instanceof CollidableObject || tempObj instanceof CollidableWallObject) &&
					this.getRectangle().intersects(tempObj.getRectangle()) &&
					!tempObj.getType().isTRANSPARENT()
				) {
				
				this.x = OLD_X;
				this.y = OLD_Y;
				
			}
			
			if (
					
					(
							tempObj.getType() == ObjectType.WALL ||
							tempObj.getType() == ObjectType.STONE_1 ||
							tempObj.getType() == ObjectType.IRON_ORE_1 ||
							tempObj.getType() == ObjectType.GOLD_ORE_1 ||
							tempObj.getType() == ObjectType.DIAMOND_ORE_1
								
					) &&
					tempObj instanceof PlayerObject &&
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
		
		Game.MAP_HANDLER().CURRENT_MAP_ID = 0;
		
		Game.resetPlayerPosToCenter();
		
		Game.logln("Player died :(", LogType.INFO);
		
	}
	
	public void dropAllItems() {
		
		for (int i = 0; i < this.hotbar.list.length; i++) {
			
			Item<?> item = this.hotbar.list[i];
			
			if (item == null) continue;
			
			Game.makeItemAtRandomWithItem(item);
			
			this.hotbar.list[i] = null;
			
		}
		
	}


	public long getCoins() {
		return this.coins;
	}

	public void setCoins(long coins) {
		this.coins = coins;
	}
	
	public void addCoins(long coins) {
		
		this.coins += coins;
		
	}
	
	public void removeCoins(long coins) {
		
		this.coins -= coins;
		
	}
	
	public float[] getPos() {
		
		float[] pos = {this.x, this.y};
		
		return pos;
		
	}

	@Override
	public Player cloneType() {
		return new Player(this.x, this.y, this.xv, this.yv, this.width, this.height, this.id, this.image, this.keysDown, this.dashKeyDown, this.hotbar.cloneType(), this.hunger, this.health, this.coins);
	}



	@Override
	public void damage(float num, EntityDeathMessages deathType) {
		
		float tempHP = (float) (this.health - num);
		
		if (tempHP <= 0) {
			
			this.die(deathType);
			
		} else {
			
			this.health -= num;
			
		}
		
	}
	
}
