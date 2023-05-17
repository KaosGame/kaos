package com.dodgydavid.kaos.entities.player.items.objects;

import java.awt.image.BufferedImage;

import com.dodgydavid.kaos.collision.objects.PlayerObject;
import com.dodgydavid.kaos.collision.objects.base.ObjectType;
import com.dodgydavid.kaos.entities.player.items.base.Item;
import com.dodgydavid.kaos.entities.player.items.base.ItemID;
import com.dodgydavid.kaos.main.Game;

public class Stone1Item extends Item<Stone1Item> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4542388992343664699L;

	public Stone1Item(int count, ItemID id, BufferedImage image) {
		
		super(count, id, image);
		
		
	}

	@Override
	public Stone1Item cloneType() {
		return new Stone1Item(this.count, this.id, this.image);
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
																ObjectType.STONE_1,
																Game.OBJECT_TEXTRA_ALICE.getImageFrom(208, 0, 16, 16)
															));
		
		for (int i = 0; i < 10; i++) {
			
			float[] pos = Game.getRandomItemPos();
			
			Game.PLAYER.setX(pos[0]);
			Game.PLAYER.setY(pos[1]);
			
		}
		
	}

}
