package client;
import java.util.*;

public class OrderWindow {
	List<Item> Cart = null;
	Manager ma = null;
	public OrderWindow() {
		Cart = new ArrayList<Item>();
	}
	
	public void setOil() {
		ma = new OilManager();
		ma.initNewItem("NineTwo",80.0,23.1);
		ma.initNewItem("NineFive",75.0,25.2);
		ma.initNewItem("NineEight",50.0,28.5);
	}
	
	public void additem(String add) {
		Item it=ma.findItem(add);
		Cart.add(it);
	}
	
	public void getcart() {
	}
}
