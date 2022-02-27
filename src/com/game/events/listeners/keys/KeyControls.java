package com.game.events.listeners.keys;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import com.game.annotations.Empty;
import com.game.annotations.Unused;
import com.game.entities.player.Player;
import com.game.entities.player.items.Item;
import com.game.entities.player.items.WeaponItem;
import com.game.main.Game;

public class KeyControls implements KeyListener {
	
	@Unused
	@Empty
	@Override
	public void keyTyped(KeyEvent event) {
		
		
	}

	@Override
	public void keyPressed(KeyEvent event) {
		
		int key = event.getKeyCode();
		
		if (KeyEvent.VK_SHIFT == key) {
			
			Player.SPEED = Player.DASH_SPEED;
			
		}
		
		if (KeyEvent.VK_W == key || KeyEvent.VK_UP == key) {
			
			Game.PLAYER.setKeyDownAt(0, true);
			
		}
		
		if (KeyEvent.VK_S == key || KeyEvent.VK_DOWN == key) {
			
			Game.PLAYER.setKeyDownAt(1, true);
			
		}
		
		if (KeyEvent.VK_A == key || KeyEvent.VK_LEFT == key) {
			
			Game.PLAYER.setKeyDownAt(2, true);
			
		}
		
		if (KeyEvent.VK_D == key || KeyEvent.VK_RIGHT == key) {
			
			Game.PLAYER.setKeyDownAt(3, true);
			
		}
		
		if (KeyEvent.VK_SPACE == key) {
			
			Game.PLAYER.useItem();
			
		}
		
	}

	@Override
	public void keyReleased(KeyEvent event) {
		
		int key = event.getKeyCode();
		
		
		if (KeyEvent.VK_SHIFT == key) {
			
			Player.SPEED = Player.DEFAULT_SPEED;
			
		}
		
		if (KeyEvent.VK_W == key || KeyEvent.VK_UP == key) {
			
			Game.PLAYER.setKeyDownAt(0, false);
			
		}
		
		if (KeyEvent.VK_S == key || KeyEvent.VK_DOWN == key) {
			
			Game.PLAYER.setKeyDownAt(1, false);
			
		}
		
		if (KeyEvent.VK_A == key || KeyEvent.VK_LEFT == key) {
			
			Game.PLAYER.setKeyDownAt(2, false);
			
		}
		
		if (KeyEvent.VK_D == key || KeyEvent.VK_RIGHT == key) {
			
			Game.PLAYER.setKeyDownAt(3, false);
			
		}
		
		
		
		if (KeyEvent.VK_1 == key) {
			
			Game.PLAYER.getHotbar().currentItemIndex = 0;
			
		}
		
		if (KeyEvent.VK_2 == key) {
			
			Game.PLAYER.getHotbar().currentItemIndex = 1;
			
		}
		
		if (KeyEvent.VK_3 == key) {
			
			Game.PLAYER.getHotbar().currentItemIndex = 2;
			
		}
		
		if (KeyEvent.VK_4 == key) {
			
			Game.PLAYER.getHotbar().currentItemIndex = 3;
			
		}
		
		if (KeyEvent.VK_5 == key) {
			
			Game.PLAYER.getHotbar().currentItemIndex = 4;
			
		}
		
		if (KeyEvent.VK_6 == key) {
			
			Game.PLAYER.getHotbar().currentItemIndex = 5;
			
		}
		
		if (KeyEvent.VK_7 == key) {
			
			Game.PLAYER.getHotbar().currentItemIndex = 6;
			
		}
		
		if (KeyEvent.VK_8 == key) {
			
			Game.PLAYER.getHotbar().currentItemIndex = 7;
			
		}
		
		
		
		if (KeyEvent.VK_X == key) {
			
			Game.PLAYER.getHotbar().list[Game.PLAYER.getHotbar().currentItemIndex] = null;
			
		}
		
		if (KeyEvent.VK_Z == key) {
			
			if (Game.PLAYER.getHotbar().list[Game.PLAYER.getHotbar().currentItemIndex] != null) {
				
				Game.PLAYER.getHotbar().list[Game.PLAYER.getHotbar().currentItemIndex].setCount((int) (Game.PLAYER.getHotbar().list[Game.PLAYER.getHotbar().currentItemIndex].getCount() - 1));
				
				if (Game.PLAYER.getHotbar().list[Game.PLAYER.getHotbar().currentItemIndex].getCount() <= 0) {
					
					Game.PLAYER.getHotbar().list[Game.PLAYER.getHotbar().currentItemIndex] = null;
					
				}
				
			}
			
		}
		
		if (KeyEvent.VK_COMMA == key) {
			
			if (Game.PLAYER.getHotbar().list[Game.PLAYER.getHotbar().currentItemIndex] != null) {
				
				float[] pos = this.getRandomItemPos();
				
				if (Game.PLAYER.getHotbar().list[Game.PLAYER.getHotbar().currentItemIndex] instanceof WeaponItem) {
					
					WeaponItem<?> dropItem = (WeaponItem<?>) Game.PLAYER.getHotbar().list[Game.PLAYER.getHotbar().currentItemIndex].cloneType();
					
					dropItem.setCount(1);
					
					Game.addItemEntity(pos[0], pos[1], dropItem, dropItem.getImage(), 64);
					
				} else if (Game.PLAYER.getHotbar().list[Game.PLAYER.getHotbar().currentItemIndex] instanceof Item) {
					
					Item<?> dropItem = (Item<?>) Game.PLAYER.getHotbar().list[Game.PLAYER.getHotbar().currentItemIndex].cloneType();
					
					dropItem.setCount(1);
					
					Game.addItemEntity(pos[0], pos[1], dropItem, dropItem.getImage(), 64);
					
				}
				
				Game.PLAYER.getHotbar().list[Game.PLAYER.getHotbar().currentItemIndex].setCount((int) (Game.PLAYER.getHotbar().list[Game.PLAYER.getHotbar().currentItemIndex].getCount() - 1));
				
				if (Game.PLAYER.getHotbar().list[Game.PLAYER.getHotbar().currentItemIndex].getCount() <= 0) {
					
					Game.PLAYER.getHotbar().list[Game.PLAYER.getHotbar().currentItemIndex] = null;
					
				}
				
			}
			
		}
		
	}
	
	private float[] getRandomItemPos() {
		
		Random random = new Random();
		
		float itemX = 0f;
		float itemY = 0f;
		
		final int OFFSET = 128; 
		
		if (random.nextBoolean()) {
			
			itemX = (float) (Game.PLAYER.getX() + random.nextInt((int) (OFFSET + 1)));
			
		} else {
			
			itemX = (float) (Game.PLAYER.getX() + (float) (random.nextInt((int) (OFFSET + 1)) * -1f));
			
		}
		
		if (random.nextBoolean()) {
			
			itemY = (float) (Game.PLAYER.getY() + random.nextInt((int) (OFFSET + 1)));
			
		} else {
			
			itemY = (float) (Game.PLAYER.getY() + (float) (random.nextInt((int) (OFFSET + 1)) * -1f));
			
		}
		
		float[] res = {itemX, itemY};
		
		return res;
		
	}

}
