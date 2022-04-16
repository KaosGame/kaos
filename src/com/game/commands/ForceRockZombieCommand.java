package com.game.commands;

import com.game.commands.base.CommandBase;
import com.game.entities.bad.zombie.rock.RockZombieEntity;

public class ForceRockZombieCommand implements CommandBase {

	@Override
	public void run(String commandText) {
		
		RockZombieEntity z = new RockZombieEntity();
		
		z.spawn();
		
	}

}
