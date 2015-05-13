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
	
	public Player(float x, float y, Char character){
		this.hp = character.hp;
		this.dmg = character.dmg;
		
		this.x = x;
		this.y = y;
		this.speed = character.speed;
		this.image = character.image;
		this.canMove = true;
		this.hasHitbox = true;
		this.bounding = new Rectangle((int)x, (int)y);
		this.size = character.size;
		
		this.oldX = x;
		this.oldY = y;
	}
	
	
	@Override
	public void move() {
		super.move();
		
		if(keyCheck.keysCheck(KeyEvent.VK_W)){
			x = x + speed;
		}
		
		
	}
	
	@Override
	public void update() {
		super.update();
		
	}
	
}
