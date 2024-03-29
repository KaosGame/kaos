package com.github.kaosgame.kaos.display;

import java.awt.*;

import com.github.kaosgame.kaos.entities.IsawawabubEntity;
import com.github.kaosgame.kaos.entities.cats.Catachiller;
import com.github.kaosgame.kaos.entities.monster.leath.MonsterLeath;
import com.github.kaosgame.kaos.entities.player.items.base.Item;
import com.github.kaosgame.kaos.main.Drawable;
import com.github.kaosgame.kaos.main.Game;
import com.github.kaosgame.kaos.main.Updatable;

public class HUD implements Drawable, Updatable {
	
	private short hungerGreenValue;
	private short healthGreenValue;

	
	public HUD() {
		
		this.hungerGreenValue = 255;
		this.healthGreenValue = 255;
		
	}
	
	@Override
	public void update() {
		
		this.hungerGreenValue = (short) (Game.PLAYER.getHunger() * 12);
		this.healthGreenValue = (short) (Math.round(Game.PLAYER.getHealth()) * 12);
		
	}

	@Override
	public void draw(Graphics2D g2d) {
		
		this.drawHotbar(g2d);
		this.drawHungerBar(g2d);
		this.drawHealthBar(g2d);
		this.drawCoins(g2d);
		this.drawMute(g2d);
		Game.PLAYER.getStatHandler().draw(g2d);
		Game.PLAYER.getEffectHandler().draw(g2d);
		
		if (MonsterLeath.onScreen()) MonsterLeath.drawBossBar(g2d);
		if (IsawawabubEntity.onScreen()) IsawawabubEntity.drawBossBar(g2d);
		if (Catachiller.onScreen()) Catachiller.drawBossBar(g2d);
		
	}


	private void drawCoins(Graphics2D g2d) {
		
		g2d.drawImage(Game.OBJECT_TEXTRA_ALICE.getImageFrom(192, 0, 16, 16), 25, 25, 48, 48, null);
		
		g2d.setColor(new Color(0x000000));
		g2d.setFont(Game.MAIN_GAME_FONT.deriveFont(Font.PLAIN, 32f));
		g2d.drawString(String.valueOf(Game.PLAYER.getCoins()), 80, 60);
		
	}

	private void drawHealthBar(Graphics2D g2d) {
		
		g2d.setColor(new Color(75, 75, 75));
		g2d.fillRect(176, (int) (Game.HEIGHT - 170), 216, 64);
		g2d.setColor(new Color(38, 38, 38));
		g2d.setStroke(new BasicStroke(2));
		g2d.drawRect(176, (int) (Game.HEIGHT - 170), 216, 64);
		
		g2d.setColor(new Color(75, this.healthGreenValue, 0));
		g2d.fillRect(184, (int) (Game.HEIGHT - 164), (int) (Math.round(Game.PLAYER.getHealth()) * 10), 48);
		
		g2d.setColor(new Color(0xC0C0C0));
		g2d.setStroke(new BasicStroke(2));
		g2d.drawRect(184, (int) (Game.HEIGHT - 164), 200, 48);
		
		g2d.setColor(new Color(0x222222));
		g2d.setFont(Game.HOTBAR_GAME_FONT.deriveFont(16f));
		g2d.drawString("Health", 184, (int) (Game.HEIGHT - 150));
		
	}

	private void drawMute(Graphics2D g2d) {

		Image img = Game.MUTE_TEXTRA_ALICE.getImageFrom(0, 0, 16, 16);

		if (Game.MUTED) {

			img = Game.MUTE_TEXTRA_ALICE.getImageFrom(16, 0, 16, 16);

		}

		g2d.drawImage(img, Game.WIDTH - 80, Game.HEIGHT - 80, 48, 48, null);

	}

	private void drawHungerBar(Graphics2D g2d) {
		
		g2d.setColor(new Color(75, 75, 75));
		g2d.fillRect(440, (int) (Game.HEIGHT - 170), 216, 64);
		g2d.setColor(new Color(38, 38, 38));
		g2d.setStroke(new BasicStroke(2));
		g2d.drawRect(440, (int) (Game.HEIGHT - 170), 216, 64);
		
		g2d.setColor(new Color(75, this.hungerGreenValue, 0));
		g2d.fillRect(448, (int) (Game.HEIGHT - 164), (int) (Game.PLAYER.getHunger() * 10), 48);
		
		g2d.setColor(new Color(0xC0C0C0));
		g2d.setStroke(new BasicStroke(2));
		g2d.drawRect(448, (int) (Game.HEIGHT - 164), 200, 48);
		
		g2d.setColor(new Color(0x222222));
		g2d.setFont(Game.HOTBAR_GAME_FONT.deriveFont(16f));
		g2d.drawString("Hunger", 448, (int) (Game.HEIGHT - 150));
		
	}

	private void drawHotbar(Graphics2D g2d) {
		
		int xDraw = 164;
		
		for (int i = 0; i < Game.PLAYER.getHotbar().list.length; i++) {
			
			g2d.drawImage(Game.HOTBAR_TEXTRA_ALICE.getImageFrom(0, 0, 64, 64), xDraw, (int) (Game.HEIGHT - 96), 64, 64, null);
			
			Item<?> item = Game.PLAYER.getHotbar().list[i];
			
			xDraw += 64;
			
			if (item != null) {
				
				g2d.drawImage(item.getImage(), (int) (xDraw - 64), (int) (Game.HEIGHT - 96), 64, 64, null);	
				
				
				g2d.setColor(item.getId().getColor());
				g2d.setFont(Game.HOTBAR_GAME_FONT.deriveFont(16f));
				g2d.drawString(String.valueOf(item.getCount()), (int) (xDraw - 48), (int) (Game.HEIGHT - 37));
				
			}
			
			if ((int) Game.PLAYER.getHotbar().currentItemIndex == i) {
				
				g2d.drawImage(Game.HOTBAR_TEXTRA_ALICE.getImageFrom(64, 0, 64, 64), (int) (xDraw - 64), (int) (Game.HEIGHT - 96), 64, 64, null);
				
			}
			
		}
		
	}

}
