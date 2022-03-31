package com.game.maps;

import javax.swing.JOptionPane;

import com.game.collision.objects.ChestTransparentObject;
import com.game.collision.objects.PlayerObject;
import com.game.collision.objects.base.CollisionObject;
import com.game.entities.base.Entity;
import com.game.main.Game;

public class OverflowHandler {
	
	public void handle() {
		
		boolean hasDeleted = false;
		
		long itemsRemoved = 0L;
		
		while (Game.MAP_HANDLER().currentMap().getEntityHandler().getList().size() > MapHandler.MAX_ENTITIES) {
			
			for (int i = 0; i < Game.MAP_HANDLER().currentMap().getEntityHandler().getList().size(); i++) {
				
				Entity e = Game.MAP_HANDLER().currentMap().getEntityHandler().get(i);
				
				if (e.getId().canDelete()) {
					
					Game.MAP_HANDLER().currentMap().getEntityHandler().remove(e);
					
					hasDeleted = true;
					
					itemsRemoved++;
					
					continue;
					
				}
				
			}
			
		}
		
		
		while (Game.MAP_HANDLER().currentMap().getObjectList().size() > MapHandler.MAX_OBJECTS) {
			
			for (int i = 0; i < Game.MAP_HANDLER().currentMap().getObjectList().size(); i++) {
				
				CollisionObject o = Game.MAP_HANDLER().currentMap().getObject(i);
				
				if (o instanceof PlayerObject || o instanceof ChestTransparentObject) {
					
					Game.MAP_HANDLER().currentMap().removeObject(o);
					
					hasDeleted = true;
					
					itemsRemoved++;
					
					continue;
					
				}
				
			}
			
		}
		
		if (hasDeleted) {
			
			JOptionPane.showMessageDialog(null, "Warning some things have being deleted from your world\nbecause you had more that the max", "Warning", JOptionPane.WARNING_MESSAGE);
			Game.logln("Warning some things have being deleted from your world because you had more that the max so we removed " + itemsRemoved + " things");
			
		}
		
		
	}

}
