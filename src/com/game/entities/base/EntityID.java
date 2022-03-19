package com.game.entities.base;

public enum EntityID {
	
	PLAYER(false),
	ITEM(true),
	VILAGER(false),
	BIRD(true),
	ITEM_PLANE(true),
	ITEM_PLANE_FALLING_CHEST(true);
	
	private final boolean CAN_DELETE;
	
	private EntityID(final boolean CAN_DELETE) {
		
		this.CAN_DELETE = CAN_DELETE;
		
	}
	
	public boolean canDelete() {
		
		return this.CAN_DELETE;
		
	}

}
