package com.game.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Random;
import java.util.Stack;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.game.collision.objects.ChangeMapCollidableObject;
import com.game.collision.objects.ChestTransparentObject;
import com.game.collision.objects.CollidableObject;
import com.game.collision.objects.CollidableWallObject;
import com.game.collision.objects.TextSignObject;
import com.game.collision.objects.base.CollisionObject;
import com.game.collision.objects.base.ObjectType;
import com.game.display.HUD;
import com.game.display.components.GamePanel;
import com.game.entities.ItemEntity;
import com.game.entities.base.Entity;
import com.game.entities.base.EntityID;
import com.game.entities.player.Player;
import com.game.entities.player.items.base.Item;
import com.game.entities.player.items.base.ItemID;
import com.game.entities.player.items.tools.PickaxeItem;
import com.game.entities.vilagers.VillagerEntity;
import com.game.entities.vilagers.VillagerTrades;
import com.game.exceptions.image.restoring.NotEnoughInformationToRestoreImageException;
import com.game.maps.Map;
import com.game.maps.MapHandler;
import com.game.saving.GameVersion;
import com.game.saving.SaveableObject;
import com.game.saving.SavingGame;
import com.game.textures.BufferedImageLoader;
import com.game.textures.TextraAlice;

public class Game {
	
	private JFrame frame;
	private GamePanel gamePanel;
	
	public static final int WIDTH = 800;
	public static final int HEIGHT = 704;
	
	private static BufferedImageLoader OBJECT_TEXTRA_ALICE_LOADER = new BufferedImageLoader("/assets/images/object-textra-alice.png");
	private static BufferedImageLoader PLAYER_TEXTRA_ALICE_LOADER = new BufferedImageLoader("/assets/images/entities/player-textra-alice.png");
	private static BufferedImageLoader VILAGER_TEXTRA_ALICE_LOADER = new BufferedImageLoader("/assets/images/entities/vilager-textra-alice.png");
	private static BufferedImageLoader BIRD_TEXTRA_ALICE_LOADER = new BufferedImageLoader("/assets/images/entities/bird-textra-alice.png");
	private static BufferedImageLoader PLANE_TEXTRA_ALICE_LOADER = new BufferedImageLoader("/assets/images/entities/plane-textra-alice.png");
	private static BufferedImageLoader HUD_TEXTRA_ALICE_LOADER = new BufferedImageLoader("/assets/images/hud/hud-textra-alice.png");
	private static BufferedImageLoader ITEM_TEXTRA_ALICE_LOADER = new BufferedImageLoader("/assets/images/item-textra-alice.png");
	
	public static BufferedImageLoader HOUSE_1_IMAGE_LOADER = new BufferedImageLoader("/assets/images/objects/house_1.png");
	public static BufferedImageLoader HUD_ITEM_CURRENT_LOADER = new BufferedImageLoader("/assets/images/hud/hud-item-current-image.png");
	
	public static TextraAlice OBJECT_TEXTRA_ALICE = new TextraAlice(Game.OBJECT_TEXTRA_ALICE_LOADER.getImage());
	public static TextraAlice PLAYER_TEXTRA_ALICE = new TextraAlice(Game.PLAYER_TEXTRA_ALICE_LOADER.getImage());
	public static TextraAlice HUD_TEXTRA_ALICE = new TextraAlice(Game.HUD_TEXTRA_ALICE_LOADER.getImage());
	public static TextraAlice ITEM_TEXTRA_ALICE = new TextraAlice(Game.ITEM_TEXTRA_ALICE_LOADER.getImage());
	public static TextraAlice VILAGER_TEXTRA_ALICE = new TextraAlice(Game.VILAGER_TEXTRA_ALICE_LOADER.getImage());
	public static TextraAlice BIRD_TEXTRA_ALICE = new TextraAlice(Game.BIRD_TEXTRA_ALICE_LOADER.getImage());
	public static TextraAlice PLANE_TEXTRA_ALICE = new TextraAlice(Game.PLANE_TEXTRA_ALICE_LOADER.getImage());
	
	public static CollisionObject[][] BASE_MAPS = {
			
			{
				new ChangeMapCollidableObject((int) (Game.WIDTH - 64), 0, 64, 64, ObjectType.NEXT_MAP, Game.OBJECT_TEXTRA_ALICE.getImageFrom(112, 0, 16, 16), 1),
				new CollidableWallObject(125, 81, 135, 100, ObjectType.WALL, Game.OBJECT_TEXTRA_ALICE.getImageFrom(64, 0, 16, 16), CollidableWallObject.ImageBase.TYPE_1),
				new CollidableWallObject(25, 200, 100, 300, ObjectType.WALL, Game.OBJECT_TEXTRA_ALICE.getImageFrom(32, 0, 16, 16), CollidableWallObject.ImageBase.TYPE_2),
				new CollidableWallObject(25, 500, 100, 100, ObjectType.WALL, Game.OBJECT_TEXTRA_ALICE.getImageFrom(48, 0, 16, 16), CollidableWallObject.ImageBase.TYPE_3),
				new CollidableWallObject(125, 500, 150, 100, ObjectType.WALL, Game.OBJECT_TEXTRA_ALICE.getImageFrom(64, 0, 16, 16), CollidableWallObject.ImageBase.TYPE_1),
				new CollidableWallObject(25, 100, 100, 100, ObjectType.WALL, Game.OBJECT_TEXTRA_ALICE.getImageFrom(80, 0, 16, 16), CollidableWallObject.ImageBase.TYPE_4),
				new CollidableObject(100, 175, 170, 100, ObjectType.WOOD_1, Game.OBJECT_TEXTRA_ALICE.getImageFrom(96, 0, 16, 16)),
				new CollidableObject(100, 275, 170, 100, ObjectType.WOOD_1, Game.OBJECT_TEXTRA_ALICE.getImageFrom(96, 0, 16, 16)),
				new CollidableObject(100, 375, 170, 100, ObjectType.WOOD_1, Game.OBJECT_TEXTRA_ALICE.getImageFrom(96, 0, 16, 16)),
				new CollidableObject(100, 475, 170, 50, ObjectType.WOOD_1, Game.OBJECT_TEXTRA_ALICE.getImageFrom(96, 0, 16, 16))
				
				
			},
			
			{
				
				new ChangeMapCollidableObject(0, (int) (Game.HEIGHT - 85), 64, 64, ObjectType.LAST_MAP, Game.OBJECT_TEXTRA_ALICE.getImageFrom(128, 0, 16, 16), 0),
				new ChangeMapCollidableObject((int) (Game.WIDTH - 64), 0, 64, 64, ObjectType.NEXT_MAP, Game.OBJECT_TEXTRA_ALICE.getImageFrom(112, 0, 16, 16), 2),
				new TextSignObject(256, 128, 128, 128, ObjectType.SIGN_1, Game.OBJECT_TEXTRA_ALICE.getImageFrom(144, 0, 16, 16), "This is a sign!", new Color(0x000000), new Font("Verdana", Font.PLAIN, 16), 10, 32),
				new CollidableObject(100, 300, 128, 128, ObjectType.TREE_1, Game.OBJECT_TEXTRA_ALICE.getImageFrom(160, 0, 16, 16))
				
			},
			
			{
				
				new ChangeMapCollidableObject((int) (Game.WIDTH - 64), 0, 64, 64, ObjectType.NEXT_MAP, Game.OBJECT_TEXTRA_ALICE.getImageFrom(112, 0, 16, 16), 3),
				new ChangeMapCollidableObject(0, (int) (Game.HEIGHT - 85), 64, 64, ObjectType.LAST_MAP, Game.OBJECT_TEXTRA_ALICE.getImageFrom(128, 0, 16, 16), 1),
				new CollidableObject(100, 25, 256, 256, ObjectType.HOUSE_1, Game.HOUSE_1_IMAGE_LOADER.getImage()),
				new CollidableObject(75, 240, 128, 128, ObjectType.APPLE_TREE_1, Game.OBJECT_TEXTRA_ALICE.getImageFrom(176, 0, 16, 16)),
				new TextSignObject(500, 128, 128, 128, ObjectType.SIGN_1, Game.OBJECT_TEXTRA_ALICE.getImageFrom(144, 0, 16, 16), "Village", new Color(0x000000), new Font("Verdana", Font.PLAIN, 16), 35, 32)
				
			},
			
			{
				
				new ChangeMapCollidableObject((int) (Game.WIDTH - 64), 0, 64, 64, ObjectType.NEXT_MAP, Game.OBJECT_TEXTRA_ALICE.getImageFrom(112, 0, 16, 16), 4),
				new ChangeMapCollidableObject(0, (int) (Game.HEIGHT - 85), 64, 64, ObjectType.LAST_MAP, Game.OBJECT_TEXTRA_ALICE.getImageFrom(128, 0, 16, 16), 2),
				new CollidableObject(100, 25, 256, 256, ObjectType.HOUSE_1, Game.HOUSE_1_IMAGE_LOADER.getImage()),
				new CollidableObject(75, 240, 128, 128, ObjectType.APPLE_TREE_1, Game.OBJECT_TEXTRA_ALICE.getImageFrom(176, 0, 16, 16)),
				new CollidableObject(400, 25, 256, 256, ObjectType.HOUSE_1, Game.HOUSE_1_IMAGE_LOADER.getImage())
				
			},
			
			{
				
				new ChangeMapCollidableObject((int) (Game.WIDTH - 64), 0, 64, 64, ObjectType.NEXT_MAP, Game.OBJECT_TEXTRA_ALICE.getImageFrom(112, 0, 16, 16), 5),
				new ChangeMapCollidableObject(0, (int) (Game.HEIGHT - 85), 64, 64, ObjectType.LAST_MAP, Game.OBJECT_TEXTRA_ALICE.getImageFrom(128, 0, 16, 16), 3),
				new CollidableObject(100, 25, 256, 256, ObjectType.HOUSE_1, Game.HOUSE_1_IMAGE_LOADER.getImage()),
				new CollidableObject(75, 240, 128, 128, ObjectType.APPLE_TREE_1, Game.OBJECT_TEXTRA_ALICE.getImageFrom(176, 0, 16, 16)),
				new CollidableObject(400, 25, 256, 256, ObjectType.HOUSE_1, Game.HOUSE_1_IMAGE_LOADER.getImage())
				
			},
			
			{
				
				new ChangeMapCollidableObject((int) (Game.WIDTH - 64), 0, 64, 64, ObjectType.NEXT_MAP, Game.OBJECT_TEXTRA_ALICE.getImageFrom(112, 0, 16, 16), 6),
				new ChangeMapCollidableObject(0, (int) (Game.HEIGHT - 85), 64, 64, ObjectType.LAST_MAP, Game.OBJECT_TEXTRA_ALICE.getImageFrom(128, 0, 16, 16), 4),
				new CollidableObject(100, 25, 256, 256, ObjectType.HOUSE_1, Game.HOUSE_1_IMAGE_LOADER.getImage()),
				new CollidableObject(75, 240, 128, 128, ObjectType.APPLE_TREE_1, Game.OBJECT_TEXTRA_ALICE.getImageFrom(176, 0, 16, 16)),
				new CollidableObject(400, 25, 256, 256, ObjectType.HOUSE_1, Game.HOUSE_1_IMAGE_LOADER.getImage())
				
			},
			
			{
				
				new ChangeMapCollidableObject((int) (Game.WIDTH - 64), 0, 64, 64, ObjectType.NEXT_MAP, Game.OBJECT_TEXTRA_ALICE.getImageFrom(112, 0, 16, 16), 7),
				new ChangeMapCollidableObject(0, (int) (Game.HEIGHT - 85), 64, 64, ObjectType.LAST_MAP, Game.OBJECT_TEXTRA_ALICE.getImageFrom(128, 0, 16, 16), 5),
				new CollidableObject(0, 0, 64, 64, ObjectType.IRON_ORE_1, Game.OBJECT_TEXTRA_ALICE.getImageFrom(224, 0, 16, 16)),
				new CollidableObject(64, 0, 64, 64, ObjectType.GOLD_ORE_1, Game.OBJECT_TEXTRA_ALICE.getImageFrom(240, 0, 16, 16)),
				new CollidableObject(0, 64, 64, 64, ObjectType.DIAMOND_ORE_1, Game.OBJECT_TEXTRA_ALICE.getImageFrom(256, 0, 16, 16)),
				new CollidableObject(64, 64, 64, 64, ObjectType.STONE_1, Game.OBJECT_TEXTRA_ALICE.getImageFrom(208, 0, 16, 16)),
				new CollidableObject(128, 0, 64, 64, ObjectType.STONE_1, Game.OBJECT_TEXTRA_ALICE.getImageFrom(208, 0, 16, 16)),
				new CollidableObject(0, 128, 64, 64, ObjectType.STONE_1, Game.OBJECT_TEXTRA_ALICE.getImageFrom(208, 0, 16, 16)),
				new CollidableObject(400, 25, 256, 256, ObjectType.HOUSE_1, Game.HOUSE_1_IMAGE_LOADER.getImage())
				
			},
			
			{
				
				new ChangeMapCollidableObject(0, (int) (Game.HEIGHT - 85), 64, 64, ObjectType.LAST_MAP, Game.OBJECT_TEXTRA_ALICE.getImageFrom(128, 0, 16, 16), 6),
				new CollidableObject(100, 25, 256, 256, ObjectType.HOUSE_1, Game.HOUSE_1_IMAGE_LOADER.getImage()),
				new CollidableObject(400, 25, 256, 256, ObjectType.HOUSE_1, Game.HOUSE_1_IMAGE_LOADER.getImage())
				
			}
			
	};
	
	public static final GameVersion VERSION = new GameVersion("Pre-0.0.0.2.0");
	
	public static Player PLAYER = new Player((float) ((float) (Game.WIDTH / 2) - 64), (float) ((float) (Game.HEIGHT / 2) - 64), 0f, 0f, 64, 64, EntityID.PLAYER, Game.PLAYER_TEXTRA_ALICE.getImageFrom(0, 0, 16, 16));
	public static HUD HUD = new HUD();
	public static MapHandler MAP_HANDLER = new MapHandler();
	
	
	public Game(String title) {
		
		this.frame = new JFrame();
		this.gamePanel = new GamePanel();
		
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setLocationRelativeTo(null);
		this.frame.setSize(Game.WIDTH, Game.HEIGHT);
		this.frame.setTitle(title);
		this.frame.setResizable(false);
		this.frame.setLayout(null);
		
		
		this.gamePanel.setBounds(0, 0, Game.WIDTH, Game.HEIGHT);
		this.frame.add(this.gamePanel);
		
		
		
		this.frame.setVisible(true);
		
		this.gamePanel.startGameLoop();
		
	}
	
	public static int clamp(int var, int max, int min) {
		if (var >= max) {
			return max;
		} else if (var <= min) {
			return min;
		} else {
			return var;
		}
	}
	
	public static float clamp(float var, float max, float min) {
		if (var >= max) {
			return max;
		} else if (var <= min) {
			return min;
		} else {
			return var;
		}
	}
	
	public static double clamp(double var, double max, double min) {
		if (var >= max) {
			return max;
		} else if (var <= min) {
			return min;
		} else {
			return var;
		}
	}
	
	public static void resetPlayerPosToCenter() {
		
		Game.PLAYER.setXv(0f);
		Game.PLAYER.setX((float) ((float) (Game.WIDTH / 2) - 64));
		
		
		Game.PLAYER.setYv(0f);
		Game.PLAYER.setY((float) ((float) (Game.HEIGHT / 2) - 64));
		
		
	}
	
	public static Rectangle getRectangle(int x, int y, int width, int height) {
		
		return new Rectangle(x, y, width, height);
		
	}
	
	public static void addItemEntity(float x, float y, Item<?> item, BufferedImage image, int size) {
		
		Game.MAP_HANDLER.currentMap().getEntityHandler().add(new ItemEntity(x, y, 0, 0, size, size, EntityID.ITEM, image, item));
		
	}
	
	public static float[] getRandomItemPos() {
		
		Random random = new Random();
		
		float itemX = 0f;
		float itemY = 0f;
		
		final int OFFSET = 128;
		
		if (random.nextBoolean()) {
			
			itemX = (float) (Game.PLAYER.getX() + random.nextInt((int) (OFFSET + 1)));
			
		} else {
			
			itemX = (float) (Game.PLAYER.getX() + (float) (random.nextInt((int) (OFFSET + 1)) * -1f));
			
		}
		
		if (random.nextBoolean()) {
			
			itemY = (float) (Game.PLAYER.getY() + random.nextInt((int) (OFFSET + 1)));
			
		} else {
			
			itemY = (float) (Game.PLAYER.getY() + (float) (random.nextInt((int) (OFFSET + 1)) * -1f));
			
		}
		
		float[] res = {itemX, itemY};
		
		return res;
		
	}
	
	public static float[] getRandomItemPos(float x, float y) {
		
		Random random = new Random();
		
		float itemX = 0f;
		float itemY = 0f;
		
		final int OFFSET = 128;
		
		if (random.nextBoolean()) {
			
			itemX = (float) (x + random.nextInt((int) (OFFSET + 1)));
			
		} else {
			
			itemX = (float) (x + (float) (random.nextInt((int) (OFFSET + 1)) * -1f));
			
		}
		
		if (random.nextBoolean()) {
			
			itemY = (float) (y + random.nextInt((int) (OFFSET + 1)));
			
		} else {
			
			itemY = (float) (y + (float) (random.nextInt((int) (OFFSET + 1)) * -1f));
			
		}
		
		float[] res = {itemX, itemY};
		
		return res;
		
	}
	
	public static void makeItemAtRandomWithItem(Item<?> item) {
		
		float[] pos = Game.getRandomItemPos();
		
		Game.MAP_HANDLER.currentMap().getEntityHandler().add(new ItemEntity(pos[0], pos[1], 0, 0, 64, 64, EntityID.ITEM, item.getImage(), item));
		
	}
	
	public static void makeItemAtRandomWithItem(Item<?> item, float x, float y) {
		
		float[] pos = Game.getRandomItemPos(x, y);
		
		Game.MAP_HANDLER.currentMap().getEntityHandler().add(new ItemEntity(pos[0], pos[1], 0, 0, 64, 64, EntityID.ITEM, item.getImage(), item));
		
	}
	
	public static void save() {
		
		JFileChooser fileChooser = new JFileChooser();
		
		int res = fileChooser.showSaveDialog(null);
		
		if (res == JFileChooser.APPROVE_OPTION) {
			
			File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
			
			try {
				
				SavingGame.saveGame(file.getPath());
				
			} catch (IOException e) {
				
				e.printStackTrace();
				
			}
			
		}
		
	}

	public static void load() {
		
		JFileChooser fileChooser = new JFileChooser();
		
		int res = fileChooser.showOpenDialog(null);
		
		if (res == JFileChooser.APPROVE_OPTION) {
			
			File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
			
			try {
				
				SaveableObject obj = SavingGame.loadGame(file.getPath());
				
				if (obj.getVersionHashcode() == Game.VERSION.hashCode()) {
					
					Game.MAP_HANDLER = obj.getMapHandler();
					Game.PLAYER = obj.getPlayer();
					
					Game.fixAllImages();
					
				} else {
					
					JOptionPane.showMessageDialog(null, "Can not load a save file from " + obj.getVersion().getVersion() + " in " + Game.VERSION.getVersion(), "Error", JOptionPane.ERROR_MESSAGE);
					
				}
				
			} catch (ClassNotFoundException | IOException e) {
				
				e.printStackTrace();
				
			} catch (NotEnoughInformationToRestoreImageException e) {
				
				System.out.println(e.toString());
				
			}
			
		}
		
	}

	public static void fixImagesForCurrentMap(Map map) throws NotEnoughInformationToRestoreImageException {
		
		Game.PLAYER.setImage(Game.PLAYER_TEXTRA_ALICE.getImageFrom(0, 0, 16, 16));
		
		for (int i = 0; i < Game.PLAYER.getHotbar().list.length; i++) {
			
			Item<?> item =  Game.PLAYER.getHotbar().list[i];
			
			if (item == null) continue;
			
			switch (item.getId()) {
			
				case AXE_1:
					item.setImage(Game.ITEM_TEXTRA_ALICE.getImageFrom(0, 0, 16, 16));
					break;
					
				case PIE_1:
					item.setImage(Game.ITEM_TEXTRA_ALICE.getImageFrom(80, 0, 16, 16));
					break;
					
				case APPLE_1:
					item.setImage(Game.ITEM_TEXTRA_ALICE.getImageFrom(64, 0, 16, 16));
					break;
					
				case APPLE_TREE_1:
					item.setImage(Game.ITEM_TEXTRA_ALICE.getImageFrom(48, 0, 16, 16));
					break;
					
				case TACO_1:
					item.setImage(Game.ITEM_TEXTRA_ALICE.getImageFrom(96, 0, 16, 16));
					break;
					
				case TREE_1:
					item.setImage(Game.ITEM_TEXTRA_ALICE.getImageFrom(32, 0, 16, 16));
					break;
					
				case WOOD_1:
					item.setImage(Game.ITEM_TEXTRA_ALICE.getImageFrom(16, 0, 16, 16));
					break;
					
				case CHEST_1:
					item.setImage(Game.ITEM_TEXTRA_ALICE.getImageFrom(112, 0, 16, 16));
					break;
					
				case SIGN_1:
					item.setImage(Game.ITEM_TEXTRA_ALICE.getImageFrom(128, 0, 16, 16));
					break;
					
				case PICKAXE_1:
					item.setImage(Game.ITEM_TEXTRA_ALICE.getImageFrom(144, 0, 16, 16));
					break;
					
				case STONE_1:
					item.setImage(Game.ITEM_TEXTRA_ALICE.getImageFrom(160, 0, 16, 16));
					break;
					
				case IRON_ORE_1:
					item.setImage(Game.ITEM_TEXTRA_ALICE.getImageFrom(176, 0, 16, 16));
					break;
					
				case GOLD_ORE_1:
					item.setImage(Game.ITEM_TEXTRA_ALICE.getImageFrom(192, 0, 16, 16));
					break;
					
				case DIAMOND_ORE_1:
					item.setImage(Game.ITEM_TEXTRA_ALICE.getImageFrom(208, 0, 16, 16));
					break;
					
				case ORANGE_JUCE_1:
					item.setImage(Game.ITEM_TEXTRA_ALICE.getImageFrom(224, 0, 16, 16));
					break;
				
				case BANANA_1:
					item.setImage(Game.ITEM_TEXTRA_ALICE.getImageFrom(240, 0, 16, 16));
					break;
					
				case HEART_1:
					item.setImage(Game.ITEM_TEXTRA_ALICE.getImageFrom(272, 0, 16, 16));
					break;
					
				case MEDKIT_1:
					item.setImage(Game.ITEM_TEXTRA_ALICE.getImageFrom(256, 0, 16, 16));
					break;
			
			}
			
		}
		
		for (int i = 0; i < map.getEntityHandler().getList().size(); i++) {
			
			Entity e = map.getEntityHandler().get(i);
			
			switch (e.getId()) {
			
				case PLAYER:
					break;
				
				case VILAGER:
					e.setImage(Game.VILAGER_TEXTRA_ALICE.getImageFrom(0, 0, 16, 16));
					break;
					
				case ITEM:
					
					if (e instanceof ItemEntity) {
						
						Item<?> item = ((ItemEntity) e).getItem();
						
						switch (item.getId()) {
						
							case AXE_1:
								item.setImage(Game.ITEM_TEXTRA_ALICE.getImageFrom(0, 0, 16, 16));
								break;
								
							case PIE_1:
								item.setImage(Game.ITEM_TEXTRA_ALICE.getImageFrom(80, 0, 16, 16));
								break;
								
							case APPLE_1:
								item.setImage(Game.ITEM_TEXTRA_ALICE.getImageFrom(64, 0, 16, 16));
								break;
								
							case APPLE_TREE_1:
								item.setImage(Game.ITEM_TEXTRA_ALICE.getImageFrom(48, 0, 16, 16));
								break;
								
							case TACO_1:
								item.setImage(Game.ITEM_TEXTRA_ALICE.getImageFrom(96, 0, 16, 16));
								break;
								
							case TREE_1:
								item.setImage(Game.ITEM_TEXTRA_ALICE.getImageFrom(32, 0, 16, 16));
								break;
								
							case WOOD_1:
								item.setImage(Game.ITEM_TEXTRA_ALICE.getImageFrom(16, 0, 16, 16));
								break;
								
							case CHEST_1:
								item.setImage(Game.ITEM_TEXTRA_ALICE.getImageFrom(112, 0, 16, 16));
								break;
								
							case SIGN_1:
								item.setImage(Game.ITEM_TEXTRA_ALICE.getImageFrom(128, 0, 16, 16));
								break;
								
							case PICKAXE_1:
								item.setImage(Game.ITEM_TEXTRA_ALICE.getImageFrom(144, 0, 16, 16));
								break;
								
							case STONE_1:
								item.setImage(Game.ITEM_TEXTRA_ALICE.getImageFrom(160, 0, 16, 16));
								break;
								
							case IRON_ORE_1:
								item.setImage(Game.ITEM_TEXTRA_ALICE.getImageFrom(176, 0, 16, 16));
								break;
								
							case GOLD_ORE_1:
								item.setImage(Game.ITEM_TEXTRA_ALICE.getImageFrom(192, 0, 16, 16));
								break;
								
							case DIAMOND_ORE_1:
								item.setImage(Game.ITEM_TEXTRA_ALICE.getImageFrom(208, 0, 16, 16));
								break;
								
							case ORANGE_JUCE_1:
								item.setImage(Game.ITEM_TEXTRA_ALICE.getImageFrom(224, 0, 16, 16));
								break;
							
							case BANANA_1:
								item.setImage(Game.ITEM_TEXTRA_ALICE.getImageFrom(240, 0, 16, 16));
								break;
								
							case HEART_1:
								item.setImage(Game.ITEM_TEXTRA_ALICE.getImageFrom(272, 0, 16, 16));
								break;
								
							case MEDKIT_1:
								item.setImage(Game.ITEM_TEXTRA_ALICE.getImageFrom(256, 0, 16, 16));
								break;
							
					
						}
						
						e.setImage(item.getImage());
						
						((ItemEntity) e).setItem(item);
						
					}
					
					break;
					
				case BIRD:
					e.setImage(Game.BIRD_TEXTRA_ALICE.getImageFrom(0, 0, 16, 16));
					break;
					
				case ITEM_PLANE:
					e.setImage(Game.PLANE_TEXTRA_ALICE.getImageFrom(16, 0, 16, 16));
					break;
					
				case ITEM_PLANE_FALLING_CHEST:
					e.setImage(Game.OBJECT_TEXTRA_ALICE.getImageFrom(16, 0, 16, 16));
					break;
			
			}
			
		}
		
		for (int i = 0; i < map.getObjectList().size(); i++) {
			
			CollisionObject o = map.getObject(i);
			
			switch (o.getType()) {
			
				case APPLE_TREE_1:
					o.setImage(Game.OBJECT_TEXTRA_ALICE.getImageFrom(176, 0, 16, 16));
					break;
					
				case HOUSE_1:
					o.setImage(Game.HOUSE_1_IMAGE_LOADER.getImage());
					break;
					
				case LAST_MAP:
					o.setImage(Game.OBJECT_TEXTRA_ALICE.getImageFrom(128, 0, 16, 16));
					break;
					
				case NEXT_MAP:
					o.setImage(Game.OBJECT_TEXTRA_ALICE.getImageFrom(112, 0, 16, 16));
					break;
					
				case OBJECT:
					throw new NotEnoughInformationToRestoreImageException("Can not restore image from: " + o.toString());
					
				case SIGN_1:
					o.setImage(Game.OBJECT_TEXTRA_ALICE.getImageFrom(144, 0, 16, 16));
					break;
					
				case TREE_1:
					o.setImage(Game.OBJECT_TEXTRA_ALICE.getImageFrom(160, 0, 16, 16));
					break;
					
				case WOOD_1:
					o.setImage(Game.OBJECT_TEXTRA_ALICE.getImageFrom(96, 0, 16, 16));
					break;
					
				case WALL:
					
					if (o instanceof CollidableWallObject) {
						
						BufferedImage image = ((CollidableWallObject) o).getImageType().getIMAGE();
						
						o.setImage(image);
						
					}
					break;
					
				case CHEST:
					o.setImage(Game.OBJECT_TEXTRA_ALICE.getImageFrom(16, 0, 16, 16));
					break;
					
				case STONE_1:
					o.setImage(Game.OBJECT_TEXTRA_ALICE.getImageFrom(208, 0, 16, 16));
					break;
					
				case IRON_ORE_1:
					o.setImage(Game.OBJECT_TEXTRA_ALICE.getImageFrom(224, 0, 16, 16));
					break;
					
				case GOLD_ORE_1:
					o.setImage(Game.OBJECT_TEXTRA_ALICE.getImageFrom(240, 0, 16, 16));
					break;
					
				case DIAMOND_ORE_1:
					o.setImage(Game.OBJECT_TEXTRA_ALICE.getImageFrom(256, 0, 16, 16));
					break;
			
			}
			
		}
		
	}
	
	public static void fixAllImages() throws NotEnoughInformationToRestoreImageException {
		
		for (int i = 0; i < Game.MAP_HANDLER.getMAPS().size(); i++) {
			
			Game.fixImagesForCurrentMap(Game.MAP_HANDLER.getMAPS().get(i));
			
		}
		
	}
	
	public static void addEntity(Entity e) {
		
		Game.MAP_HANDLER.currentMap().getEntityHandler().add(e);
		
	}
	
	public static void removeEntity(Entity e) {
		
		Game.MAP_HANDLER.currentMap().getEntityHandler().remove(e);
		
	}
	
	public static void addObject(CollisionObject o) {
		
		Game.MAP_HANDLER.currentMap().addObject(o);
		
	}

	public static void reset() {
		
		Game.MAP_HANDLER = new MapHandler();
		Game.PLAYER = new Player((float) ((float) (Game.WIDTH / 2) - 64), (float) ((float) (Game.HEIGHT / 2) - 64), 0f, 0f, 64, 64, EntityID.PLAYER, Game.PLAYER_TEXTRA_ALICE.getImageFrom(0, 0, 16, 16));
		
		Game.MAP_HANDLER.addMap(new Map(Game.BASE_MAPS[0]));
		Game.MAP_HANDLER.addMap(new Map(Game.BASE_MAPS[1]));
		Game.MAP_HANDLER.addMap(new Map(Game.BASE_MAPS[2]));
		Game.MAP_HANDLER.addMap(new Map(Game.BASE_MAPS[3]));
		Game.MAP_HANDLER.addMap(new Map(Game.BASE_MAPS[4]));
		Game.MAP_HANDLER.addMap(new Map(Game.BASE_MAPS[5]));
		Game.MAP_HANDLER.addMap(new Map(Game.BASE_MAPS[6]));
		Game.MAP_HANDLER.addMap(new Map(Game.BASE_MAPS[7]));
		
		Stack<Item<?>> itemsForFistChest = new Stack<Item<?>>();
		
		itemsForFistChest.push(new PickaxeItem(1, ItemID.PICKAXE_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(144, 0, 16, 16)));
		
		Game.MAP_HANDLER.get(0).addObject(new ChestTransparentObject(126, 184, 64, 64, ObjectType.CHEST, Game.OBJECT_TEXTRA_ALICE.getImageFrom(16, 0, 16, 16), itemsForFistChest));
		
		Game.MAP_HANDLER.get(2).getEntityHandler().add(new VillagerEntity(200, 200, 0, 0, 64, 64, EntityID.VILAGER, Game.VILAGER_TEXTRA_ALICE.getImageFrom(0, 0, 16, 16), VillagerTrades.WOOD_TO_COIN));
		
		Game.MAP_HANDLER.get(3).getEntityHandler().add(new VillagerEntity(200, 200, 0, 0, 64, 64, EntityID.VILAGER, Game.VILAGER_TEXTRA_ALICE.getImageFrom(0, 0, 16, 16), VillagerTrades.COIN_TO_TACO));
		Game.MAP_HANDLER.get(3).getEntityHandler().add(new VillagerEntity(500, 200, 0, 0, 64, 64, EntityID.VILAGER, Game.VILAGER_TEXTRA_ALICE.getImageFrom(0, 0, 16, 16), VillagerTrades.APPLE_TO_COIN));
		
		Game.MAP_HANDLER.get(4).getEntityHandler().add(new VillagerEntity(200, 200, 0, 0, 64, 64, EntityID.VILAGER, Game.VILAGER_TEXTRA_ALICE.getImageFrom(0, 0, 16, 16), VillagerTrades.COIN_TO_PIE));
		Game.MAP_HANDLER.get(4).getEntityHandler().add(new VillagerEntity(500, 200, 0, 0, 64, 64, EntityID.VILAGER, Game.VILAGER_TEXTRA_ALICE.getImageFrom(0, 0, 16, 16), VillagerTrades.STONE_TO_COIN));
		
		Game.MAP_HANDLER.get(5).getEntityHandler().add(new VillagerEntity(200, 200, 0, 0, 64, 64, EntityID.VILAGER, Game.VILAGER_TEXTRA_ALICE.getImageFrom(0, 0, 16, 16), VillagerTrades.COIN_TO_CHEST));
		Game.MAP_HANDLER.get(5).getEntityHandler().add(new VillagerEntity(500, 200, 0, 0, 64, 64, EntityID.VILAGER, Game.VILAGER_TEXTRA_ALICE.getImageFrom(0, 0, 16, 16), VillagerTrades.WOOD_TO_SIGN));
		
		Game.MAP_HANDLER.get(6).getEntityHandler().add(new VillagerEntity(500, 200, 0, 0, 64, 64, EntityID.VILAGER, Game.VILAGER_TEXTRA_ALICE.getImageFrom(0, 0, 16, 16), VillagerTrades.IRON_ORE_TO_COIN));
		
		Game.MAP_HANDLER.get(7).getEntityHandler().add(new VillagerEntity(200, 200, 0, 0, 64, 64, EntityID.VILAGER, Game.VILAGER_TEXTRA_ALICE.getImageFrom(0, 0, 16, 16), VillagerTrades.GOLD_ORE_TO_COIN));
		Game.MAP_HANDLER.get(7).getEntityHandler().add(new VillagerEntity(500, 200, 0, 0, 64, 64, EntityID.VILAGER, Game.VILAGER_TEXTRA_ALICE.getImageFrom(0, 0, 16, 16), VillagerTrades.DIAMOND_ORE_TO_COIN));
		
	}

	public static <L, O> boolean arrayContains(L[] list, O thing) {
		
		boolean has = false;
		
		for (int i = 0; i < list.length; i++) {
			
			if (thing == null && list[i] == thing) {
				
				has = true;
				
				break;
				
			} else if (thing != null && list[i] != null && list[i].getClass() == thing.getClass()) {
				
				has = true;
				
				break;
				
			}
			
		}
		
		return has;
		
	}
	
	public static boolean touchingSomething(Rectangle rect) {
		
		LinkedList<CollisionObject> tempList = Game.MAP_HANDLER.currentMap().getObjectList();
		
		for (int i = 0; i < tempList.size(); i++) {
			
			CollisionObject tempObj = tempList.get(i);
			
			if (
					rect.intersects(tempObj.getRectangle()) &&
					!tempObj.getType().isTRANSPARENT()
				) {
				
				return true;
				
			}
			
		}
		
		return false;
		
	}
	
	public static void addItemOrItemEntity(Item<?> item) {
		
		if (!Game.PLAYER.getHotbar().returnBooleanAndAddItem(item)) {
			
			float[] pos = Game.getRandomItemPos();
			
			Game.addItemEntity(pos[0], pos[1], item, item.getImage(), 64);
			
		}
		
	}
	
}
