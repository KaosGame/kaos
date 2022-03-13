package com.game.collision.objects;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Stack;

import com.game.annotations.Empty;
import com.game.annotations.Unused;
import com.game.collision.objects.base.CollisionObject;
import com.game.collision.objects.base.ObjectType;
import com.game.entities.player.items.base.Item;
import com.game.exceptions.image.restoring.NotEnoughInformationToRestoreImageException;
import com.game.main.Drawable;
import com.game.main.Game;

public class ChestTransparentObject extends CollisionObject implements Drawable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1500721024614185753L;
	
	private Stack<Item<?>> stack;

	public ChestTransparentObject(int x, int y, int width, int height, ObjectType type, BufferedImage image) {
		
		super(x, y, width, height, type, image);
		this.stack = new Stack<Item<?>>();
		
		
	}
	
	

	public ChestTransparentObject(int x, int y, int width, int height, ObjectType type, BufferedImage image, Stack<Item<?>> stack) {
		
		super(x, y, width, height, type, image);
		this.stack = stack;
		
		
	}


	@Empty
	@Unused
	@Override
	public void collide() {
		
		
		
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
		
	}

	@Override
	public void draw(Graphics2D g2d) {
		
		g2d.drawImage(this.image, this.x, this.y, this.width, this.height, null);
		
	}

}
