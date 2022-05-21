package com.game.collision.objects;

import java.awt.Graphics2D;

import com.game.collision.objects.base.CollisionObject;
import com.game.collision.objects.base.ObjectType;
import com.game.entities.base.Entity;
import com.game.entities.monster.leath.MonsterLeath;
import com.game.entities.player.Player;
import com.game.main.Drawable;
import com.game.main.Game;
import com.game.sound.Sounds;

public class StartMonsterLeathFightCollidableObject extends CollisionObject implements Drawable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6419928446109006569L;


	public StartMonsterLeathFightCollidableObject(int x, int y, int width, int height) {
		super(x, y, width, height, ObjectType.START_MONSTER_LEATH_FIGHT, Game.MONSTER_LEATH_IMAGE_LOADER.getImage(), true);
	}

	@Override
	public void collide(Entity e) {
		
		if (!(e instanceof Player)) return;
		
		Game.SE_SOUND.setSound(Sounds.MONSTER_LEATH_START);
		Game.SE_SOUND.play();
		
		Game.MAP_HANDLER().currentMap().getEntityHandler().add(new MonsterLeath(this.x, this.y));
		
		Game.MAP_HANDLER().currentMap().removeObject(this);
		
	}


	@Override
	public void draw(Graphics2D g2d) {
		
		g2d.drawImage(this.image, this.x, this.y, this.width, this.height, null);
		
		
	}

}
