package com.dodgydavid.kaos.entities.player.items.tools;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

import com.dodgydavid.kaos.collision.objects.base.CollisionObject;
import com.dodgydavid.kaos.collision.objects.base.ObjectType;
import com.dodgydavid.kaos.entities.player.items.base.Item;
import com.dodgydavid.kaos.entities.player.items.base.ItemID;
import com.dodgydavid.kaos.loot.tables.handler.LootTableHandler;
import com.dodgydavid.kaos.main.Game;
import com.dodgydavid.kaos.sound.Sounds;

public class FishingRodItem extends Item<FishingRodItem> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6103992296614837706L;

	public FishingRodItem(int count, ItemID id, BufferedImage image) {
		super(count, id, image);
		
		
	}

	@Override
	public FishingRodItem cloneType() {
		return new FishingRodItem(this.count, this.id, this.image);
	}

	@Override
	public void use() {

		LinkedList<CollisionObject> tempObjList = Game.MAP_HANDLER().currentMap().getObjectList();
		
		for (int i = 0; i < tempObjList.size(); i++) {
			
			CollisionObject tempObject = tempObjList.get(i);
			
			Rectangle objectHitbox = Game.getRectangle((int) (tempObject.getX() - 20), (int) (tempObject.getY() - 20),
					(int) (tempObject.getWidth() + 40), (int) (tempObject.getHeight() + 40));
			
			if (tempObject.getType() == ObjectType.WATER && Game.PLAYER.getRectangle().intersects(objectHitbox) && Math.random() < 0.50) {
				
				Item<?> item = LootTableHandler.returnRandomLootItemForFishingRodItem();
				
				Game.addItemOrItemEntity(item);
				
				Game.ANY_VOLUME_SOUNDS.setSound(Sounds.POP);
				Game.ANY_VOLUME_SOUNDS.setVolumeScale(1);
				Game.ANY_VOLUME_SOUNDS.play();
				Game.ANY_VOLUME_SOUNDS.setVolumeScale(3);
				
				
			}
			
		}
		
	}

}
