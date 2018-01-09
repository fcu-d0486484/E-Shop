package client;

import java.util.ArrayList;
import java.util.List;

abstract class Manager{
	
	protected List<Item> stock = new ArrayList<Item>();
	
	void initNewItem(String itemname,double Fstock) {
		Item it = createItem();
		it.initNewitem(itemname,Fstock);
		stock.add(it);
	}
	
	List<String> getAllstock() {
		List<String> tmp = new ArrayList<String>();
		for(Item it:stock) {
			tmp.add(it.getitemstock());
		}
		return tmp;
	}
	
	void pushstock(Item it,double addnum) {
		it.pushstock(addnum);
	}
	
	void removeItem(Item it,double num) {
		it.removeitem(num);
	}
	
	void getitstock(Item it) {
		it.getitemstock();
	}
	
	abstract Item findItem(String name);
	abstract Item createItem();
}