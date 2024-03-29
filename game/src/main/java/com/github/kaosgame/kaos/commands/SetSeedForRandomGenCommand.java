package com.github.kaosgame.kaos.commands;

import javax.swing.JOptionPane;

import com.github.kaosgame.kaos.commands.base.CommandBase;
import com.github.kaosgame.kaos.logging.LogType;
import com.github.kaosgame.kaos.main.Game;

public class SetSeedForRandomGenCommand implements CommandBase {

	@Override
	public void run(String commandText) {
		
		String seedString = JOptionPane.showInputDialog(null, "Enter the new random world seed", "Enter", JOptionPane.QUESTION_MESSAGE);
		
		if (seedString == null || seedString.trim().equals("") || seedString.equals("")) return;
		
		long seed = Game.stringToLong(seedString);
		
		int newWorldOrNot = JOptionPane.showConfirmDialog(null,
				"Do you want to make a new world\nor chance the current word's seed?", "Question",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
		
		if (newWorldOrNot == JOptionPane.YES_OPTION) {
			
			Game.reset();
			Game.RANDOM.setSeed(seed);
			
			Game.logln(String.format("%d was set the seed for a new world", seed), LogType.INFO);
			
		} else if (newWorldOrNot == JOptionPane.NO_OPTION) {
			
			Game.RANDOM.setSeed(seed);
			
			Game.logln(String.format("%d is now the world seed", seed), LogType.INFO);
			
		}
		
	}

}
