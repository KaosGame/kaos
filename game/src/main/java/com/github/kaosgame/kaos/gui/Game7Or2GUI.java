package com.github.kaosgame.kaos.gui;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.Random;

import com.github.kaosgame.kaos.gui.base.GUI;
import com.github.kaosgame.kaos.main.Game;
import com.github.kaosgame.kaos.sound.Sounds;

public class Game7Or2GUI extends GUI {

	/**
	 * 
	 */
	private static final long serialVersionUID = -692559188419091775L;
	
	private transient Image image;
	
	public static final int X_POS = (int) (((int) Game.WIDTH / 2) - ((int) 384 / 2));
	public static final int Y_POS = (int) (((int) Game.HEIGHT / 2) - ((int) 288 / 2));
	
	private Rectangle button7;
	private Rectangle button2;
	private Rectangle buttonClose;
	
	private boolean cliked;
	private boolean num7;
	
	private Boolean btnNum7;
	
	public Game7Or2GUI() {
		
		this.image = Game.GUI_7_OR_2_TEXTRA_ALICE.getImageFrom(0, 0, 64, 48);
		
		this.button7 = new Rectangle(((int) Game7Or2GUI.X_POS + 36), ((int) Game7Or2GUI.Y_POS + 36), 96, 90);
		this.button2 = new Rectangle(((int) Game7Or2GUI.X_POS + 252), ((int) Game7Or2GUI.Y_POS + 36), 96, 90);
		this.buttonClose = new Rectangle(((int) Game7Or2GUI.X_POS + 78), ((int) Game7Or2GUI.Y_POS + 174), 234, 90);
		
		this.cliked = false;
		
		this.btnNum7 = null;
		
		Random random = new Random();
		
		this.num7 = !random.nextBoolean();
	}

	@Override
	public void update() {
		
		Rectangle mouse = new Rectangle(this.mouseX, this.mouseY, 10, 10);
		
		if (!this.cliked) {
			
			if (mouse.intersects(this.button7)) {
				
				this.image = Game.GUI_7_OR_2_TEXTRA_ALICE.getImageFrom(192, 0, 64, 48);
				
			} else if (mouse.intersects(this.button2)) {
				
				this.image = Game.GUI_7_OR_2_TEXTRA_ALICE.getImageFrom(128, 0, 64, 48);
				
			} else if (mouse.intersects(this.buttonClose)) {
				
				this.image = Game.GUI_7_OR_2_TEXTRA_ALICE.getImageFrom(64, 0, 64, 48);
				
			} else {
				
				this.image = Game.GUI_7_OR_2_TEXTRA_ALICE.getImageFrom(0, 0, 64, 48);
				
			}
			
		} else {
			
			if (this.num7 == this.btnNum7) {
				
				if (mouse.intersects(this.buttonClose)) {
					
					this.image = Game.GUI_7_OR_2_TEXTRA_ALICE.getImageFrom(128, 48, 64, 48);
					
				} else {
					
					this.image = Game.GUI_7_OR_2_TEXTRA_ALICE.getImageFrom(192, 48, 64, 48);
					
				}
				
			} else {
				
				this.image = Game.GUI_7_OR_2_TEXTRA_ALICE.getImageFrom(64, 48, 64, 48);
				
				if (mouse.intersects(this.buttonClose)) {
					
					this.image = Game.GUI_7_OR_2_TEXTRA_ALICE.getImageFrom(0, 48, 64, 48);
					
				} else {
					
					this.image = Game.GUI_7_OR_2_TEXTRA_ALICE.getImageFrom(64, 48, 64, 48);
					
				}
				
			}
			
			
			
		}
		
	}

	@Override
	public void draw(Graphics2D g2d) {
		
		g2d.drawImage(this.image, Game7Or2GUI.X_POS, Game7Or2GUI.Y_POS, 384, 288, null);
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
		this.mouseX = e.getX();
		this.mouseY = e.getY();
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		Random random = new Random();
		
		Rectangle mouse = new Rectangle(this.mouseX, this.mouseY, 10, 10);
		
		if (!this.cliked) {
			
			if (mouse.intersects(this.button7)) {
				
				this.cliked = true;
				this.num7 = !random.nextBoolean();
				this.btnNum7 = true;
				

				
			} else if (mouse.intersects(this.button2)) {
				
				this.cliked = true;
				this.num7 = !random.nextBoolean();
				this.btnNum7 = false;
				
			
				
			}
			
			if (this.num7 == this.btnNum7) {
				
				long coins = Game.PLAYER.getCoins();
				
				if (coins != 0L) {
					
					Game.PLAYER.setCoins(((long) coins * 2));
					
				} else {
					
					Game.PLAYER.addCoins(72L);
					
				}
				
				Game.SE_SOUND.setSound(Sounds.GAME_7_OR_2_WIN);
				Game.SE_SOUND.play();
				
				
			} else {
				
				Game.PLAYER.setCoins(0L);
				
				Game.SE_SOUND.setSound(Sounds.GAME_7_OR_2_LOSE);
				Game.SE_SOUND.play();
				
			}
			
		}
		
		if (mouse.intersects(this.buttonClose)) {
			
			this.close();
			
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}
	
	@Override
	public void open() {
		
		Game.HIDE_PAUSE = true;
		Game.GUI_OPEN = true;
		
		this.image = Game.GUI_7_OR_2_TEXTRA_ALICE.getImageFrom(0, 0, 64, 48);
		this.cliked = false;
		
		this.mouseX = 0;
		this.mouseY = 0;
		
	}

}
