package com.game.entities.player.items;

import java.awt.image.BufferedImage;
import java.util.LinkedList;

import com.game.collision.objects.LavaTransparentCollisionObject;
import com.game.collision.objects.WaterTransparentCollisionObject;
import com.game.collision.objects.base.CollisionObject;
import com.game.collision.objects.base.ObjectType;
import com.game.entities.player.items.base.Item;
import com.game.entities.player.items.base.ItemID;
import com.game.main.Game;

public class BowlItem extends Item<BowlItem> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1994103458522697542L;

	public BowlItem(int count, ItemID id, BufferedImage image) {
		
		super(count, id, image);
		
		
	}

	@Override
	public BowlItem cloneType() {
		return new BowlItem(this.count, this.id, this.image);
	}
	
	@Override
	public void use() {
		
		LinkedList<CollisionObject> objList = Game.MAP_HANDLER().currentMap().getObjectList();
		
		for (int i = 0; i < objList.size(); i++) {
			
			CollisionObject o = objList.get(i);
			
			if (o instanceof WaterTransparentCollisionObject && o.getType() == ObjectType.WATER
					&& Game.PLAYER.getRectangle().intersects(o.getRectangle())) {
				
				this.count--;
				
				if (this.count <= 0) Game.PLAYER.getHotbar().list[Game.PLAYER.getHotbar().currentItemIndex] = null;
				
				Game.addItemOrItemEntity(new WaterBowlItem(1));
				
				Game.MAP_HANDLER().currentMap().removeObject(o);
				
			} else if (o instanceof LavaTransparentCollisionObject && o.getType() == ObjectType.LAVA
					&& Game.PLAYER.getRectangle().intersects(o.getRectangle())) {
				
				this.count--;
				
				if (this.count <= 0) Game.PLAYER.getHotbar().list[Game.PLAYER.getHotbar().currentItemIndex] = null;
				
				Game.addItemOrItemEntity(new LavaBowlItem(1));
				
				Game.MAP_HANDLER().currentMap().removeObject(o);
				
			}
			
		}
		
	}

}
