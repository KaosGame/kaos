package com.game.entities.player.items;

import java.awt.image.BufferedImage;

public class Apple1Item extends Item<Apple1Item> {

	public Apple1Item(int count, ItemID id, BufferedImage image) {
		
		super(count, id, image);
		
		
	}

	@Override
	public Apple1Item cloneType() {
		return new Apple1Item(this.count, this.id, this.image);
	}

	@Override
	public void use() {
		
		
		
	}

}
