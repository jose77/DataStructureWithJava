package structures.linear;

import java.util.Calendar;
public class ItemExpense extends Expense{
	public ItemExpense(String item){
		super(null,(float)0.0,item);
	}
	public ItemExpense(Calendar date,float amount,String item){
		super(date,amount,item);
	}
	public boolean equals(Object other){
		if((other!=null)&&(other instanceof Expense)){
			Expense another = (Expense) other;
			return item.equals(another.item);
		}
		return false;
	}
}
