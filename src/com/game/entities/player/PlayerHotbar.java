package com.game.entities.player;

import java.util.Arrays;

import com.game.entities.player.items.AxeItem;
import com.game.entities.player.items.Item;
import com.game.entities.player.items.ItemID;
import com.game.main.Game;

public class PlayerHotbar {
	
	public Item[] list;
	
	public PlayerHotbar() {
		
		this.list = new Item[8];
		
		Arrays.fill(this.list, null);
		
		this.list[0] = new AxeItem(1, ItemID.AXE, Game.ITEM_TEXTRA_ALICE.getImageFrom(0, 0, 16, 16), 1f);
		
	}

}
