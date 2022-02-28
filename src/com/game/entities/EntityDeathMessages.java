package com.game.entities;

public enum EntityDeathMessages {
	
	STARVING("You starved to death!");
	
	
	private final String MESSAGE;
	
	private EntityDeathMessages(final String MESSAGE) {
		
		this.MESSAGE = MESSAGE;
		
	}
	
	public String getDeathMessage() {
		
		return this.MESSAGE;
		
	}

}
