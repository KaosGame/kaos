package com.game.spawning.base;

import java.util.ArrayList;

public class Spawner {
	
	private static ArrayList<Spawnable> LIST = new ArrayList<Spawnable>();
	
	public static void add(Spawnable s) {
		
		Spawner.LIST.add(s);
		
	}
	
	public static void remove(Spawnable s) {
		
		Spawner.LIST.remove(s);
		
	}
	
	public static Spawnable get(int index) {
		
		return Spawner.LIST.get(index);
		
	}
	
	public static ArrayList<Spawnable> getList() {
		
		return Spawner.LIST;
		
	}
	
	public static void spwan() {
		
		for (int i = 0; i < Spawner.LIST.size(); i++) {
			
			Spawnable s = Spawner.LIST.get(i);
			
			s.randomSpawn();
			
		}
		
	}

}
