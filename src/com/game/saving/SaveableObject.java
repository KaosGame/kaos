package com.game.saving;

import java.io.Serializable;

import com.game.entities.player.Player;
import com.game.main.Game;
import com.game.maps.DimensionHandler;

public class SaveableObject implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8843059449073582668L;
	
	private DimensionHandler dimensionHandler;
	private Player player;
	
	private GameVersion version;
	private int versionHashcode;
	
	public SaveableObject() {
		
		this.dimensionHandler = Game.DIMENSION_HANDLER.cloneType();
		this.player = Game.PLAYER.cloneType();
		
		this.version = Game.VERSION;
		this.versionHashcode = this.version.hashCode();
		
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
	
	
	
}
