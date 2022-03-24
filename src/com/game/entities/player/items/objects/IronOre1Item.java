package com.game.entities.player.items.objects;

import java.awt.image.BufferedImage;

import com.game.collision.objects.PlayerObject;
import com.game.collision.objects.base.ObjectType;
import com.game.entities.player.items.base.Item;
import com.game.entities.player.items.base.ItemID;
import com.game.main.Game;

public class IronOre1Item extends Item<IronOre1Item> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7027837785967929997L;

	public IronOre1Item(int count, ItemID id, BufferedImage image) {
		
		super(count, id, image);
		
		
	}

	@Override
	public IronOre1Item cloneType() {
		return new IronOre1Item(this.count, this.id, this.image);
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
																ObjectType.IRON_ORE_1,
																Game.OBJECT_TEXTRA_ALICE.getImageFrom(224, 0, 16, 16)
															));
		
		for (int i = 0; i < 10; i++) {
			
			float[] pos = Game.getRandomItemPos();
			
			Game.PLAYER.setX(pos[0]);
			Game.PLAYER.setY(pos[1]);
			
		}
		
	}

}
