package client;

import java.util.ArrayList;
import java.util.List;

abstract class Manager{
	protected String systemName;
	
	Manager(String systemName){
		this.systemName = systemName;
	}
	final public String getName(){ return this.systemName; }
	
	protected List<Item> stock = new ArrayList<Item>();
	
	void initNewItem(String itemname,double Fstock) {
		Item it = createItem();
		it.initNewitem(itemname,Fstock);
		stock.add(it);
	}
	
	void getAllstock() {
		System.out.println("目前庫存:");
		for(Item it:stock) {
			it.getitemstock();
		}
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