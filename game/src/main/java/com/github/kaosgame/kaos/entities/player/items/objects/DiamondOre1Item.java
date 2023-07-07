package com.github.kaosgame.kaos.entities.player.items.objects;

import java.awt.image.BufferedImage;

import com.github.kaosgame.kaos.collision.objects.PlayerObject;
import com.github.kaosgame.kaos.collision.objects.base.ObjectType;
import com.github.kaosgame.kaos.entities.player.items.base.Item;
import com.github.kaosgame.kaos.entities.player.items.base.ItemID;
import com.github.kaosgame.kaos.main.Game;

public class DiamondOre1Item extends Item<DiamondOre1Item> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 548900021978890508L;

	public DiamondOre1Item(int count, ItemID id, BufferedImage image) {
		
		super(count, id, image);
		
		
	}

	@Override
	public DiamondOre1Item cloneType() {
		return new DiamondOre1Item(this.count, this.id, this.image);
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
																ObjectType.DIAMOND_ORE_1,
																Game.OBJECT_TEXTRA_ALICE.getImageFrom(256, 0, 16, 16)
															));
		
		for (int i = 0; i < 10; i++) {
			
			float[] pos = Game.getRandomItemPos();
			
			Game.PLAYER.setX(pos[0]);
			Game.PLAYER.setY(pos[1]);
			
		}
		
	}

}
