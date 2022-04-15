package com.game.saving;

import java.io.Serializable;

import com.game.entities.player.Player;
import com.game.main.Game;
import com.game.maps.DimensionHandler;
import com.game.random.RandomGen;

public class SaveableObject implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8843059449073582668L;
	
	private DimensionHandler dimensionHandler;
	private Player player;
	private RandomGen randomGen;
	
	private GameVersion version;
	private int versionHashcode;
	
	public SaveableObject() {
		
		this.dimensionHandler = Game.DIMENSION_HANDLER;
		this.player = Game.PLAYER;
		
		this.version = Game.VERSION;
		this.versionHashcode = this.version.hashCode();
		
		this.randomGen = Game.RANDOM;
		
	}

	public DimensionHandler getDimensionHandler() {
		return this.dimensionHandler;
	}

	public void setDimensionHandler(DimensionHandler dimensionHandler) {
		this.dimensionHandler = dimensionHandler;
	}

	public Player getPlayer() {
		return this.player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public GameVersion getVersion() {
		return this.version;
	}

	public void setVersion(GameVersion version) {
		this.version = version;
	}

	public int getVersionHashcode() {
		return this.versionHashcode;
	}

	public void setVersionHashcode(int versionHashcode) {
		this.versionHashcode = versionHashcode;
	}

	public RandomGen getRandomGen() {
		return this.randomGen;
	}

	public void setRandomGen(RandomGen randomGen) {
		this.randomGen = randomGen;
	}
	
	
	
}
