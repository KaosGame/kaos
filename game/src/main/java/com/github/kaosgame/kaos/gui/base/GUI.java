package com.github.kaosgame.kaos.gui.base;

import java.awt.event.MouseEvent;
import java.io.Serializable;

import com.github.kaosgame.kaos.main.Drawable;
import com.github.kaosgame.kaos.main.Game;
import com.github.kaosgame.kaos.main.Updatable;

public abstract class GUI implements Updatable, Drawable, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9013400902301712421L;
	protected int mouseX;
	protected int mouseY;
	
	public GUI() {
		
		
		
	}
	
	public abstract void mouseDragged(MouseEvent e);
	public abstract void mouseMoved(MouseEvent e);
	public abstract void mouseClicked(MouseEvent e);
	public abstract void mousePressed(MouseEvent e);
	public abstract void mouseReleased(MouseEvent e);
	public abstract void mouseEntered(MouseEvent e);
	public abstract void mouseExited(MouseEvent e);
	
	public void open() {
		
		Game.HIDE_PAUSE = true;
		Game.GUI_OPEN = true;
		
	}
	
	public void close() {
		
		Game.HIDE_PAUSE = false;
		Game.GUI_OPEN = false;
		
	}

}
