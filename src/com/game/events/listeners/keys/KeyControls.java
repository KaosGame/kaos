package com.game.events.listeners.keys;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.game.annotations.Empty;
import com.game.annotations.Unused;
import com.game.entities.player.Player;
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
		
	}

}
