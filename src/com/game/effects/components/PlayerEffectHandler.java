package com.game.effects.components;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.io.Serializable;
import java.util.LinkedList;

import com.game.effects.base.Effect;
import com.game.main.Drawable;
import com.game.main.Updatable;

public class PlayerEffectHandler implements Updatable, Drawable, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -167846693833886064L;
	
	private LinkedList<Effect> list;

	public PlayerEffectHandler() {
		
		this.list = new LinkedList<Effect>();
		
	}

	@Override
	public void draw(Graphics2D g2d) {
		
		int drawY = 200;
		
		for (int i = 0; i < this.list.size(); i++) {
			
			if (i > 2) {
				
				g2d.setColor(new Color(0x000000));
				g2d.setFont(new Font("Verdana", Font.PLAIN, 32));
				g2d.drawString("...", 25, (int) (drawY + 32));
				
			} else {
				
				Effect e = this.get(i);
				
				g2d.drawImage(e.getId().getImage(), 25, drawY, 48, 48, null);
				
				g2d.setColor(new Color(0x000000));
				g2d.setFont(new Font("Verdana", Font.PLAIN, 20));
				long displayTime = (long) (e.getTime() / 60);
				g2d.drawString(String.format("%d sec", displayTime), 75, (int) (drawY + 32));
				
				g2d.setColor(new Color(0x000000));
				g2d.setFont(new Font("Verdana", Font.PLAIN, 20));
				g2d.drawString(String.format("%d", e.getLevel()), 170, (int) (drawY + 32));
				
				drawY += 64;
				
			}
			

			
			
		}
		
	}
	
	@Override
	public void update() {
		
		for (int i = 0; i < this.list.size(); i++) {
			
			this.list.get(i).update();
			
		}
		
	}

	public LinkedList<Effect> getList() {
		return this.list;
	}

	public void setList(LinkedList<Effect> list) {
		this.list = list;
	}

	public void clear() {
		this.list.clear();
	}

	public boolean add(Effect e) {
		return this.list.add(e);
	}

	public boolean remove(Effect e) {
		return this.list.remove(e);
	}

	public Effect get(int index) {
		return this.list.get(index);
	}

	public Effect remove(int index) {
		return this.list.remove(index);
	}

}
