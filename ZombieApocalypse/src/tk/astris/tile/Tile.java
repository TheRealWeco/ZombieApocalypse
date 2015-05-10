package tk.astris.tile;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Tile {

	
	public float x;
	public float y;
	public BufferedImage image;
	public Rectangle bounding;
	
	public Tile(float x, float y, BufferedImage image){
		this.x = x;
		this.y = y;
		this.image = image;
		this.bounding = new Rectangle((int)x, (int)y, 50, 50);
	}
	
	public Rectangle getBounding(){
		return bounding;
	}
	
}
