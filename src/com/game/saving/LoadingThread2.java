package com.game.saving;

import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;

import com.game.exceptions.image.restoring.NotEnoughInformationToRestoreImageException;
import com.game.main.Game;

public class LoadingThread2 implements Runnable {

	@Override
	public void run() {
		
		JFileChooser fileChooser = new JFileChooser();
		
		int res = fileChooser.showOpenDialog(null);
		
		if (res == JFileChooser.APPROVE_OPTION) {
			
			File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
			
			try {
				SaveableObject obj = SavingGame.loadGame(file.getPath());
				
				if (obj.getVersionHashcode() == Game.VERSION.hashCode()) {
					
					Game.MAP_HANDLER = obj.getMapHandler();
					Game.PLAYER = obj.getPlayer();
					
					Game.fixAllImages();
					
				}
				
			} catch (ClassNotFoundException | IOException e) {
				
				e.printStackTrace();
				
			} catch (NotEnoughInformationToRestoreImageException e) {
				
				System.out.println(e.toString());
				
			}
			
		}
		
	}

}
