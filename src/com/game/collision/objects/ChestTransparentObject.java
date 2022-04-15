package com.game.collision.objects;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Stack;

import com.game.annotations.Empty;
import com.game.annotations.Unused;
import com.game.collision.objects.base.CollisionObject;
import com.game.collision.objects.base.ObjectType;
import com.game.entities.base.Entity;
import com.game.entities.player.items.base.Item;
import com.game.entities.player.items.base.ItemID;
import com.game.entities.player.items.tools.PickaxeItem;
import com.game.exceptions.image.restoring.NotEnoughInformationToRestoreImageException;
import com.game.logging.LogType;
import com.game.main.Drawable;
import com.game.main.Game;

public class ChestTransparentObject extends CollisionObject implements Drawable {
	
	public enum LootTable {
		
		HOME_FIRT_MAP_CHEST();

	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -1500721024614185753L;
	
	private Stack<Item<?>> stack;

	public ChestTransparentObject(int x, int y, int width, int height, ObjectType type, BufferedImage image) {
		
		super(x, y, width, height, type, image);
		this.stack = new Stack<Item<?>>();
		
		
	}
	
	public ChestTransparentObject(int x, int y, int width, int height, ObjectType type, BufferedImage image, ChestTransparentObject.LootTable table) {
		
		super(x, y, width, height, type, image);
		this.stack = new Stack<Item<?>>();
		
		switch (table) {
			case HOME_FIRT_MAP_CHEST:
				
				this.stack.push(new PickaxeItem(1, ItemID.PICKAXE_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(144, 0, 16, 16)));
				
				break;
	
			default:
				break;
				
		}
		
		
	}
	
	

	public ChestTransparentObject(int x, int y, int width, int height, ObjectType type, BufferedImage image, Stack<Item<?>> stack) {
		
		super(x, y, width, height, type, image);
		this.stack = stack;
		
		
	}


	@Empty
	@Unused
	@Override
	public void collide(Entity e) {
		
		
		
	}
	
	public void push(Item<?> item) {
		
		this.stack.push(item);
		
	}
	
	public Item<?> pop() {
		
		return this.stack.pop();
		
	}
	
	public Item<?> peek() {
		
		return this.stack.peek();
		
	}
	
	public Stack<Item<?>> getStack() {
		
		return this.stack;
		
	}
	
	public boolean isNotEmpty() {
		
		return !this.stack.empty();
		
	}
	
	public void breakItem() {
		
		while (this.isNotEmpty()) {
			
			Game.makeItemAtRandomWithItem(this.stack.pop(), this.x, this.y);
			
		}
		
		try {
			
			Game.fixAllImages();
			
		} catch (NotEnoughInformationToRestoreImageException e) {
			
			System.out.println("NotEnoughInformationToRestoreImageException: " + e.toString());
			
		}
		
		Game.logln("Player broke chest at X: " + this.x + ", Y: " + this.y, LogType.INFO);
		
	}

	@Override
	public void draw(Graphics2D g2d) {
		
		g2d.drawImage(this.image, this.x, this.y, this.width, this.height, null);
		
	}

}
