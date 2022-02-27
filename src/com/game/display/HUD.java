package com.game.display;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import com.game.entities.player.items.Item;
import com.game.main.Drawable;
import com.game.main.Game;
import com.game.main.Updatable;

public class HUD implements Drawable, Updatable {

	@Override
	public void update() {
		
		
		
	}

	@Override
	public void draw(Graphics2D g2d) {
		
		int xDraw = 164;
		
		g2d.drawImage(Game.HUD_TEXTRA_ALICE.getImageFrom(0, 0, 512, 64), 164, (int) (Game.HEIGHT - 96), 512, 64, null);
		
		for (int i = 0; i < Game.PLAYER.getHotbar().list.length; i++) {
			
			Item<?> item = Game.PLAYER.getHotbar().list[i];
			
			xDraw += 64;
			
			if (item != null) {
				
				g2d.drawImage(item.getImage(), (int) (xDraw - 64), (int) (Game.HEIGHT - 96), 64, 64, null);	
				
				
				g2d.setColor(new Color(0x000000));
				g2d.setFont(new Font("Verdana", Font.PLAIN, 16));
				g2d.drawString(String.valueOf(item.getCount()), (int) (xDraw - 48), (int) (Game.HEIGHT - 37));
				
			}
			
			
		}
		
	}

}
