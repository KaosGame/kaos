package com.game.maps;

import java.util.LinkedList;

public class MapHandler {
	
	public int CURRENT_MAP_ID = 0;
	
	private LinkedList<Map> maps = new LinkedList<Map>();
	
	public void addMap(Map m) {
		
		this.maps.add(m);
		
	}
	
	public LinkedList<Map> getMAPS() {
		
		return this.maps;
		
	}
	
	public Map currentMap() throws IndexOutOfBoundsException {
		
		return this.maps.get(this.CURRENT_MAP_ID);
		
	}
	
	public Map get(int index) {
		
		return this.maps.get(index);
		
	}

}
