package com.dodgydavid.kaos.commands;

import com.dodgydavid.kaos.commands.base.CommandBase;
import com.dodgydavid.kaos.entities.bad.zombie.rock.RockZombieEntity;

public class ForceRockZombieCommand implements CommandBase {

	@Override
	public void run(String commandText) {
		
		RockZombieEntity z = new RockZombieEntity();
		
		z.spawn();
		
	}

}
