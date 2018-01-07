package client;
import java.util.*;

abstract class Item {
	protected String name;
	protected double stocknum;
	
	abstract void initNewitem(String name,double initnum);
	abstract void pushstock(double addnum);
	abstract void removeitem(double rmnum);
	abstract void getitemstock();
}

abstract class Manager{
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

class OilManager extends Manager{
	Item createItem() {
		return new Item() {
			void initNewitem(String name,double initnum) {
				this.name=name;
				this.stocknum=initnum;
			}
			void pushstock(double addnum) {
				System.out.println("品名:"+this.name+"增加從"+this.stocknum+">>>"+(this.stocknum+addnum));
				this.stocknum+=addnum;
			}
			void removeitem(double rmnum) {
				if(rmnum>this.stocknum)
					System.out.println("品名:"+this.name+"庫存不足，目前:"+this.stocknum+"，欲扣除:"+rmnum);
				else {
					System.out.println("品名:"+this.name+"以扣除"+this.stocknum+">>>"+(this.stocknum-rmnum));
					this.stocknum-=rmnum;
				}
			}
			void getitemstock() {
				System.out.println("品名:"+this.name+"數量:"+this.stocknum);
			}
		};
	}
	Item findItem(String name) {
		Item respond=null;
		String tmp=name.toLowerCase();
		for(Item it:stock) {
			if(tmp.equals(it.name.toLowerCase())) {
				respond=it;
				break;
			}
		}
		if(respond==null) {
			System.out.println("無法找到你需要的油品");
		}
		return respond;
	}
}