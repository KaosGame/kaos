package com.dodgydavid.kaos.entities.player.items.base;

import java.awt.image.BufferedImage;

public abstract class WeaponItem<CT> extends Item<CT> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6251990828524976307L;
	
	protected float damage;

	public WeaponItem(int count, ItemID id, BufferedImage image, float damage) {
		
		super(count, id, image);
		this.damage = damage;
		
	}

	public float getDamage() {
		
		return this.damage;
		
	}

	public void setDamage(float damage) {
		
		this.damage = damage;
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Float.floatToIntBits(damage);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		WeaponItem<?> other = (WeaponItem<?>) obj;
		if (Float.floatToIntBits(damage) != Float.floatToIntBits(other.damage))
			return false;
		return true;
	}
	
	
	

}
