package com.game.effects;

import com.game.annotations.Empty;
import com.game.effects.base.Effect;
import com.game.effects.base.EffectID;
import com.game.entities.base.EntityDeathMessages;
import com.game.main.Game;
import com.game.random.RandomChance;

public class PoisonEffect1 extends Effect {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5797993012214267785L;

	public PoisonEffect1(int level, long time) {
		super(level, EffectID.POISON_1, time);
		
		
	}
	
	@Empty
	@Override
	public void onStart() {

		
		
		
	}

	@Override
	public void onUpdate() {
		
		float damage = (float) (0.25f * this.level);
		
		RandomChance chance = new RandomChance();
		
		if (chance.firstChoose(0.50) && chance.firstChoose(0.34)) {
			
			Game.PLAYER.damage(damage, EntityDeathMessages.POISON_EFFECT_1);
			
		}
		
		
	}
	
	@Empty
	@Override
	public void onEnd() {
		
		
		
	}

}
