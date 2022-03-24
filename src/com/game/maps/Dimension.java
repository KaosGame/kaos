package com.game.maps;

import java.awt.Graphics2D;
import java.io.Serializable;

import com.game.main.CloneableType;
import com.game.main.Drawable;
import com.game.main.Updatable;

public class Dimension implements Updatable, Drawable, CloneableType<Dimension>, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3256960586029559635L;

	private MapHandler mapHandler;
	
	private DimensionID id;
	
	public Dimension(DimensionID id) {
		
		this.mapHandler = new MapHandler();
		this.id = id;
		
		
	}
	
	public Dimension(MapHandler mapHandler, DimensionID id) {
		
		this.mapHandler = mapHandler;
		this.id = id;
		
		
	}
	
	@Override
	public void update() {
		
		this.mapHandler.currentMap().update();
		
	}
	
	@Override
	public void draw(Graphics2D g2d) {
		
		this.mapHandler.currentMap().draw(g2d);
		
	}

	public MapHandler getMapHandler() {
		return this.mapHandler;
	}

	public void setMapHandler(MapHandler mapHandler) {
		this.mapHandler = mapHandler;
	}

	public DimensionID getId() {
		return this.id;
	}

	public void setId(DimensionID id) {
		this.id = id;
	}

	@Override
	public Dimension cloneType() {
		return new Dimension(this.mapHandler, this.id);
	}
	
}
