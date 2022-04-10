package com.game.entities.player.items.money.bags;

import java.awt.image.BufferedImage;

import com.game.entities.player.items.base.CoinGiveItem;
import com.game.entities.player.items.base.ItemID;

public class MoneyBag3Item extends CoinGiveItem<MoneyBag3Item> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -366877503658796259L;

	public MoneyBag3Item(int count, ItemID id, BufferedImage image, long value) {
		super(count, id, image, value);
		
		
	}
	
	public MoneyBag3Item(int count, ItemID id, BufferedImage image) {
		super(count, id, image, 100L);
		
		
	}

	@Override
	public MoneyBag3Item cloneType() {
		return new MoneyBag3Item(this.count, this.id, this.image, this.value);
	}

}
