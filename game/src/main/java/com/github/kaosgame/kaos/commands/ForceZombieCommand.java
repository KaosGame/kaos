package com.github.kaosgame.kaos.commands;

import com.github.kaosgame.kaos.commands.base.CommandBase;
import com.github.kaosgame.kaos.entities.bad.zombie.ZombieEntity;

public class ForceZombieCommand implements CommandBase {

	@Override
	public void run(String commandText) {
		
		ZombieEntity z = new ZombieEntity();
		
		z.spawn();
		
	}

}
