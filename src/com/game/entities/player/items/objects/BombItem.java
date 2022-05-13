package com.game.entities.player.items.objects;

import com.game.entities.BombEntity;
import com.game.entities.player.items.base.Item;
import com.game.entities.player.items.base.ItemID;
import com.game.main.Game;

public class BombItem extends Item<BombItem> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1353112773095750661L;

	public BombItem(int count) {
		super(count, ItemID.BOMB, Game.BOMB_TEXTRA_ALICE.getImageFrom(0, 0, 16, 16));
		
		
	}

	@Override
	public BombItem cloneType() {
		return new BombItem(this.count);
	}

	@Override
	public void use() {
		
		this.count--;
		
		if (this.count <= 0) Game.PLAYER.getHotbar().list[Game.PLAYER.getHotbar().currentItemIndex] = null;
		
		Game.MAP_HANDLER().currentMap().getEntityHandler().add(new BombEntity(Game.PLAYER.getX(), Game.PLAYER.getY(), 64, 64));
		
	}

}
