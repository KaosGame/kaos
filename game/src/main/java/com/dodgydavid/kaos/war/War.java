package com.dodgydavid.kaos.war;

import java.util.Random;

import com.dodgydavid.kaos.main.Game;
import com.dodgydavid.kaos.spawning.base.Spawnable;

public class War implements Spawnable {

	@Override
	public void spawn() {
		
		Game.startWar();
		
	}
	
	@Override
	public void randomSpawn() {
		
		Random random = new Random();
		
		if (
				random.nextBoolean() && !random.nextBoolean() && random.nextBoolean() && !random.nextBoolean() && random.nextBoolean() && !random.nextBoolean() &&
				random.nextBoolean() && !random.nextBoolean() && random.nextBoolean() && !random.nextBoolean() && random.nextBoolean() && !random.nextBoolean() &&
				random.nextBoolean() && !random.nextBoolean() && random.nextBoolean() && !random.nextBoolean() && random.nextBoolean() && !random.nextBoolean() &&
				random.nextBoolean() && !random.nextBoolean() && random.nextBoolean() && !random.nextBoolean() && random.nextBoolean() && !random.nextBoolean()
			) {
			
			this.spawn();
			
		}
		
	}

}
