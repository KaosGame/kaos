package com.dodgydavid.kaos.entities.player.items.potions;

import java.awt.image.BufferedImage;

import com.dodgydavid.kaos.effects.base.Effect;
import com.dodgydavid.kaos.effects.base.EffectID;
import com.dodgydavid.kaos.entities.player.items.base.ItemID;
import com.dodgydavid.kaos.entities.player.items.potions.base.PotionItem;

public class SwimmingEffect1PotionItem extends PotionItem<SwimmingEffect1PotionItem> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5108085584934370550L;

	public SwimmingEffect1PotionItem(int count, Effect e) {
		super(count, ItemID.SWIMMING_EFFECT_1, EffectID.SWIMMING_1, e);
		
		
	}

	private SwimmingEffect1PotionItem(int count, ItemID id, BufferedImage image,
			PotionItem<SwimmingEffect1PotionItem>.EffectDataClass effectDataClass) {
		super(count, id, image, effectDataClass);
	}

	@Override
	public SwimmingEffect1PotionItem cloneType() {
		return new SwimmingEffect1PotionItem(this.count, this.id, this.image, this.effectDataClass);
	}

}
