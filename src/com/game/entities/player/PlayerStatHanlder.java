package com.game.entities.player;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.io.Serializable;

import com.game.annotations.Empty;
import com.game.main.Drawable;
import com.game.main.Game;
import com.game.main.Updatable;

public class PlayerStatHanlder implements Serializable, Updatable, Drawable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4186466690375406182L;
	
	private long attack;
	private long defence;
	
	
	public PlayerStatHanlder() {
		
		this.attack = 0L;
		this.defence = 0L;
		
	}
	
	public void addAttack(long num) {
		
		this.attack += num;
		
	}
	
	public void removeAttack(long num) {
		
		this.attack -= num;
		
	}
	
	
	public void addDefence(long num) {
		
		this.defence += num;
		
	}
	
	public void removeDefence(long num) {
		
		this.defence -= num;
		
	}

	public long getAttack() {
		return this.attack;
	}

	public void setAttack(long attack) {
		this.attack = attack;
	}

	public long getDefence() {
		return this.defence;
	}

	public void setDefence(long defence) {
		this.defence = defence;
	}

	@Override
	public void draw(Graphics2D g2d) {
		
		g2d.drawImage(Game.STAT_TEXTRA_ALICE.getImageFrom(0, 0, 16, 16), 25, 80, 48, 48, null);
		
		g2d.setColor(new Color(0x000000));
		g2d.setFont(new Font("Verdana", Font.PLAIN, 32));
		g2d.drawString(String.valueOf(this.attack), 80, 115);
		
		
		g2d.drawImage(Game.STAT_TEXTRA_ALICE.getImageFrom(16, 0, 16, 16), 25, 135, 48, 48, null);
		
		g2d.setColor(new Color(0x000000));
		g2d.setFont(new Font("Verdana", Font.PLAIN, 32));
		g2d.drawString(String.valueOf(this.defence), 80, 170);
		
	}
	
	@Empty
	@Override
	public void update() {
		
		
		
	}
	
}
