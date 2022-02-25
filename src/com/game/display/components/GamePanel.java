package com.game.display.components;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import com.game.events.listeners.keys.KeyControls;
import com.game.main.Game;
import com.game.maps.Map;
import com.game.maps.MapHandler;

public class GamePanel extends JPanel implements Runnable {

	private Thread gameThread;
	private final int FPS;
	
	private KeyControls keyControls;
	
	public GamePanel() {
		
		this.FPS = 60;
		
		MapHandler.addMap(new Map(Game.BASE_MAPS[0]));
		MapHandler.addMap(new Map(Game.BASE_MAPS[1]));
		
		
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
		
		MapHandler.currentMap().update();
		
		Game.PLAYER.update();
		
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) g;
		
		this.drawBackground(g2d);
		
		MapHandler.currentMap().draw(g2d);
		
		Game.PLAYER.draw(g2d);
		
		
	}
	
	private void drawBackground(Graphics2D g2d) {
		
		g2d.drawImage(Game.OBJECT_TEXTRA_ALICE.getImageFrom(0, 0, 16, 16), 0, 0, Game.WIDTH, Game.HEIGHT, null);
		
	}
	
}
