package com.game.sound;

import java.net.URL;

public enum Sounds {
	
	BASE_BACKGROUND_MUSIC("/assets/music/base-background-music.wav"),
	BREAK("/assets/music/break.wav"),
	SOFT_BREAK("/assets/music/soft-break.wav"),
	BOMB_BOOM("/assets/music/bomb/boom.wav"),
	BOMB_FIZZ("/assets/music/bomb/fizz.wav"),
	PLAYER_DEATH("/assets/music/player/player-death.wav"),
	POP("/assets/music/pop.wav"),
	WAR_START("/assets/music/war/war-start.wav"),
	WAR_END("/assets/music/war/war-end.wav"),
	MONSTER_LEATH_START("/assets/music/monster/leath/monster-leath-start.wav"),
	MONSTER_LEATH_END("/assets/music/monster/leath/monster-leath-end.wav"),
	PLAYER_GET_STAT("/assets/music/player/get-stat.wav"),
	ISAWAWABUB_ATTACK("/assets/music/isawawabub/attack.wav"),
	ISAWAWABUB_END("/assets/music/isawawabub/end.wav"),
	LEAF_BLOWER_MOVE("/assets/music/fun/leaf-blower-move.wav"),
	CATACHILLER_HISS("/assets/music/catachiller/hiss.wav"),
	BANK_ALARM("/assets/music/bank-alarm.wav");
	
	private final URL URL;
	
	private Sounds(String path) {
		
		this.URL = this.getClass().getResource(path);
		
	}
	
	public URL getURL() {
		
		return this.URL;
		
	}

}
