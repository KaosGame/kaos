package com.dodgydavid.kaos.entities.bad.zombie;

import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Random;

import com.dodgydavid.kaos.collision.objects.ChestTransparentObject;
import com.dodgydavid.kaos.collision.objects.base.CollisionObject;
import com.dodgydavid.kaos.collision.objects.base.ObjectType;
import com.dodgydavid.kaos.entities.base.DamageableEntity;
import com.dodgydavid.kaos.entities.base.EntityDeathMessages;
import com.dodgydavid.kaos.entities.base.EntityID;
import com.dodgydavid.kaos.entities.player.items.base.Item;
import com.dodgydavid.kaos.logging.LogType;
import com.dodgydavid.kaos.loot.tables.handler.LootTableHandler;
import com.dodgydavid.kaos.main.Game;
import com.dodgydavid.kaos.sound.Sounds;

public class WarZombie extends DamageableEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4707682148300966924L;
	
	private LinkedList<Item<?>> items;

	public WarZombie(float x, float y, float xv, float yv, int width, int height, EntityID id, BufferedImage image,
			float health) {
		super(x, y, xv, yv, width, height, id, image, health, true);
		this.setItems(new LinkedList<Item<?>>());
		this.setup();
	}
	
	public WarZombie(float x, float y, int width, int height, EntityID id, BufferedImage image) {
		super(x, y, 0f, 0f, width, height, id, image, 12.5f, true);
		this.setItems(new LinkedList<Item<?>>());
		this.setup();
		
	}
	
	public WarZombie() {
		
		this(0, 0, 0, 0, null, null);
		
	}
	
	private void setup() {
		
		for (int i = 0; i < 5; i++) {
			
			Item<?> item = LootTableHandler.returnRandomLootItemForWarZombie();
			
			this.items.add(item);
			
		}
		
	}

	@Override
	public void die(EntityDeathMessages message) {
		
		for (int i = 0; i < this.items.size(); i++) {
			
			Item<?> item = this.items.get(i);
			
			Game.addItemEntityWithRandomPos(item, this.x, this.y);
			
			this.items.remove(item);
			
		}
		
		Game.SE_SOUND.setSound(Sounds.WAR_END);
		Game.SE_SOUND.play();
		
		Game.MAP_HANDLER().currentMap().getEntityHandler().remove(this);
		
	}

	@Override
	public void die() {
		
		this.die(null);
		
	}

	@Override
	public void update() {
		
		final float OLD_X = this.x;
		final float OLD_Y = this.y;
		
		
		this.addVPos();
		
		this.x = Game.clamp(this.x, (float) (Game.WIDTH - this.width), 0f);
		this.y = Game.clamp(this.y, (float) (Game.HEIGHT - (float) (this.height * 1.3f)), 0f);
		
		this.handleCollidableObjects(OLD_X, OLD_Y);
		
		float diffX = (float) ((float) (this.x - Game.PLAYER.getX()) - 8);
		float diffY = (float) ((float) (this.y - Game.PLAYER.getY()) - 8);
		
		float distance = (float) Math.sqrt(
												
												(double) (
															(double) (
															
																(double) (
																		this.x - Game.PLAYER.getX()	
																		) *
																(double) (
																		this.x - Game.PLAYER.getX()	
																		)
															
															) + (double) (
																	
																	(double) (
																			this.y - Game.PLAYER.getY()	
																			) *
																	(double) (
																			this.y - Game.PLAYER.getY()	
																			)
																	
																	))
				
											);
		
		final float SPEED = -1.0f;
		
		this.xv = (float) ((float) (SPEED / distance) * diffX);
		this.yv = (float) ((float) (SPEED / distance) * diffY);
		
		
		Random random = new Random();
		
		if (
				this.getRectangle().intersects(Game.PLAYER.getRectangle()) &&
				random.nextBoolean() && !random.nextBoolean() && random.nextBoolean() && Math.random() < 0.50
				
			) {
			
			final float DAMAGE = 0.75f;
			
			Game.PLAYER.damage(DAMAGE, EntityDeathMessages.ZOMBIE);
			Game.logln(String.format("WAR_ZOMBIE did %f damage to a player with the health of %f!", Game.PLAYER.calculateDamage(DAMAGE), Game.PLAYER.getHealth()), LogType.INFO);
			
		}
		
		this.handleItemTaking();
		
	}

	private void handleItemTaking() {
		
		LinkedList<CollisionObject> tempList = Game.MAP_HANDLER().currentMap().getObjectList();
		
		for (int i = 0; i < tempList.size(); i++) {
			
			CollisionObject o = tempList.get(i);
			
			if (o.getType() == ObjectType.CHEST && this.getRectangle().intersects(o.getRectangle()) && o instanceof ChestTransparentObject) {
				
				if (((ChestTransparentObject) o).isNotEmpty()) {
					
					this.items.add(((ChestTransparentObject) o).pop());
					
					Game.ANY_VOLUME_SOUNDS.setSound(Sounds.POP);
					Game.ANY_VOLUME_SOUNDS.setVolumeScale(1);
					Game.ANY_VOLUME_SOUNDS.play();
					Game.ANY_VOLUME_SOUNDS.setVolumeScale(3);
					
				}
				
			}
			
		}
		
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
	
	@Override
	public void damage(float num) {
		
		this.damage(num, null);
		
	}
	
	private void handleCollidableObjects(final float OLD_X, final float OLD_Y) {
		
		LinkedList<CollisionObject> tempList = Game.MAP_HANDLER().currentMap().getObjectList();
		
		for (int i = 0; i < tempList.size(); i++) {
			
			CollisionObject tempObj = tempList.get(i);
			
			if (this.getRectangle().intersects(tempObj.getRectangle())) {
				
				tempObj.collide(this);
				
			}
			
			if (
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

	public void spawn() {
		
		Random random = new Random();
		
		float[] offset = {random.nextInt(Game.WIDTH), random.nextInt(Game.HEIGHT)};
		
		WarZombie zombie = new WarZombie(offset[0], offset[1], 64, 64, EntityID.WAR_ZOMBIE,
				Game.ZOMBIE_TEXTRA_ALICE.getImageFrom(0, 0, 16, 16));
		
		zombie.setPos(Game.clamp(zombie.getX(), (float) (Game.WIDTH - zombie.getWidth()), 0f),
				Game.clamp(zombie.getY(), (float) (Game.HEIGHT - (float) (zombie.getHeight() * 1.3f)), 0f));
		
		while (Game.touchingSomething(zombie.getRectangle())) {
			
			float[] pos = Game.getRandomItemPos(zombie.getX(), zombie.getY());
			
			zombie.setPos(pos);
			
			zombie.setPos(Game.clamp(zombie.getX(), (float) (Game.WIDTH - zombie.getWidth()), 0f),
					Game.clamp(zombie.getY(), (float) (Game.HEIGHT - (float) (zombie.getHeight() * 1.3f)), 0f));
			
		}
		
		Game.addEntity(zombie);
		
		Game.logln("New WAR_ZOMBIE summoned successfully", LogType.SUCCESS);
		
	}
	
	public void setPos(float x, float y) {
		
		this.x = x;
		this.y = y;
		
	}
	
	public void setPos(float[] pos) {
		
		this.setPos(pos[0], pos[1]);
		
	}

	public LinkedList<Item<?>> getItems() {
		return items;
	}

	public void setItems(LinkedList<Item<?>> items) {
		this.items = items;
	}
	

}
