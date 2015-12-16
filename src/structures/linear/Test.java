package structures.linear;

import java.io.*;
import java.util.Calendar;
public class Test {
	public static void main(String[] args){
		ExpenseList expList=new ExpenseList();
		ItemExpense itemExp=new ItemExpense(Calendar.getInstance(),(float)499,"Shoes");
		expList.add(itemExp);
		expList.add(new Expense(Calendar.getInstance(),(float) 122.0,"Shoes"));
		String s=expList.first().toString();
		System.out.print(s);
	}
}
