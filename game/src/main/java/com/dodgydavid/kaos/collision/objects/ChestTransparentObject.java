package com.dodgydavid.kaos.collision.objects;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Stack;

import com.dodgydavid.kaos.collision.objects.base.CollisionObject;
import com.dodgydavid.kaos.collision.objects.base.ObjectType;
import com.dodgydavid.kaos.entities.base.Entity;
import com.dodgydavid.kaos.entities.player.items.base.Item;
import com.dodgydavid.kaos.entities.player.items.base.ItemID;
import com.dodgydavid.kaos.entities.player.items.dimension.teleporters.FishLandDimensionTeleporterItem;
import com.dodgydavid.kaos.entities.player.items.food.BurgerFoodItem;
import com.dodgydavid.kaos.entities.player.items.food.PizzaFoodItem;
import com.dodgydavid.kaos.entities.player.items.fun.LeafBlower;
import com.dodgydavid.kaos.entities.player.items.tools.FishingRodItem;
import com.dodgydavid.kaos.entities.player.items.tools.PickaxeItem;
import com.dodgydavid.kaos.entities.player.items.tools.weapon.SwordItem;
import com.dodgydavid.kaos.entities.player.items.tools.weapon.bow.standard.BowStandardItem;
import com.dodgydavid.kaos.exceptions.image.restoring.NotEnoughInformationToRestoreImageException;
import com.dodgydavid.kaos.logging.LogType;
import com.dodgydavid.kaos.main.Drawable;
import com.dodgydavid.kaos.main.Game;

public class ChestTransparentObject extends CollisionObject implements Drawable {
	
	public enum LootTable {
		
		HOME_FIRT_MAP_CHEST(),
		START_FTART_MAP_FISH_LAND();

	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -1500721024614185753L;
	
	private Stack<Item<?>> stack;

	public ChestTransparentObject(int x, int y, int width, int height, ObjectType type, BufferedImage image) {
		
		super(x, y, width, height, type, image, false);
		this.stack = new Stack<Item<?>>();
		
		
	}
	
	public ChestTransparentObject(int x, int y, int width, int height, ObjectType type, BufferedImage image, ChestTransparentObject.LootTable table) {
		
		super(x, y, width, height, type, image, false);
		this.stack = new Stack<Item<?>>();
		
		switch (table) {
		
		
			case HOME_FIRT_MAP_CHEST:
				
				this.stack.push(new PickaxeItem(1, ItemID.PICKAXE_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(144, 0, 16, 16)));
				this.stack.push(new FishingRodItem(1, ItemID.FISHING_ROD_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(416, 0, 16, 16)));
				this.stack.push(new SwordItem(1, ItemID.SWORD_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(496, 0, 16, 16)));
				this.stack.push(new BowStandardItem(1, ItemID.BOW_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(48, 16, 16, 16)));
				this.stack.push(new LeafBlower(1));
				
				break;
				
				
			case START_FTART_MAP_FISH_LAND:
				
				this.stack.push(new FishLandDimensionTeleporterItem(1, ItemID.FISH_LAND_TELEPORTER_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(32, 16, 16, 16)));
				this.stack.push(new PizzaFoodItem(2, ItemID.PIZZA_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(0, 16, 16, 16)));
				this.stack.push(new BurgerFoodItem(5, ItemID.BURGER_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(16, 16, 16, 16)));
				this.stack.push(new FishingRodItem(1, ItemID.FISHING_ROD_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(416, 0, 16, 16)));
				
				break;
				
			
	
		}
		
		
	}
	
	

	public ChestTransparentObject(int x, int y, int width, int height, ObjectType type, BufferedImage image, Stack<Item<?>> stack) {
		
		super(x, y, width, height, type, image, false);
		this.stack = stack;
		
		
	}


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
