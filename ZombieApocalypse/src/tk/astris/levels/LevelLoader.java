package tk.astris.levels;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

import tk.astris.data.Size;
import tk.astris.main.Main;

public class LevelLoader {
	
	public ArrayList<Level> levels = new ArrayList<Level>();
	public HashMap<String, Level> levelMap = new HashMap<String, Level>();
	
	public LevelLoader(){
		loadLevel("1");

	}
	
	public Level getLevel(String id){
		Level lvl = levelMap.get(id);
		if(lvl.CameraX == -1 || lvl.CameraY == -1){
		}else{
			Main.camera.x = lvl.CameraX;
			Main.camera.y = lvl.CameraY;
		}
		return lvl;
	}
	
	public void loadLevel(String name){
		String[][] multi = null;
		int lineCount = 0;
		Size size = null;
		Size cameraxy = null;
		try(BufferedReader br = new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream("tk\\astris\\levels\\" + name + ".level")))) {
		    for(String line; (line = br.readLine()) != null; ) {
		    	System.out.println(line);
		    	
		    	
		    	if(multi == null){
		    		multi = new String[length(name)][line.replaceAll(" ", "").length()];
		    		size = new Size(length(name), line.replaceAll(" ", "").length());

		    	}
		    	
		    	if(line.startsWith("data.")){
		    		if(line.startsWith("data.spawn=")){
		    			line = line.replaceFirst("data.spawn=", "");
		    			if(line.equals("middle")){
			    			cameraxy = new Size(-size.x*25 + size.x*15 + 50, 0);
		    			}else{
		    			String[] parts = line.split(",");
		    		    
		    			cameraxy = new Size(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
		    			}
		    			}
		    	}else{
		    	
		    		String[] text = line.split(" ");
		    		for(int i = 0; i < text.length; i++){
		    			multi[lineCount][i] = text[i];
		    		}
			    	lineCount++;
		    	}
		    	
		    }
		} catch (IOException e) {
			e.printStackTrace();
		}
		Level lvl = new Level(multi, size);
		
		if(cameraxy != null){
			lvl.CameraX = cameraxy.x;
			lvl.CameraY = cameraxy.y;
			System.out.println(cameraxy.y + " : " + cameraxy.x);
		}
		
		levels.add(lvl);
		levelMap.put(name, lvl);
		
	}
	
	private int length(String name) throws IOException{
		int length = 0;
	try(BufferedReader br = new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream("tk\\astris\\levels\\" + name + ".level")))) {
	    for(String line; (line = br.readLine()) != null; ) {
	    	if(!line.startsWith("data.")){
	    	length++;
	    	}
	    }
	}
	return length;
	}


}
