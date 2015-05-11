package tk.astris.tile;

import java.util.HashMap;

import tk.astris.data.Size;
import tk.astris.main.Main;

public class Tiles {

	public HashMap<String, Tile> tiles = new HashMap<String, Tile>();
	
	public Tiles(){
		tiles.put("0", new Tile(Main.images.getSpriteSheet().getSubimage(0, 0, 50, 50), new Size(50, 50)));
		tiles.put("grass", new Tile(Main.images.getSpriteSheet().getSubimage(0, 0, 50, 50), new Size(50, 50)));

		
		tiles.put("1", new Tile(Main.images.getSpriteSheet().getSubimage(50, 0, 50, 50), new Size(50, 50)));
		tiles.put("water", new Tile(Main.images.getSpriteSheet().getSubimage(50, 0, 50, 50), new Size(50, 50)));

	}
	
}
