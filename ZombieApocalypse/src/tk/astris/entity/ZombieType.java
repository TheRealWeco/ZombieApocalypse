package tk.astris.entity;

import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;

import tk.astris.data.Size;
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
	
	public Size hearRaduisSize;
	public Shape hearRaduis;
	
	public Rectangle bounding;
	
	public ZombieType(Zombie z, float x, float y){
		this.zombie = z;
		this.x = x;
		this.y = y;
		this.image = zombie.walkFront[0];
		
		this.hearRaduisSize = new Size(500, 500);
		hearRaduis = new Ellipse2D.Float(x + Main.camera.x, y + Main.camera.y, hearRaduisSize.x, hearRaduisSize.y);
		bounding = new Rectangle((int)(x + Main.camera.x), (int)(y + Main.camera.y), (int)zombie.size.x, (int)zombie.size.y);
	}
	
	public void update(){
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
		
		hearRaduis = new Ellipse2D.Float(x + Main.camera.x - hearRaduisSize.x/2 + zombie.size.x/2, y + Main.camera.y - hearRaduisSize.y/2 + zombie.size.y/2, hearRaduisSize.x , hearRaduisSize.y);
		if(walking){
			walking = false;
		}
		
	}
	public void move(){

		if(x >= Main.player.trueX){
			
			this.revertTexture = true;
			maxWalkTime = sWalkTime*zombie.walkLeft.length;
			facing = "left";
			walking = true;

			x = x - zombie.speed;
			onMove();

		}
		if(x <= Main.player.trueX){
			x = x + zombie.speed;
			this.revertTexture = false;
			maxWalkTime = sWalkTime*zombie.walkLeft.length;
			facing = "left";
			walking = true;
			onMove();

		}
		if(y >= Main.player.trueY){
			maxWalkTime = sWalkTime*zombie.walkFront.length;
			facing = "front";
			walking = true;

			y = y - zombie.speed;
			onMove();

		}
		if(y <= Main.player.trueY){
			maxWalkTime = sWalkTime*zombie.walkBack.length;
			facing = "back";
			walking = true;
			y = y + zombie.speed;
			onMove();
		}	
		
	}
	
	public void onMove(){
		bounding = new Rectangle((int)(x + Main.camera.x), (int)(y + Main.camera.y), (int)zombie.size.x, (int)zombie.size.y);

	}

}
