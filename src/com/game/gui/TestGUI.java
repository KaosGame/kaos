package com.game.gui;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import com.game.annotations.Empty;
import com.game.annotations.NotNeeded;
import com.game.annotations.Unused;
import com.game.gui.base.GUI;

public class TestGUI extends GUI {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1836675154190609275L;
	private Color c1;
	private Color c2;
	private Color b;
	
	public TestGUI () {
		
		c1 = new Color(0x222222);
		c2 = new Color(0x222222);
		
		b = new Color(0xE0E0E0);
	}
	
	

	@Override
	public void update() {
		
		Rectangle rect1 = new Rectangle(96, 96, 64, 64);
		Rectangle rect2 = new Rectangle(196, 96, 64, 64);
		
		Rectangle m = new Rectangle(this.mouseX, this.mouseY, 10, 10);
		
		if (m.intersects(rect1)) {
			
			c1 = new Color(0xFFFFFF);
			
		} else {
			
			c1 = new Color(0x222222);
			
		}
		
		if (m.intersects(rect2)) {
			
			c2 = new Color(0xFFFFFF);
			
		} else {
			
			c2 = new Color(0x222222);
			
		}
		
		
		
	}

	@Override
	public void draw(Graphics2D g2d) {
		

		
		g2d.setColor(b);
		g2d.fillRect(64, 64, 256, 128);
		
		

		g2d.setColor(c1);
		g2d.fillRect(96, 96, 64, 64);
		

		g2d.setColor(c2);
		g2d.fillRect(196, 96, 64, 64);
		
		
	}
	
	
	@NotNeeded
	@Empty
	@Unused
	@Override
	public void mouseDragged(MouseEvent e) {
		
	}
	
	public void mouseMoved(MouseEvent e) {
		
		this.mouseX = e.getX();
		this.mouseY = e.getY();
		
	}
	
	@NotNeeded
	@Empty
	@Unused
	@Override
	public void mouseClicked(MouseEvent e) {
		
	}
	
	@NotNeeded
	@Empty
	@Unused
	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		Rectangle rect1 = new Rectangle(96, 96, 64, 64);
		Rectangle rect2 = new Rectangle(196, 96, 64, 64);
		
		Rectangle m = new Rectangle(this.mouseX, this.mouseY, 10, 10);
		
		if (m.intersects(rect1)) {
			
			b = Color.cyan;
			
		}
		
		if (m.intersects(rect2)) {
			
			this.close();
			
		}
		
	}
	
	@NotNeeded
	@Empty
	@Unused
	@Override
	public void mouseEntered(MouseEvent e) {
		
	}
	
	@NotNeeded
	@Empty
	@Unused
	@Override
	public void mouseExited(MouseEvent e) {
		
	}

}
