package com.dodgydavid.kaos.particles.images;

import java.util.Random;

import com.dodgydavid.kaos.main.Game;

public enum ImageParticleTypes {
	
	FALL_1((double x, double y, int width, int height,
			Runnable onEnd, Runnable onUpdate, ParticleImages particleImageType) -> {
		
		final long time = 180;
		
		final double xv = 0.356;
		final double yv = 0.23116;
		
		Random random = new Random();
		
		Game.MAP_HANDLER().currentMap().getParticleList().add(new ImageParticle(x, y, xv, yv, width, height, time, onEnd, onUpdate, particleImageType));
		
		for (int i = 0; i < (int) (random.nextInt(6) + 1); i++) {
			
			Game.MAP_HANDLER().currentMap().getParticleList()
			.add(new ImageParticle((double) (x + (double) (random.nextInt(16) + 1)),
					(double) (y + (double) (random.nextInt(16) + 1)), xv, yv, width, height, time, onEnd,
					onUpdate, particleImageType));
			
		}
		
		
	});
	
	private final ImageParticleInterfacer MAKE;

	private ImageParticleTypes(final ImageParticleInterfacer MAKE) {
		this.MAKE = MAKE;
	}

	public ImageParticleInterfacer getMAKE() {
		return this.MAKE;
	}
	
	public void make(double x, double y, int width, int height,
			Runnable onEnd, Runnable onUpdate, ParticleImages particleImageType) {
		
		this.MAKE.generateParticle(x, y, width, height, onEnd, onUpdate, particleImageType);
		
	}

}
