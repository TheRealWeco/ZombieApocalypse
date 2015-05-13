package tk.astris.data;

import java.util.ArrayList;

public class AnimationChar {
	
	public String type;
	public ArrayList<State> states;
	
	public AnimationChar(String type, ArrayList<State> states){
		this.type = type;
		this.states = states;
	}
	public AnimationChar(String type, State state){
		this.type = type;
		ArrayList<State> list = new ArrayList<State>();
		list.add(state);
		this.states = list;
	}

}
