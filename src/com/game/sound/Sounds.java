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
	WAR_END("/assets/music/war/war-end.wav");
	
	private final URL URL;
	
	private Sounds(String path) {
		
		this.URL = this.getClass().getResource(path);
		
	}
	
	public URL getURL() {
		
		return this.URL;
		
	}

}
