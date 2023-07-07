package com.github.kaosgame.kaos.gui.base;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import com.github.kaosgame.kaos.main.Game;

public class GenericGUIEventHandler implements MouseListener, MouseMotionListener {

	@Override
	public void mouseDragged(MouseEvent e) {
		
		if (Game.GUI_OPEN == true && Game.CURRENT_GUI != null) {
			
			Game.CURRENT_GUI.mouseDragged(e);
			
		}
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
		if (Game.GUI_OPEN == true && Game.CURRENT_GUI != null) {
			
			Game.CURRENT_GUI.mouseMoved(e);
			
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		if (Game.GUI_OPEN == true && Game.CURRENT_GUI != null) {
			
			Game.CURRENT_GUI.mouseClicked(e);
			
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		if (Game.GUI_OPEN == true && Game.CURRENT_GUI != null) {
			
			Game.CURRENT_GUI.mousePressed(e);
			
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		if (Game.GUI_OPEN == true && Game.CURRENT_GUI != null) {
			
			Game.CURRENT_GUI.mouseReleased(e);
			
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
		if (Game.GUI_OPEN == true && Game.CURRENT_GUI != null) {
			
			Game.CURRENT_GUI.mouseEntered(e);
			
		}
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
		if (Game.GUI_OPEN == true && Game.CURRENT_GUI != null) {
			
			Game.CURRENT_GUI.mouseExited(e);
			
		}
		
	}

}
