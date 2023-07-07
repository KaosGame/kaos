package com.github.kaosgame.kaos.entities.base;

public enum EntityID {
	
	PLAYER(false, false),
	ITEM(true, true),
	VILAGER(false, false),
	BIRD(true, true),
	ITEM_PLANE(true, true),
	ITEM_PLANE_FALLING_CHEST(true, true),
	ZOMBIE(true, true),
	ROCK_ZOMBIE(true, true),
	ROCK_ZOMBIE_ROCK(true, true),
	PLAYER_BOW_BULLET(true, true),
	AXOLOTL(true, true),
	BOMB(true, true),
	WAR_ZOMBIE(true, true),
	MONSTER_LEATH(true, true),
	MONSTER_LEATH_LEATH(true, true),
	ISAWAWABUB(true, true),
	KITTNASOURS(true, true),
	CAT(true, true),
	CATACHILLER(true, true);

	private final boolean CAN_DELETE;
	private final boolean CAN_MOVE;
	
	private EntityID(final boolean CAN_DELETE, final boolean CAN_MOVE) {
		
		this.CAN_DELETE = CAN_DELETE;
		this.CAN_MOVE = CAN_MOVE;
		
	}
	
	public boolean canDelete() {
		
		return this.CAN_DELETE;
		
	}
	
	public boolean canMove() {
		
		return this.CAN_MOVE;
		
	}

}
