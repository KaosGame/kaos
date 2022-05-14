package com.game.particles.images;

public interface ImageParticleInterfacer {
	
	public abstract void generateParticle(double x, double y, int width, int height,
			Runnable onEnd, Runnable onUpdate, ParticleImages particleImageType);

}
