package com.github.kaosgame.kaos.entities.player.items.money.bags;

import java.awt.image.BufferedImage;

import com.github.kaosgame.kaos.entities.player.items.base.CoinGiveItem;
import com.github.kaosgame.kaos.entities.player.items.base.ItemID;

public class MoneyBag1Item extends CoinGiveItem<MoneyBag1Item> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -366877503658796259L;

	public MoneyBag1Item(int count, ItemID id, BufferedImage image, long value) {
		super(count, id, image, value);
		
		
	}
	
	public MoneyBag1Item(int count, ItemID id, BufferedImage image) {
		super(count, id, image, 10L);
		
		
	}

	@Override
	public MoneyBag1Item cloneType() {
		return new MoneyBag1Item(this.count, this.id, this.image, this.value);
	}

}
