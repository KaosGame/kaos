package com.game.particles.images;

import java.awt.image.BufferedImage;

import com.game.main.Game;

public enum ParticleImages {
	
	SMOKE_1(Game.PARTICLE_TEXTRA_ALICE.getImageFrom(0, 0, 16, 16));
	
	private final BufferedImage IMAGE;
	
	private ParticleImages(final BufferedImage IMAGE) {
		
		this.IMAGE = IMAGE;
		
	}
	
	public BufferedImage getImage() {
		
		return this.IMAGE;
		
	}

}
