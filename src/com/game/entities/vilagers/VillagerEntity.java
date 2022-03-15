package com.game.entities.vilagers;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.game.entities.base.Entity;
import com.game.entities.base.EntityID;
import com.game.entities.player.items.base.ItemID;
import com.game.entities.player.items.food.Apple1Item;
import com.game.entities.player.items.food.Pie1Item;
import com.game.entities.player.items.food.Taco1Item;
import com.game.entities.player.items.objects.Chest1Item;
import com.game.entities.player.items.objects.DiamondOre1Item;
import com.game.entities.player.items.objects.GoldOre1Item;
import com.game.entities.player.items.objects.IronOre1Item;
import com.game.entities.player.items.objects.Sign1Item;
import com.game.entities.player.items.objects.Stone1Item;
import com.game.entities.player.items.objects.Wood1Item;
import com.game.main.Game;

public class VillagerEntity extends Entity implements Trading {
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -728672425856786000L;

	private boolean touchingPlayer;
	
	private VillagerTrades tradeItem;

	public VillagerEntity(float x, float y, float xv, float yv, int width, int height, EntityID id,
			BufferedImage image, VillagerTrades tradeItem) {
		
		super(x, y, xv, yv, width, height, id, image);
		
		this.touchingPlayer = false;
		this.tradeItem = tradeItem;
		
		
	}

	@Override
	public void update() {
		
		this.handleEntities();
		
	}

	private void handleEntities() {
		
		if (Game.PLAYER.getRectangle().intersects(this.getRectangle())) {
			
			this.touchingPlayer = true;
			
		} else {
			
			this.touchingPlayer = false;
			
		}
		
	}

	@Override
	public void trade() {
		
		if (this.tradeItem == VillagerTrades.WOOD_TO_COIN) {
			
			Wood1Item tempItem = new Wood1Item(5, ItemID.WOOD_1, null);
			
			if (Game.PLAYER.getHotbar().hasItemValue(tempItem) >= 5) {
				
				Game.PLAYER.getHotbar().removeItem(tempItem);
				
				Game.PLAYER.addCoins(2L);
				
			}
			
		} else if (this.tradeItem == VillagerTrades.COIN_TO_TACO) {
			
			if (Game.PLAYER.getCoins() >= 2) {
				
				Game.PLAYER.removeCoins(2L);
				
				Taco1Item item = new Taco1Item(1, ItemID.TACO_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(96, 0, 16, 16));
				
				if (!Game.PLAYER.getHotbar().returnBooleanAndAddItem(item)) {
					
					Game.makeItemAtRandomWithItem(item);
					
				}
				
			}
			
		} else if (this.tradeItem == VillagerTrades.APPLE_TO_COIN) {
			
			Apple1Item tempItem = new Apple1Item(2, ItemID.APPLE_1, null);
			
			if (Game.PLAYER.getHotbar().hasItemValue(tempItem) >= 2) {
				
				Game.PLAYER.getHotbar().removeItem(tempItem);
				
				Game.PLAYER.addCoins(5L);
				
			}
			
		} else if (this.tradeItem == VillagerTrades.COIN_TO_PIE) {
			
			if (Game.PLAYER.getCoins() >= 4) {
				
				Game.PLAYER.removeCoins(4L);
				
				Pie1Item item = new Pie1Item(1, ItemID.PIE_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(80, 0, 16, 16));
				
				if (!Game.PLAYER.getHotbar().returnBooleanAndAddItem(item)) {
					
					Game.makeItemAtRandomWithItem(item);
					
				}
				
			}
			
		} else if (this.tradeItem == VillagerTrades.COIN_TO_CHEST) {
			
			if (Game.PLAYER.getCoins() >= 8) {
				
				Game.PLAYER.removeCoins(8L);
				
				Chest1Item item = new Chest1Item(1, ItemID.CHEST_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(112, 0, 16, 16));
				
				if (!Game.PLAYER.getHotbar().returnBooleanAndAddItem(item)) {
					
					Game.makeItemAtRandomWithItem(item);
					
				}
				
			}
			
		} else if (this.tradeItem == VillagerTrades.WOOD_TO_SIGN) {
			
			Wood1Item tempItem = new Wood1Item(7, ItemID.WOOD_1, null);
			
			if (Game.PLAYER.getHotbar().hasItemValue(tempItem) >= 2) {
				
				Game.PLAYER.getHotbar().removeItem(tempItem);
				
				Sign1Item item = new Sign1Item(1, ItemID.SIGN_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(128, 0, 16, 16));
				
				if (!Game.PLAYER.getHotbar().returnBooleanAndAddItem(item)) {
					
					Game.makeItemAtRandomWithItem(item);
					
				}
				
			}
			
		} else if (this.tradeItem == VillagerTrades.STONE_TO_COIN) {
			
			Stone1Item tempItem = new Stone1Item(1, ItemID.STONE_1, null);
			
			if (Game.PLAYER.getHotbar().hasItemValue(tempItem) >= 1) {
				
				Game.PLAYER.getHotbar().removeItem(tempItem);
				
				Game.PLAYER.addCoins(5L);
				
			}
			
		} else if (this.tradeItem == VillagerTrades.IRON_ORE_TO_COIN) {
			
			IronOre1Item tempItem = new IronOre1Item(1, ItemID.IRON_ORE_1, null);
			
			if (Game.PLAYER.getHotbar().hasItemValue(tempItem) >= 1) {
				
				Game.PLAYER.getHotbar().removeItem(tempItem);
				
				Game.PLAYER.addCoins(10L);
				
			}
			
		} else if (this.tradeItem == VillagerTrades.GOLD_ORE_TO_COIN) {
			
			GoldOre1Item tempItem = new GoldOre1Item(1, ItemID.GOLD_ORE_1, null);
			
			if (Game.PLAYER.getHotbar().hasItemValue(tempItem) >= 1) {
				
				Game.PLAYER.getHotbar().removeItem(tempItem);
				
				Game.PLAYER.addCoins(15L);
				
			}
			
		} else if (this.tradeItem == VillagerTrades.DIAMOND_ORE_TO_COIN) {
			
			DiamondOre1Item tempItem = new DiamondOre1Item(1, ItemID.DIAMOND_ORE_1, null);
			
			if (Game.PLAYER.getHotbar().hasItemValue(tempItem) >= 1) {
				
				Game.PLAYER.getHotbar().removeItem(tempItem);
				
				Game.PLAYER.addCoins(20L);
				
			}
			
		}
		
	}
	
	@Override
	public void tradeAll() {
		
		if (this.tradeItem == VillagerTrades.WOOD_TO_COIN) {
			
			Wood1Item tempItem = new Wood1Item(5, ItemID.WOOD_1, null);
			
			while (Game.PLAYER.getHotbar().hasItemValue(tempItem) >= 5) {
				
				Game.PLAYER.getHotbar().removeItem(tempItem);
				
				Game.PLAYER.addCoins(2L);
				
			}
			
		} else if (this.tradeItem == VillagerTrades.COIN_TO_TACO) {
			
			while (Game.PLAYER.getCoins() >= 2) {
				
				Game.PLAYER.removeCoins(2L);
				
				Taco1Item item = new Taco1Item(1, ItemID.TACO_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(96, 0, 16, 16));
				
				if (!Game.PLAYER.getHotbar().returnBooleanAndAddItem(item)) {
					
					Game.makeItemAtRandomWithItem(item);
					
				}
				
			}
			
		} else if (this.tradeItem == VillagerTrades.APPLE_TO_COIN) {
			
			Apple1Item tempItem = new Apple1Item(2, ItemID.APPLE_1, null);
			
			while (Game.PLAYER.getHotbar().hasItemValue(tempItem) >= 2) {
				
				Game.PLAYER.getHotbar().removeItem(tempItem);
				
				Game.PLAYER.addCoins(5L);
				
			}
			
		} else if (this.tradeItem == VillagerTrades.COIN_TO_PIE) {
			
			while (Game.PLAYER.getCoins() >= 4) {
				
				Game.PLAYER.removeCoins(4L);
				
				Pie1Item item = new Pie1Item(1, ItemID.PIE_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(80, 0, 16, 16));
				
				if (!Game.PLAYER.getHotbar().returnBooleanAndAddItem(item)) {
					
					Game.makeItemAtRandomWithItem(item);
					
				}
				
			}
			
		} else if (this.tradeItem == VillagerTrades.COIN_TO_CHEST) {
			
			while (Game.PLAYER.getCoins() >= 8) {
				
				Game.PLAYER.removeCoins(8L);
				
				Chest1Item item = new Chest1Item(1, ItemID.CHEST_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(112, 0, 16, 16));
				
				if (!Game.PLAYER.getHotbar().returnBooleanAndAddItem(item)) {
					
					Game.makeItemAtRandomWithItem(item);
					
				}
				
			}
			
		} else if (this.tradeItem == VillagerTrades.WOOD_TO_SIGN) {
			
			Wood1Item tempItem = new Wood1Item(7, ItemID.WOOD_1, null);
			
			while (Game.PLAYER.getHotbar().hasItemValue(tempItem) >= 2) {
				
				Game.PLAYER.getHotbar().removeItem(tempItem);
				
				Sign1Item item = new Sign1Item(1, ItemID.SIGN_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(128, 0, 16, 16));
				
				if (!Game.PLAYER.getHotbar().returnBooleanAndAddItem(item)) {
					
					Game.makeItemAtRandomWithItem(item);
					
				}
				
			}
			
		} else if (this.tradeItem == VillagerTrades.STONE_TO_COIN) {
			
			Stone1Item tempItem = new Stone1Item(1, ItemID.STONE_1, null);
			
			while (Game.PLAYER.getHotbar().hasItemValue(tempItem) >= 1) {
				
				Game.PLAYER.getHotbar().removeItem(tempItem);
				
				Game.PLAYER.addCoins(5L);
				
			}
			
		} else if (this.tradeItem == VillagerTrades.IRON_ORE_TO_COIN) {
			
			IronOre1Item tempItem = new IronOre1Item(1, ItemID.IRON_ORE_1, null);
			
			while (Game.PLAYER.getHotbar().hasItemValue(tempItem) >= 1) {
				
				Game.PLAYER.getHotbar().removeItem(tempItem);
				
				Game.PLAYER.addCoins(10L);
				
			}
			
		} else if (this.tradeItem == VillagerTrades.GOLD_ORE_TO_COIN) {
			
			GoldOre1Item tempItem = new GoldOre1Item(1, ItemID.GOLD_ORE_1, null);
			
			while (Game.PLAYER.getHotbar().hasItemValue(tempItem) >= 1) {
				
				Game.PLAYER.getHotbar().removeItem(tempItem);
				
				Game.PLAYER.addCoins(15L);
				
			}
			
		} else if (this.tradeItem == VillagerTrades.DIAMOND_ORE_TO_COIN) {
			
			DiamondOre1Item tempItem = new DiamondOre1Item(1, ItemID.DIAMOND_ORE_1, null);
			
			while (Game.PLAYER.getHotbar().hasItemValue(tempItem) >= 1) {
				
				Game.PLAYER.getHotbar().removeItem(tempItem);
				
				Game.PLAYER.addCoins(20L);
				
			}
			
		}
		
	}

	public boolean isTouchingPlayer() {
		
		return this.touchingPlayer;
		
	}

	public void setTouchingPlayer(boolean touchingPlayer) {
		
		this.touchingPlayer = touchingPlayer;
		
	}
	
	@Override
	public void draw(Graphics2D g2d) {
		
		g2d.drawImage(this.image, (int) this.x, (int) this.y, this.width, this.height, null);
		
		if (this.touchingPlayer && this.tradeItem == VillagerTrades.WOOD_TO_COIN) {
			
			g2d.drawImage(Game.OBJECT_TEXTRA_ALICE.getImageFrom(96, 0, 16, 16), 325, 25, 64, 64, null);
			
			g2d.setColor(new Color(0x000000));
			g2d.setFont(new Font("Verdana", Font.PLAIN, 18));
			g2d.drawString("5  -->  2", 400, 50);
			
			g2d.drawImage(Game.OBJECT_TEXTRA_ALICE.getImageFrom(192, 0, 16, 16), 490, 25, 64, 64, null);
			
		} else if (this.touchingPlayer && this.tradeItem == VillagerTrades.COIN_TO_TACO) {
			
			g2d.drawImage(Game.OBJECT_TEXTRA_ALICE.getImageFrom(192, 0, 16, 16), 325, 25, 64, 64, null);
			
			g2d.setColor(new Color(0x000000));
			g2d.setFont(new Font("Verdana", Font.PLAIN, 18));
			g2d.drawString("2  -->  1", 400, 50);
			
			g2d.drawImage(Game.ITEM_TEXTRA_ALICE.getImageFrom(96, 0, 16, 16), 490, 25, 64, 64, null);
			
		}  else if (this.touchingPlayer && this.tradeItem == VillagerTrades.APPLE_TO_COIN) {
			
			g2d.drawImage(Game.ITEM_TEXTRA_ALICE.getImageFrom(64, 0, 16, 16), 325, 25, 64, 64, null);
			
			g2d.setColor(new Color(0x000000));
			g2d.setFont(new Font("Verdana", Font.PLAIN, 18));
			g2d.drawString("2  -->  5", 400, 50);
			
			g2d.drawImage(Game.OBJECT_TEXTRA_ALICE.getImageFrom(192, 0, 16, 16), 490, 25, 64, 64, null);
			
		}  else if (this.touchingPlayer && this.tradeItem == VillagerTrades.COIN_TO_PIE) {
			
			g2d.drawImage(Game.OBJECT_TEXTRA_ALICE.getImageFrom(192, 0, 16, 16), 325, 25, 64, 64, null);
			
			g2d.setColor(new Color(0x000000));
			g2d.setFont(new Font("Verdana", Font.PLAIN, 18));
			g2d.drawString("4  -->  1", 400, 50);
			
			g2d.drawImage(Game.ITEM_TEXTRA_ALICE.getImageFrom(80, 0, 16, 16), 490, 25, 64, 64, null);
			
		} else if (this.touchingPlayer && this.tradeItem == VillagerTrades.COIN_TO_CHEST) {
			
			g2d.drawImage(Game.OBJECT_TEXTRA_ALICE.getImageFrom(192, 0, 16, 16), 325, 25, 64, 64, null);
			
			g2d.setColor(new Color(0x000000));
			g2d.setFont(new Font("Verdana", Font.PLAIN, 18));
			g2d.drawString("8  -->  1", 400, 50);
			
			g2d.drawImage(Game.ITEM_TEXTRA_ALICE.getImageFrom(112, 0, 16, 16), 490, 25, 64, 64, null);
			
		} else if (this.touchingPlayer && this.tradeItem == VillagerTrades.WOOD_TO_SIGN) {
			
			g2d.drawImage(Game.OBJECT_TEXTRA_ALICE.getImageFrom(96, 0, 16, 16), 325, 25, 64, 64, null);
			
			g2d.setColor(new Color(0x000000));
			g2d.setFont(new Font("Verdana", Font.PLAIN, 18));
			g2d.drawString("7  -->  1", 400, 50);
			
			g2d.drawImage(Game.ITEM_TEXTRA_ALICE.getImageFrom(128, 0, 16, 16), 490, 25, 64, 64, null);
			
		} else if (this.touchingPlayer && this.tradeItem == VillagerTrades.STONE_TO_COIN) {
			
			g2d.drawImage(Game.ITEM_TEXTRA_ALICE.getImageFrom(160, 0, 16, 16), 325, 25, 64, 64, null);
			
			g2d.setColor(new Color(0x000000));
			g2d.setFont(new Font("Verdana", Font.PLAIN, 18));
			g2d.drawString("1  -->  5", 400, 50);
			
			g2d.drawImage(Game.OBJECT_TEXTRA_ALICE.getImageFrom(192, 0, 16, 16), 490, 25, 64, 64, null);
			
		} else if (this.touchingPlayer && this.tradeItem == VillagerTrades.IRON_ORE_TO_COIN) {
			
			g2d.drawImage(Game.ITEM_TEXTRA_ALICE.getImageFrom(176, 0, 16, 16), 325, 25, 64, 64, null);
			
			g2d.setColor(new Color(0x000000));
			g2d.setFont(new Font("Verdana", Font.PLAIN, 18));
			g2d.drawString("1  -->  10", 400, 50);
			
			g2d.drawImage(Game.OBJECT_TEXTRA_ALICE.getImageFrom(192, 0, 16, 16), 490, 25, 64, 64, null);
			
		} else if (this.touchingPlayer && this.tradeItem == VillagerTrades.GOLD_ORE_TO_COIN) {
			
			g2d.drawImage(Game.ITEM_TEXTRA_ALICE.getImageFrom(192, 0, 16, 16), 325, 25, 64, 64, null);
			
			g2d.setColor(new Color(0x000000));
			g2d.setFont(new Font("Verdana", Font.PLAIN, 18));
			g2d.drawString("1  -->  15", 400, 50);
			
			g2d.drawImage(Game.OBJECT_TEXTRA_ALICE.getImageFrom(192, 0, 16, 16), 490, 25, 64, 64, null);
			
		} else if (this.touchingPlayer && this.tradeItem == VillagerTrades.DIAMOND_ORE_TO_COIN) {
			
			g2d.drawImage(Game.ITEM_TEXTRA_ALICE.getImageFrom(208, 0, 16, 16), 325, 25, 64, 64, null);
			
			g2d.setColor(new Color(0x000000));
			g2d.setFont(new Font("Verdana", Font.PLAIN, 18));
			g2d.drawString("1  -->  20", 400, 50);
			
			g2d.drawImage(Game.OBJECT_TEXTRA_ALICE.getImageFrom(192, 0, 16, 16), 490, 25, 64, 64, null);
			
		}
		
	}

}
