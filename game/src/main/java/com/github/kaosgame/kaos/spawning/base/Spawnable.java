package com.github.kaosgame.kaos.spawning.base;

import java.util.Random;

public interface Spawnable {
	
	public abstract void spawn();
	
	public default void randomSpawn() {
		
		Random random = new Random();
		
		if (
				random.nextBoolean() && !random.nextBoolean() && random.nextBoolean() && !random.nextBoolean() && random.nextBoolean() && !random.nextBoolean() &&
				random.nextBoolean() && !random.nextBoolean() && Math.random() < 0.50 && random.nextBoolean() && !random.nextBoolean() && random.nextBoolean() &&
				!random.nextBoolean() && random.nextBoolean() && !random.nextBoolean() && random.nextBoolean() && !random.nextBoolean() && Math.random() < 0.50
			) {
			
			this.spawn();
			
		}
		
	}

}
