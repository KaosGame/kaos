package com.game.entities.player.items.fun;

import com.game.annotations.Empty;
import com.game.annotations.NotNeeded;
import com.game.annotations.Unused;
import com.game.entities.player.items.base.Item;
import com.game.entities.player.items.base.ItemID;
import com.game.main.Game;

public class BankMaskItem extends Item<BankMaskItem> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3071028143327356744L;

	public BankMaskItem(int count) {
		super(count, ItemID.BANK_MASK_ITEM, Game.ITEM_TEXTRA_ALICE.getImageFrom(128, 16, 16, 16));
		
		
	}

	@Override
	public BankMaskItem cloneType() {
		return new BankMaskItem(this.count);
	}

	@NotNeeded
	@Unused
	@Empty
	@Override
	public void use() {
		
	}

}
