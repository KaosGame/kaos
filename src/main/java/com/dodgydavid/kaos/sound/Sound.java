package com.dodgydavid.kaos.sound;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

import com.dodgydavid.kaos.logging.LogType;
import com.dodgydavid.kaos.main.Game;

public class Sound {
	
	private Clip clip;
	private FloatControl fc;
	private short volumeScale;
	private float volume;
	
	public Sound() {
		
		this.volumeScale = 3;
		
	}
	
	public void updateVolume() {
		
		switch (this.volumeScale) {
			
		
			case 0:
				this.volume = -80f;
				break;
			
			case 1:
				this.volume = -20f;
				break;
				
			case 2:
				this.volume = -12f;
				break;
				
			case 3:
				this.volume = -5f;
				break;
				
			case 4:
				this.volume = 1f;
				break;
				
			case 5:
				this.volume = 6f;
				break;
				
		}
		
		fc.setValue(this.volume);
		
		
	}
	
	public void setSound(Sounds sound) {
		
		try {
			
			AudioInputStream ais = AudioSystem.getAudioInputStream(sound.getURL());
			
			this.clip = AudioSystem.getClip();
			this.clip.open(ais);
			this.fc = (FloatControl) this.clip.getControl(FloatControl.Type.MASTER_GAIN);
			
			this.updateVolume();
			
		} catch (Exception e) {
			
			Game.logln(e, LogType.EXCRPTION);
			
		}
		
	}
	
	public void play() {
		
		this.clip.start();
		
	}
	
	public void stop() {
		
		this.clip.stop();
		
	}
	
	public void loop() {
		
		this.clip.loop(Clip.LOOP_CONTINUOUSLY);
		
	}
	
	public void loop(int times) {
		
		this.clip.loop(times);
		
	}
	
	public void setVolumeScale(int volumeScale) {
		
		this.volumeScale = (short) volumeScale;
		this.updateVolume();
		
	}
	
	public void setTrueVolumeScale(int volumeScale) {
		
		this.volumeScale = (short) volumeScale;
		
	}

}
