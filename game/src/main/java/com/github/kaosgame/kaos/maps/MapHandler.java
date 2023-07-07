package com.github.kaosgame.kaos.maps;

import java.io.Serializable;
import java.util.LinkedList;

import com.github.kaosgame.kaos.main.CloneableType;

public class MapHandler implements Serializable, CloneableType<MapHandler> {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -2582107661902420758L;
	
	public static final int MAX_ENTITIES = 1024;
	public static final int MAX_OBJECTS = 1024;
	public static final int MAX_PARTICLES = 2048;

	public int CURRENT_MAP_ID;
	
	private LinkedList<Map> maps;
	
	public void addMap(Map m) {
		
		this.maps.add(m);
		
	}
	
	
	public MapHandler() {
		
		this.CURRENT_MAP_ID = 0;
		this.maps = new LinkedList<Map>();
		
	}
	
	private MapHandler(int CURRENT_MAP_ID, LinkedList<Map> maps) {
		
		super();
		
		this.CURRENT_MAP_ID = CURRENT_MAP_ID;
		this.maps = maps;
		
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

	@Override
	public MapHandler cloneType() {
		return new MapHandler(this.CURRENT_MAP_ID, this.maps);
	}

}
