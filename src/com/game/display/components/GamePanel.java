package com.game.display.components;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import com.game.commands.DropPlayersItemsCommand;
import com.game.commands.KillPlayerCommand;
import com.game.commands.base.Commands;
import com.game.entities.base.EntityID;
import com.game.entities.vilagers.VillagerEntity;
import com.game.entities.vilagers.VillagerTrades;
import com.game.events.listeners.keys.KeyControls;
import com.game.main.Game;
import com.game.maps.Map;

public class GamePanel extends JPanel implements Runnable {

	private Thread gameThread;
	private final int FPS;
	
	private KeyControls keyControls;
	
	public GamePanel() {
		
		this.FPS = 60;
		
		
		Commands.add("Game.Player.dropItems();", new DropPlayersItemsCommand());
		Commands.add("Game.Player.dropAllItems();", new DropPlayersItemsCommand());
		Commands.add("Game.Player.die();", new KillPlayerCommand());
		
		
		Game.MAP_HANDLER.addMap(new Map(Game.BASE_MAPS[0]));
		Game.MAP_HANDLER.addMap(new Map(Game.BASE_MAPS[1]));
		Game.MAP_HANDLER.addMap(new Map(Game.BASE_MAPS[2]));
		Game.MAP_HANDLER.addMap(new Map(Game.BASE_MAPS[3]));
		
		Game.MAP_HANDLER.get(2).getEntityHandler().add(new VillagerEntity(200, 200, 0, 0, 64, 64, EntityID.VILAGER, Game.VILAGER_TEXTRA_ALICE.getImageFrom(0, 0, 16, 16), VillagerTrades.WOOD_TO_COIN));
		
		Game.MAP_HANDLER.get(3).getEntityHandler().add(new VillagerEntity(200, 200, 0, 0, 64, 64, EntityID.VILAGER, Game.VILAGER_TEXTRA_ALICE.getImageFrom(0, 0, 16, 16), VillagerTrades.COIN_TO_TACO));
		Game.MAP_HANDLER.get(3).getEntityHandler().add(new VillagerEntity(500, 200, 0, 0, 64, 64, EntityID.VILAGER, Game.VILAGER_TEXTRA_ALICE.getImageFrom(0, 0, 16, 16), VillagerTrades.APPLE_TO_COIN));
		
		
		this.keyControls = new KeyControls();
		
		this.addKeyListener(this.keyControls);
		
		
	}
	
	public void startGameLoop() {
		this.gameThread = new Thread(this);
		this.gameThread.setDaemon(false);
		this.gameThread.start();
	}

	@Override
	public void run() {
		
		this.requestFocus();
		
		double drawInterval = (double) (1000000000 / this.FPS);
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		long timer = 0L;
		int drawCount = 0;
		
		while (this.gameThread != null) {
			
			currentTime = System.nanoTime();
			
			delta += (double) ((double) (currentTime - lastTime) / drawInterval);
			timer += (long) (currentTime - lastTime);
			
			lastTime = currentTime;
			
			if (delta >= 1) {
				
				this.update();
				
				this.repaint();
				
				
				delta--;
				
				drawCount++;
				
				
			}
			
			if (timer >= 1000000000) {
				System.out.println("FPS: " + drawCount);
				drawCount = 0;
				timer = 0L;
			}
			
			
		}
	}
	
	private void update() {
		
		Game.MAP_HANDLER.currentMap().update();
		
		Game.PLAYER.update();
		
		Game.HUD.update();
		
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) g;
		
		this.drawBackground(g2d);
		
		Game.MAP_HANDLER.currentMap().draw(g2d);
		
		Game.PLAYER.draw(g2d);
		
		Game.HUD.draw(g2d);
		
		
	}
	
	private void drawBackground(Graphics2D g2d) {
		
		g2d.drawImage(Game.OBJECT_TEXTRA_ALICE.getImageFrom(0, 0, 16, 16), 0, 0, Game.WIDTH, Game.HEIGHT, null);
		
	}
	
}
