package tk.astris.data;

import java.awt.image.BufferedImage;

public class Char {

	public Size size;
	public String name;
	public int hp;
	public float speed;
	public int dmg;
	
	public BufferedImage[] walkFront;
	public BufferedImage[] walkLeft;
	public BufferedImage[] walkBack;

	
	public Char(String name, Size size, int hp, float speed, int dmg, int front, int left, int back){
		this.size = size;
		this.name = name;
		this.dmg = dmg;
		this.speed = speed;
		this.hp = hp;	
		walkFront = new BufferedImage[front];
		walkLeft = new BufferedImage[left];
		walkBack = new BufferedImage[back];
	}
	
	
}
