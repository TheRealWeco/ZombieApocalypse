package tk.astris.levels;

import tk.astris.data.Size;

public class Level {
	
	
	public Size size;
	public String[][] tiles;
	public float CameraX = -1;
	public float CameraY = -1;
	
	public Level(String[][] tiles, Size size){
		this.tiles = tiles;
		this.size = size;
	}

}
