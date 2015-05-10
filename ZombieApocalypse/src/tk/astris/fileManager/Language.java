package tk.astris.fileManager;

import java.util.HashMap;

import tk.astris.data.LanguageType;

public class Language {

	public static HashMap<LanguageType, String> string = new HashMap<LanguageType, String>();
	
	public static void setupLanguage(){
		string.put(new LanguageType("en", "steve"), "Steve");
	}

	
}
