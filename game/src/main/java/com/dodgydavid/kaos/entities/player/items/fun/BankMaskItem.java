package com.dodgydavid.kaos.entities.player.items.fun;

import com.dodgydavid.kaos.entities.player.items.base.Item;
import com.dodgydavid.kaos.entities.player.items.base.ItemID;
import com.dodgydavid.kaos.main.Game;

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

	@Override
	public void use() {
		
	}

}
