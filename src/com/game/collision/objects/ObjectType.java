package com.game.collision.objects;

public enum ObjectType {
	
	OBJECT(false),
	WOOD_1(true),
	WALL(false),
	NEXT_MAP(false),
	LAST_MAP(false),
	SIGN_1(true),
	TREE_1(true),
	APPLE_TREE_1(true),
	HOUSE_1(true),
	CHEST(true);
	
	private final boolean TRANSPARENT;
	
	private ObjectType(final boolean TRANSPARENT) {
		
		this.TRANSPARENT = TRANSPARENT;
		
	}
	
	public boolean isTRANSPARENT() {
		
		return this.TRANSPARENT;
		
	}

}
