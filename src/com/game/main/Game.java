package com.game.main;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;

import com.game.collision.objects.ChangeMapCollidableObject;
import com.game.collision.objects.CollidableObject;
import com.game.collision.objects.CollisionObject;
import com.game.collision.objects.ObjectType;
import com.game.collision.objects.TextSignObject;
import com.game.display.components.GamePanel;
import com.game.entities.EntityID;
import com.game.entities.Player;
import com.game.textures.BufferedImageLoader;
import com.game.textures.TextraAlice;

public class Game {
	
	private JFrame frame;
	private GamePanel gamePanel;
	
	public static final int WIDTH = 800;
	public static final int HEIGHT = 704;
	
	private static BufferedImageLoader OBJECT_TEXTRA_ALICE_LOADER = new BufferedImageLoader("/assets/images/object-textra-alice.png");
	private static BufferedImageLoader PLAYER_TEXTRA_ALICE_LOADER = new BufferedImageLoader("/assets/images/player-textra-alice.png");
	
	public static TextraAlice OBJECT_TEXTRA_ALICE = new TextraAlice(Game.OBJECT_TEXTRA_ALICE_LOADER.getImage());
	public static TextraAlice PLAYER_TEXTRA_ALICE = new TextraAlice(Game.PLAYER_TEXTRA_ALICE_LOADER.getImage());
	
	public static CollisionObject[][] BASE_MAPS = {
			
			{
				new ChangeMapCollidableObject((int) (Game.WIDTH - 64), 0, 64, 64, ObjectType.CHANGE_MAP, Game.OBJECT_TEXTRA_ALICE.getImageFrom(112, 0, 16, 16), 1),
				new CollidableObject(125, 81, 135, 100, ObjectType.WALL, Game.OBJECT_TEXTRA_ALICE.getImageFrom(64, 0, 16, 16)),
				new CollidableObject(25, 200, 100, 300, ObjectType.WALL, Game.OBJECT_TEXTRA_ALICE.getImageFrom(32, 0, 16, 16)),
				new CollidableObject(25, 500, 100, 100, ObjectType.WALL, Game.OBJECT_TEXTRA_ALICE.getImageFrom(48, 0, 16, 16)),
				new CollidableObject(125, 500, 150, 100, ObjectType.WALL, Game.OBJECT_TEXTRA_ALICE.getImageFrom(64, 0, 16, 16)),
				new CollidableObject(25, 100, 100, 100, ObjectType.WALL, Game.OBJECT_TEXTRA_ALICE.getImageFrom(80, 0, 16, 16)),
				new CollidableObject(100, 175, 170, 100, ObjectType.WOOD_1, Game.OBJECT_TEXTRA_ALICE.getImageFrom(96, 0, 16, 16)),
				new CollidableObject(100, 275, 170, 100, ObjectType.WOOD_1, Game.OBJECT_TEXTRA_ALICE.getImageFrom(96, 0, 16, 16)),
				new CollidableObject(100, 375, 170, 100, ObjectType.WOOD_1, Game.OBJECT_TEXTRA_ALICE.getImageFrom(96, 0, 16, 16)),
				new CollidableObject(100, 475, 170, 50, ObjectType.WOOD_1, Game.OBJECT_TEXTRA_ALICE.getImageFrom(96, 0, 16, 16))
				
			},
			
			{
				
				new ChangeMapCollidableObject((int) (Game.WIDTH - 64), 0, 64, 64, ObjectType.CHANGE_MAP, Game.OBJECT_TEXTRA_ALICE.getImageFrom(128, 0, 16, 16), 0),
				new TextSignObject(256, 128, 128, 128, ObjectType.SIGN_1, Game.OBJECT_TEXTRA_ALICE.getImageFrom(144, 0, 16, 16), "This is a sign!", new Color(0x000000), new Font("Verdana", Font.PLAIN, 16), 10, 32)
				
			}
			
	};
	
	public static Player PLAYER = new Player((float) ((float) (Game.WIDTH / 2) - 64), (float) ((float) (Game.HEIGHT / 2) - 64), 0f, 0f, 64, 64, EntityID.PLAYER, Game.PLAYER_TEXTRA_ALICE.getImageFrom(0, 0, 16, 16));
	
	
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

}
