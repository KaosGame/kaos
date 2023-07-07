package com.github.kaosgame.kaos.war;

import java.util.Random;

import com.github.kaosgame.kaos.main.Game;
import com.github.kaosgame.kaos.spawning.base.Spawnable;

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
