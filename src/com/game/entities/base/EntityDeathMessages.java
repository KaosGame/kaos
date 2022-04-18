package com.game.entities.base;

import com.game.main.Game;

public enum EntityDeathMessages {
	
	STARVING("You starved to death with the score of %d!"),
	COMMAND("You have died to a command with the score of %d!"),
	RED_MUSHROOM("You were poisoned by a red mushroom you died you the score of %d!"),
	WATER_DROWNED("You drowned under water and died with the score of %d!"),
	WATER_FALL("You fell into a pond and died with the score of %d!"),
	LAVA("You fell into lava and died with the score of %d!"),
	ZOMBIE("You died to a zombie with the score of %d!"),
	ROCK_ZOMBIE_ROCK("You got shot by a rock zombie and died with the score of %d!"),
	PLAYER_BOW_STANDARD_BULLET("You got shot by a player and died with the score of %d!");
	
	
	private final String MESSAGE;
	
	private EntityDeathMessages(final String MESSAGE) {
		
		this.MESSAGE = MESSAGE;
		
	}
	
	public String getDeathMessage() {
		
		String text = String.format(this.MESSAGE, EntityDeathMessages.getPlayerScore());
		
		return text;
		
	}
	
	public String getTrueText() {
		
		return this.MESSAGE;
		
	}
	
	public static long getPlayerScore() {
		
		long deathScore = (long) (Game.PLAYER.getCoins() + (long) (Game.PLAYER.getAttack() + Game.PLAYER.getDefence()));
		
		return deathScore;
		
	}

}
