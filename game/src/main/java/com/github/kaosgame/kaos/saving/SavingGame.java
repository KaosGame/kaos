package com.github.kaosgame.kaos.saving;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.github.kaosgame.kaos.logging.LogType;
import com.github.kaosgame.kaos.main.Game;

public class SavingGame {
	
	public static void saveGame(String path) throws IOException {
		
		SaveableObject object = new SaveableObject();
		
		FileOutputStream fileOut = new FileOutputStream(path);
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		
		out.writeObject(object);
		
		out.close();
		fileOut.close();
		
		Game.logln("Saved game", LogType.SUCCESS);
		
	}
	
	public static SaveableObject loadGame(String path) throws IOException, ClassNotFoundException {
		
		SaveableObject object = null;
		
		try {
			
			FileInputStream fileIn = new FileInputStream(path);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			
			object = (SaveableObject) in.readObject();
			
			in.close();
			fileIn.close();
			
			
		} catch (InvalidClassException e) {
			
			e.printStackTrace();
			
		}
		
		return object;
		
	}

}
