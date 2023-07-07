package com.github.kaosgame.kaos.textures;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BufferedImageLoader {
	
	private BufferedImage image;
	
	public BufferedImageLoader() {
		
		super();
		
		this.image = null;
		
	}
	
	public BufferedImageLoader(String path) {
		
		this.image = this.loadImage(path);
		
	}
	
	public BufferedImage loadImage(String path) {
		
		BufferedImage image = null;
		
		try {
			
			image = ImageIO.read(this.getClass().getResource(path));
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
		return image;
		
	}

	public BufferedImage getImage() {
		return this.image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}
	
	

}
