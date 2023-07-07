package com.github.kaosgame.kaos.particles;

import java.awt.Color;

public interface ParticleInterfacer {
	
	public abstract void generateParticle(double x, double y, int width, int height, Color color,
			Runnable onEnd, Runnable onUpdate);

}
