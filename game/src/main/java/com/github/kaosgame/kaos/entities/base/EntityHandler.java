package com.github.kaosgame.kaos.entities.base;

import java.awt.Graphics2D;
import java.io.Serializable;
import java.util.LinkedList;

import com.github.kaosgame.kaos.main.Drawable;
import com.github.kaosgame.kaos.main.Updatable;

public class EntityHandler implements Updatable, Drawable, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9010496619070360598L;
	
	private LinkedList<Entity> list;
	
	public EntityHandler() {
		
		this.list = new LinkedList<Entity>();
		
	}
	
	
	public void add(Entity e) {
		
		this.list.add(e);
		
	}
	
	public void remove(Entity e) {
		
		this.list.remove(e);
		
	}
	
	
	public LinkedList<Entity> getList() {
		
		return this.list;
		
	}
	
	@Override
	public void update() {
		
		for (int i = 0; i < this.list.size(); i++) {
			
			Entity e = (Entity) this.list.get(i);
			
			e.update();
			
			
		}
		
	}
	
	@Override
	public void draw(Graphics2D g2d) {
		
		for (int i = 0; i < this.list.size(); i++) {
			
			Entity e = (Entity) this.list.get(i);
			
			e.draw(g2d);
			
		}
		
	}
	
	public Entity get(int index) {
		
		return this.list.get(index);
		
	}

}
