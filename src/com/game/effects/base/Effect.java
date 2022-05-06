package com.game.effects.base;

import java.io.Serializable;

import com.game.entities.player.Player;
import com.game.main.Game;
import com.game.main.Updatable;

public abstract class Effect implements Updatable, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4905444267142283907L;
	
	protected int level;
	protected EffectID id;
	protected long time;
	
	public Effect(int level, EffectID id, long time) {
		
		super();
		this.level = level;
		this.id = id;
		this.time = time;
		
	}
	
	public abstract void onStart();
	
	@Override
	public final void update() {
		
		this.time--;
		
		if (this.time <= 0) {
			
			this.onEnd();
			
			Game.PLAYER.getEffectHandler().remove(this);
			
		}
		
		this.onUpdate();
		
	}
	
	public abstract void onUpdate();
	
	public abstract void onEnd();
	
	protected final Player getPlayer() {
		
		return Game.getCurrentPlayer();
		
	}

	public int getLevel() {
		return this.level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public EffectID getId() {
		return this.id;
	}

	public void setId(EffectID id) {
		this.id = id;
	}

	public long getTime() {
		return this.time;
	}

	public void setTime(long time) {
		this.time = time;
	}
	
}
