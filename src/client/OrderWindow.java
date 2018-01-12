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
	
	public void setMC() {
		ma = new MCManager();
		ma.initNewItem("1 Dish",80,20);
		ma.initNewItem("2 Dish",75,10);
		ma.initNewItem("3 Dish",50,30);
		ma.initNewItem("A Set",80,33);
		ma.initNewItem("B Set",75,23);
		ma.initNewItem("C Set",50,43);
		ma.initNewItem("Coke",80,25);
		ma.initNewItem("Sprite",75,25);
		ma.initNewItem("Coke Zero",50,25);
		
	}
	
	public void additem(String add) {
		Item it=ma.findItem(add);
		Cart.add(it);
	}
	
	public void getcart() {
	}
}
