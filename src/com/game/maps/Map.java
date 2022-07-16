package com.game.maps;

import java.awt.Graphics2D;
import java.io.Serializable;
import java.util.LinkedList;

import com.game.collision.objects.base.CollisionObject;
import com.game.entities.base.Entity;
import com.game.entities.base.EntityHandler;
import com.game.main.Drawable;
import com.game.main.Updatable;
import com.game.particles.Particle;

public class Map implements Updatable, Drawable, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3668298662107521492L;
	
	private volatile LinkedList<CollisionObject> objectList;
	private volatile EntityHandler entityHandler;
	private volatile LinkedList<Particle> particleList;
	
	
	
	public Map() {
		
		this.objectList = new LinkedList<CollisionObject>();
		this.entityHandler = new EntityHandler();
		this.particleList = new LinkedList<Particle>();
		
	}
	
	
	public Map(LinkedList<CollisionObject> objectList, EntityHandler entityHandler) {
		
		this.objectList = objectList;
		this.entityHandler = entityHandler;
		this.particleList = new LinkedList<Particle>();
		
	}
	
	public Map(CollisionObject[] objectList, EntityHandler entityHandler) {
		
		
		this.objectList = new LinkedList<CollisionObject>();
		
		for (int i = 0; i < objectList.length; i++) {
			
			this.objectList.add(objectList[i]);
			
		}
		
		this.entityHandler = entityHandler;
		this.particleList = new LinkedList<Particle>();
		
	}
	
	public Map(CollisionObject[] objectList) {
		
		
		this.objectList = new LinkedList<CollisionObject>();
		
		for (int i = 0; i < objectList.length; i++) {
			
			this.objectList.add(objectList[i]);
			
		}
		
		this.entityHandler = new EntityHandler();
		this.particleList = new LinkedList<Particle>();
		
	}
	
	public Map(CollisionObject[] objectList, Entity[] entityList) {
		
		
		this.objectList = new LinkedList<CollisionObject>();
		
		for (int i = 0; i < objectList.length; i++) {
			
			this.objectList.add(objectList[i]);
			
		}
		
		this.entityHandler = new EntityHandler();
		
		for (int i = 0; i < entityList.length; i++) {
			
			this.entityHandler.add(entityList[i]);
			
		}
		
		this.particleList = new LinkedList<Particle>();
		
	}	
	
	@Override
	public void update() {
		
		
		for (int i = 0; i < this.objectList.size(); i++) {
			
			CollisionObject o = this.objectList.get(i);
			
			if (o instanceof Updatable) ((Updatable) o).update();
			
		}
		
		this.entityHandler.update();
		
		for (int i = 0; i < this.particleList.size(); i++) {
			
			Particle p = this.particleList.get(i);
			
			if (p instanceof Updatable) ((Updatable) p).update();
			
		}
		
	}
	
	@Override
	public void draw(Graphics2D g2d) {
		
		for (int i = 0; i < this.objectList.size(); i++) {
			
			CollisionObject o = this.objectList.get(i);
			
			if (o instanceof Drawable) ((Drawable) o).draw(g2d);
			
		}
		
		this.entityHandler.draw(g2d);
		
		try {
			
			for (int i = 0; i < this.particleList.size(); i++) {
				
				if (this.particleList.get(i) == null) continue;
				
				Particle p = this.particleList.get(i);
				
				if (p instanceof Drawable) ((Drawable) p).draw(g2d);
				
			}
			
		} catch (NullPointerException e) {}
		
	}
	
	public void addObject(CollisionObject o) {
		
		this.objectList.add(o);
		
	}
	
	public void removeObject(CollisionObject o) {
		
		this.objectList.remove(o);
		
	}
	
	public CollisionObject getObject(int index) {
		
		return this.objectList.get(index);
		
	}


	public LinkedList<CollisionObject> getObjectList() {
		
		return this.objectList;
		
	}

	public EntityHandler getEntityHandler() {
		return this.entityHandler;
	}
	
	public LinkedList<Particle> getParticleList() {
		
		return this.particleList;
		
	}


	@Override
	public String toString() {
		return "Map [objectList=" + objectList + ", entityHandler=" + entityHandler + "]";
	}
	
	

}
