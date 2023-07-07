package com.github.kaosgame.kaos.effects;

import com.github.kaosgame.kaos.effects.base.Effect;
import com.github.kaosgame.kaos.effects.base.EffectID;

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
	

	@Override
	public void onStart() {
		
		float temp = this.getPlayer().getMoreDefence();
		
		temp += this.calculateDamage();
		
		this.getPlayer().setMoreDefence(temp);
		
	}
	
	@Override
	public void onUpdate() {
		
		
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
