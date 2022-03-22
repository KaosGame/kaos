package com.game.entities.base;

import com.game.main.Game;

public enum EntityDeathMessages {
	
	STARVING("You starved to death with the score of %d!"),
	COMMAND("You have died to a command with the score of %d!"),
	RED_MUSHROOM("You were poisoned by a red mushroom you died you the score of %d!");
	
	
	private final String MESSAGE;
	
	private EntityDeathMessages(final String MESSAGE) {
		
		this.MESSAGE = MESSAGE;
		
	}
	
	public String getDeathMessage() {
		
		long deathScore = Game.PLAYER.getCoins();
		
		String text = String.format(this.MESSAGE, deathScore);
		
		return text;
		
	}
	
	public String getTrueText() {
		
		return this.MESSAGE;
		
	}

}
