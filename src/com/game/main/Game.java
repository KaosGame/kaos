package com.game.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.game.collision.objects.ChestTransparentObject;
import com.game.collision.objects.CollidableObject;
import com.game.collision.objects.CollidableWallObject;
import com.game.collision.objects.LastMapCollidableObject;
import com.game.collision.objects.LavaTransparentCollisionObject;
import com.game.collision.objects.NextRandomMapCollisionObject;
import com.game.collision.objects.StartMonsterLeathFightCollidableObject;
import com.game.collision.objects.TextSignObject;
import com.game.collision.objects.WaterTransparentCollisionObject;
import com.game.collision.objects.base.CollisionObject;
import com.game.collision.objects.base.ObjectType;
import com.game.display.HUD;
import com.game.display.components.GamePanel;
import com.game.entities.AxolotlEntity;
import com.game.entities.BombEntity;
import com.game.entities.ItemEntity;
import com.game.entities.bad.zombie.WarZombie;
import com.game.entities.base.Entity;
import com.game.entities.base.EntityID;
import com.game.entities.player.Player;
import com.game.entities.player.items.base.Item;
import com.game.entities.player.items.potions.base.PotionItem;
import com.game.entities.vilagers.VillagerEntity;
import com.game.entities.vilagers.VillagerTrades;
import com.game.exceptions.image.restoring.NotEnoughInformationToRestoreImageException;
import com.game.logging.LogType;
import com.game.logging.Logger;
import com.game.maps.DimensionHandler;
import com.game.maps.DimensionID;
import com.game.maps.Map;
import com.game.maps.MapHandler;
import com.game.random.RandomGen;
import com.game.saving.GameVersion;
import com.game.saving.SaveableObject;
import com.game.saving.SavingGame;
import com.game.sound.Sound;
import com.game.sound.Sounds;
import com.game.textures.BufferedImageLoader;
import com.game.textures.TextraAlice;

public class Game {
	
	private JFrame frame;
	private GamePanel gamePanel;
	
	public static final int WIDTH = 820;
	public static final int HEIGHT = 724;
	
	private static BufferedImageLoader OBJECT_TEXTRA_ALICE_LOADER = new BufferedImageLoader("/assets/images/object-textra-alice.png");
	private static BufferedImageLoader PLAYER_TEXTRA_ALICE_LOADER = new BufferedImageLoader("/assets/images/entities/player-textra-alice.png");
	private static BufferedImageLoader VILAGER_TEXTRA_ALICE_LOADER = new BufferedImageLoader("/assets/images/entities/vilager-textra-alice.png");
	private static BufferedImageLoader BIRD_TEXTRA_ALICE_LOADER = new BufferedImageLoader("/assets/images/entities/bird-textra-alice.png");
	private static BufferedImageLoader PLANE_TEXTRA_ALICE_LOADER = new BufferedImageLoader("/assets/images/entities/plane-textra-alice.png");
	private static BufferedImageLoader ZOMBIE_TEXTRA_ALICE_LOADER = new BufferedImageLoader("/assets/images/entities/zombie-textra-alice.png");
	private static BufferedImageLoader AXOLOTL_TEXTRA_ALICE_LOADER = new BufferedImageLoader("/assets/images/entities/axolotl-textra-alice.png");
	private static BufferedImageLoader HOTBAR_TEXTRA_ALICE_LOADER = new BufferedImageLoader("/assets/images/hud/hotbar/hotbar-textra-alice.png");
	private static BufferedImageLoader ITEM_TEXTRA_ALICE_LOADER = new BufferedImageLoader("/assets/images/item-textra-alice.png");
	private static BufferedImageLoader STAT_TEXTRA_ALICE_LOADER = new BufferedImageLoader("/assets/images/stat-textra-alice.png");
	private static BufferedImageLoader EFFECT_TEXTRA_ALICE_LOADER = new BufferedImageLoader("/assets/images/effect-textra-alice.png");
	private static BufferedImageLoader BOMB_TEXTRA_ALICE_LOADER = new BufferedImageLoader("/assets/images/entities/bomb-textra-alice.png");
	private static BufferedImageLoader PARTICLE_TEXTRA_ALICE_LOADER = new BufferedImageLoader("/assets/images/particle-textra-alice.png"); 
	
	public static BufferedImageLoader HOUSE_1_IMAGE_LOADER = new BufferedImageLoader("/assets/images/objects/house_1.png");
	public static BufferedImageLoader PAUSE_1_IMAGE_LOADER = new BufferedImageLoader("/assets/images/hud/pause.png");
	public static BufferedImageLoader BULLET_1_IMAGE_LOADER = new BufferedImageLoader("/assets/images/entities/bullet.png");
	public static BufferedImageLoader MONSTER_LEATH_IMAGE_LOADER = new BufferedImageLoader("/assets/images/entities/monster-leath.png");
	
	public static TextraAlice OBJECT_TEXTRA_ALICE = new TextraAlice(Game.OBJECT_TEXTRA_ALICE_LOADER.getImage());
	public static TextraAlice PLAYER_TEXTRA_ALICE = new TextraAlice(Game.PLAYER_TEXTRA_ALICE_LOADER.getImage());
	public static TextraAlice HOTBAR_TEXTRA_ALICE = new TextraAlice(Game.HOTBAR_TEXTRA_ALICE_LOADER.getImage());
	public static TextraAlice ITEM_TEXTRA_ALICE = new TextraAlice(Game.ITEM_TEXTRA_ALICE_LOADER.getImage());
	public static TextraAlice VILAGER_TEXTRA_ALICE = new TextraAlice(Game.VILAGER_TEXTRA_ALICE_LOADER.getImage());
	public static TextraAlice BIRD_TEXTRA_ALICE = new TextraAlice(Game.BIRD_TEXTRA_ALICE_LOADER.getImage());
	public static TextraAlice PLANE_TEXTRA_ALICE = new TextraAlice(Game.PLANE_TEXTRA_ALICE_LOADER.getImage());
	public static TextraAlice ZOMBIE_TEXTRA_ALICE = new TextraAlice(Game.ZOMBIE_TEXTRA_ALICE_LOADER.getImage());
	public static TextraAlice AXOLOTL_TEXTRA_ALICE = new TextraAlice(Game.AXOLOTL_TEXTRA_ALICE_LOADER.getImage());
	public static TextraAlice STAT_TEXTRA_ALICE = new TextraAlice(Game.STAT_TEXTRA_ALICE_LOADER.getImage());
	public static TextraAlice EFFECT_TEXTRA_ALICE = new TextraAlice(Game.EFFECT_TEXTRA_ALICE_LOADER.getImage());
	public static TextraAlice BOMB_TEXTRA_ALICE = new TextraAlice(Game.BOMB_TEXTRA_ALICE_LOADER.getImage());
	public static TextraAlice PARTICLE_TEXTRA_ALICE = new TextraAlice(Game.PARTICLE_TEXTRA_ALICE_LOADER.getImage());
	
	public static CollisionObject[] HOME_MAP_HOME = {
			
			
			new NextRandomMapCollisionObject((int) (Game.WIDTH - 64), 0, 64, 64, ObjectType.NEXT_MAP, Game.OBJECT_TEXTRA_ALICE.getImageFrom(112, 0, 16, 16)),
			new CollidableWallObject(125, 81, 135, 100, ObjectType.WALL, Game.OBJECT_TEXTRA_ALICE.getImageFrom(64, 0, 16, 16), CollidableWallObject.ImageBase.TYPE_1),
			new CollidableWallObject(25, 200, 100, 300, ObjectType.WALL, Game.OBJECT_TEXTRA_ALICE.getImageFrom(32, 0, 16, 16), CollidableWallObject.ImageBase.TYPE_2),
			new CollidableWallObject(25, 500, 100, 100, ObjectType.WALL, Game.OBJECT_TEXTRA_ALICE.getImageFrom(48, 0, 16, 16), CollidableWallObject.ImageBase.TYPE_3),
			new CollidableWallObject(125, 500, 150, 100, ObjectType.WALL, Game.OBJECT_TEXTRA_ALICE.getImageFrom(64, 0, 16, 16), CollidableWallObject.ImageBase.TYPE_1),
			new CollidableWallObject(25, 100, 100, 100, ObjectType.WALL, Game.OBJECT_TEXTRA_ALICE.getImageFrom(80, 0, 16, 16), CollidableWallObject.ImageBase.TYPE_4),
			new CollidableObject(100, 175, 170, 100, ObjectType.WOOD_1, Game.OBJECT_TEXTRA_ALICE.getImageFrom(96, 0, 16, 16)),
			new CollidableObject(100, 275, 170, 100, ObjectType.WOOD_1, Game.OBJECT_TEXTRA_ALICE.getImageFrom(96, 0, 16, 16)),
			new CollidableObject(100, 375, 170, 100, ObjectType.WOOD_1, Game.OBJECT_TEXTRA_ALICE.getImageFrom(96, 0, 16, 16)),
			new CollidableObject(100, 475, 170, 50, ObjectType.WOOD_1, Game.OBJECT_TEXTRA_ALICE.getImageFrom(96, 0, 16, 16))
			
			
	};
	
	public static CollisionObject[][] RANDOM_MAP_HOME = {
			
			{
				
				new NextRandomMapCollisionObject((int) (Game.WIDTH - 64), 0, 64, 64, ObjectType.NEXT_MAP, Game.OBJECT_TEXTRA_ALICE.getImageFrom(112, 0, 16, 16)),
				new LastMapCollidableObject(0, (int) (Game.HEIGHT - 85), 64, 64, ObjectType.LAST_MAP, Game.OBJECT_TEXTRA_ALICE.getImageFrom(128, 0, 16, 16)),
				new TextSignObject(256, 128, 128, 128, ObjectType.SIGN_1, Game.OBJECT_TEXTRA_ALICE.getImageFrom(144, 0, 16, 16), "This is a sign!", new Color(0x000000), 10, 32),
				new CollidableObject(100, 300, 128, 128, ObjectType.TREE_1, Game.OBJECT_TEXTRA_ALICE.getImageFrom(160, 0, 16, 16))
				
			},
			
			{
				
				new NextRandomMapCollisionObject((int) (Game.WIDTH - 64), 0, 64, 64, ObjectType.NEXT_MAP, Game.OBJECT_TEXTRA_ALICE.getImageFrom(112, 0, 16, 16)),
				new LastMapCollidableObject(0, (int) (Game.HEIGHT - 85), 64, 64, ObjectType.LAST_MAP, Game.OBJECT_TEXTRA_ALICE.getImageFrom(128, 0, 16, 16)),
				new CollidableObject(100, 25, 256, 256, ObjectType.HOUSE_1, Game.HOUSE_1_IMAGE_LOADER.getImage()),
				new CollidableObject(75, 240, 128, 128, ObjectType.APPLE_TREE_1, Game.OBJECT_TEXTRA_ALICE.getImageFrom(176, 0, 16, 16)),
				new TextSignObject(500, 128, 128, 128, ObjectType.SIGN_1, Game.OBJECT_TEXTRA_ALICE.getImageFrom(144, 0, 16, 16), "Village", new Color(0x000000), 35, 32)
				
			},
			
			{
				
				new NextRandomMapCollisionObject((int) (Game.WIDTH - 64), 0, 64, 64, ObjectType.NEXT_MAP, Game.OBJECT_TEXTRA_ALICE.getImageFrom(112, 0, 16, 16)),
				new LastMapCollidableObject(0, (int) (Game.HEIGHT - 85), 64, 64, ObjectType.LAST_MAP, Game.OBJECT_TEXTRA_ALICE.getImageFrom(128, 0, 16, 16)),
				new CollidableObject(100, 25, 256, 256, ObjectType.HOUSE_1, Game.HOUSE_1_IMAGE_LOADER.getImage()),
				new CollidableObject(75, 240, 128, 128, ObjectType.APPLE_TREE_1, Game.OBJECT_TEXTRA_ALICE.getImageFrom(176, 0, 16, 16)),
				new CollidableObject(400, 25, 256, 256, ObjectType.HOUSE_1, Game.HOUSE_1_IMAGE_LOADER.getImage())
				
			},
			
			{
				
				new NextRandomMapCollisionObject((int) (Game.WIDTH - 64), 0, 64, 64, ObjectType.NEXT_MAP, Game.OBJECT_TEXTRA_ALICE.getImageFrom(112, 0, 16, 16)),
				new LastMapCollidableObject(0, (int) (Game.HEIGHT - 85), 64, 64, ObjectType.LAST_MAP, Game.OBJECT_TEXTRA_ALICE.getImageFrom(128, 0, 16, 16)),
				new CollidableObject(100, 25, 256, 256, ObjectType.HOUSE_1, Game.HOUSE_1_IMAGE_LOADER.getImage()),
				new CollidableObject(75, 240, 128, 128, ObjectType.APPLE_TREE_1, Game.OBJECT_TEXTRA_ALICE.getImageFrom(176, 0, 16, 16)),
				new CollidableObject(400, 25, 256, 256, ObjectType.HOUSE_1, Game.HOUSE_1_IMAGE_LOADER.getImage()),
				new WaterTransparentCollisionObject((int) (Game.WIDTH - 64), (int) (Game.HEIGHT - 85), 64, 64, ObjectType.WATER, Game.OBJECT_TEXTRA_ALICE.getImageFrom(272, 0, 16, 16)),
				new LavaTransparentCollisionObject((int) (Game.WIDTH - 128), (int) (Game.HEIGHT - 85), 64, 64, ObjectType.LAVA, Game.OBJECT_TEXTRA_ALICE.getImageFrom(288, 0, 16, 16))
				
			},
			
			{
				
				new NextRandomMapCollisionObject((int) (Game.WIDTH - 64), 0, 64, 64, ObjectType.NEXT_MAP, Game.OBJECT_TEXTRA_ALICE.getImageFrom(112, 0, 16, 16)),
				new LastMapCollidableObject(0, (int) (Game.HEIGHT - 85), 64, 64, ObjectType.LAST_MAP, Game.OBJECT_TEXTRA_ALICE.getImageFrom(128, 0, 16, 16)),
				new CollidableObject(100, 25, 256, 256, ObjectType.HOUSE_1, Game.HOUSE_1_IMAGE_LOADER.getImage()),
				new CollidableObject(75, 240, 128, 128, ObjectType.APPLE_TREE_1, Game.OBJECT_TEXTRA_ALICE.getImageFrom(176, 0, 16, 16)),
				new CollidableObject(400, 25, 256, 256, ObjectType.HOUSE_1, Game.HOUSE_1_IMAGE_LOADER.getImage())
				
			},
			
			{
				
				new NextRandomMapCollisionObject((int) (Game.WIDTH - 64), 0, 64, 64, ObjectType.NEXT_MAP, Game.OBJECT_TEXTRA_ALICE.getImageFrom(112, 0, 16, 16)),
				new LastMapCollidableObject(0, (int) (Game.HEIGHT - 85), 64, 64, ObjectType.LAST_MAP, Game.OBJECT_TEXTRA_ALICE.getImageFrom(128, 0, 16, 16)),
				new CollidableObject(0, 0, 64, 64, ObjectType.IRON_ORE_1, Game.OBJECT_TEXTRA_ALICE.getImageFrom(224, 0, 16, 16)),
				new CollidableObject(64, 0, 64, 64, ObjectType.GOLD_ORE_1, Game.OBJECT_TEXTRA_ALICE.getImageFrom(240, 0, 16, 16)),
				new CollidableObject(0, 64, 64, 64, ObjectType.DIAMOND_ORE_1, Game.OBJECT_TEXTRA_ALICE.getImageFrom(256, 0, 16, 16)),
				new CollidableObject(64, 64, 64, 64, ObjectType.STONE_1, Game.OBJECT_TEXTRA_ALICE.getImageFrom(208, 0, 16, 16)),
				new CollidableObject(128, 0, 64, 64, ObjectType.STONE_1, Game.OBJECT_TEXTRA_ALICE.getImageFrom(208, 0, 16, 16)),
				new CollidableObject(0, 128, 64, 64, ObjectType.STONE_1, Game.OBJECT_TEXTRA_ALICE.getImageFrom(208, 0, 16, 16)),
				new CollidableObject(400, 25, 256, 256, ObjectType.HOUSE_1, Game.HOUSE_1_IMAGE_LOADER.getImage())
				
			},
			
			{
				
				new NextRandomMapCollisionObject((int) (Game.WIDTH - 64), 0, 64, 64, ObjectType.NEXT_MAP, Game.OBJECT_TEXTRA_ALICE.getImageFrom(112, 0, 16, 16)),
				new LastMapCollidableObject(0, (int) (Game.HEIGHT - 85), 64, 64, ObjectType.LAST_MAP, Game.OBJECT_TEXTRA_ALICE.getImageFrom(128, 0, 16, 16)),
				new CollidableObject(100, 25, 256, 256, ObjectType.HOUSE_1, Game.HOUSE_1_IMAGE_LOADER.getImage()),
				new CollidableObject(400, 25, 256, 256, ObjectType.HOUSE_1, Game.HOUSE_1_IMAGE_LOADER.getImage())
				
			},
			
			{
				
				new NextRandomMapCollisionObject((int) (Game.WIDTH - 64), 0, 64, 64, ObjectType.NEXT_MAP, Game.OBJECT_TEXTRA_ALICE.getImageFrom(112, 0, 16, 16)),
				new LastMapCollidableObject(0, (int) (Game.HEIGHT - 85), 64, 64, ObjectType.LAST_MAP, Game.OBJECT_TEXTRA_ALICE.getImageFrom(128, 0, 16, 16)),
				new CollidableObject(100, 25, 256, 256, ObjectType.HOUSE_1, Game.HOUSE_1_IMAGE_LOADER.getImage()),
				new CollidableObject(400, 25, 256, 256, ObjectType.HOUSE_1, Game.HOUSE_1_IMAGE_LOADER.getImage())
				
			},
			
			{
				
				new NextRandomMapCollisionObject((int) (Game.WIDTH - 64), 0, 64, 64, ObjectType.NEXT_MAP, Game.OBJECT_TEXTRA_ALICE.getImageFrom(112, 0, 16, 16)),
				new LastMapCollidableObject(0, (int) (Game.HEIGHT - 85), 64, 64, ObjectType.LAST_MAP, Game.OBJECT_TEXTRA_ALICE.getImageFrom(128, 0, 16, 16)),
				
			},
			
			{
				
				new NextRandomMapCollisionObject((int) (Game.WIDTH - 64), 0, 64, 64, ObjectType.NEXT_MAP, Game.OBJECT_TEXTRA_ALICE.getImageFrom(112, 0, 16, 16)),
				new LastMapCollidableObject(0, (int) (Game.HEIGHT - 85), 64, 64, ObjectType.LAST_MAP, Game.OBJECT_TEXTRA_ALICE.getImageFrom(128, 0, 16, 16)),
				new CollidableObject(100, 25, 256, 256, ObjectType.HOUSE_1, Game.HOUSE_1_IMAGE_LOADER.getImage()),
				new CollidableObject(400, 25, 256, 256, ObjectType.HOUSE_1, Game.HOUSE_1_IMAGE_LOADER.getImage())
				
			},
			
			{
				
				new NextRandomMapCollisionObject((int) (Game.WIDTH - 64), 0, 64, 64, ObjectType.NEXT_MAP, Game.OBJECT_TEXTRA_ALICE.getImageFrom(112, 0, 16, 16)),
				new LastMapCollidableObject(0, (int) (Game.HEIGHT - 85), 64, 64, ObjectType.LAST_MAP, Game.OBJECT_TEXTRA_ALICE.getImageFrom(128, 0, 16, 16)),
				new CollidableObject(100, 25, 256, 256, ObjectType.HOUSE_1, Game.HOUSE_1_IMAGE_LOADER.getImage())
				
			},
			
			{
				
				new NextRandomMapCollisionObject((int) (Game.WIDTH - 64), 0, 64, 64, ObjectType.NEXT_MAP, Game.OBJECT_TEXTRA_ALICE.getImageFrom(112, 0, 16, 16)),
				new LastMapCollidableObject(0, (int) (Game.HEIGHT - 85), 64, 64, ObjectType.LAST_MAP, Game.OBJECT_TEXTRA_ALICE.getImageFrom(128, 0, 16, 16)),
				new CollidableObject(400, 25, 256, 256, ObjectType.HOUSE_1, Game.HOUSE_1_IMAGE_LOADER.getImage()),
				new WaterTransparentCollisionObject(128, 147, 128, 64, ObjectType.WATER, Game.OBJECT_TEXTRA_ALICE.getImageFrom(272, 0, 16, 16)),
				new WaterTransparentCollisionObject(64, 211, 192, 192, ObjectType.WATER, Game.OBJECT_TEXTRA_ALICE.getImageFrom(272, 0, 16, 16))
				
			},
			
			{
				
				new NextRandomMapCollisionObject((int) (Game.WIDTH - 64), 0, 64, 64, ObjectType.NEXT_MAP, Game.OBJECT_TEXTRA_ALICE.getImageFrom(112, 0, 16, 16)),
				new LastMapCollidableObject(0, (int) (Game.HEIGHT - 85), 64, 64, ObjectType.LAST_MAP, Game.OBJECT_TEXTRA_ALICE.getImageFrom(128, 0, 16, 16)),
				new WaterTransparentCollisionObject(128, 147, 128, 64, ObjectType.WATER, Game.OBJECT_TEXTRA_ALICE.getImageFrom(272, 0, 16, 16)),
				new WaterTransparentCollisionObject(64, 211, 192, 192, ObjectType.WATER, Game.OBJECT_TEXTRA_ALICE.getImageFrom(272, 0, 16, 16))
				
			},
			
			{
				
				new NextRandomMapCollisionObject((int) (Game.WIDTH - 64), 0, 64, 64, ObjectType.NEXT_MAP, Game.OBJECT_TEXTRA_ALICE.getImageFrom(112, 0, 16, 16)),
				new LastMapCollidableObject(0, (int) (Game.HEIGHT - 85), 64, 64, ObjectType.LAST_MAP, Game.OBJECT_TEXTRA_ALICE.getImageFrom(128, 0, 16, 16)),
				new LavaTransparentCollisionObject(128, 147, 128, 64, ObjectType.LAVA, Game.OBJECT_TEXTRA_ALICE.getImageFrom(288, 0, 16, 16)),
				new LavaTransparentCollisionObject(64, 211, 192, 192, ObjectType.LAVA, Game.OBJECT_TEXTRA_ALICE.getImageFrom(288, 0, 16, 16))
				
			},
			
			{
				
				new NextRandomMapCollisionObject((int) (Game.WIDTH - 64), 0, 64, 64, ObjectType.NEXT_MAP, Game.OBJECT_TEXTRA_ALICE.getImageFrom(112, 0, 16, 16)),
				new LastMapCollidableObject(0, (int) (Game.HEIGHT - 85), 64, 64, ObjectType.LAST_MAP, Game.OBJECT_TEXTRA_ALICE.getImageFrom(128, 0, 16, 16)),
				new CollidableObject(100, 25, 256, 256, ObjectType.HOUSE_1, Game.HOUSE_1_IMAGE_LOADER.getImage()),
				new CollidableObject(400, 25, 256, 256, ObjectType.HOUSE_1, Game.HOUSE_1_IMAGE_LOADER.getImage())
				
			},
			
			{
				
				new NextRandomMapCollisionObject((int) (Game.WIDTH - 64), 0, 64, 64, ObjectType.NEXT_MAP, Game.OBJECT_TEXTRA_ALICE.getImageFrom(112, 0, 16, 16)),
				new LastMapCollidableObject(0, (int) (Game.HEIGHT - 85), 64, 64, ObjectType.LAST_MAP, Game.OBJECT_TEXTRA_ALICE.getImageFrom(128, 0, 16, 16)),
				new CollidableObject(100, 25, 256, 256, ObjectType.HOUSE_1, Game.HOUSE_1_IMAGE_LOADER.getImage()),
				new CollidableObject(400, 25, 256, 256, ObjectType.HOUSE_1, Game.HOUSE_1_IMAGE_LOADER.getImage())
				
			},
			
			{
				
				new NextRandomMapCollisionObject((int) (Game.WIDTH - 64), 0, 64, 64, ObjectType.NEXT_MAP, Game.OBJECT_TEXTRA_ALICE.getImageFrom(112, 0, 16, 16)),
				new LastMapCollidableObject(0, (int) (Game.HEIGHT - 85), 64, 64, ObjectType.LAST_MAP, Game.OBJECT_TEXTRA_ALICE.getImageFrom(128, 0, 16, 16)),
				new CollidableObject(100, 25, 256, 256, ObjectType.HOUSE_1, Game.HOUSE_1_IMAGE_LOADER.getImage()),
				new CollidableObject(400, 25, 256, 256, ObjectType.HOUSE_1, Game.HOUSE_1_IMAGE_LOADER.getImage())
				
			},
			
			{
				
				new NextRandomMapCollisionObject((int) (Game.WIDTH - 64), 0, 64, 64, ObjectType.NEXT_MAP, Game.OBJECT_TEXTRA_ALICE.getImageFrom(112, 0, 16, 16)),
				new LastMapCollidableObject(0, (int) (Game.HEIGHT - 85), 64, 64, ObjectType.LAST_MAP, Game.OBJECT_TEXTRA_ALICE.getImageFrom(128, 0, 16, 16)),
				new CollidableObject(100, 25, 256, 256, ObjectType.HOUSE_1, Game.HOUSE_1_IMAGE_LOADER.getImage()),
				new CollidableObject(400, 25, 256, 256, ObjectType.HOUSE_1, Game.HOUSE_1_IMAGE_LOADER.getImage())
				
			},
			
			{
				
				new NextRandomMapCollisionObject((int) (Game.WIDTH - 64), 0, 64, 64, ObjectType.NEXT_MAP, Game.OBJECT_TEXTRA_ALICE.getImageFrom(112, 0, 16, 16)),
				new LastMapCollidableObject(0, (int) (Game.HEIGHT - 85), 64, 64, ObjectType.LAST_MAP, Game.OBJECT_TEXTRA_ALICE.getImageFrom(128, 0, 16, 16)),
				new CollidableObject(100, 25, 256, 256, ObjectType.HOUSE_1, Game.HOUSE_1_IMAGE_LOADER.getImage()),
				new CollidableObject(75, 240, 128, 128, ObjectType.APPLE_TREE_1, Game.OBJECT_TEXTRA_ALICE.getImageFrom(176, 0, 16, 16)),
				new CollidableObject(400, 25, 256, 256, ObjectType.HOUSE_1, Game.HOUSE_1_IMAGE_LOADER.getImage())
				
			},
			
			{
				
				new NextRandomMapCollisionObject((int) (Game.WIDTH - 64), 0, 64, 64, ObjectType.NEXT_MAP, Game.OBJECT_TEXTRA_ALICE.getImageFrom(112, 0, 16, 16)),
				new LastMapCollidableObject(0, (int) (Game.HEIGHT - 85), 64, 64, ObjectType.LAST_MAP, Game.OBJECT_TEXTRA_ALICE.getImageFrom(128, 0, 16, 16)),
				new CollidableObject(100, 25, 256, 256, ObjectType.HOUSE_1, Game.HOUSE_1_IMAGE_LOADER.getImage()),
				new CollidableObject(75, 240, 64, 64, ObjectType.SUNFLOWER, Game.OBJECT_TEXTRA_ALICE.getImageFrom(304, 0, 16, 16)),
				new CollidableObject(400, 25, 256, 256, ObjectType.HOUSE_1, Game.HOUSE_1_IMAGE_LOADER.getImage())
				
			},
			
			{
				
				new NextRandomMapCollisionObject((int) (Game.WIDTH - 64), 0, 64, 64, ObjectType.NEXT_MAP, Game.OBJECT_TEXTRA_ALICE.getImageFrom(112, 0, 16, 16)),
				new LastMapCollidableObject(0, (int) (Game.HEIGHT - 85), 64, 64, ObjectType.LAST_MAP, Game.OBJECT_TEXTRA_ALICE.getImageFrom(128, 0, 16, 16)),
				new StartMonsterLeathFightCollidableObject(256, 128, 64, 64)
				
			}
			
	};
	
	public static Entity[][] RANDOM_MAP_HOME_ENTITYS = {
			
			
			{},
			
			{
				
				new VillagerEntity(200, 200, 0, 0, 64, 64, EntityID.VILAGER, Game.VILAGER_TEXTRA_ALICE.getImageFrom(0, 0, 16, 16), VillagerTrades.WOOD_TO_COIN)
				
			},
			
			{
				
				new VillagerEntity(200, 200, 0, 0, 64, 64, EntityID.VILAGER, Game.VILAGER_TEXTRA_ALICE.getImageFrom(0, 0, 16, 16), VillagerTrades.COIN_TO_TACO),
				new VillagerEntity(500, 200, 0, 0, 64, 64, EntityID.VILAGER, Game.VILAGER_TEXTRA_ALICE.getImageFrom(0, 0, 16, 16), VillagerTrades.APPLE_TO_COIN)
				
			},
			
			{
					
				new VillagerEntity(200, 200, 0, 0, 64, 64, EntityID.VILAGER, Game.VILAGER_TEXTRA_ALICE.getImageFrom(0, 0, 16, 16), VillagerTrades.COIN_TO_PIE),
				new VillagerEntity(500, 200, 0, 0, 64, 64, EntityID.VILAGER, Game.VILAGER_TEXTRA_ALICE.getImageFrom(0, 0, 16, 16), VillagerTrades.STONE_TO_COIN)
				
			},
			
			{
				
				new VillagerEntity(200, 200, 0, 0, 64, 64, EntityID.VILAGER, Game.VILAGER_TEXTRA_ALICE.getImageFrom(0, 0, 16, 16), VillagerTrades.COIN_TO_CHEST),
				new VillagerEntity(500, 200, 0, 0, 64, 64, EntityID.VILAGER, Game.VILAGER_TEXTRA_ALICE.getImageFrom(0, 0, 16, 16), VillagerTrades.WOOD_TO_SIGN)
				
			},
			
			{
				
				new VillagerEntity(500, 200, 0, 0, 64, 64, EntityID.VILAGER, Game.VILAGER_TEXTRA_ALICE.getImageFrom(0, 0, 16, 16), VillagerTrades.IRON_ORE_TO_COIN)
				
			},
			
			{
				
				new VillagerEntity(200, 200, 0, 0, 64, 64, EntityID.VILAGER, Game.VILAGER_TEXTRA_ALICE.getImageFrom(0, 0, 16, 16), VillagerTrades.GOLD_ORE_TO_COIN),
				new VillagerEntity(500, 200, 0, 0, 64, 64, EntityID.VILAGER, Game.VILAGER_TEXTRA_ALICE.getImageFrom(0, 0, 16, 16), VillagerTrades.DIAMOND_ORE_TO_COIN)
				
			},
			
			{
				
				new VillagerEntity(200, 200, 0, 0, 64, 64, EntityID.VILAGER, Game.VILAGER_TEXTRA_ALICE.getImageFrom(0, 0, 16, 16), VillagerTrades.COIN_TO_RED_MUSHROOM),
				new VillagerEntity(500, 200, 0, 0, 64, 64, EntityID.VILAGER, Game.VILAGER_TEXTRA_ALICE.getImageFrom(0, 0, 16, 16), VillagerTrades.COIN_TO_HEART)
				
			},
			
			{},
			
			{
				
				new VillagerEntity(200, 200, 0, 0, 64, 64, EntityID.VILAGER, Game.VILAGER_TEXTRA_ALICE.getImageFrom(0, 0, 16, 16), VillagerTrades.COIN_TO_BREAD),
				new VillagerEntity(500, 200, 0, 0, 64, 64, EntityID.VILAGER, Game.VILAGER_TEXTRA_ALICE.getImageFrom(0, 0, 16, 16), VillagerTrades.WOOD_TO_BOWL)
				
			},
			
			{
				
				new VillagerEntity(200, 200, 0, 0, 64, 64, EntityID.VILAGER, Game.VILAGER_TEXTRA_ALICE.getImageFrom(0, 0, 16, 16), VillagerTrades.BOWL_AND_RED_MUSHROOM_TO_MUSHROOM_STEW)
				
			},
			
			{
				
				new VillagerEntity(500, 200, 0, 0, 64, 64, EntityID.VILAGER, Game.VILAGER_TEXTRA_ALICE.getImageFrom(0, 0, 16, 16), VillagerTrades.COIN_TO_FISHING_ROD)
				
			},
			
			{},
			
			{},
			
			{
				
				new VillagerEntity(200, 200, 0, 0, 64, 64, EntityID.VILAGER, Game.VILAGER_TEXTRA_ALICE.getImageFrom(0, 0, 16, 16), VillagerTrades.GOLD_FISH_TO_COIN),
				new VillagerEntity(500, 200, 0, 0, 64, 64, EntityID.VILAGER, Game.VILAGER_TEXTRA_ALICE.getImageFrom(0, 0, 16, 16), VillagerTrades.BLUE_FISH_TO_COIN)
				
			},
			
			{
				
				new VillagerEntity(200, 200, 0, 0, 64, 64, EntityID.VILAGER, Game.VILAGER_TEXTRA_ALICE.getImageFrom(0, 0, 16, 16), VillagerTrades.SALMON_FISH_TO_COIN),
				new VillagerEntity(500, 200, 0, 0, 64, 64, EntityID.VILAGER, Game.VILAGER_TEXTRA_ALICE.getImageFrom(0, 0, 16, 16), VillagerTrades.COD_FISH_TO_COIN)
				
			},
			
			{
				
				new VillagerEntity(200, 200, 0, 0, 64, 64, EntityID.VILAGER, Game.VILAGER_TEXTRA_ALICE.getImageFrom(0, 0, 16, 16), VillagerTrades.COIN_TO_ATTACK_STAT),
				new VillagerEntity(500, 200, 0, 0, 64, 64, EntityID.VILAGER, Game.VILAGER_TEXTRA_ALICE.getImageFrom(0, 0, 16, 16), VillagerTrades.COIN_TO_DEFENCE_STAT)
				
			},
			
			{
				
				new VillagerEntity(200, 200, 0, 0, 64, 64, EntityID.VILAGER, Game.VILAGER_TEXTRA_ALICE.getImageFrom(0, 0, 16, 16), VillagerTrades.COIN_TO_PIZZA),
				new VillagerEntity(500, 200, 0, 0, 64, 64, EntityID.VILAGER, Game.VILAGER_TEXTRA_ALICE.getImageFrom(0, 0, 16, 16), VillagerTrades.COIN_TO_BURGER)
				
			},
			
			{
				
				new VillagerEntity(200, 200, 0, 0, 64, 64, EntityID.VILAGER, Game.VILAGER_TEXTRA_ALICE.getImageFrom(0, 0, 16, 16), VillagerTrades.COIN_TO_FISH_LAND_DIMENSION_TELEPORTER),
				new VillagerEntity(500, 200, 0, 0, 64, 64, EntityID.VILAGER, Game.VILAGER_TEXTRA_ALICE.getImageFrom(0, 0, 16, 16), VillagerTrades.SWORD_TO_COIN)
				
			},
			
			{
				
				new VillagerEntity(200, 200, 0, 0, 64, 64, EntityID.VILAGER, Game.VILAGER_TEXTRA_ALICE.getImageFrom(0, 0, 16, 16), VillagerTrades.COIN_TO_BREAD),
				new VillagerEntity(500, 200, 0, 0, 64, 64, EntityID.VILAGER, Game.VILAGER_TEXTRA_ALICE.getImageFrom(0, 0, 16, 16), VillagerTrades.COIN_TO_BOMB)
				
			},
			
			{}
			
	};
	
	public static CollisionObject[] START_MAP_FISH_LAND = {
			
			new WaterTransparentCollisionObject(0, 479, Game.WIDTH, 245, ObjectType.WATER, Game.OBJECT_TEXTRA_ALICE.getImageFrom(272, 0, 16, 16)),
			new WaterTransparentCollisionObject(0, 0, Game.WIDTH, 192, ObjectType.WATER, Game.OBJECT_TEXTRA_ALICE.getImageFrom(272, 0, 16, 16)),
			new WaterTransparentCollisionObject(0, 0, 284, Game.HEIGHT, ObjectType.WATER, Game.OBJECT_TEXTRA_ALICE.getImageFrom(272, 0, 16, 16)),
			new WaterTransparentCollisionObject(599, 0, 221, Game.HEIGHT, ObjectType.WATER, Game.OBJECT_TEXTRA_ALICE.getImageFrom(272, 0, 16, 16)),
			new ChestTransparentObject(470, 242, 64, 64, ObjectType.CHEST, Game.OBJECT_TEXTRA_ALICE.getImageFrom(16, 0, 16, 16), ChestTransparentObject.LootTable.START_FTART_MAP_FISH_LAND)
			
	};
	
	
	private static final Date DATE = new Date();
	
	public static RandomGen RANDOM = new RandomGen(Game.DATE.getTime());
	
	public static final GameVersion VERSION = new GameVersion("Pre-0.0.0.4.1");
	
	public static Player PLAYER = new Player((float) ((float) (Game.WIDTH / 2) - 64), (float) ((float) (Game.HEIGHT / 2) - 64), 0f, 0f, 64, 64, EntityID.PLAYER, Game.PLAYER_TEXTRA_ALICE.getImageFrom(0, 0, 16, 16));
	public static HUD HUD = new HUD();
	public static DimensionHandler DIMENSION_HANDLER = new DimensionHandler();
	public static boolean PAUSED = false;
	public static Logger LOGGER = new Logger();
	
	public static Font MAIN_GAME_FONT;
	public static Font HOTBAR_GAME_FONT;
	public static Font VILAGER_GAME_FONT;
	public static Font SIGN_GAME_FONT;
	
	public static final Sound BG_SOUND = new Sound();
	public static final Sound SE_SOUND = new Sound();
	public static final Sound ANY_VOLUME_SOUNDS = new Sound();
	
	
	public Game(String title) {
		
		Game.logln("Game class created", LogType.SUCCESS);
		
		try {
			
			Game.MAIN_GAME_FONT = Font.createFont(Font.TRUETYPE_FONT, this.getClass().getResourceAsStream("/assets/fonts/RobotoMono.ttf"));
			
		} catch (FontFormatException ffe) {
			
			ffe.printStackTrace();
			
		} catch (IOException ioe) {
			
			ioe.printStackTrace();
			
		}
		
		try {
			
			Game.HOTBAR_GAME_FONT = Font.createFont(Font.TRUETYPE_FONT, this.getClass().getResourceAsStream("/assets/fonts/ShareTechMono-Regular.ttf"));
			
		} catch (FontFormatException ffe) {
			
			ffe.printStackTrace();
			
		} catch (IOException ioe) {
			
			ioe.printStackTrace();
			
		}
		
		try {
			
			Game.VILAGER_GAME_FONT = Font.createFont(Font.TRUETYPE_FONT, this.getClass().getResourceAsStream("/assets/fonts/Poppins-Regular.ttf"));
			
		} catch (FontFormatException ffe) {
			
			ffe.printStackTrace();
			
		} catch (IOException ioe) {
			
			ioe.printStackTrace();
			
		}
		
		Game.SIGN_GAME_FONT = Game.VILAGER_GAME_FONT;
		
		this.frame = new JFrame();
		this.gamePanel = new GamePanel();
		
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setLocationRelativeTo(null);
		this.frame.setSize(Game.WIDTH, Game.HEIGHT);
		this.frame.setTitle(title);
		this.frame.setResizable(false);
		this.frame.setMinimumSize(new Dimension(Game.WIDTH, Game.HEIGHT));
		this.frame.setMaximumSize(new Dimension(Game.WIDTH, Game.HEIGHT));
		
		this.gamePanel.setPreferredSize(new Dimension(Game.WIDTH, Game.HEIGHT));
		this.frame.add(this.gamePanel);
		
		
		this.frame.setPreferredSize(new Dimension(Game.WIDTH, Game.HEIGHT));
		this.frame.setVisible(true);
		
		this.gamePanel.startGameLoop();
		
	}
	
	public final static MapHandler MAP_HANDLER() {
		
		return Game.DIMENSION_HANDLER.currentDimension().getMapHandler();
		
	}
	
	public static <T> void logln(T t, LogType type) {
		
		Game.LOGGER.logln(t, type);
		
	}
	
	public static <T> void log(T t, LogType type) {
		
		Game.LOGGER.log(t, type);
		
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
	
	public static byte clamp(byte var, byte max, byte min) {
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
		
		Game.MAP_HANDLER().currentMap().getEntityHandler().add(new ItemEntity(x, y, 0, 0, size, size, EntityID.ITEM, image, item));
		
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
		
		Game.MAP_HANDLER().currentMap().getEntityHandler().add(new ItemEntity(pos[0], pos[1], 0, 0, 64, 64, EntityID.ITEM, item.getImage(), item));
		
	}
	
	public static void makeItemAtRandomWithItem(Item<?> item, float x, float y) {
		
		float[] pos = Game.getRandomItemPos(x, y);
		
		Game.MAP_HANDLER().currentMap().getEntityHandler().add(new ItemEntity(pos[0], pos[1], 0, 0, 64, 64, EntityID.ITEM, item.getImage(), item));
		
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
					
					Game.DIMENSION_HANDLER = obj.getDimensionHandler();
					Game.PLAYER = obj.getPlayer();
					Game.RANDOM = obj.getRandomGen();
					
					Game.logln("Loaded game", LogType.SUCCESS);
					
					Game.fixAllImages();
					
				} else {
					
					JOptionPane.showMessageDialog(null, "Can not load a save file from " + obj.getVersion().getVersion() + " in " + Game.VERSION.getVersion(), "Warning", JOptionPane.WARNING_MESSAGE);
					
				}
				
			} catch (ClassNotFoundException | IOException e) {
				
				Game.logln(e.toString(), LogType.EXCRPTION);
				Game.loadingSaveFileEErrorMessage();
				
			} catch (NotEnoughInformationToRestoreImageException e) {
				
				Game.logln(e.toString(), LogType.EXCRPTION);
				Game.loadingSaveFileEErrorMessage();
				
			} catch (Exception e) {
				
				Game.logln(e.toString(), LogType.EXCRPTION);
				Game.loadingSaveFileEErrorMessage();
				
			}
			
		}
		
	}
	
	private static void loadingSaveFileEErrorMessage() {
		
		JOptionPane.showMessageDialog(null, "Can not load save file!", "Error", JOptionPane.ERROR_MESSAGE);
		
	}

	public static void fixImagesForCurrentMap(Map map) throws NotEnoughInformationToRestoreImageException {
		
		Iterator<com.game.maps.Dimension> dimsListIt = Game.DIMENSION_HANDLER.getDimensionHashMap().values().iterator();
		
		while (dimsListIt.hasNext()) {
			
			com.game.maps.Dimension dim = dimsListIt.next();
			
			switch (dim.getId()) {
			
				case HOME:
					dim.setBackground(Game.OBJECT_TEXTRA_ALICE.getImageFrom(0, 0, 16, 16));
					break;
					
				case FISH_LAND:
					dim.setBackground(Game.OBJECT_TEXTRA_ALICE.getImageFrom(0, 0, 16, 16));
					break;
				
			}
			
		}
		
		if (Game.PLAYER.isInCar()) {
			
			Game.PLAYER.setImage(Game.PLAYER_TEXTRA_ALICE.getImageFrom(16, 0, 16, 16));
			
		} else {
			
			Game.PLAYER.setImage(Game.PLAYER_TEXTRA_ALICE.getImageFrom(0, 0, 16, 16));
			
		}
		
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
					
				case RED_MUSHROOM_1:
					item.setImage(Game.ITEM_TEXTRA_ALICE.getImageFrom(288, 0, 16, 16));
					break;
					
				case COOKIE_1:
					item.setImage(Game.ITEM_TEXTRA_ALICE.getImageFrom(304, 0, 16, 16));
					break;
					
				case MUSHROOM_STEW_1:
					item.setImage(Game.ITEM_TEXTRA_ALICE.getImageFrom(320, 0, 16, 16));
					break;
					
				case BOWL_1:
					item.setImage(Game.ITEM_TEXTRA_ALICE.getImageFrom(336, 0, 16, 16));
					break;
				
				case BREAD_1:
					item.setImage(Game.ITEM_TEXTRA_ALICE.getImageFrom(352, 0, 16, 16));
					break;
					
				case MONEY_BAG_1:
					item.setImage(Game.ITEM_TEXTRA_ALICE.getImageFrom(368, 0, 16, 16));
					break;
					
				case MONEY_BAG_2:
					item.setImage(Game.ITEM_TEXTRA_ALICE.getImageFrom(384, 0, 16, 16));
					break;
					
				case MONEY_BAG_3:
					item.setImage(Game.ITEM_TEXTRA_ALICE.getImageFrom(400, 0, 16, 16));
					break;
					
				case FISHING_ROD_1:
					item.setImage(Game.ITEM_TEXTRA_ALICE.getImageFrom(416, 0, 16, 16));
					break;
					
				case GOLD_FISH_1:
					item.setImage(Game.ITEM_TEXTRA_ALICE.getImageFrom(432, 0, 16, 16));
					break;
					
				case BLUE_FISH_1:
					item.setImage(Game.ITEM_TEXTRA_ALICE.getImageFrom(448, 0, 16, 16));
					break;
					
				case SALMON_FISH_1:
					item.setImage(Game.ITEM_TEXTRA_ALICE.getImageFrom(464, 0, 16, 16));
					break;
					
				case COD_FISH_1:
					item.setImage(Game.ITEM_TEXTRA_ALICE.getImageFrom(480, 0, 16, 16));
					break;
					
				case SWORD_1:
					item.setImage(Game.ITEM_TEXTRA_ALICE.getImageFrom(496, 0, 16, 16));
					break;
					
				case PIZZA_1:
					item.setImage(Game.ITEM_TEXTRA_ALICE.getImageFrom(0, 16, 16, 16));
					break;
					
				case BURGER_1:
					item.setImage(Game.ITEM_TEXTRA_ALICE.getImageFrom(16, 16, 16, 16));
					break;
					
				case FISH_LAND_TELEPORTER_1:
					item.setImage(Game.ITEM_TEXTRA_ALICE.getImageFrom(32, 16, 16, 16));
					break;
				
				case BOW_1:
					item.setImage(Game.ITEM_TEXTRA_ALICE.getImageFrom(48, 16, 16, 16));
					break;
					
				case BOW_2:
					item.setImage(Game.ITEM_TEXTRA_ALICE.getImageFrom(64, 16, 16, 16));
					break;
					
				case BETTER_ATTACK_DAMAGE_EFFECT_1:
					
					if (item instanceof PotionItem<?>) {
						
						PotionItem<?> pitem = (PotionItem<?>) item;
						
						item.setImage(pitem.getEffectDataClass().getEffectID().getImage());
						
					}
					
					break;
					
				case FAST_GENERATION_EFFECT_1:
					
					if (item instanceof PotionItem<?>) {
						
						PotionItem<?> pitem = (PotionItem<?>) item;
						
						item.setImage(pitem.getEffectDataClass().getEffectID().getImage());
						
					}
					
					break;
					
				case POSION_EFFECT_1:
					
					if (item instanceof PotionItem<?>) {
						
						PotionItem<?> pitem = (PotionItem<?>) item;
						
						item.setImage(pitem.getEffectDataClass().getEffectID().getImage());
						
					}
					
					break;
					
				case RESISTANCE_EFFECT_1:
					
					if (item instanceof PotionItem<?>) {
						
						PotionItem<?> pitem = (PotionItem<?>) item;
						
						item.setImage(pitem.getEffectDataClass().getEffectID().getImage());
						
					}
					
					break;
					
				case SWIMMING_EFFECT_1:
					
					if (item instanceof PotionItem<?>) {
						
						PotionItem<?> pitem = (PotionItem<?>) item;
						
						item.setImage(pitem.getEffectDataClass().getEffectID().getImage());
						
					}
					
					break;
					
				case BOMB:
					item.setImage(Game.BOMB_TEXTRA_ALICE.getImageFrom(0, 0, 16, 16));
					break;
					
				case LAVA_BOWL:
					item.setImage(Game.ITEM_TEXTRA_ALICE.getImageFrom(80, 16, 16, 16));
					break;
					
				case WATER_BOWL:
					item.setImage(Game.ITEM_TEXTRA_ALICE.getImageFrom(96, 16, 16, 16));
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
								
							case RED_MUSHROOM_1:
								item.setImage(Game.ITEM_TEXTRA_ALICE.getImageFrom(288, 0, 16, 16));
								break;
								
							case COOKIE_1:
								item.setImage(Game.ITEM_TEXTRA_ALICE.getImageFrom(304, 0, 16, 16));
								break;
								
							case MUSHROOM_STEW_1:
								item.setImage(Game.ITEM_TEXTRA_ALICE.getImageFrom(320, 0, 16, 16));
								break;
								
							case BOWL_1:
								item.setImage(Game.ITEM_TEXTRA_ALICE.getImageFrom(336, 0, 16, 16));
								break;
							
							case BREAD_1:
								item.setImage(Game.ITEM_TEXTRA_ALICE.getImageFrom(352, 0, 16, 16));
								break;
								
							case MONEY_BAG_1:
								item.setImage(Game.ITEM_TEXTRA_ALICE.getImageFrom(368, 0, 16, 16));
								break;
								
							case MONEY_BAG_2:
								item.setImage(Game.ITEM_TEXTRA_ALICE.getImageFrom(384, 0, 16, 16));
								break;
								
							case MONEY_BAG_3:
								item.setImage(Game.ITEM_TEXTRA_ALICE.getImageFrom(400, 0, 16, 16));
								break;
								
							case FISHING_ROD_1:
								item.setImage(Game.ITEM_TEXTRA_ALICE.getImageFrom(416, 0, 16, 16));
								break;
								
							case GOLD_FISH_1:
								item.setImage(Game.ITEM_TEXTRA_ALICE.getImageFrom(432, 0, 16, 16));
								break;
								
							case BLUE_FISH_1:
								item.setImage(Game.ITEM_TEXTRA_ALICE.getImageFrom(448, 0, 16, 16));
								break;
								
							case SALMON_FISH_1:
								item.setImage(Game.ITEM_TEXTRA_ALICE.getImageFrom(464, 0, 16, 16));
								break;
								
							case COD_FISH_1:
								item.setImage(Game.ITEM_TEXTRA_ALICE.getImageFrom(480, 0, 16, 16));
								break;
								
							case SWORD_1:
								item.setImage(Game.ITEM_TEXTRA_ALICE.getImageFrom(496, 0, 16, 16));
								break;
								
							case PIZZA_1:
								item.setImage(Game.ITEM_TEXTRA_ALICE.getImageFrom(0, 16, 16, 16));
								break;
								
							case BURGER_1:
								item.setImage(Game.ITEM_TEXTRA_ALICE.getImageFrom(16, 16, 16, 16));
								break;
								
							case FISH_LAND_TELEPORTER_1:
								item.setImage(Game.ITEM_TEXTRA_ALICE.getImageFrom(32, 16, 16, 16));
								break;
								
							case BOW_1:
								item.setImage(Game.ITEM_TEXTRA_ALICE.getImageFrom(48, 16, 16, 16));
								break;
								
							case BOW_2:
								item.setImage(Game.ITEM_TEXTRA_ALICE.getImageFrom(64, 16, 16, 16));
								break;
								
							case BETTER_ATTACK_DAMAGE_EFFECT_1:
								
								if (item instanceof PotionItem<?>) {
									
									PotionItem<?> pitem = (PotionItem<?>) item;
									
									item.setImage(pitem.getEffectDataClass().getEffectID().getImage());
									
								}
								
								break;
								
							case FAST_GENERATION_EFFECT_1:
								
								if (item instanceof PotionItem<?>) {
									
									PotionItem<?> pitem = (PotionItem<?>) item;
									
									item.setImage(pitem.getEffectDataClass().getEffectID().getImage());
									
								}
								
								break;
								
							case POSION_EFFECT_1:
								
								if (item instanceof PotionItem<?>) {
									
									PotionItem<?> pitem = (PotionItem<?>) item;
									
									item.setImage(pitem.getEffectDataClass().getEffectID().getImage());
									
								}
								
								break;
								
							case RESISTANCE_EFFECT_1:
								
								if (item instanceof PotionItem<?>) {
									
									PotionItem<?> pitem = (PotionItem<?>) item;
									
									item.setImage(pitem.getEffectDataClass().getEffectID().getImage());
									
								}
								
								break;
								
							case SWIMMING_EFFECT_1:
								
								if (item instanceof PotionItem<?>) {
									
									PotionItem<?> pitem = (PotionItem<?>) item;
									
									item.setImage(pitem.getEffectDataClass().getEffectID().getImage());
									
								}
								
								break;
								
							case BOMB:
								item.setImage(Game.BOMB_TEXTRA_ALICE.getImageFrom(0, 0, 16, 16));
								break;
								
							case LAVA_BOWL:
								item.setImage(Game.ITEM_TEXTRA_ALICE.getImageFrom(80, 16, 16, 16));
								break;
								
							case WATER_BOWL:
								item.setImage(Game.ITEM_TEXTRA_ALICE.getImageFrom(96, 16, 16, 16));
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
					
				case ZOMBIE:
					e.setImage(Game.ZOMBIE_TEXTRA_ALICE.getImageFrom(0, 0, 16, 16));
					break;
					
				case WAR_ZOMBIE:
					e.setImage(Game.ZOMBIE_TEXTRA_ALICE.getImageFrom(0, 0, 16, 16));
					break;
					
				case ROCK_ZOMBIE:
					e.setImage(Game.ZOMBIE_TEXTRA_ALICE.getImageFrom(32, 0, 16, 16));
					break;
					
				case ROCK_ZOMBIE_ROCK:
					e.setImage(Game.ZOMBIE_TEXTRA_ALICE.getImageFrom(16, 0, 16, 16));
					break;
					
				case PLAYER_BOW_BULLET:
					e.setImage(Game.BULLET_1_IMAGE_LOADER.getImage());
					break;
					
				case AXOLOTL:
					if (e instanceof AxolotlEntity) {
						
						((AxolotlEntity) e).handleImage();
						
					}
					if (e.getImage() == null) e.setImage(Game.AXOLOTL_TEXTRA_ALICE.getImageFrom(0, 0, 16, 16));
					break;
					
				case BOMB:
					
					if (e instanceof BombEntity) {
						
						BombEntity be = (BombEntity) e;
						
						if (be.getFrameState() == 0) {
							
							be.setImage(Game.BOMB_TEXTRA_ALICE.getImageFrom(0, 0, 16, 16));
							
						} else if (be.getFrameState() == 1) {
							
							be.setImage(Game.BOMB_TEXTRA_ALICE.getImageFrom(16, 0, 16, 16));
							
						} else if (be.getFrameState() == 2) {
							
							be.setImage(Game.BOMB_TEXTRA_ALICE.getImageFrom(32, 0, 16, 16));
							
						}
						
					}
				break;
				
				case MONSTER_LEATH:
					e.setImage(Game.MONSTER_LEATH_IMAGE_LOADER.getImage());
					break;
					
				case MONSTER_LEATH_LEATH:
					e.setImage(Game.ITEM_TEXTRA_ALICE.getImageFrom(64, 0, 16, 16));
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
					
				case WATER:
					o.setImage(Game.OBJECT_TEXTRA_ALICE.getImageFrom(272, 0, 16, 16));
					break;
					
				case LAVA:
					o.setImage(Game.OBJECT_TEXTRA_ALICE.getImageFrom(288, 0, 16, 16));
					break;
					
				case SUNFLOWER:
					o.setImage(Game.OBJECT_TEXTRA_ALICE.getImageFrom(304, 0, 16, 16));
					break;
					
				case START_MONSTER_LEATH_FIGHT:
					o.setImage(Game.MONSTER_LEATH_IMAGE_LOADER.getImage());
					break;
			
			}
			
		}
		
	}
	
	public static void fixAllImages() throws NotEnoughInformationToRestoreImageException {
		
		for (int i = 0; i < Game.DIMENSION_HANDLER.getDimensionHashMap().size(); i++) {
			
			DimensionID did = (DimensionID) Game.DIMENSION_HANDLER.getDimensionHashMap().keySet().toArray()[i];
			
			MapHandler mp = Game.DIMENSION_HANDLER.get(did).getMapHandler();
			
			for (int j = 0; j < mp.getMAPS().size(); j++) {
				
				Game.fixImagesForCurrentMap(mp.getMAPS().get(j));
				
			}
			
			
		}
		
	}
	
	public static void addEntity(Entity e) {
		
		Game.MAP_HANDLER().currentMap().getEntityHandler().add(e);
		
	}
	
	public static void removeEntity(Entity e) {
		
		Game.MAP_HANDLER().currentMap().getEntityHandler().remove(e);
		
	}
	
	public static void addObject(CollisionObject o) {
		
		Game.MAP_HANDLER().currentMap().addObject(o);
		
	}

	public static void reset() {
		
		Game.PAUSED = false;
		
		Date date = new Date();
		
		Game.RANDOM.setSeed(date.getTime());
		
		Game.DIMENSION_HANDLER = new DimensionHandler();
		
		Game.PLAYER = new Player((float) ((float) (Game.WIDTH / 2) - 64), (float) ((float) (Game.HEIGHT / 2) - 64), 0f,
				0f, 64, 64, EntityID.PLAYER, Game.PLAYER_TEXTRA_ALICE.getImageFrom(0, 0, 16, 16));
		
		Game.DIMENSION_HANDLER.get(DimensionID.HOME).getMapHandler().addMap(new Map(Game.HOME_MAP_HOME));
		
		Game.DIMENSION_HANDLER.get(DimensionID.HOME).getMapHandler().get(0)
				.addObject(new ChestTransparentObject(126, 184, 64, 64, ObjectType.CHEST,
						Game.OBJECT_TEXTRA_ALICE.getImageFrom(16, 0, 16, 16),
						ChestTransparentObject.LootTable.HOME_FIRT_MAP_CHEST));
		
		Game.DIMENSION_HANDLER.get(DimensionID.FISH_LAND).getMapHandler().addMap(new Map(Game.START_MAP_FISH_LAND));
		
		Game.logln("Reset game", LogType.SUCCESS);
		
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
		
		LinkedList<CollisionObject> tempList = Game.MAP_HANDLER().currentMap().getObjectList();
		
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
	
	public static boolean touchingSomethingTheTrueOne(Rectangle rect) {
		
		LinkedList<CollisionObject> tempList = Game.MAP_HANDLER().currentMap().getObjectList();
		
		for (int i = 0; i < tempList.size(); i++) {
			
			CollisionObject tempObj = tempList.get(i);
			
			if (
					rect.intersects(tempObj.getRectangle())
				) {
				
				return true;
				
			}
			
		}
		
		return false;
		
	}
	
	public static void addItemOrItemEntity(Item<?> item) throws NullPointerException {
		
		if (item == null) throw new NullPointerException("Item can not be null");
		
		if (!Game.PLAYER.getHotbar().returnBooleanAndAddItem(item)) {
			
			float[] pos = Game.getRandomItemPos();
			
			Game.addItemEntity(pos[0], pos[1], item, item.getImage(), 64);
			
		}
		
	}
	
	public static void addItemEntityWithRandomPos(Item<?> item, float x, float y) {
		
		float[] pos = Game.getRandomItemPos(x, y);
		
		Game.addItemEntity(pos[0], pos[1], item, item.getImage(), 64);
		
	}
	
	public static final long stringToLong(String text) {
		
		Long result = null;
		
		try {
			
			result = Long.parseLong(text);
			
		} catch (NumberFormatException nfe) {
			
			Game.logln(nfe, LogType.SAFE_EXCRPTION);
			
		}
		
		if (result == null) {
			
			result = (long) text.hashCode();
			
		}
		
		return (long) result;
		
	}
	
	public static float[] calculateDirection(float targetX, float targetY, final float BASE_SPEED, float x, float y) {
		
		float diffX = (float) ((float) (x - targetX) - 8);
		float diffY = (float) ((float) (y - targetY) - 8);
		
		float distance = (float) Math.sqrt(
												
												(double) (
															(double) (
															
																(double) (
																		x - targetX
																		) *
																(double) (
																		x - targetX
																		)
															
															) + (double) (
																	
																	(double) (
																			y - targetY
																			) *
																	(double) (
																			y - targetY
																			)
																	
																	))
				
											);
		
		final float SPEED = -BASE_SPEED;
		
		float xv = (float) ((float) (SPEED / distance) * diffX);
		float yv = (float) ((float) (SPEED / distance) * diffY);
		
		float[] result = {xv, yv};
		
		return result;
		
	}
	
	public static float[] getRandomPosNotInStuff(int width, int height) {
		
		Random random = new Random();
		
		float startX = random.nextInt(Game.WIDTH);
		float startY = random.nextInt(Game.HEIGHT);
		
		float[] pos = {startX, startY};
		
		pos[0] = Game.clamp(pos[0], (float) (Game.WIDTH - width), 0f);
		pos[1] = Game.clamp(pos[1], (float) (Game.WIDTH - height), 0f);
		
		Rectangle rect = new Rectangle((int) pos[0], (int) pos[1], width, height);
		
		while (Game.touchingSomething(rect)) {
			
			float tempX = random.nextInt(Game.WIDTH);
			float tempY = random.nextInt(Game.HEIGHT);
			
			pos[0] = tempX;
			pos[1] = tempY;
			
			pos[0] = Game.clamp(pos[0], (float) (Game.WIDTH - width), 0f);
			pos[1] = Game.clamp(pos[1], (float) (Game.WIDTH - height), 0f);
			
			rect = new Rectangle((int) pos[0], (int) pos[1], width, height);
			
		}
		
		return pos;
		
	}
	
	public static boolean aroundNumber(int number, int targetNumber, int range) {
		
		if (number == targetNumber) return true;
		
		int temp1 = (int) (targetNumber - range);
		int temp2 = (int) (targetNumber + range);
		
		if (number == temp1) return true;
		if (number == temp2) return true;
		
		if (number > temp1 && number < temp2) return true;
		
		return false;
		
	}
	
	public static boolean isPositive(float number) {
		
		return (boolean) (number == Math.abs(number));
		
	}
	
	public static boolean isNegative(float number) {
		
		return !Game.isPositive(number);
		
	}
	
	public static Player getCurrentPlayer() {
		
		return Game.PLAYER;
		
	}
	
	public static <T> T getRandomItemFrom(T[] list) {
		
		Random random = new Random();
		
		T temp = null;
		
		do {
			
			for (int i = 0; i < list.length; i++) {
				
				T item = list[i];
				
				if (random.nextBoolean() && !random.nextBoolean()) {
					
					temp = item;
					break;
					
				}
				
			}
			
		} while (temp == null);
		
		return temp;
		
	}
	
	public static void startWar() {
		
		Game.SE_SOUND.setSound(Sounds.WAR_START);
		Game.SE_SOUND.play();
		
		final int TOTAL_ZOMBIES = 7;
		
		final WarZombie wz = new WarZombie();
		
		for (int i = 0; i < TOTAL_ZOMBIES; i++) wz.spawn();
		
	}
	
}
