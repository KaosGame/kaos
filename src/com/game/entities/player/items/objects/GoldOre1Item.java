package com.game.entities.player.items.objects;

import java.awt.image.BufferedImage;

import com.game.collision.objects.PlayerObject;
import com.game.collision.objects.base.ObjectType;
import com.game.entities.player.items.base.Item;
import com.game.entities.player.items.base.ItemID;
import com.game.main.Game;

public class GoldOre1Item extends Item<GoldOre1Item> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7742742984114504950L;

	public GoldOre1Item(int count, ItemID id, BufferedImage image) {
		
		super(count, id, image);
		
		
	}

	@Override
	public GoldOre1Item cloneType() {
		return new GoldOre1Item(this.count, this.id, this.image);
	}

	@Override
	public void use() {
		
		this.count--;
		
		if (this.count <= 0) Game.PLAYER.getHotbar().list[Game.PLAYER.getHotbar().currentItemIndex] = null;
		
		Game.MAP_HANDLER.currentMap().addObject(new PlayerObject(
																(int) Game.PLAYER.getX(),
																(int) Game.PLAYER.getY(),
																64,
																64,
																ObjectType.GOLD_ORE_1,
																Game.OBJECT_TEXTRA_ALICE.getImageFrom(240, 0, 16, 16)
															));
		
	}

}
