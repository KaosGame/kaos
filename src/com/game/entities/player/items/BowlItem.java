package com.game.entities.player.items;

import java.awt.image.BufferedImage;

import com.game.annotations.Empty;
import com.game.annotations.NotNeeded;
import com.game.annotations.Unused;
import com.game.entities.player.items.base.Item;
import com.game.entities.player.items.base.ItemID;

public class BowlItem extends Item<BowlItem> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1994103458522697542L;

	public BowlItem(int count, ItemID id, BufferedImage image) {
		
		super(count, id, image);
		
		
	}

	@Override
	public BowlItem cloneType() {
		return new BowlItem(this.count, this.id, this.image);
	}
	
	@NotNeeded
	@Empty
	@Unused
	@Override
	public void use() {
		
		
		
	}

}
