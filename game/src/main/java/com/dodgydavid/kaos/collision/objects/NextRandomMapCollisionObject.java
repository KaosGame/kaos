package com.dodgydavid.kaos.collision.objects;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.dodgydavid.kaos.collision.objects.base.CollisionObject;
import com.dodgydavid.kaos.collision.objects.base.ObjectType;
import com.dodgydavid.kaos.entities.base.Entity;
import com.dodgydavid.kaos.entities.base.EntityID;
import com.dodgydavid.kaos.entities.player.Player;
import com.dodgydavid.kaos.main.Drawable;
import com.dodgydavid.kaos.main.Game;
import com.dodgydavid.kaos.maps.DimensionID;
import com.dodgydavid.kaos.maps.Map;

public class NextRandomMapCollisionObject extends CollisionObject implements Drawable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7492748792468858829L;

	public NextRandomMapCollisionObject(int x, int y, int width, int height, ObjectType type, BufferedImage image) {
		
		super(x, y, width, height, type, image, false);
		
		
	}

	@Override
	public void draw(Graphics2D g2d) {
		
		g2d.drawImage(this.image, this.x, this.y, this.width, this.height, null);
		
	}

	@Override
	public void collide(Entity e) {
		
		if (e instanceof Player && e.getId() == EntityID.PLAYER && Game.DIMENSION_HANDLER.getCURRENT_DIMENSION_ID() == DimensionID.HOME) {
			
			if ((int) (Game.MAP_HANDLER().getMAPS().size() - 1) == Game.MAP_HANDLER().CURRENT_MAP_ID) {
			
				int mapID = Game.RANDOM.nextInt(Game.RANDOM_MAP_HOME.length);
				
				Map map = new Map(Game.RANDOM_MAP_HOME[mapID], Game.RANDOM_MAP_HOME_ENTITYS[mapID]);
				
				Game.MAP_HANDLER().addMap(map);
				
			}
			
			Game.MAP_HANDLER().CURRENT_MAP_ID = (int) (Game.MAP_HANDLER().CURRENT_MAP_ID + 1);
			Game.resetPlayerPosToCenter();
			
		}
		
	}

}
