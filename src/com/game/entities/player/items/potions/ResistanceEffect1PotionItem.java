package com.game.entities.player.items.potions;

import java.awt.image.BufferedImage;

import com.game.effects.base.Effect;
import com.game.effects.base.EffectID;
import com.game.entities.player.items.base.ItemID;
import com.game.entities.player.items.potions.base.PotionItem;

public class ResistanceEffect1PotionItem extends PotionItem<ResistanceEffect1PotionItem> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5108085584934370550L;

	public ResistanceEffect1PotionItem(int count, Effect e) {
		super(count, ItemID.RESISTANCE_EFFECT_1, EffectID.RESISTANCE_1, e);
		
		
	}

	private ResistanceEffect1PotionItem(int count, ItemID id, BufferedImage image,
			PotionItem<ResistanceEffect1PotionItem>.EffectDataClass effectDataClass) {
		super(count, id, image, effectDataClass);
	}

	@Override
	public ResistanceEffect1PotionItem cloneType() {
		return new ResistanceEffect1PotionItem(this.count, this.id, this.image, this.effectDataClass);
	}

}
