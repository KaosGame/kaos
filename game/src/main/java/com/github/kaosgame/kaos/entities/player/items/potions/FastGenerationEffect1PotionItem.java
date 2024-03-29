package com.github.kaosgame.kaos.entities.player.items.potions;

import java.awt.image.BufferedImage;

import com.github.kaosgame.kaos.effects.base.Effect;
import com.github.kaosgame.kaos.effects.base.EffectID;
import com.github.kaosgame.kaos.entities.player.items.base.ItemID;
import com.github.kaosgame.kaos.entities.player.items.potions.base.PotionItem;

public class FastGenerationEffect1PotionItem extends PotionItem<FastGenerationEffect1PotionItem> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5108085584934370550L;

	public FastGenerationEffect1PotionItem(int count, Effect e) {
		super(count, ItemID.FAST_GENERATION_EFFECT_1, EffectID.FAST_REGENERATION_1, e);
		
		
	}

	private FastGenerationEffect1PotionItem(int count, ItemID id, BufferedImage image,
			PotionItem<FastGenerationEffect1PotionItem>.EffectDataClass effectDataClass) {
		super(count, id, image, effectDataClass);
	}

	@Override
	public FastGenerationEffect1PotionItem cloneType() {
		return new FastGenerationEffect1PotionItem(this.count, this.id, this.image, this.effectDataClass);
	}

}
