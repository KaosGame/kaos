package com.game.collision.objects;

import java.awt.Graphics2D;
import java.util.Random;

import com.game.collision.objects.base.CollisionObject;
import com.game.collision.objects.base.ObjectType;
import com.game.entities.base.Entity;
import com.game.entities.base.EntityDeathMessages;
import com.game.entities.player.Player;
import com.game.entities.player.items.base.Item;
import com.game.entities.player.items.base.ItemID;
import com.game.loot.tables.handler.LootTableHandler;
import com.game.main.Drawable;
import com.game.main.Game;
import com.game.sound.Sounds;

public class Bank1CollidableObjest extends CollisionObject implements Drawable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5999175893105367249L;

	public Bank1CollidableObjest(int x, int y) {
		super(x, y, 96, 96, ObjectType.BANK_1, Game.BANK_1_IMAGE_LOADER.getImage(), true);
		
		
	}

	@Override
	public void collide(Entity e) {

		if (!(e instanceof Player)) return;
		
		Random random = new Random();
		
		// If going to sound alarm
		if (random.nextBoolean()) {
			// Sound alarm
			
			// Override if player has a bank mask
			if (Game.PLAYER.getHotbar().hasItem(ItemID.BANK_MASK_ITEM)) {
				
				this.win();
				return;
				
			}
			
			
			Game.ANY_VOLUME_SOUNDS.setVolumeScale(4);
			Game.ANY_VOLUME_SOUNDS.setSound(Sounds.BANK_ALARM);
			Game.ANY_VOLUME_SOUNDS.loop(2);
			Game.ANY_VOLUME_SOUNDS.setVolumeScale(3);
			
			Game.PLAYER.die(EntityDeathMessages.EXECUTE);
			
		} else {
			// Give items
			
			this.win();
			
		}
		
	}
	
	public void win() {
		
		Item<?>[] items = LootTableHandler.returnRandomLootItemsForBank();
		
		for (int i = 0; i < items.length; i++) Game.addItemOrItemEntity(items[i]);
		
		Game.MAP_HANDLER().currentMap().removeObject(this);
		
	}
	
	@Override
	public void draw(Graphics2D g2d) {
		
		g2d.drawImage(this.image, this.x, this.y, this.width, this.height, null);
		
	}

}
