package com.game.entities.base;

public enum EntityID {
	
	PLAYER(false),
	ITEM(true),
	VILAGER(false),
	BIRD(true),
	ITEM_PLANE(true),
	ITEM_PLANE_FALLING_CHEST(true),
	ZOMBIE(true),
	ROCK_ZOMBIE(true),
	ROCK_ZOMBIE_ROCK(true),
	PLAYER_BOW_BULLET(true),
	AXOLOTL(true),
	BOMB(true),
	WAR_ZOMBIE(true),
	MONSTER_LEATH(true),
	MONSTER_LEATH_LEATH(true);

	private final boolean CAN_DELETE;
	
	private EntityID(final boolean CAN_DELETE) {
		
		this.CAN_DELETE = CAN_DELETE;
		
	}
	
	public boolean canDelete() {
		
		return this.CAN_DELETE;
		
	}

}
