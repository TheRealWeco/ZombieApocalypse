package tk.astris.data;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;

public class Char {

	public BufferedImage image;
	public Size size;
	public String name;
	public int hp;
	public float speed;
	public int dmg;
	public ArrayList<AnimationChar> animation;
	public HashMap<String, AnimationChar> animationMap;
	
	public Char(BufferedImage image, ArrayList<AnimationChar> animation, String name, Size size, int hp, float speed, int dmg){
		this.image = image;
		this.size = size;
		this.name = name;
		this.dmg = dmg;
		this.speed = speed;
		this.hp = hp;
		this.animation = animation;
		
		for(AnimationChar ani : animation){
			animationMap.put(ani.type, ani);
		}
		
	}
	
	
}
