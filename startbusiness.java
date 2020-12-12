package GHL;

import java.time.*;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Scanner.*;
import java.util.Iterator;

abstract class Drinks{
	int which = 0;				
	
	static int number;
	static String Drink;		//这是Drink的名字
	static double Cost[] = new double[] {}; 		//该Drink的成本
	static LocalDate ManufactureDate ;  //定义Drink的生产日期
	static int qualityguaranteeperiod ;			//该Drink的保质期
	static LocalDate Qualityguaranteeperiod ;//保质期时间

//构造方法显示该Drink的生产日期及保质期
	public Drinks (String Drink,LocalDate ManufactureDate,int qualityguaranteeperiod) {
		System.out.println(Drink+"类--生产日期:"+ManufactureDate+"--保质期:"+qualityguaranteeperiod);
		if(ManufactureDate.isAfter(LocalDate.of(2020,12,8)) || ManufactureDate.isEqual(LocalDate.of(2020,12,8))) {
			which = 1;
		}
	}
	
	
//判断Drink是否过期并输出
	public String toString() {
		if(which == 1) {
			System.out.println("过期");
		}else {
			System.out.println("未过期");
		}
		return null;
	}
}




//啤酒类
class Beer extends Drinks{
	static String Drink = "Beer";
	static int number = 300;
	LinkedList<String> beerdegree = new LinkedList();   //啤酒度数类别
	double Cost[] = new double[] {25,30,35};	//不同类别的价格
	static LocalDate ManufactureDate = LocalDate.of(2020,12,9);
	static int qualityguaranteeperiod = 30;
	
	public Beer() {
		super(Drink,ManufactureDate,qualityguaranteeperiod);
	}
}



//果汁类
class Juice extends Drinks{
	static String Drink = "Juice";
	static int number = 300;
	LinkedList <String>juicekinds = new LinkedList();  //果汁类别
	double Cost[] = new double[] {10,20,30};	//不同类别的价格
	static LocalDate ManufactureDate = LocalDate.of(2020,12,9);
	static int qualityguaranteeperiod = 2;
	
	public Juice() {
		super(Drink,ManufactureDate,qualityguaranteeperiod);
	}
}



//套餐类
class SetMeal{
	int Friedchickenprice = 50;		//特有的炸鸡价格
	LinkedList <String>Setmeal = new LinkedList();	//套餐类别
	double[] setmealprice = new double[] {85,100,115};	//套餐价格
}



//顾客类
class Consumer{
	String name = "张三";
	double balance = 0;
	public Consumer() {
		System.out.println("姓名："+name);
		System.out.println("余额："+balance);
	}
}



//炸鸡店接口
interface FriedChickenRestaurant{
	default void SetMealforsale() {		//出售套餐
	}
	
	default void Bulkpurchase() {		//批量进货
	}
}



//西二炸鸡店
class West2FriedChickenRestauran implements FriedChickenRestaurant{   
	long Restaurantaccountbalance;			//账目余额
	
////原料清单
	public void rawmaterial() {    
		Beer beer = new Beer();
		beer.beerdegree.add("10°啤酒");
		beer.beerdegree.add("20°啤酒");
		beer.beerdegree.add("30°啤酒");
		
		Juice juice = new Juice();
		juice.juicekinds.add("可乐");
		juice.juicekinds.add("橙汁");
		juice.juicekinds.add("牛奶");
		
		SetMeal setmeal = new SetMeal();
		System.out.println("\n套餐价格：");
		Iterator iterator1 = beer.beerdegree.iterator();
		Iterator iterator2 = juice.juicekinds.iterator();
		int i = 0;
		while(iterator1.hasNext() && iterator2.hasNext()) {
			Object obj1 = iterator1.next();
			Object obj2 = iterator2.next();
			System.out.println("套餐"+(++i)+":炸鸡"+"、"+obj1+"、"+obj2+"\t价格："+setmeal.setmealprice[i-1]);
		}
		
		System.out.println("单点价格:");
		System.out.println("炸鸡:"+setmeal.Friedchickenprice+"元");
		System.out.println("10°啤酒:"+beer.Cost[0]+"元,"+"20°啤酒:"+beer.Cost[1]+"元,"+"30°啤酒:"+beer.Cost[2]+"元");
		System.out.println("可乐:"+juice.Cost[0]+"元,"+"橙汁"+juice.Cost[1]+"元,"+"牛奶:"+juice.Cost[2]+"元");
	}
	
//啤酒余量
	private void use(Beer beer) {
		beer.number--;
		if(beer.number <= 0) {
			System.out.println("已售空!");
		} else {
			System.out.println("余量："+beer.number);
		}
	}
	
//果汁余量
	private void use(Juice juice) {
		juice.number--;
		if(juice.number <= 0) {
			System.out.println("已售空!");
		} else {
			System.out.println("余量："+juice.number);
		}
	}
}

public class startbusiness {
	public static void main(String[] args) {
		
	}
}
