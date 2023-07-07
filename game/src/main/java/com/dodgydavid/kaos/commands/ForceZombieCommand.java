package com.dodgydavid.kaos.commands;

import com.dodgydavid.kaos.commands.base.CommandBase;
import com.dodgydavid.kaos.entities.bad.zombie.ZombieEntity;

public class ForceZombieCommand implements CommandBase {

	@Override
	public void run(String commandText) {
		
		ZombieEntity z = new ZombieEntity();
		
		z.spawn();
		
	}

}
