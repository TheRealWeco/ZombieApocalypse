package tk.astris.main;

import java.util.ArrayList;

import tk.astris.data.AnimationChar;
import tk.astris.data.Char;
import tk.astris.data.Size;
import tk.astris.data.State;
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
		
		ArrayList<AnimationChar> animations = new ArrayList<AnimationChar>();
		animations.add(new AnimationChar("idle", new State(0, images.getSpriteSheet().getSubimage(200, 0, 50, 50))));
		//TODO
		characters.add(new Char(images.getSpriteSheet().getSubimage(200, 0, 50, 50), animations, language.string.get("steve"), new Size(50, 50), 100, 1.0F, 1));
		
		levelLoader = new LevelLoader();
		images = new Images();
		tiles = new Tiles();
		player = new Player(WIDTH/2-characters.get(0).size.x/2, HEIGHT/2-characters.get(0).size.y/2, characters.get(0));
		frame = new Frame(player, levelLoader.levelMap.get("1"));
		
		
		frame.setVisible(true);
		
		instance = new Main(60);
		while (true) {
			instance.sync();
			frame.repaintScreen();
			frame.update();
		}
		
	}
}