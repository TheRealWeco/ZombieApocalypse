package tk.astris.main;

import java.util.ArrayList;
import java.util.Random;

import tk.astris.camera.Camera;
import tk.astris.data.Char;
import tk.astris.data.Size;
import tk.astris.entity.Zombies;
import tk.astris.fileManager.Images;
import tk.astris.fileManager.Language;
import tk.astris.levels.LevelLoader;
import tk.astris.player.Player;
import tk.astris.tile.Tiles;


public class Main {
	
	
	
	private int fps;
	private long timeThen;
	boolean newVersion = true;
	
	public static String VERSION = "0.0.1";
	public static int HEIGHT = 16*50 + 25;
	public static int WIDTH = 16*50;
	
	
	public static Frame frame;
	public static Player player;
	public static Main instance;
	public static Language language;
	public static Images images;
	public static LevelLoader levelLoader;
	public static Tiles tiles;
	public static Camera camera;
	public static Zombies zombies;
	
	public static ArrayList<Char> characters = new ArrayList<Char>();
	
	public Main(int frameRate) {
		if (System.getProperty("java.version").startsWith("1.4"))
			newVersion = false;
		if (newVersion) {
			fps = frameRate;
			timeThen = System.nanoTime();
		} else {
			fps = frameRate;
			System.out.println("Old Version Detected: " +
				"Running Old Java Timer Version");
			timeThen = System.currentTimeMillis();
		}
	}
	public void sync() {
		if (newVersion) {
			long gapTo = 1000000000L / fps + timeThen;
			long timeNow = System.nanoTime();
				
			while (gapTo > timeNow) {
				try { Thread.sleep(1);
				} catch (InterruptedException e) {}
				timeNow = System.nanoTime();
			}
			
			timeThen = timeNow;
		} else {
			long gapTo = 1000 / fps + timeThen;
			long timeNow = System.currentTimeMillis();
				
			while (gapTo > timeNow) {
				try { Thread.sleep(1);
				} catch (InterruptedException e) {}
				timeNow = System.currentTimeMillis();
			}
			
			timeThen = timeNow;
		}
	}
	
	
	@SuppressWarnings("static-access")
	public static void main(String args[]) {
		
		language = new Language();
		language.setupLanguage();
		
		levelLoader = new LevelLoader();
		camera = new Camera();
		images = new Images();
		tiles = new Tiles();
		zombies = new Zombies();
		characters.add(new Char(language.string.get("steve"), new Size(50, 50), 100, 1.0F, 1, 2, 2, 2));
		
		characters.get(0).walkBack[0] = images.getSpriteSheet().getSubimage(0, 200, 50, 50);
		characters.get(0).walkBack[1] = images.getSpriteSheet().getSubimage(50, 200, 50, 50);
		
		characters.get(0).walkFront[0] = images.getSpriteSheet().getSubimage(150, 200, 50, 50);
		characters.get(0).walkFront[1] = images.getSpriteSheet().getSubimage(200, 200, 50, 50);

		characters.get(0).walkLeft[0] = images.getSpriteSheet().getSubimage(250, 200, 50, 50);
		characters.get(0).walkLeft[1] = images.getSpriteSheet().getSubimage(300, 200, 50, 50);
		
		player = new Player(characters.get(0));
		
		frame = new Frame(player, levelLoader.getLevel("1"));
		
		frame.setVisible(true);
		
		instance = new Main(60);
		while (true) {
			instance.sync();
			frame.repaintScreen();
			frame.update();
		}
		
	}
	
	public static int randInt(int min, int max) {
	    Random rand = new Random();
	    int randomNum = rand.nextInt((max - min) + 1) + min;
	    return randomNum;
	}
	
}