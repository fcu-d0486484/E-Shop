package client;
import java.util.*;

abstract class Item {
	protected String name;
	protected double stocknum;
	
	abstract void initNewitem(String name,double initnum);//add new item
	abstract void pushstock(double addnum);//
	abstract void removeitem(double rmnum);
	abstract void getitemstock();
}



