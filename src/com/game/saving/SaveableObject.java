package com.game.saving;

import java.io.Serializable;

import com.game.entities.player.Player;
import com.game.main.Game;
import com.game.maps.MapHandler;

public class SaveableObject implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8843059449073582668L;
	
	private MapHandler mapHandler;
	private Player player;
	
	private GameVersion version;
	private int versionHashcode;
	
	public SaveableObject() {
		
		this.mapHandler = Game.MAP_HANDLER.cloneType();
		this.player = Game.PLAYER.cloneType();
		
		this.version = Game.VERSION;
		this.versionHashcode = this.version.hashCode();
		
	}

	public MapHandler getMapHandler() {
		return mapHandler;
	}

	public void setMapHandler(MapHandler mapHandler) {
		this.mapHandler = mapHandler;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public GameVersion getVersion() {
		return version;
	}

	public void setVersion(GameVersion version) {
		this.version = version;
	}

	public int getVersionHashcode() {
		return versionHashcode;
	}

	public void setVersionHashcode(int versionHashcode) {
		this.versionHashcode = versionHashcode;
	}
	
	
	
}
