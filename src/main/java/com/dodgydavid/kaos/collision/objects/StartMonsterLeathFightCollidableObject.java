package com.dodgydavid.kaos.collision.objects;

import java.awt.Graphics2D;

import com.dodgydavid.kaos.collision.objects.base.CollisionObject;
import com.dodgydavid.kaos.collision.objects.base.ObjectType;
import com.dodgydavid.kaos.entities.base.Entity;
import com.dodgydavid.kaos.entities.monster.leath.MonsterLeath;
import com.dodgydavid.kaos.entities.player.Player;
import com.dodgydavid.kaos.main.Drawable;
import com.dodgydavid.kaos.main.Game;
import com.dodgydavid.kaos.sound.Sounds;

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
