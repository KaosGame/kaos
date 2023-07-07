package com.github.kaosgame.kaos.entities.player.items;

import java.awt.image.BufferedImage;

import com.github.kaosgame.kaos.entities.player.items.base.Item;
import com.github.kaosgame.kaos.entities.player.items.base.ItemID;
import com.github.kaosgame.kaos.loot.tables.handler.LootTableHandler;
import com.github.kaosgame.kaos.main.Game;

public class Medkit1Item extends Item<Medkit1Item> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9090924333864455455L;

	public Medkit1Item(int count, ItemID id, BufferedImage image) {
		
		super(count, id, image);
		
		
	}

	@Override
	public Medkit1Item cloneType() {
		return new Medkit1Item(this.count, this.id, this.image);
	}

	@Override
	public void use() {

		this.count--;
		
		if (this.count <= 0) Game.PLAYER.getHotbar().list[Game.PLAYER.getHotbar().currentItemIndex] = null;
		
		Item<?>[] items = LootTableHandler.returnRandomLootItemsForMedkit1();
		
		for (int i = 0; i < items.length; i++) if (items[i] != null) Game.addItemOrItemEntity(items[i]);
		
	}

}
