package com.dodgydavid.kaos.effects;

import java.util.LinkedList;

import com.dodgydavid.kaos.collision.objects.base.CollisionObject;
import com.dodgydavid.kaos.collision.objects.base.ObjectType;
import com.dodgydavid.kaos.effects.base.Effect;
import com.dodgydavid.kaos.effects.base.EffectID;
import com.dodgydavid.kaos.entities.player.Player;
import com.dodgydavid.kaos.main.Game;

public class SwimmingEffect1 extends Effect {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8265836221838435733L;
	
	public SwimmingEffect1(int level, long time) {
		super(level, EffectID.SWIMMING_1, time);
		
	}
	
	@Override
	public void onStart() {
		
		
		
	}

	@Override
	public void onUpdate() {
		
		if (this.playerInWater(this.getPlayer())) {
			
			Player.SPEED = (float) (Player.SWIMMING_SPEED * (float) this.level);
			
		} else {
			
			Player.SPEED = Player.DEFAULT_SPEED;
			
		}
		
	}
	
	@Override
	public void onEnd() {
		
		Player.SPEED = Player.DEFAULT_SPEED;
		
	}
	
	private boolean playerInWater(Player player) {
		
		LinkedList<CollisionObject> lllot = Game.MAP_HANDLER().currentMap().getObjectList();
		
		for (int i = 0; i < lllot.size(); i++) {
			
			if (lllot.get(i).getRectangle().intersects(player.getRectangle())
					&& lllot.get(i).getType().equals(ObjectType.WATER))
				return true;
			
		}
		
		return false;
		
	}


}
