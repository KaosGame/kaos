package com.game.spawning.base;

import java.util.ArrayList;

public class Spawner {
	
	private static ArrayList<Spawnable> LIST_HOME = new ArrayList<Spawnable>();
	
	public static void addHome(Spawnable s) {
		
		Spawner.LIST_HOME.add(s);
		
	}
	
	public static void removeHome(Spawnable s) {
		
		Spawner.LIST_HOME.remove(s);
		
	}
	
	public static Spawnable getHome(int index) {
		
		return Spawner.LIST_HOME.get(index);
		
	}
	
	public static ArrayList<Spawnable> getLIST_HOME() {
		
		return Spawner.LIST_HOME;
		
	}
	
	public static void spwanHome() {
		
		for (int i = 0; i < Spawner.LIST_HOME.size(); i++) {
			
			Spawnable s = Spawner.LIST_HOME.get(i);
			
			s.randomSpawn();
			
		}
		
	}

}
