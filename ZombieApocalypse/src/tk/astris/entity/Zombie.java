package tk.astris.entity;

import java.awt.image.BufferedImage;

import tk.astris.data.Size;

public class Zombie extends Entity{

	public BufferedImage[] walkFront;
	public BufferedImage[] walkBack;
	public BufferedImage[] walkLeft;
	public Size size;
	
	
	public Zombie(float speed, int imageF, int imageB, int ImageL, Size size){
		this.speed = speed;
		walkFront = new BufferedImage[imageF];
		walkBack = new BufferedImage[imageB];
		walkLeft = new BufferedImage[ImageL];
		this.size = size;

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
