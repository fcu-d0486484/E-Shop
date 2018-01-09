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
		ma.initNewItem("NineTwo",80.0);
		ma.initNewItem("NineFive",75.0);
		ma.initNewItem("NineEight",50.0);
	}
}
