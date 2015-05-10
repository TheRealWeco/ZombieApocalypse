package tk.astris.entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import tk.astris.data.Size;

public class Entity {

	public boolean canMove = false;
	public boolean hasHitbox = false;
	public Rectangle bounding;
	public float x;
	public float y;
	public float speed;
	public Size size;
	public BufferedImage image;
	
	public void update(){
		
		if(hasHitbox){
			bounding.x = (int)x;
			bounding.y = (int)y;
		}
		
		if(canMove){
			move();
		}
		
	}
	
	public Rectangle getBounds(){
		return bounding;	
	}
	
	public void move(){}
	
	
}
