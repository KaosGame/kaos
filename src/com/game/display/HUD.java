package com.game.display;

import java.awt.Graphics2D;

import com.game.main.Drawable;
import com.game.main.Game;
import com.game.main.Updatable;

public class HUD implements Drawable, Updatable {

	@Override
	public void update() {
		
		
		
	}

	@Override
	public void draw(Graphics2D g2d) {
		
		g2d.drawImage(Game.HUD_TEXTRA_ALICE.getImageFrom(0, 0, 512, 64), 164, (int) (Game.HEIGHT - 96), 512, 64, null);
		
	}

}
