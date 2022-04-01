package com.game.collision.objects;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.game.collision.objects.base.CollisionObject;
import com.game.collision.objects.base.ObjectType;
import com.game.entities.base.Entity;
import com.game.entities.base.EntityID;
import com.game.entities.player.Player;
import com.game.main.Drawable;
import com.game.main.Game;
import com.game.maps.DimensionID;
import com.game.maps.Map;

public class NextRandomMapCollisionObject extends CollisionObject implements Drawable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7492748792468858829L;

	public NextRandomMapCollisionObject(int x, int y, int width, int height, ObjectType type, BufferedImage image) {
		
		super(x, y, width, height, type, image);
		
		
	}

	@Override
	public void draw(Graphics2D g2d) {
		
		g2d.drawImage(this.image, this.x, this.y, this.width, this.height, null);
		
	}

	@Override
	public void collide(Entity e) {
		
		if (e instanceof Player && e.getId() == EntityID.PLAYER && Game.DIMENSION_HANDLER.getCURRENT_DIMENSION_ID() == DimensionID.HOME) {
			
			int mapID = Game.RANDOM.nextInt(Game.RANDOM_MAP_HOME.length);
			
			Map map = new Map(Game.RANDOM_MAP_HOME[mapID], Game.RANDOM_MAP_HOME_ENTITYS[mapID]);
			
			Game.MAP_HANDLER().addMap(map);
			
			Game.MAP_HANDLER().CURRENT_MAP_ID = (int) (Game.MAP_HANDLER().CURRENT_MAP_ID + 1);
			Game.resetPlayerPosToCenter();
			
		}
		
	}

}
