package com.dodgydavid.kaos.entities.player;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.io.Serializable;

import com.dodgydavid.kaos.main.Drawable;
import com.dodgydavid.kaos.main.Game;
import com.dodgydavid.kaos.main.Updatable;
import com.dodgydavid.kaos.sound.Sounds;

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
		
		Game.SE_SOUND.setSound(Sounds.PLAYER_GET_STAT);
		Game.SE_SOUND.play();
		
		
	}
	
	public void removeAttack(long num) {
		
		this.attack -= num;
		
	}
	
	
	public void addDefence(long num) {
		
		this.defence += num;
		
		Game.SE_SOUND.setSound(Sounds.PLAYER_GET_STAT);
		Game.SE_SOUND.play();
		
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
		g2d.setFont(Game.MAIN_GAME_FONT.deriveFont(Font.PLAIN, 32f));
		g2d.drawString(String.valueOf(this.attack), 80, 115);
		
		
		g2d.drawImage(Game.STAT_TEXTRA_ALICE.getImageFrom(16, 0, 16, 16), 25, 135, 48, 48, null);
		
		g2d.setColor(new Color(0x000000));
		g2d.setFont(Game.MAIN_GAME_FONT.deriveFont(Font.PLAIN, 32f));
		g2d.drawString(String.valueOf(this.defence), 80, 170);
		
	}
	
	@Override
	public void update() {
		
		
		
	}
	
}
