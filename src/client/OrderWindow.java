package client;
import java.util.*;

public class OrderWindow {
	List<Item> Cart = new ArrayList<Item>();
	public static void main(String[] args) {
		Manager Oil = new OilManager();
		Oil.initNewItem("NineTwo",80.0);
		Oil.initNewItem("NineFive",75.0);
		Oil.initNewItem("NineEight",50.0);
		
		Item tmp=Oil.findItem("NineTwo");
		Oil.getitstock(tmp);
		
		Oil.pushstock(tmp, 15);
		
		Oil.removeItem(tmp, 50);
		
		Oil.removeItem(tmp, 777);
		
		Oil.getAllstock();
	}
}
