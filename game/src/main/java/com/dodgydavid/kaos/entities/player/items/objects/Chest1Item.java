package com.dodgydavid.kaos.entities.player.items.objects;

import java.awt.image.BufferedImage;

import com.dodgydavid.kaos.collision.objects.ChestTransparentObject;
import com.dodgydavid.kaos.collision.objects.base.ObjectType;
import com.dodgydavid.kaos.entities.player.items.base.Item;
import com.dodgydavid.kaos.entities.player.items.base.ItemID;
import com.dodgydavid.kaos.main.Game;

public class Chest1Item extends Item<Chest1Item> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3550978995956940726L;

	public Chest1Item(int count, ItemID id, BufferedImage image) {
		
		super(count, id, image);
		
		
	}

	@Override
	public Chest1Item cloneType() {
		return new Chest1Item(this.count, this.id, this.image);
	}

	@Override
	public void use() {
		
		this.count--;
		
		if (this.count <= 0) Game.PLAYER.getHotbar().list[Game.PLAYER.getHotbar().currentItemIndex] = null;
		
		Game.MAP_HANDLER().currentMap().addObject(new ChestTransparentObject(
																(int) Game.PLAYER.getX(),
																(int) Game.PLAYER.getY(),
																64,
																64,
																ObjectType.CHEST,
																Game.OBJECT_TEXTRA_ALICE.getImageFrom(16, 0, 16, 16)
															));
		
		
	}

}
