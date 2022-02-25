package com.game.maps;

import java.util.LinkedList;

public class MapHandler {
	
	public static int CURRENT_MAP_ID = 0;
	
	private static LinkedList<Map> MAPS = new LinkedList<Map>();
	
	public static void addMap(Map m) {
		
		MapHandler.MAPS.add(m);
		
	}
	
	public static LinkedList<Map> getMAPS() {
		
		return MapHandler.MAPS;
		
	}
	
	public static Map currentMap() {
		
		return MapHandler.MAPS.get(MapHandler.CURRENT_MAP_ID);
		
	}

}
