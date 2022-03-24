package com.game.entities.player.items.objects;

import java.awt.image.BufferedImage;

import com.game.collision.objects.PlayerObject;
import com.game.collision.objects.base.ObjectType;
import com.game.entities.player.items.base.Item;
import com.game.entities.player.items.base.ItemID;
import com.game.main.Game;

public class Wood1Item extends Item<Wood1Item> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6972677228091459779L;

	public Wood1Item(int count, ItemID id, BufferedImage image) {
		
		super(count, id, image);
		
	}
	
	@Override
	public void use() {
	
		this.count--;
		
		if (this.count <= 0) Game.PLAYER.getHotbar().list[Game.PLAYER.getHotbar().currentItemIndex] = null;
		
		Game.MAP_HANDLER().currentMap().addObject(new PlayerObject(
																(int) Game.PLAYER.getX(),
																(int) Game.PLAYER.getY(),
																64,
																64,
																ObjectType.WOOD_1,
																Game.OBJECT_TEXTRA_ALICE.getImageFrom(96, 0, 16, 16)
															));
		
	}

	@Override
	public Wood1Item cloneType() {
		return new Wood1Item(this.count, this.id, this.image);
	}
	

}
