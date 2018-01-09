package client;

import java.util.ArrayList;
import java.util.List;
public class Control {
	List<Manager> system = new ArrayList<Manager>();
	int currentSystem = -1;
	
	public void addSystem(Manager target){
		system.add(target);
	}
	 
	public void switchSystem(int target){
		for(Manager it: system){
			System.out.println(x);
			System.out.println();
		}
	}
	
}
