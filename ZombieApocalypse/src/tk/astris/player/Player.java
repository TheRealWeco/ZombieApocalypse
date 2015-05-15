package tk.astris.player;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import tk.astris.data.Char;
import tk.astris.entity.Entity;
import tk.astris.main.keyCheck;

public class Player extends Entity{
		
	float oldX;
	float oldY;
	
	public int hp;
	public int dmg;
	public Char character;
		
	public boolean revertTexture = false;
	
	int walkTime = 0;
	int sWalkTime = 10;
	int maxWalkTime = 25;
	
	int textureFontChange = 0;
	int textureBackChange = 0;
	int textureLeftChange = 0;
	String facing = "front";
	boolean walking = false;
	
	public Player(float x, float y, Char character){
		this.character = character;
		this.hp = character.hp;
		this.dmg = character.dmg;
		
		this.x = x;
		this.y = y;
		this.speed = character.speed;
		this.canMove = true;
		this.hasHitbox = true;
		this.bounding = new Rectangle((int)x, (int)y);
		this.size = character.size;
		
		this.oldX = x;
		this.oldY = y;
		this.image = character.walkFront[0];

	}
	
	
	@Override
	public void move() {
		super.move();
		
		if(keyCheck.keysCheck(KeyEvent.VK_W)){
			maxWalkTime = sWalkTime*character.walkFront.length;
			facing = "front";
			walking = true;
		}
		else if(keyCheck.keysCheck(KeyEvent.VK_S)){
			maxWalkTime = sWalkTime*character.walkBack.length;
			facing = "back";
			walking = true;
		}
		else if(keyCheck.keysCheck(KeyEvent.VK_A)){
			this.revertTexture = true;
			maxWalkTime = sWalkTime*character.walkLeft.length;
			facing = "left";
			walking = true;
		}
		else if(keyCheck.keysCheck(KeyEvent.VK_D)){
			this.revertTexture = false;
			maxWalkTime = sWalkTime*character.walkLeft.length;
			facing = "left";
			walking = true;
		}else{
			walking = false;
		}
	
	}
	
	@Override
	public void update() {
		super.update();
		
		if(walking){
		walkTime++;
		if(walkTime == maxWalkTime){
			if(facing.equals("front")){
				if(character.walkFront.length-1 > textureFontChange){
				textureFontChange++;
				}else{
					textureFontChange = 0;
				}
				this.image = character.walkFront[textureFontChange];
			}
			if(facing.equals("back")){
				if(character.walkBack.length-1 > textureBackChange){
					textureBackChange++;
				}else{
					textureBackChange = 0;
				}
				this.image = character.walkBack[textureBackChange];
			}
			if(facing.equals("left")){
				if(character.walkLeft.length-1 > textureLeftChange){
					textureLeftChange++;
				}else{
					textureLeftChange = 0;
				}
				this.image = character.walkLeft[textureLeftChange];
			}

			
			
			
			
			walkTime = 0;
		}
		}
	}
	
}
