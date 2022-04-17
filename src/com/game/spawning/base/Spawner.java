package com.game.spawning.base;

import java.util.ArrayList;

import com.game.main.Game;
import com.game.maps.DimensionID;

public class Spawner {
	
	private static ArrayList<Spawnable> LIST_HOME = new ArrayList<Spawnable>();
	private static ArrayList<Spawnable> LIST_FISH_LAND = new ArrayList<Spawnable>();
	
	public static void addHome(Spawnable s) {
		
		Spawner.LIST_HOME.add(s);
		
	}
	
	public static void addFishLand(Spawnable s) {
		
		Spawner.LIST_FISH_LAND.add(s);
		
	}
	
	public static void removeHome(Spawnable s) {
		
		Spawner.LIST_HOME.remove(s);
		
	}
	
	public static void removeFishLand(Spawnable s) {
		
		Spawner.LIST_FISH_LAND.remove(s);
		
	}
	
	public static Spawnable getHome(int index) {
		
		return Spawner.LIST_HOME.get(index);
		
	}
	
	public static Spawnable getFishLand(int index) {
		
		return Spawner.LIST_FISH_LAND.get(index);
		
	}
	
	public static ArrayList<Spawnable> getLIST_HOME() {
		
		return Spawner.LIST_HOME;
		
	}
	
	public static ArrayList<Spawnable> getLIST_FISH_LAND() {
		
		return Spawner.LIST_FISH_LAND;
		
	}
	
	public static void spwan() {
		
		if (Game.DIMENSION_HANDLER.getCURRENT_DIMENSION_ID() == DimensionID.HOME) {
			
			for (int i = 0; i < Spawner.LIST_HOME.size(); i++) {
				
				Spawnable s = Spawner.LIST_HOME.get(i);
				
				s.randomSpawn();
				
			}
			
		} else if (Game.DIMENSION_HANDLER.getCURRENT_DIMENSION_ID() == DimensionID.FISH_LAND) {
			
			for (int i = 0; i < Spawner.LIST_FISH_LAND.size(); i++) {
				
				Spawnable s = Spawner.LIST_FISH_LAND.get(i);
				
				s.randomSpawn();
				
			}
			
		}
		
	}

}
