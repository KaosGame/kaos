package com.game.entities.player;

import java.util.Arrays;

import com.game.entities.player.items.AxeItem;
import com.game.entities.player.items.Item;
import com.game.entities.player.items.ItemID;
import com.game.main.Game;

public class PlayerHotbar {
	
	public Item[] list;
	public byte currentItemIndex;
	
	public PlayerHotbar() {
		
		this.list = new Item[8];
		
		this.currentItemIndex = 0;
		
		Arrays.fill(this.list, null);
		
		this.list[0] = new AxeItem(1, ItemID.AXE_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(0, 0, 16, 16), 1f);
		
	}

	public void useCurrentItem() {
		
		if (this.list[this.currentItemIndex] != null) this.list[this.currentItemIndex].use();
		
	}

	public void addItem(Item item) {
		
		for (int i = 0; i < this.list.length; i++) {
			
			Item tempItem = this.list[i];
			
			if (tempItem == null || tempItem.getCount() >= Item.MAX_COUNT) continue;
			
			if (tempItem.getId() == item.getId()) {
				
				this.list[i].setCount((int) (this.list[i].getCount() + item.getCount()));
				this.list[i].setCount(Game.clamp(this.list[i].getCount(), Item.MAX_COUNT, 1));
				
				return;
				
			}
			
		}
		
		for (int i = 0; i < this.list.length; i++) {
			
			Item tempItem = this.list[i];
			
			if (tempItem == null) {
				
				this.list[i] = item;
				
				return;
				
			}
			
		}
		
	}
	
	public boolean returnBooleanAndAddItem(Item item) {
		
		for (int i = 0; i < this.list.length; i++) {
			
			Item tempItem = this.list[i];
			
			if (tempItem == null || tempItem.getCount() >= Item.MAX_COUNT) continue;
			
			if (tempItem.getId() == item.getId()) {
				
				this.list[i].setCount((int) (this.list[i].getCount() + item.getCount()));
				this.list[i].setCount(Game.clamp(this.list[i].getCount(), Item.MAX_COUNT, 1));
				
				return true;
				
			}
			
		}
		
		for (int i = 0; i < this.list.length; i++) {
			
			Item tempItem = this.list[i];
			
			if (tempItem == null) {
				
				this.list[i] = item;
				
				return true;
				
			}
			
		}
		
		return false;
		
	}

}
