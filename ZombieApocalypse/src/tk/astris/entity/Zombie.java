package tk.astris.entity;

import java.awt.image.BufferedImage;

import tk.astris.data.Size;

public class Zombie extends Entity{

	public BufferedImage[] walkFront;
	public BufferedImage[] walkBack;
	public BufferedImage[] walkLeft;
	public Size size;
	public int damage;
	public int posionLevel = 10;
	
	public Zombie(float speed, int imageF, int imageB, int ImageL, Size size, int damage, int poisonLevel){
		this.speed = speed;
		walkFront = new BufferedImage[imageF];
		walkBack = new BufferedImage[imageB];
		walkLeft = new BufferedImage[ImageL];
		this.size = size;
		this.damage = damage;
		this.posionLevel = poisonLevel;

	}
	
	@Override
	public void update() {
		super.update();
		
		
	}
	@Override
	public void move() {
		super.move();
		
		
	}
}
