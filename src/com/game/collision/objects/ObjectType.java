package com.game.collision.objects;

public enum ObjectType {
	
	OBJECT(false),
	WOOD_1(true),
	WALL(false),
	CHANGE_MAP(true),
	SIGN_1(true),
	TREE_1(true),
	APPLE_TREE_1(true),
	HOUSE_1(false);
	
	private final boolean TRANSPARENT;
	
	private ObjectType(final boolean TRANSPARENT) {
		
		this.TRANSPARENT = TRANSPARENT;
		
	}
	
	public boolean isTRANSPARENT() {
		
		return this.TRANSPARENT;
		
	}

}
