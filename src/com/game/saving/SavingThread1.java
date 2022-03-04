package com.game.saving;

import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;

public class SavingThread1 implements Runnable {

	@Override
	public void run() {
		
		JFileChooser fileChooser = new JFileChooser();
		
		int res = fileChooser.showSaveDialog(null);
		
		if (res == JFileChooser.APPROVE_OPTION) {
			
			File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
			
			try {
				SavingGame.saveGame(file.getPath());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

}
