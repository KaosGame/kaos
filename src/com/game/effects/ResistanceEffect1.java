package com.game.effects;

import com.game.annotations.Empty;
import com.game.effects.base.Effect;
import com.game.effects.base.EffectID;

public class ResistanceEffect1 extends Effect {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2159874974571244264L;

	public ResistanceEffect1(int level, long time) {
		super(level, EffectID.RESISTANCE_1, time);
		
		
	}
	
	private float calculateDamage() {
		
		float damage = (0.25f * (float) this.level);
		
		return damage;
		
	}
	
	@Empty
	@Override
	public void onStart() {
		
		
		
	}
	
	@Override
	public void onUpdate() {
		
		this.resetDamage();
		
		float temp = this.getPlayer().getMoreDefence();
		
		temp += this.calculateDamage();
		
		this.getPlayer().setMoreDefence(temp);
		
	}

	@Override
	public void onEnd() {
		
		this.resetDamage();
		
	}
	
	private void resetDamage() {
		
		float temp = this.getPlayer().getMoreDefence();
		
		temp -= this.calculateDamage();
		
		this.getPlayer().setMoreDefence(temp);
		
	}

}
