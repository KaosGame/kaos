package com.game.entities.player.items.objects;

import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;

import javax.swing.JOptionPane;

import com.game.collision.objects.TextSignObject;
import com.game.collision.objects.base.ObjectType;
import com.game.entities.player.items.base.Item;
import com.game.entities.player.items.base.ItemID;
import com.game.main.Game;

public class Sign1Item extends Item<Sign1Item> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7024150019459813439L;

	public Sign1Item(int count, ItemID id, BufferedImage image) {
		
		super(count, id, image);
		
		
	}

	@Override
	public Sign1Item cloneType() {
		return new Sign1Item(this.count, this.id, this.image);
	}

	@Override
	public void use() {
		
		this.count--;
		
		if (this.count <= 0) Game.PLAYER.getHotbar().list[Game.PLAYER.getHotbar().currentItemIndex] = null;
		
		String text = JOptionPane.showInputDialog(null, "What do you want your sign to say?", "Question", JOptionPane.QUESTION_MESSAGE);
		
		
		if (text != null) {
			
			Game.MAP_HANDLER.currentMap().addObject(
					new TextSignObject(
							(int) Game.PLAYER.getX(),
							(int) Game.PLAYER.getY(),
							128,
							128,
							ObjectType.SIGN_1,
							Game.OBJECT_TEXTRA_ALICE.getImageFrom(144, 0, 16, 16),
							text,
							new Color(0x000000),
							new Font("Verdana", Font.PLAIN, 16),
							10,
							32));
			
		}
		
		
	}

}
