package tk.astris.data;

import java.awt.image.BufferedImage;

public class Char {

	public BufferedImage image;
	public Size size;
	public String name;
	public int hp;
	public float speed;
	public int dmg;
	
	public Char(BufferedImage image, String name, Size size, int hp, float speed, int dmg){
		this.image = image;
		this.size = size;
		this.name = name;
		this.dmg = dmg;
		this.speed = speed;
		this.hp = hp;
	}
	
	
}
