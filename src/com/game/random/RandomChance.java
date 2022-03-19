package com.game.random;

import java.io.Serializable;

public class RandomChance implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4376254531231893113L;

	public RandomChance() {
		
		super();
		
	}
	
	
	/**
	 * 
	 * This code is good for 2% to be it
	 * 
	 * Example:
	 *  Lets say you want a 2% chance to give the player an item
	 *  This method makes it so a 2% chance to be true
	 * 
	 */
	public boolean firstChoose(float chance) {
		
		return (Math.random() < chance);
		
	}
	
	/**
	 * 
	 * This code is good for 2% to be it
	 * 
	 * Example:
	 *  Lets say you want a 2% chance to give the player an item
	 *  This method makes it so a 2% chance to be true
	 * 
	 */
	public boolean firstChoose(double chance) {
		
		return (Math.random() < chance);
		
	}
	
	/**
	 * 
	 * This code is good for 2% to be it
	 * 
	 * Example:
	 *  Lets say you want a 2% chance to give the player an item
	 *  This method makes it so a 2% chance to be false
	 * 
	 */
	public boolean lastChoose(float chance) {
		
		return (Math.random() > chance);
		
	}
	
	/**
	 * 
	 * This code is good for 2% to be it
	 * 
	 * Example:
	 *  Lets say you want a 2% chance to give the player an item
	 *  This method makes it so a 2% chance to be false
	 * 
	 */
	public boolean lastChoose(double chance) {
		
		return (Math.random() > chance);
		
	}
	
	public static RandomChance getNewClass() {
		
		return new RandomChance();
		
	}
	

}
