package GHL;

import java.time.*;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Scanner.*;
import java.util.Iterator;

abstract class Drinks{
	int which = 0;				
	
	static int number;
	static String Drink;		//����Drink������
	static double Cost[] = new double[] {}; 		//��Drink�ĳɱ�
	static LocalDate ManufactureDate ;  //����Drink����������
	static int qualityguaranteeperiod ;			//��Drink�ı�����
	static LocalDate Qualityguaranteeperiod ;//������ʱ��

//���췽����ʾ��Drink���������ڼ�������
	public Drinks (String Drink,LocalDate ManufactureDate,int qualityguaranteeperiod) {
		System.out.println(Drink+"��--��������:"+ManufactureDate+"--������:"+qualityguaranteeperiod);
		if(ManufactureDate.isAfter(LocalDate.of(2020,12,8)) || ManufactureDate.isEqual(LocalDate.of(2020,12,8))) {
			which = 1;
		}
	}
	
	
//�ж�Drink�Ƿ���ڲ����
	public String toString() {
		if(which == 1) {
			System.out.println("����");
		}else {
			System.out.println("δ����");
		}
		return null;
	}
}




//ơ����
class Beer extends Drinks{
	static String Drink = "Beer";
	static int number = 300;
	LinkedList<String> beerdegree = new LinkedList();   //ơ�ƶ������
	double Cost[] = new double[] {25,30,35};	//��ͬ���ļ۸�
	static LocalDate ManufactureDate = LocalDate.of(2020,12,9);
	static int qualityguaranteeperiod = 30;
	
	public Beer() {
		super(Drink,ManufactureDate,qualityguaranteeperiod);
	}
}



//��֭��
class Juice extends Drinks{
	static String Drink = "Juice";
	static int number = 300;
	LinkedList <String>juicekinds = new LinkedList();  //��֭���
	double Cost[] = new double[] {10,20,30};	//��ͬ���ļ۸�
	static LocalDate ManufactureDate = LocalDate.of(2020,12,9);
	static int qualityguaranteeperiod = 2;
	
	public Juice() {
		super(Drink,ManufactureDate,qualityguaranteeperiod);
	}
}



//�ײ���
class SetMeal{
	int Friedchickenprice = 50;		//���е�ը���۸�
	LinkedList <String>Setmeal = new LinkedList();	//�ײ����
	double[] setmealprice = new double[] {85,100,115};	//�ײͼ۸�
}



//�˿���
class Consumer{
	String name = "����";
	double balance = 0;
	public Consumer() {
		System.out.println("������"+name);
		System.out.println("��"+balance);
	}
}



//ը����ӿ�
interface FriedChickenRestaurant{
	default void SetMealforsale() {		//�����ײ�
	}
	
	default void Bulkpurchase() {		//��������
	}
}



//����ը����
class West2FriedChickenRestauran implements FriedChickenRestaurant{   
	long Restaurantaccountbalance;			//��Ŀ���
	
////ԭ���嵥
	public void rawmaterial() {    
		Beer beer = new Beer();
		beer.beerdegree.add("10��ơ��");
		beer.beerdegree.add("20��ơ��");
		beer.beerdegree.add("30��ơ��");
		
		Juice juice = new Juice();
		juice.juicekinds.add("����");
		juice.juicekinds.add("��֭");
		juice.juicekinds.add("ţ��");
		
		SetMeal setmeal = new SetMeal();
		System.out.println("\n�ײͼ۸�");
		Iterator iterator1 = beer.beerdegree.iterator();
		Iterator iterator2 = juice.juicekinds.iterator();
		int i = 0;
		while(iterator1.hasNext() && iterator2.hasNext()) {
			Object obj1 = iterator1.next();
			Object obj2 = iterator2.next();
			System.out.println("�ײ�"+(++i)+":ը��"+"��"+obj1+"��"+obj2+"\t�۸�"+setmeal.setmealprice[i-1]);
		}
		
		System.out.println("����۸�:");
		System.out.println("ը��:"+setmeal.Friedchickenprice+"Ԫ");
		System.out.println("10��ơ��:"+beer.Cost[0]+"Ԫ,"+"20��ơ��:"+beer.Cost[1]+"Ԫ,"+"30��ơ��:"+beer.Cost[2]+"Ԫ");
		System.out.println("����:"+juice.Cost[0]+"Ԫ,"+"��֭"+juice.Cost[1]+"Ԫ,"+"ţ��:"+juice.Cost[2]+"Ԫ");
	}
	
//ơ������
	private void use(Beer beer) {
		beer.number--;
		if(beer.number <= 0) {
			System.out.println("���ۿ�!");
		} else {
			System.out.println("������"+beer.number);
		}
	}
	
//��֭����
	private void use(Juice juice) {
		juice.number--;
		if(juice.number <= 0) {
			System.out.println("���ۿ�!");
		} else {
			System.out.println("������"+juice.number);
		}
	}
}

public class startbusiness {
	public static void main(String[] args) {
		
	}
}
