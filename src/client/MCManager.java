package client;

public class MCManager extends Manager{
	MCManager(String systemName){
		super(systemName);
	}
	
	@Override
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
			System.out.println("無法找到你需要的食物");
		}
		return respond;
	}

	@Override
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
}