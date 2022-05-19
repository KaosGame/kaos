package com.game.war;

import java.util.Random;

import com.game.main.Game;
import com.game.spawning.base.Spawnable;

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
				random.nextBoolean() && !random.nextBoolean() && random.nextBoolean() && !random.nextBoolean() && random.nextBoolean() && !random.nextBoolean()
			) {
			
			this.spawn();
			
		}
		
	}

}
