package com.game.spawning.base;

import java.util.ArrayList;

import com.game.main.Game;
import com.game.maps.DimensionID;

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
		
		if (Game.DIMENSION_HANDLER.getCURRENT_DIMENSION_ID() == DimensionID.HOME) {
			
			for (int i = 0; i < Spawner.LIST_HOME.size(); i++) {
				
				Spawnable s = Spawner.LIST_HOME.get(i);
				
				s.randomSpawn();
				
			}
			
		}
		
	}

}
