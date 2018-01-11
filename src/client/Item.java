package client;

abstract class Item {
	protected String name;
	protected double stocknum;
	protected double price;
	
	abstract void initNewitem(String name,double initnum,double price);//add new item
	abstract void pushstock(double addnum);//
	abstract void removeitem(double rmnum);
	abstract String getitemstock();
}



