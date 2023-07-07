package com.github.kaosgame.kaos.entities.player.items;

import com.github.kaosgame.kaos.collision.objects.LavaTransparentCollisionObject;
import com.github.kaosgame.kaos.collision.objects.base.ObjectType;
import com.github.kaosgame.kaos.entities.player.items.base.Item;
import com.github.kaosgame.kaos.entities.player.items.base.ItemID;
import com.github.kaosgame.kaos.main.Game;

public class LavaBowlItem extends Item<LavaBowlItem> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6086634405786729823L;

	public LavaBowlItem(int count) {
		super(count, ItemID.LAVA_BOWL, Game.ITEM_TEXTRA_ALICE.getImageFrom(80, 16, 16, 16));
		
	}

	@Override
	public LavaBowlItem cloneType() {
		return new LavaBowlItem(this.count);
	}

	@Override
	public void use() {
		
		this.count--;
		
		if (this.count <= 0) Game.PLAYER.getHotbar().list[Game.PLAYER.getHotbar().currentItemIndex] = null;
		
		LavaTransparentCollisionObject lava = new LavaTransparentCollisionObject((int) Game.PLAYER.getX(),
				(int) Game.PLAYER.getY(), 64, 64, ObjectType.LAVA,
				Game.OBJECT_TEXTRA_ALICE.getImageFrom(288, 0, 16, 16));
		
		Game.MAP_HANDLER().currentMap().addObject(lava);
		
		Game.addItemOrItemEntity(new BowlItem(1, ItemID.BOWL_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(336, 0, 16, 16)));
		
		for (int i = 0; i < 10; i++) {
			
			float[] pos = Game.getRandomItemPos();
			
			Game.PLAYER.setX(pos[0]);
			Game.PLAYER.setY(pos[1]);
			
		}
		
	}

}
