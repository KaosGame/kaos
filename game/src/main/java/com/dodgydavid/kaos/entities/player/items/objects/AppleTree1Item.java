package com.dodgydavid.kaos.entities.player.items.objects;

import java.awt.image.BufferedImage;

import com.dodgydavid.kaos.collision.objects.PlayerObject;
import com.dodgydavid.kaos.collision.objects.base.ObjectType;
import com.dodgydavid.kaos.entities.player.items.base.Item;
import com.dodgydavid.kaos.entities.player.items.base.ItemID;
import com.dodgydavid.kaos.main.Game;

public class AppleTree1Item extends Item<AppleTree1Item> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6566645115592068848L;

	public AppleTree1Item(int count, ItemID id, BufferedImage image) {
		
		super(count, id, image);
		
		
	}

	@Override
	public AppleTree1Item cloneType() {
		return new AppleTree1Item(this.count, this.id, this.image);
	}

	@Override
	public void use() {
		
		this.count--;
		
		if (this.count <= 0) Game.PLAYER.getHotbar().list[Game.PLAYER.getHotbar().currentItemIndex] = null;
		
		Game.MAP_HANDLER().currentMap().addObject(new PlayerObject(
																(int) Game.PLAYER.getX(),
																(int) Game.PLAYER.getY(),
																128,
																128,
																ObjectType.APPLE_TREE_1,
																Game.OBJECT_TEXTRA_ALICE.getImageFrom(176, 0, 16, 16)
															));
		
	}

}
