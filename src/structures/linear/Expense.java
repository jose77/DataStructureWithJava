package structures.linear;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class Expense {
	public Calendar date;
	public float amount;
	public String item;
	public static final SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");
	
	public Expense(Calendar expDate,float expAmount,String expItem){
		date=expDate;
		amount=expAmount;
		item=expItem;
	}
	
	public boolean equals(Object other){
		if((other!=null) && (other instanceof Expense)){
			Expense another =(Expense) other;
			return (item.equals(another.item)&& amount==another.amount && date.equals(another.date));
		}
		return false;
	}
	
	public String toString(){
		return String.format("%s\t%.2f\t%s", sdf.format(date.getTime()),amount,item);
	}
	
	public String getDate(){
		return sdf.format(date.getTime());
	}
	
	public static Calendar getCalendar(int year,int month,int date){
		Calendar cal=Calendar.getInstance();
		cal.set(year,month,date,0,0,0);
		return cal;
	}
	
	public static Calendar getCalendar(String date){
		Scanner sc=new Scanner(date).useDelimiter("/");
		return getCalendar(sc.nextInt(),sc.nextInt()-1,sc.nextInt());
	}
	
	public static String getDate(Calendar date){
		return sdf.format(date.getTime());
	}
	
}
