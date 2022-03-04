package com.game.maps;

import java.awt.Graphics2D;
import java.io.Serializable;
import java.util.LinkedList;

import com.game.collision.objects.CollisionObject;
import com.game.entities.base.EntityHandler;
import com.game.main.Drawable;
import com.game.main.Updatable;

public class Map implements Updatable, Drawable, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3668298662107521492L;
	
	private LinkedList<CollisionObject> objectList;
	private EntityHandler entityHandler;
	
	
	
	public Map() {
		
		this.objectList = new LinkedList<CollisionObject>();
		this.entityHandler = new EntityHandler();
		
	}
	
	
	public Map(LinkedList<CollisionObject> objectList, EntityHandler entityHandler) {
		
		this.objectList = objectList;
		this.entityHandler = entityHandler;
		
	}
	
	public Map(CollisionObject[] objectList, EntityHandler entityHandler) {
		
		
		this.objectList = new LinkedList<CollisionObject>();
		
		for (int i = 0; i < objectList.length; i++) {
			
			this.objectList.add(objectList[i]);
			
		}
		
		this.entityHandler = entityHandler;
		
	}
	
	public Map(CollisionObject[] objectList) {
		
		
		this.objectList = new LinkedList<CollisionObject>();
		
		for (int i = 0; i < objectList.length; i++) {
			
			this.objectList.add(objectList[i]);
			
		}
		
		this.entityHandler = new EntityHandler();
		
	}	
	
	@Override
	public void update() {
		
		
		for (int i = 0; i < this.objectList.size(); i++) {
			
			CollisionObject o = this.objectList.get(i);
			
			if (o instanceof Updatable) ((Updatable) o).update();
			
		}
		
		this.entityHandler.update();
		
	}
	
	@Override
	public void draw(Graphics2D g2d) {
		
		for (int i = 0; i < this.objectList.size(); i++) {
			
			CollisionObject o = this.objectList.get(i);
			
			if (o instanceof Drawable) ((Drawable) o).draw(g2d);
			
		}
		
		this.entityHandler.draw(g2d);
		
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
	
	

}
