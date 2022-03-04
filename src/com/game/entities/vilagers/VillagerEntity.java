package com.game.entities.vilagers;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.game.entities.base.Entity;
import com.game.entities.base.EntityID;
import com.game.entities.player.items.Wood1Item;
import com.game.entities.player.items.base.ItemID;
import com.game.main.Game;

public class VillagerEntity extends Entity implements Trading {
	
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
		
		if (this.tradeItem == VillagerTrades.ALLPE_TO_COIN) {
			
			Wood1Item tempItem = new Wood1Item(5, ItemID.WOOD_1, null);
			
			if (Game.PLAYER.getHotbar().hasItemValue(tempItem) >= 5) {
				
				Game.PLAYER.getHotbar().removeItem(tempItem);
				
				Game.PLAYER.addCoins(2L);
				
			}
			
		}
		
	}
	
	@Override
	public void tradeAll() {
		
		Wood1Item tempItem = new Wood1Item(5, ItemID.WOOD_1, null);
		
		if (this.tradeItem == VillagerTrades.ALLPE_TO_COIN) {
			
			while (Game.PLAYER.getHotbar().hasItemValue(tempItem) >= 5) {
				
				Game.PLAYER.getHotbar().removeItem(tempItem);
				
				Game.PLAYER.addCoins(2L);
				
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
		
		if (this.touchingPlayer && this.tradeItem == VillagerTrades.ALLPE_TO_COIN) {
			
			g2d.drawImage(Game.OBJECT_TEXTRA_ALICE.getImageFrom(96, 0, 16, 16), 325, 25, 64, 64, null);
			
			g2d.setColor(new Color(0x000000));
			g2d.setFont(new Font("Verdana", Font.PLAIN, 18));
			g2d.drawString("5  -->  2", 400, 50);
			
			g2d.drawImage(Game.OBJECT_TEXTRA_ALICE.getImageFrom(192, 0, 16, 16), 490, 25, 64, 64, null);
			
		}
		
	}

}
