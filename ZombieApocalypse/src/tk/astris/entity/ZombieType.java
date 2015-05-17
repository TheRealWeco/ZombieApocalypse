package tk.astris.entity;

import java.awt.image.BufferedImage;

import tk.astris.main.Main;

public class ZombieType {
	
	public float x;
	public float y;
	public Zombie zombie;
	
	
	int walkTime = 0;
	int sWalkTime = 10;
	int maxWalkTime = 25;
	
	int textureFontChange = 0;
	int textureBackChange = 0;
	int textureLeftChange = 0;
	String facing = "front";
	boolean walking = false;
	public BufferedImage image;
	public boolean revertTexture = false;
	
	public boolean isDead = false;
	
	public ZombieType(Zombie z, float x, float y){
		this.zombie = z;
		this.x = x;
		this.y = y;
		this.image = zombie.walkFront[0];
	}
	
	public void update(){
		move();
		
		if(walking){
		walkTime++;
		if(walkTime == maxWalkTime){
			if(facing.equals("front")){
				if(zombie.walkFront.length-1 > textureFontChange){
				textureFontChange++;
				}else{
					textureFontChange = 0;
				}
				this.image = zombie.walkFront[textureFontChange];
			}
			if(facing.equals("back")){
				if(zombie.walkBack.length-1 > textureBackChange){
					textureBackChange++;
				}else{
					textureBackChange = 0;
				}
				this.image = zombie.walkBack[textureBackChange];
			}
			if(facing.equals("left")){
				if(zombie.walkLeft.length-1 > textureLeftChange){
					textureLeftChange++;
				}else{
					textureLeftChange = 0;
				}
				this.image = zombie.walkLeft[textureLeftChange];
			}

			
			
			
			
			walkTime = 0;
		}
		}
		
		
	}
	public void move(){
		
		if(x >= Main.player.trueX){
			
			this.revertTexture = true;
			maxWalkTime = sWalkTime*zombie.walkLeft.length;
			facing = "left";
			walking = true;

			x = x - zombie.speed;
		}
		if(x <= Main.player.trueX){
			x = x + zombie.speed;
			this.revertTexture = false;
			maxWalkTime = sWalkTime*zombie.walkLeft.length;
			facing = "left";
			walking = true;
		}
		if(y >= Main.player.trueY){
			maxWalkTime = sWalkTime*zombie.walkFront.length;
			facing = "front";
			walking = true;

			y = y - zombie.speed;
		}
		if(y <= Main.player.trueY){
			maxWalkTime = sWalkTime*zombie.walkBack.length;
			facing = "back";
			walking = true;
			y = y + zombie.speed;
		}		
		
	}

}
