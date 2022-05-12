package com.game.entities.player.cars.base;

import java.util.LinkedList;

import com.game.entities.base.Entity;
import com.game.entities.player.Player;
import com.game.main.Game;
import com.game.main.Updatable;

public class PlayerVehicleHandler implements Updatable {
	
	private boolean inVehicle;
	private Vehicle vehicle;
	private float vehicleSpeed;
	
	public PlayerVehicleHandler(Vehicle vehicle) {
		
		this.inVehicle = false;
		this.vehicle = vehicle;
		
		if (this.vehicle != null) {
			
			this.vehicleSpeed = vehicle.getSpeed();
			
		} else {
			
			this.vehicleSpeed = 0f;
			
		}
		
	}
	
	public PlayerVehicleHandler() {
	
		this(null);

	}

	
	
	public void key() {
		
		if (this.inVehicle) {
			
			this.inVehicle = false;
			
		} else if (this.canGetIn()) {
			
			this.inVehicle = true;
			this.vehicle = this.getCurrentVehicle();
			
		}
		
	}
	
	
	public Vehicle getCurrentVehicle() {

		LinkedList<Entity> eltl = Game.MAP_HANDLER().currentMap().getEntityHandler().getList();
		
		for (int i = 0; i < eltl.size(); i++) {
			
			Entity e = eltl.get(i);
			
			if (e instanceof Vehicle && e.getRectangle().intersects(Game.PLAYER.getRectangle())) return (Vehicle) e;
			
		}
		
		return null;
		
		
	}

	public boolean canGetIn() {
		
		LinkedList<Entity> eltl = Game.MAP_HANDLER().currentMap().getEntityHandler().getList();
		
		for (int i = 0; i < eltl.size(); i++) {
			
			Entity e = eltl.get(i);
			
			if (e instanceof Vehicle && e.getRectangle().intersects(Game.PLAYER.getRectangle())) return true;
			
		}
		
		return false;
	}

	@Override
	public void update() {
		
		if (this.inVehicle) {
			
			Player.SPEED = this.vehicle.getSpeed();
			
			this.vehicle.setX(Game.PLAYER.getX());
			this.vehicle.setY(Game.PLAYER.getY());
			
		}
		
	}

	public boolean isInVehicle() {
		return inVehicle;
	}

	public void setInVehicle(boolean inVehicle) {
		this.inVehicle = inVehicle;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public float getVehicleSpeed() {
		return vehicleSpeed;
	}

	public void setVehicleSpeed(float vehicleSpeed) {
		this.vehicleSpeed = vehicleSpeed;
	}

}
