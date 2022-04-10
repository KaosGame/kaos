package com.game.entities.player.items.money.bags;

import java.awt.image.BufferedImage;

import com.game.entities.player.items.base.CoinGiveItem;
import com.game.entities.player.items.base.ItemID;

public class MoneyBag2Item extends CoinGiveItem<MoneyBag2Item> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -366877503658796259L;

	public MoneyBag2Item(int count, ItemID id, BufferedImage image, long value) {
		super(count, id, image, value);
		
		
	}
	
	public MoneyBag2Item(int count, ItemID id, BufferedImage image) {
		super(count, id, image, 20L);
		
		
	}

	@Override
	public MoneyBag2Item cloneType() {
		return new MoneyBag2Item(this.count, this.id, this.image, this.value);
	}

}
