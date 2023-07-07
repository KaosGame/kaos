package com.github.kaosgame.kaos.particles.images;

import java.awt.Graphics2D;
import java.io.Serializable;

import com.github.kaosgame.kaos.main.Drawable;
import com.github.kaosgame.kaos.main.Updatable;
import com.github.kaosgame.kaos.particles.Particle;

public class ImageParticle extends Particle implements Drawable, Updatable, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6161130011500923769L;
	
	protected ParticleImages particleImageType;

	public ImageParticle(double x, double y, double xv, double yv, int width, int height, long time,
			Runnable onEnd, Runnable onUpdate, ParticleImages particleImageType) {
		super(x, y, xv, yv, width, height, null, time, onEnd, onUpdate);
		this.particleImageType = particleImageType;
		
	}
	
	@Override
	public void draw(Graphics2D g2d) {
		
		g2d.drawImage(this.particleImageType.getImage(), (int) this.x, (int) this.y, this.width, this.height, null);
		
	}

	public ParticleImages getImage() {
		return this.particleImageType;
	}

	public void setImage(ParticleImages particleImageType) {
		this.particleImageType = particleImageType;
	}

}
