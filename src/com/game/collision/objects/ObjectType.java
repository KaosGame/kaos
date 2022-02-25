package com.game.collision.objects;

public enum ObjectType {
	
	OBJECT(false),
	WOOD_1(true),
	WALL(false),
	CHANGE_MAP(true);
	
	private final boolean TRANSPARENT;
	
	private ObjectType(final boolean TRANSPARENT) {
		
		this.TRANSPARENT = TRANSPARENT;
		
	}
	
	public boolean isTRANSPARENT() {
		
		return this.TRANSPARENT;
		
	}

}
