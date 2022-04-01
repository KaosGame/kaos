package com.game.commands;

import javax.swing.JOptionPane;

import com.game.commands.base.CommandBase;
import com.game.main.Game;

public class SetSeedForRandomGenCommand implements CommandBase {

	@Override
	public void run(String commandText) {
		
		String seedString = JOptionPane.showInputDialog(null, "Enter the new random world seed", "Enter", JOptionPane.QUESTION_MESSAGE);
		
		if (seedString == null) return;
		
		long seed = Long.parseLong(seedString);
		
		int newWorldOrNot = JOptionPane.showConfirmDialog(null,
				"Do you want to make a new world\nor chance the current word's seed?", "Question",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
		
		if (newWorldOrNot == JOptionPane.YES_OPTION) {
			
			Game.reset();
			Game.RANDOM.setSeed(seed);
			
		} else if (newWorldOrNot == JOptionPane.NO_OPTION) {
			
			Game.RANDOM.setSeed(seed);
			
		}
		
	}

}
