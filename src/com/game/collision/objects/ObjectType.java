package com.game.collision.objects;

public enum ObjectType {
	
	OBJECT(false);
	
	private final boolean TRANSPARENT;
	
	private ObjectType(final boolean TRANSPARENT) {
		
		this.TRANSPARENT = TRANSPARENT;
		
	}
	
	public boolean isTRANSPARENT() {
		
		return this.TRANSPARENT;
		
	}

}
