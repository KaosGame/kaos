package com.game.entities.player.items.potions.base;

import java.awt.image.BufferedImage;

import com.game.effects.base.Effect;
import com.game.effects.base.EffectID;
import com.game.entities.player.items.base.Item;
import com.game.entities.player.items.base.ItemID;
import com.game.main.Game;

public abstract class PotionItem<CT> extends Item<CT> {

	public class EffectDataClass {
		
		private Effect effect;
		private EffectID effectID;
		
		public EffectDataClass(Effect e, EffectID ei) {
			
			this.effect = e;
			this.effectID = ei;
			
		}
		
		public Effect getEffect() {
			return effect;
		}
		public void setEffect(Effect effect) {
			this.effect = effect;
		}
		public EffectID getEffectID() {
			return effectID;
		}
		public void setEffectID(EffectID effectID) {
			this.effectID = effectID;
		}
		
		

	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1283154940668336684L;
	
	protected EffectDataClass effectDataClass;

	public PotionItem(int count, ItemID id, EffectID eid, Effect e) {
		super(count, id, eid.getImage());
		
		this.effectDataClass = this.new EffectDataClass(e, eid);
		
	}

	protected PotionItem(int count, ItemID id, BufferedImage image, PotionItem<CT>.EffectDataClass effectDataClass) {
		super(count, id, image);
		this.effectDataClass = effectDataClass;
	}


	@Override
	public void use() {
		
		this.count--;
		
		if (this.count <= 0) Game.PLAYER.getHotbar().list[Game.PLAYER.getHotbar().currentItemIndex] = null;
		
		Game.PLAYER.getEffectHandler().add(this.effectDataClass.getEffect());
		
	}

	public EffectDataClass getEffectDataClass() {
		return effectDataClass;
	}

	public void setEffectDataClass(EffectDataClass effectDataClass) {
		this.effectDataClass = effectDataClass;
	}

}
