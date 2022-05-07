package com.game.effects.base;

import java.awt.image.BufferedImage;

import com.game.main.Game;

public enum EffectID {
	
	
	POISON_1(Game.EFFECT_TEXTRA_ALICE.getImageFrom(0, 0, 16, 16)),
	FAST_REGENERATION_1(Game.EFFECT_TEXTRA_ALICE.getImageFrom(16, 0, 16, 16)),
	RESISTANCE_1(Game.EFFECT_TEXTRA_ALICE.getImageFrom(32, 0, 16, 16)),
	ATTACK_1(Game.EFFECT_TEXTRA_ALICE.getImageFrom(48, 0, 16, 16)),
	SWIMMING_1(Game.EFFECT_TEXTRA_ALICE.getImageFrom(64, 0, 16, 16));
	
	private final BufferedImage IMAGE;
	
	private EffectID(final BufferedImage IMAGE) {
		
		this.IMAGE = IMAGE;
		
	}
	
	public BufferedImage getImage() {
		
		return this.IMAGE;
		
	}
	

}
