package com.dodgydavid.kaos.random;

import java.io.Serializable;
import java.util.Random;

/**
 * 
 * RandomChance is a class that can return a random chance
 * 
 */
public class RandomChance implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4376254531231893113L;

	/**
	 * 
	 * RandomChance is a class that can return a random chance
	 * 
	 */
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
		
		return (boolean) (Math.random() < chance);
		
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
		
		return (boolean) (Math.random() < chance);
		
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
	
	/**
	 * Runs alot of boolean tests and returns and the result
	 */
	public boolean alotOfBooleans() {
		
		Random random = new Random();
		
		if (
				random.nextBoolean() && !random.nextBoolean() && random.nextBoolean() && !random.nextBoolean() &&
				random.nextBoolean() && !random.nextBoolean() && random.nextBoolean() && !random.nextBoolean()
				
			) {
			
			return true;
			
		}
		
		return false;
		
	}
	
	public static RandomChance getNewClass() {
		
		return new RandomChance();
		
	}
	

}
