package com.game.display.components;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import com.game.commands.DropPlayersItemsCommand;
import com.game.commands.GetNumberOfEntitiesCommand;
import com.game.commands.GetPlayerPosCommand;
import com.game.commands.GivePlayerPickaxeItemCommand;
import com.game.commands.KillPlayerCommand;
import com.game.commands.base.Commands;
import com.game.events.listeners.keys.KeyControls;
import com.game.main.Game;
import com.game.maps.OverflowHandler;
import com.game.spawning.base.Spawner;

public class GamePanel extends JPanel implements Runnable {

	private Thread gameThread;
	private final int FPS;
	
	private KeyControls keyControls;
	private OverflowHandler overflowHandler;
	
	public GamePanel() {
		
		this.FPS = 60;
		
		
		Commands.add("Game.Player.dropItems();", new DropPlayersItemsCommand());
		Commands.add("Game.Player.dropAllItems();", new DropPlayersItemsCommand());
		Commands.add("Game.Player.die();", new KillPlayerCommand());
		Commands.add("Game.Player.getPos();", new GetPlayerPosCommand());
		Commands.add("Game.countE();", new GetNumberOfEntitiesCommand());
		Commands.add("Game.Player.give(Pickaxe);", new GivePlayerPickaxeItemCommand());
		
		
		Game.reset();
		
		
		this.keyControls = new KeyControls();
		
		this.overflowHandler = new OverflowHandler();
		
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
		
		
		try {
			
			Game.MAP_HANDLER.currentMap().update();
			
			Game.PLAYER.update();
			
			Game.HUD.update();
			
			Spawner.spwan();
			
			this.overflowHandler.handle();
			
		} catch (NullPointerException e) {
			
			e.printStackTrace();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		
		try {
			
			super.paintComponent(g);
			
			Graphics2D g2d = (Graphics2D) g;
			
			this.drawBackground(g2d);
			
			Game.MAP_HANDLER.currentMap().draw(g2d);
			
			Game.PLAYER.draw(g2d);
			
			Game.HUD.draw(g2d);
			
		} catch (NullPointerException e) {
			
			e.printStackTrace();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		
	}
	
	private void drawBackground(Graphics2D g2d) {
		
		g2d.drawImage(Game.OBJECT_TEXTRA_ALICE.getImageFrom(0, 0, 16, 16), 0, 0, Game.WIDTH, Game.HEIGHT, null);
		
	}
	
}
