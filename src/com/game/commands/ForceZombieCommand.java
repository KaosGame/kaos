package com.game.commands;

import com.game.commands.base.CommandBase;
import com.game.entities.bad.zombie.ZombieEntity;

public class ForceZombieCommand implements CommandBase {

	@Override
	public void run(String commandText) {
		
		ZombieEntity z = new ZombieEntity();
		
		z.spawn();
		
	}

}
