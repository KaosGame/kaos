package com.game.effects;

import com.game.effects.base.Effect;
import com.game.effects.base.EffectID;
import com.game.main.Game;
import com.game.random.RandomChance;

public class FastGenerationEffect1 extends Effect {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4285855575586918880L;

	public FastGenerationEffect1(int level, long time) {
		super(level, EffectID.FAST_REGENERATION_1, time);
		
		
	}
	
	@Override
	public void onStart() {
		
		
		
	}

	@Override
	public void onUpdate() {
		
		float health = (float) (0.25f * this.level);
		
		RandomChance chance = new RandomChance();
		
		if (chance.firstChoose(0.50) && chance.firstChoose(0.34)) {
			
			Game.PLAYER.addHealth(health);
			
		}
		
		
	}

	@Override
	public void onEnd() {
		
		
		
	}

}
