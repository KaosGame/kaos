package com.dodgydavid.kaos.random;

import java.util.Random;

public class RandomGen extends Random {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7971810348121530911L;
	
	private long seedR;
	
	public RandomGen(long seedR) {
		
		super(seedR);
		
		this.seedR = seedR;
		
	}

	public long getSeed() {
		return this.seedR;
	}
	
	@Override
	public void setSeed(long seedR) {
		this.seedR = seedR;
		super.setSeed(seedR);
	}
	
	

}
