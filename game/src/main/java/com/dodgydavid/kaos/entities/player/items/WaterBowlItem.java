package com.dodgydavid.kaos.entities.player.items;

import com.dodgydavid.kaos.collision.objects.WaterTransparentCollisionObject;
import com.dodgydavid.kaos.collision.objects.base.ObjectType;
import com.dodgydavid.kaos.entities.player.items.base.Item;
import com.dodgydavid.kaos.entities.player.items.base.ItemID;
import com.dodgydavid.kaos.main.Game;

public class WaterBowlItem extends Item<WaterBowlItem> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5363199645881450914L;

	public WaterBowlItem(int count) {
		super(count, ItemID.WATER_BOWL, Game.ITEM_TEXTRA_ALICE.getImageFrom(96, 16, 16, 16));
		
		
	}

	@Override
	public WaterBowlItem cloneType() {
		return new WaterBowlItem(this.count);
	}

	@Override
	public void use() {
		
		this.count--;
		
		if (this.count <= 0) Game.PLAYER.getHotbar().list[Game.PLAYER.getHotbar().currentItemIndex] = null;
		
		WaterTransparentCollisionObject water = new WaterTransparentCollisionObject((int) Game.PLAYER.getX(),
				(int) Game.PLAYER.getY(), 64, 64, ObjectType.WATER,
				Game.OBJECT_TEXTRA_ALICE.getImageFrom(272, 0, 16, 16));
		
		Game.MAP_HANDLER().currentMap().addObject(water);
		
		Game.addItemOrItemEntity(new BowlItem(1, ItemID.BOWL_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(336, 0, 16, 16)));
		
	}

}
