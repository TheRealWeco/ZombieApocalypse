package tk.astris.entity;

import java.util.HashMap;

import tk.astris.data.Size;
import tk.astris.main.Main;

public class Zombies {

	public HashMap<String, Zombie> zombie = new HashMap<String, Zombie>();
	
	public Zombies(){
		Zombie z = new Zombie(0.5F, 2, 2, 2, new Size(50, 50), 20, 10);
		z.walkBack[0] = Main.images.getSpriteSheet().getSubimage(0, 250, 50, 50);
		z.walkBack[1] = Main.images.getSpriteSheet().getSubimage(50, 250, 50, 50);
		
		z.walkFront[0] = Main.images.getSpriteSheet().getSubimage(0, 250, 50, 50);
		z.walkFront[1] = Main.images.getSpriteSheet().getSubimage(50, 250, 50, 50);
		
		z.walkLeft[0] = Main.images.getSpriteSheet().getSubimage(0, 250, 50, 50);
		z.walkLeft[1] = Main.images.getSpriteSheet().getSubimage(50, 250, 50, 50);
		zombie.put("0", z);
	}
	
}
