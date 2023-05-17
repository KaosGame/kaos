package com.dodgydavid.kaos.entities.player.items.food;

import java.awt.image.BufferedImage;

import com.dodgydavid.kaos.entities.player.Player;
import com.dodgydavid.kaos.entities.player.items.base.FoodItem;
import com.dodgydavid.kaos.entities.player.items.base.ItemID;
import com.dodgydavid.kaos.main.Game;

public class OrangeJuce1Item extends FoodItem<OrangeJuce1Item> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5918197020543028777L;

	public OrangeJuce1Item(int count, ItemID id, BufferedImage image) {
		
		super(count, id, image, 3);
		
		
	}
	
	@Override
	public void eat() {
		
		if (Game.PLAYER.getHunger() != Player.MAX_HUNGER) {
			
			this.count--;
			
			if (this.count <= 0) Game.PLAYER.getHotbar().list[Game.PLAYER.getHotbar().currentItemIndex] = null;
			
			Game.PLAYER.addHungerValue(this.hungerValue);
			
			Player.SPEED = Player.ORANGE_JUCE_1_SPEED;
			
		}
		
	}

	@Override
	public OrangeJuce1Item cloneType() {
		return new OrangeJuce1Item(this.count, this.id, this.image);
	}

}
