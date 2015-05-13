package tk.astris.levels;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

import tk.astris.data.Size;

public class LevelLoader {
	
	public ArrayList<Level> levels = new ArrayList<Level>();
	public HashMap<String, Level> levelMap = new HashMap<String, Level>();
	
	public LevelLoader(){
		loadLevel("1");

	}
	
	public void loadLevel(String name){
		String[][] multi = null;
		int lineCount = 0;
		Size size = null;
		try(BufferedReader br = new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream("tk\\astris\\levels\\" + name + ".level")))) {
		    for(String line; (line = br.readLine()) != null; ) {
		    	System.out.println(line);
		    	
		    	if(multi == null){
		    		multi = new String[length(name)][line.replaceAll(" ", "").length()];
		    		size = new Size(length(name), line.replaceAll(" ", "").length());

		    	}
		    	
		    		String[] text = line.split(" ");
		    		for(int i = 0; i < text.length; i++){
		    			multi[lineCount][i] = text[i];
		    		}
			    	lineCount++;
		    	
		    }
		} catch (IOException e) {
			e.printStackTrace();
		}
		Level lvl = new Level(multi, size);
		levels.add(lvl);
		levelMap.put(name, lvl);
		
	}
	
	@SuppressWarnings("unused")
	private int length(String name) throws IOException{
		int length = 0;
	try(BufferedReader br = new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream("tk\\astris\\levels\\" + name + ".level")))) {
	    for(String line; (line = br.readLine()) != null; ) {
	    	length++;
	    }
	}
	return length;
	}


}
