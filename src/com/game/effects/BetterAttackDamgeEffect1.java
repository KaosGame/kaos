package com.game.effects;

import com.game.annotations.Empty;
import com.game.effects.base.Effect;
import com.game.effects.base.EffectID;
import com.game.main.Game;

public class BetterAttackDamgeEffect1 extends Effect {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8500308543451342522L;

	public BetterAttackDamgeEffect1(int level, long time) {
		super(level, EffectID.ATTACK_1, time);
		
		
	}
	
	private float calculateDamage() {
		
		float damage = (0.25f * (float) this.level);
		
		return damage;
		
	}
	
	
	@Override
	public void onStart() {
		
		float temp = Game.getCurrentPlayer().getMoreDamage();
		
		temp += this.calculateDamage();
		
		Game.getCurrentPlayer().setMoreDamage(temp);
		
	}
	
	@Empty
	@Override
	public void onUpdate() {
		
		
	}
	
	@Override
	public void onEnd() {
		
		this.resetDamage();
		
	}
	
	private void resetDamage() {
		
		float temp = this.getPlayer().getMoreDamage();
		
		temp -= this.calculateDamage();
		
		this.getPlayer().setMoreDamage(temp);
		
	}

}
