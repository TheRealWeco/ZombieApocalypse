package tk.astris.player;

import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.KeyEvent;
import java.awt.geom.Ellipse2D;

import tk.astris.data.Char;
import tk.astris.data.Size;
import tk.astris.entity.Entity;
import tk.astris.main.Main;
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
	
	public float trueX = 0;
	public float trueY = 0;
	
	public Shape hearRaduis;
	public Size hearRaduisSize;
	public Size hearRaduisSizeDef;
	
	public int illness = 0;

	public Player(Char character){
		this.character = character;
		this.hp = character.hp;
		this.dmg = character.dmg;
		
		this.speed = character.speed;
		this.canMove = true;
		this.hasHitbox = true;
		this.bounding = new Rectangle((int)x, (int)y);
		this.size = character.size;
		this.x = Main.WIDTH/2 - size.x;
		this.y = Main.HEIGHT/2 - size.x;

		this.oldX = x;
		this.oldY = y;
		this.image = character.walkFront[0];
		
		this.trueX = x + size.x*2 + size.x/5;
		this.trueY = y;
		
		hearRaduisSize = new Size(200, 200);
		hearRaduisSizeDef = new Size(300, 300);
		hearRaduis = new Ellipse2D.Float(trueX + Main.camera.x, trueY + Main.camera.y, hearRaduisSize.x, hearRaduisSize.y);
		bounding = new Rectangle((int)trueX, (int)trueY, (int)character.size.x, (int)character.size.y);

		onWalk();
		
	}
	
	
	@Override
	public void move() {
		super.move();

		
		if(keyCheck.keysCheck(KeyEvent.VK_W)){
			maxWalkTime = sWalkTime*character.walkFront.length;
			facing = "front";
			walking = true;
			onWalk();
		}
		else if(keyCheck.keysCheck(KeyEvent.VK_S)){
			maxWalkTime = sWalkTime*character.walkBack.length;
			facing = "back";
			walking = true;
			onWalk();
		}
		else if(keyCheck.keysCheck(KeyEvent.VK_A)){
			this.revertTexture = true;
			maxWalkTime = sWalkTime*character.walkLeft.length;
			facing = "left";
			walking = true;
			onWalk();
		}
		else if(keyCheck.keysCheck(KeyEvent.VK_D)){
			this.revertTexture = false;
			maxWalkTime = sWalkTime*character.walkLeft.length;
			facing = "left";
			walking = true;
			onWalk();
		}else{
			walking = false;
			
			if(hearRaduisSize.x != hearRaduisSizeDef.x && hearRaduisSize.y != hearRaduisSizeDef.y){
				hearRaduisSize.x = 200;
				hearRaduisSize.y = 200;
				hearRaduis = new Ellipse2D.Float(trueX + Main.camera.x - hearRaduisSize.x/2 + size.x/2, trueY + Main.camera.y - hearRaduisSize.y/2 + size.y/2, hearRaduisSize.x, hearRaduisSize.y);
			}
			
		}
	
	}
	
	public void onWalk(){
		hearRaduisSize.x = hearRaduisSizeDef.x+100;
		hearRaduisSize.y = hearRaduisSizeDef.y+100;
		hearRaduis = new Ellipse2D.Float(trueX + Main.camera.x - hearRaduisSize.x/2 + size.x/2, trueY + Main.camera.y - hearRaduisSize.y/2 + size.y/2, hearRaduisSize.x, hearRaduisSize.y);
		bounding = new Rectangle((int)(trueX + Main.camera.x), (int)(trueY + Main.camera.y), (int)character.size.x, (int)character.size.y);
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
