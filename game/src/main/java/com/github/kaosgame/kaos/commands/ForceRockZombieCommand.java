package com.github.kaosgame.kaos.commands;

import com.github.kaosgame.kaos.commands.base.CommandBase;
import com.github.kaosgame.kaos.entities.bad.zombie.rock.RockZombieEntity;

public class ForceRockZombieCommand implements CommandBase {

	@Override
	public void run(String commandText) {
		
		RockZombieEntity z = new RockZombieEntity();
		
		z.spawn();
		
	}

}
