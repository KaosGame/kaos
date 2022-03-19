package com.game.entities.player.items;

import java.awt.image.BufferedImage;

import com.game.entities.player.Player;
import com.game.entities.player.items.base.Item;
import com.game.entities.player.items.base.ItemID;
import com.game.main.Game;

public class Heart1Item extends Item<Heart1Item> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5304475576328867061L;

	private byte value;
	
	public Heart1Item(int count, ItemID id, BufferedImage image, byte value) {
		
		super(count, id, image);
		this.value = value;
		
		
	}
	
	public Heart1Item(int count, ItemID id, BufferedImage image) {
		
		this(count, id, image, (byte) 1);
		
	}

	@Override
	public Heart1Item cloneType() {
		return new Heart1Item(this.count, this.id, this.image, this.value);
	}

	@Override
	public void use() {
		
		if (Game.PLAYER.getHealth() != Player.MAX_HEALTH) {
			
			this.count--;
			
			if (this.count <= 0) Game.PLAYER.getHotbar().list[Game.PLAYER.getHotbar().currentItemIndex] = null;
			
			Game.PLAYER.addHealth((float) this.value);
			
		}
		
	}

	public byte getValue() {
		return this.value;
	}

	public void setValue(byte value) {
		this.value = value;
	}
	
	

}
