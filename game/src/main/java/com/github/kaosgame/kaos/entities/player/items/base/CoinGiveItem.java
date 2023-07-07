package com.github.kaosgame.kaos.entities.player.items.base;

import java.awt.image.BufferedImage;

import com.github.kaosgame.kaos.main.Game;

public abstract class CoinGiveItem<CT> extends Item<CT> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4167424453219058085L;

	protected long value;
	
	public CoinGiveItem(int count, ItemID id, BufferedImage image, long value) {
		
		super(count, id, image);
		this.value = value;
		
	}

	@Override
	public void use() {
		
		this.count--;
		
		if (this.count <= 0) Game.PLAYER.getHotbar().list[Game.PLAYER.getHotbar().currentItemIndex] = null;
		
		Game.PLAYER.addCoins(this.value);
		
	}
	
	public long getValue() {
		return this.value;
	}

	public void setValue(long value) {
		this.value = value;
	}
	
	

}
