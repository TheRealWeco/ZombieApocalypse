package tk.astris.tile;

import java.awt.image.BufferedImage;

import tk.astris.data.Size;

public class Tile {

	
	public BufferedImage image;
	public Size size;
	
	public Tile(BufferedImage image, Size size){
		this.image = image;
		this.size = size;
	}
		
}
