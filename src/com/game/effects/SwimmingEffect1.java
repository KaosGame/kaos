package com.game.effects;

import java.util.LinkedList;

import com.game.annotations.Empty;
import com.game.collision.objects.base.CollisionObject;
import com.game.collision.objects.base.ObjectType;
import com.game.effects.base.Effect;
import com.game.effects.base.EffectID;
import com.game.entities.player.Player;
import com.game.main.Game;

public class SwimmingEffect1 extends Effect {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8265836221838435733L;
	
	public SwimmingEffect1(int level, long time) {
		super(level, EffectID.SWIMMING_1, time);
		
	}
	
	@Empty
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
	
	@Empty
	@Override
	public void onEnd() {
		
		
		
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
