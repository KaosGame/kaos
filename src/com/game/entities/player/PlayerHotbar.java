package com.game.entities.player;

import java.io.Serializable;
import java.util.Arrays;

import com.game.entities.player.items.base.Item;
import com.game.entities.player.items.base.ItemID;
import com.game.entities.player.items.food.Pie1Item;
import com.game.entities.player.items.tools.weapon.AxeItem;
import com.game.main.CloneableType;
import com.game.main.Game;
import com.game.main.Updatable;

public class PlayerHotbar implements CloneableType<PlayerHotbar>, Serializable, Updatable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9135414757537261342L;
	
	public Item<?>[] list;
	public byte currentItemIndex;
	
	public PlayerHotbar() {
		
		this.list = new Item<?>[8];
		
		this.currentItemIndex = 0;
		
		Arrays.fill(this.list, null);
		
		this.list[0] = new AxeItem(1, ItemID.AXE_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(0, 0, 16, 16));
		this.list[7] = new Pie1Item(8, ItemID.PIE_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(80, 0, 16, 16));
		
	}
	
	

	private PlayerHotbar(Item<?>[] list, byte currentItemIndex) {
		
		super();
		
		this.list = list;
		this.currentItemIndex = currentItemIndex;
		
	}



	public void useCurrentItem() {
		
		if (this.list[this.currentItemIndex] != null) this.list[this.currentItemIndex].use();
		
	}

	public void addItem(Item<?> item) {
		
		for (int i = 0; i < this.list.length; i++) {
			
			Item<?> tempItem = this.list[i];
			
			if (tempItem == null || tempItem.getCount() >= Item.MAX_COUNT) continue;
			
			if (tempItem.getId() == item.getId()) {
				
				this.list[i].setCount((int) (this.list[i].getCount() + item.getCount()));
				this.list[i].setCount(Game.clamp(this.list[i].getCount(), Item.MAX_COUNT, 1));
				
				return;
				
			}
			
		}
		
		for (int i = 0; i < this.list.length; i++) {
			
			Item<?> tempItem = this.list[i];
			
			if (tempItem == null) {
				
				this.list[i] = item;
				
				return;
				
			}
			
		}
		
	}
	
	public boolean returnBooleanAndAddItem(Item<?> item) {
		
		for (int i = 0; i < this.list.length; i++) {
			
			Item<?> tempItem = this.list[i];
			
			if (tempItem == null || tempItem.getCount() >= Item.MAX_COUNT) continue;
			
			if (tempItem.getId() == item.getId()) {
				
				this.list[i].setCount((int) (this.list[i].getCount() + item.getCount()));
				this.list[i].setCount(Game.clamp(this.list[i].getCount(), Item.MAX_COUNT, 1));
				
				return true;
				
			}
			
		}
		
		for (int i = 0; i < this.list.length; i++) {
			
			Item<?> tempItem = this.list[i];
			
			if (tempItem == null) {
				
				this.list[i] = item;
				
				return true;
				
			}
			
		}
		
		return false;
		
	}
	
	public boolean hasItem(Item<?> item) {
		
		for (int i = 0; i < this.list.length; i++) {
			
			Item<?> tempItem = this.list[i];
			
			if (tempItem == null || tempItem.getCount() > Item.MAX_COUNT) continue;
			
			if (item.getClass() == this.list[i].getClass()) {
				
				return true;
				
			}
			
		}
		
		return false;
		
	}
	
	public int hasItemValue(Item<?> item) {
		
		for (int i = 0; i < this.list.length; i++) {
			
			Item<?> tempItem = this.list[i];
			
			if (tempItem == null || tempItem.getCount() > Item.MAX_COUNT) continue;
			
			if (item.getClass() == this.list[i].getClass()) {
				
				return this.list[i].getCount();
				
			}
			
		}
		
		return -1;
		
	}
	public void removeItem(Item<?> item) {
		
		for (int i = 0; i < this.list.length; i++) {
			
			Item<?> tempItem = this.list[i];
			
			if (tempItem == null || tempItem.getCount() > Item.MAX_COUNT) continue;
			
			if (tempItem.getId() == item.getId()) {
				
				this.list[i].setCount((int) (this.list[i].getCount() - item.getCount()));
				this.list[i].setCount(Game.clamp(this.list[i].getCount(), Item.MAX_COUNT, 0));
				
				if (this.list[i].getCount() <= 0) {
					
					this.list[i] = null;
					
				}
				
				return;
				
			}
			
		}
		
	}
	
	public boolean returnBooleanAndRmoveItem(Item<?> item) {
		
		for (int i = 0; i < this.list.length; i++) {
			
			Item<?> tempItem = this.list[i];
			
			if (tempItem == null || tempItem.getCount() > Item.MAX_COUNT) continue;
			
			if (tempItem.getId() == item.getId()) {
				
				this.list[i].setCount((int) (this.list[i].getCount() - item.getCount()));
				this.list[i].setCount(Game.clamp(this.list[i].getCount(), Item.MAX_COUNT, 0));
				
				if (this.list[i].getCount() <= 0) {
					
					this.list[i] = null;
					
				}
				
				return true;
				
			}
			
		}
		
		return false;
		
	}
	
	public Item<?> getCurrentItem() {
		
		return this.list[this.currentItemIndex];
		
	}
	
	public void setCurrentItem(Item<?> item) {
		
		this.list[this.currentItemIndex] = item;
		
	}

	@Override
	public PlayerHotbar cloneType() {
		return new PlayerHotbar(this.list, this.currentItemIndex);
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + currentItemIndex;
		result = prime * result + Arrays.hashCode(list);
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlayerHotbar other = (PlayerHotbar) obj;
		if (currentItemIndex != other.currentItemIndex)
			return false;
		if (!Arrays.equals(list, other.list))
			return false;
		return true;
	}



	@Override
	public void update() {
		
		if (this.getCurrentItem() instanceof Updatable) ((Updatable) this.getCurrentItem()).update();
		
	}

}
