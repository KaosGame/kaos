package com.dodgydavid.kaos.entities.player.items.dimension.teleporters;

import java.awt.image.BufferedImage;

import com.dodgydavid.kaos.entities.player.items.base.Item;
import com.dodgydavid.kaos.entities.player.items.base.ItemID;
import com.dodgydavid.kaos.logging.LogType;
import com.dodgydavid.kaos.main.Game;
import com.dodgydavid.kaos.maps.DimensionID;

public class FishLandDimensionTeleporterItem extends Item<FishLandDimensionTeleporterItem> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8695269329841482429L;

	public FishLandDimensionTeleporterItem(int count, ItemID id, BufferedImage image) {
		super(count, id, image);
		
		
	}

	@Override
	public FishLandDimensionTeleporterItem cloneType() {
		return new FishLandDimensionTeleporterItem(this.count, this.id, this.image);
	}

	@Override
	public void use() {
		
		switch (Game.DIMENSION_HANDLER.getCURRENT_DIMENSION_ID()) {
		
			case HOME:
				Game.DIMENSION_HANDLER.setCURRENT_DIMENSION_ID(DimensionID.FISH_LAND);
				Game.resetPlayerPosToCenter();
				Game.logln("Set dimension to FISH_LAND", LogType.SUCCESS);
				break;
				
			case FISH_LAND:
				Game.DIMENSION_HANDLER.setCURRENT_DIMENSION_ID(DimensionID.HOME);
				Game.resetPlayerPosToCenter();
				Game.logln("Set dimension to HOME", LogType.SUCCESS);
				break;
				
			default:
				break;
		
		}
		
	}

}
