package com.github.kaosgame.kaos.entities.player.items.potions;

import java.awt.image.BufferedImage;

import com.github.kaosgame.kaos.effects.base.Effect;
import com.github.kaosgame.kaos.effects.base.EffectID;
import com.github.kaosgame.kaos.entities.player.items.base.ItemID;
import com.github.kaosgame.kaos.entities.player.items.potions.base.PotionItem;

public class PosionEffect1PotionItem extends PotionItem<PosionEffect1PotionItem> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5108085584934370550L;

	public PosionEffect1PotionItem(int count, Effect e) {
		super(count, ItemID.POSION_EFFECT_1, EffectID.POISON_1, e);
		
		
	}

	private PosionEffect1PotionItem(int count, ItemID id, BufferedImage image,
			PotionItem<PosionEffect1PotionItem>.EffectDataClass effectDataClass) {
		super(count, id, image, effectDataClass);
	}

	@Override
	public PosionEffect1PotionItem cloneType() {
		return new PosionEffect1PotionItem(this.count, this.id, this.image, this.effectDataClass);
	}

}
