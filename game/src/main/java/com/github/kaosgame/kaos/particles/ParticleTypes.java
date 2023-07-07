package com.github.kaosgame.kaos.particles;

import java.awt.Color;
import java.util.Random;

import com.github.kaosgame.kaos.main.Game;

public enum ParticleTypes {
	
	FALL_1((double x, double y, int width, int height, Color color,
			Runnable onEnd, Runnable onUpdate) -> {
		
		final long time = 60;
		
		final double xv = 0.356;
		final double yv = 0.23116;
		
		Particle p = new Particle(x, y, xv, yv, width, height, color, time, onEnd, onUpdate);
		
		Game.MAP_HANDLER().currentMap().getParticleList().add(p);
		
	}),
	
	FALL_2((double x, double y, int width, int height, Color color,
			Runnable onEnd, Runnable onUpdate) -> {
		
		final long time = 60;
		
		final double xv = 0.356;
		final double yv = 0.23116;
		
		Random random = new Random();
		
		Game.MAP_HANDLER().currentMap().getParticleList().add(new Particle(x, y, xv, yv, width, height, color, time, onEnd, onUpdate));
		Game.MAP_HANDLER().currentMap().getParticleList()
		.add(new Particle((double) (x + (double) (random.nextInt(16) + 1)),
				(double) (y + (double) (random.nextInt(16) + 1)), xv, yv, width, height, color, time, onEnd,
				onUpdate));
		
		
	}),
	
	FALL_3((double x, double y, int width, int height, Color color,
			Runnable onEnd, Runnable onUpdate) -> {
		
		final long time = 60;
		
		final double xv = 0.356;
		final double yv = 0.23116;
		
		Random random = new Random();
		
		Game.MAP_HANDLER().currentMap().getParticleList().add(new Particle(x, y, xv, yv, width, height, color, time, onEnd, onUpdate));
		
		for (int i = 0; i < (int) (random.nextInt(6) + 1); i++) {
			
			Game.MAP_HANDLER().currentMap().getParticleList()
			.add(new Particle((double) (x + (double) (random.nextInt(16) + 1)),
					(double) (y + (double) (random.nextInt(16) + 1)), xv, yv, width, height, color, time, onEnd,
					onUpdate));
			
		}
		
		
	});
	
	private final ParticleInterfacer MAKE;

	private ParticleTypes(final ParticleInterfacer MAKE) {
		this.MAKE = MAKE;
	}

	public ParticleInterfacer getMAKE() {
		return this.MAKE;
	}
	
	public void make(double x, double y, int width, int height, Color color,
			Runnable onEnd, Runnable onUpdate) {
		
		this.MAKE.generateParticle(x, y, width, height, color, onEnd, onUpdate);
		
	}

}
