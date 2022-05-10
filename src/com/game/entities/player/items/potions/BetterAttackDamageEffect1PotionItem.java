package com.game.entities.player.items.potions;

import java.awt.image.BufferedImage;

import com.game.effects.base.Effect;
import com.game.effects.base.EffectID;
import com.game.entities.player.items.base.ItemID;
import com.game.entities.player.items.potions.base.PotionItem;

public class BetterAttackDamageEffect1PotionItem extends PotionItem<BetterAttackDamageEffect1PotionItem> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5108085584934370550L;

	public BetterAttackDamageEffect1PotionItem(int count, Effect e) {
		super(count, ItemID.BETTER_ATTACK_DAMAGE_EFFECT_1, EffectID.ATTACK_1, e);
		
		
	}

	private BetterAttackDamageEffect1PotionItem(int count, ItemID id, BufferedImage image,
			PotionItem<BetterAttackDamageEffect1PotionItem>.EffectDataClass effectDataClass) {
		super(count, id, image, effectDataClass);
	}

	@Override
	public BetterAttackDamageEffect1PotionItem cloneType() {
		return new BetterAttackDamageEffect1PotionItem(this.count, this.id, this.image, this.effectDataClass);
	}

}
