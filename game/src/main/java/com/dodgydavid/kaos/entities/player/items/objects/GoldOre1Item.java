package com.dodgydavid.kaos.entities.player.items.objects;

import java.awt.image.BufferedImage;

import com.dodgydavid.kaos.collision.objects.PlayerObject;
import com.dodgydavid.kaos.collision.objects.base.ObjectType;
import com.dodgydavid.kaos.entities.player.items.base.Item;
import com.dodgydavid.kaos.entities.player.items.base.ItemID;
import com.dodgydavid.kaos.main.Game;

public class GoldOre1Item extends Item<GoldOre1Item> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7742742984114504950L;

	public GoldOre1Item(int count, ItemID id, BufferedImage image) {
		
		super(count, id, image);
		
		
	}

	@Override
	public GoldOre1Item cloneType() {
		return new GoldOre1Item(this.count, this.id, this.image);
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
																ObjectType.GOLD_ORE_1,
																Game.OBJECT_TEXTRA_ALICE.getImageFrom(240, 0, 16, 16)
															));
		
		for (int i = 0; i < 10; i++) {
			
			float[] pos = Game.getRandomItemPos();
			
			Game.PLAYER.setX(pos[0]);
			Game.PLAYER.setY(pos[1]);
			
		}
		
	}

}
