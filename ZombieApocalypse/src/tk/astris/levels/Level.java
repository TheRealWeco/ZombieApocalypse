package tk.astris.levels;

import tk.astris.data.Size;

public class Level {
	
	
	public Size size;
	public String[][] tiles;
	
	public Level(String[][] tiles, Size size){
		this.tiles = tiles;
		this.size = size;
	}

}
