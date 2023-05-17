package com.dodgydavid.kaos.effects;

import com.dodgydavid.kaos.annotations.Empty;
import com.dodgydavid.kaos.effects.base.Effect;
import com.dodgydavid.kaos.effects.base.EffectID;
import com.dodgydavid.kaos.main.Game;
import com.dodgydavid.kaos.random.RandomChance;

public class FastGenerationEffect1 extends Effect {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4285855575586918880L;

	public FastGenerationEffect1(int level, long time) {
		super(level, EffectID.FAST_REGENERATION_1, time);
		
		
	}
	
	@Empty
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
	
	@Empty
	@Override
	public void onEnd() {
		
		
		
	}

}
