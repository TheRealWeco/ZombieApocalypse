package tk.astris.main;

import java.util.ArrayList;

import tk.astris.data.Char;
import tk.astris.data.Size;
import tk.astris.fileManager.Images;
import tk.astris.fileManager.Language;
import tk.astris.player.Player;


public class Main {
	
	
	
	private int fps;
	private long timeThen;
	boolean newVersion = true;
	
	public static String VERSION = "0.0.1";
	public static int HEIGHT = 800;
	public static int WIDTH = 800;
	
	
	public static Frame frame;
	public static Player player;
	public static Main instance;
	public static Language language;
	public static Images images;
	
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
		
		characters.add(new Char(null, language.string.get("steve"), new Size(50, 50), 100, 1.0F, 1));
		
		images = new Images();
		player = new Player(WIDTH/2-characters.get(0).size.x/2, HEIGHT/2-characters.get(0).size.y/2, characters.get(0));
		frame = new Frame(player);
		
		
		frame.setVisible(true);
		
		instance = new Main(60);
		while (true) {
			instance.sync();
			frame.repaintScreen();
			frame.update();
		}
		
	}
}