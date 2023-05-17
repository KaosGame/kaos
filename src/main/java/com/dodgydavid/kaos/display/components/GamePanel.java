package com.dodgydavid.kaos.display.components;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import com.dodgydavid.kaos.commands.DropPlayersItemsCommand;
import com.dodgydavid.kaos.commands.ForcePlaneCommand;
import com.dodgydavid.kaos.commands.ForceRockZombieCommand;
import com.dodgydavid.kaos.commands.ForceZombieCommand;
import com.dodgydavid.kaos.commands.GetNumberOfEntitiesCommand;
import com.dodgydavid.kaos.commands.GetPlayerPosCommand;
import com.dodgydavid.kaos.commands.GivePlayerBreadItemCommand;
import com.dodgydavid.kaos.commands.GivePlayerMushroomStewItemCommand;
import com.dodgydavid.kaos.commands.GivePlayerPickaxeItemCommand;
import com.dodgydavid.kaos.commands.GivePlayerRedMushroomItemCommand;
import com.dodgydavid.kaos.commands.KillPlayerCommand;
import com.dodgydavid.kaos.commands.LogRandomGenSeedCommand;
import com.dodgydavid.kaos.commands.SetSeedForRandomGenCommand;
import com.dodgydavid.kaos.commands.base.Commands;
import com.dodgydavid.kaos.entities.AxolotlEntity;
import com.dodgydavid.kaos.entities.BirdEntity;
import com.dodgydavid.kaos.entities.bad.zombie.ZombieEntity;
import com.dodgydavid.kaos.entities.bad.zombie.rock.RockZombieEntity;
import com.dodgydavid.kaos.entities.cats.Cat;
import com.dodgydavid.kaos.entities.item.planes.ItemPlaneEntity;
import com.dodgydavid.kaos.events.listeners.keys.KeyControls;
import com.dodgydavid.kaos.gui.base.GenericGUIEventHandler;
import com.dodgydavid.kaos.logging.LogType;
import com.dodgydavid.kaos.main.Game;
import com.dodgydavid.kaos.maps.OverflowHandler;
import com.dodgydavid.kaos.sound.Sounds;
import com.dodgydavid.kaos.spawning.base.Spawner;
import com.dodgydavid.kaos.war.War;

public class GamePanel extends JPanel implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7631405450944947366L;
	
	private Thread gameThread;
	private final int FPS;
	
	private KeyControls keyControls;
	private OverflowHandler overflowHandler;
	private GenericGUIEventHandler genericGUIEventHandler;
	
	public GamePanel() {
		
		Game.logln("GamePanel class created", LogType.SUCCESS);
		
		this.FPS = 60;
		
		
		Spawner.addHome(new BirdEntity());
		Spawner.addHome(new ItemPlaneEntity());
		Spawner.addHome(new ZombieEntity());
		Spawner.addHome(new RockZombieEntity());
		Spawner.addHome(new AxolotlEntity());
		Spawner.addHome(new War());
		Spawner.addHome(new Cat());
		
		Spawner.addFishLand(new BirdEntity());
		Spawner.addFishLand(new AxolotlEntity());
		
		
		Commands.add("Game.Player.dropItems();", new DropPlayersItemsCommand());
		Commands.add("Game.Player.dropAllItems();", new DropPlayersItemsCommand());
		Commands.add("Game.Player.die();", new KillPlayerCommand());
		Commands.add("Game.Player.getPos();", new GetPlayerPosCommand());
		Commands.add("Game.countE();", new GetNumberOfEntitiesCommand());
		Commands.add("Game.Player.give(Pickaxe);", new GivePlayerPickaxeItemCommand());
		Commands.add("Game.force.item.plane();", new ForcePlaneCommand());
		Commands.add("Game.Player.give(RedMushroom);", new GivePlayerRedMushroomItemCommand());
		Commands.add("Game.force.zombie();", new ForceZombieCommand());
		Commands.add("Game.getSeed();", new LogRandomGenSeedCommand());
		Commands.add("Game.setSeed();", new SetSeedForRandomGenCommand());
		Commands.add("Game.Player.give(MushroomStew);", new GivePlayerMushroomStewItemCommand());
		Commands.add("Game.Player.give(Bread);", new GivePlayerBreadItemCommand());
		Commands.add("Game.force.rock.zombie();", new ForceRockZombieCommand());
		
		Game.reset();
		
		
		this.keyControls = new KeyControls();
		
		this.overflowHandler = new OverflowHandler();
		
		this.genericGUIEventHandler = new GenericGUIEventHandler();
		
		this.addKeyListener(this.keyControls);
		this.addMouseListener(this.genericGUIEventHandler);
		this.addMouseMotionListener(this.genericGUIEventHandler);
		
		Game.BG_SOUND.setSound(Sounds.BASE_BACKGROUND_MUSIC);
		Game.BG_SOUND.setVolumeScale(2);
		Game.BG_SOUND.loop();
		
		Game.SE_SOUND.setTrueVolumeScale(3);
		Game.ANY_VOLUME_SOUNDS.setTrueVolumeScale(3);
		
		Game.logln("Game started, class created", LogType.SUCCESS);
		
		
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
				Game.logln("FPS: " + drawCount, LogType.INFO);
				drawCount = 0;
				timer = 0L;
			}
			
			
		}
	}
	
	private void update() {
		
		
		try {
			
			if (!Game.PAUSED && !Game.HIDE_PAUSE) {
				
				Game.MAP_HANDLER().currentMap().update();
				
				Game.PLAYER.update();
				
				Game.HUD.update();
				
				Spawner.spwan();
				
				this.overflowHandler.handle();
				
			}
			
			if (Game.GUI_OPEN == true && Game.CURRENT_GUI != null) {
				
				Game.CURRENT_GUI.update();
				
			}
			
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
			
			Game.MAP_HANDLER().currentMap().draw(g2d);
			
			Game.PLAYER.draw(g2d);
			
			Game.HUD.draw(g2d);
			
			this.drawPause(g2d);
			
			if (Game.GUI_OPEN == true && Game.CURRENT_GUI != null) {
				
				Game.CURRENT_GUI.draw(g2d);
				
			}
			
			g2d.dispose();
			g.dispose();
			
		} catch (NullPointerException e) {
			
			e.printStackTrace();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		
	}
	
	private void drawPause(Graphics2D g2d) {
		
		if (Game.PAUSED) {
			
			int[] center = {
					
					(int) ((int) (Game.WIDTH / 2) - 64),
					(int) ((int) (Game.HEIGHT / 2) - 128)
					
			};
			
			g2d.drawImage(Game.PAUSE_1_IMAGE_LOADER.getImage(), center[0], center[1], 128, 128, null);
			
		}
		
	}

	private void drawBackground(Graphics2D g2d) {
		
		g2d.drawImage(Game.DIMENSION_HANDLER.currentDimension().getBackground(), 0, 0, Game.WIDTH, Game.HEIGHT, null);
		
	}
	
}
