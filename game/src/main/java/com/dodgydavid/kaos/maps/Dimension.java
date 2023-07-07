package com.dodgydavid.kaos.maps;

import java.awt.Graphics2D;
import java.awt.Image;
import java.io.Serializable;

import com.dodgydavid.kaos.main.CloneableType;
import com.dodgydavid.kaos.main.Drawable;
import com.dodgydavid.kaos.main.Updatable;

public class Dimension implements Updatable, Drawable, CloneableType<Dimension>, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3256960586029559635L;

	private MapHandler mapHandler;
	private DimensionID id;
	
	private transient Image background;
	
	public Dimension(DimensionID id, Image background) {
		
		this.mapHandler = new MapHandler();
		this.id = id;
		this.background = background;
		
		
	}
	
	public Dimension(MapHandler mapHandler, DimensionID id, Image background) {
		
		this.mapHandler = mapHandler;
		this.id = id;
		this.background = background;
		
		
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
		return new Dimension(this.mapHandler, this.id, this.background);
	}

	public Image getBackground() {
		return this.background;
	}

	public void setBackground(Image background) {
		this.background = background;
	}
	
}
