package structures.linear;
import java.util.NoSuchElementException;
import java.util.Calendar;

public class ExpenseList {
	List<Expense> expenses;
	public ExpenseList(){
		expenses=new List<Expense> ();
	}
	public void add(Expense exp){expenses.add(exp);}
	public int size(){return expenses.size();}
	public boolean isEmpty(){return expenses.isEmpty();}
	//public boolean contains(Expense exp){return expenses.contains(exp);}
	public void clear(){expenses.clear();}
	public void remove(Expense exp){expenses.remove(exp);}
	public Expense first(){return expenses.first();}
	public Expense next(){return expenses.next();}
	public Expense get(Expense getExp){
		Expense exp=expenses.first();
		while(exp!=null){
			if(exp.equals(getExp)){
				return exp;
			}
			exp=expenses.next();
		}
		return null;
	}
	public boolean contains(Expense exp){
		Expense nextExpense=expenses.first();
		while(nextExpense!=null){
			if(exp.equals(nextExpense)){
				return true;
			}
			nextExpense=expenses.next();
		}
		return false;
	}
	public boolean contains(String item){//
		ItemExpense nextExpense=(ItemExpense)expenses.first();
		while(nextExpense!=null){
			if(item.equals(nextExpense.item)){
				return true;
			}
			nextExpense=(ItemExpense)expenses.next();
		}
		return false;
	}
	public float maxExpense(){
		float min=Float.MAX_VALUE;
		Expense exp=expenses.first();
		while(exp!=null){
			float amt=exp.amount;
			if(amt<min){
				min=amt;
			}
			exp=expenses.next();
		}
		return min;
	}
	public float minExpense(){
		float max=Float.MIN_VALUE;
		Expense exp=expenses.first();
		while(exp!=null){
			float amt=exp.amount;
			if(amt>max){
				max=amt;
			}
			exp=expenses.next();
		}
		return max;
	}
	public float avgExpense(){
		float sum=0;
		Expense exp=expenses.first();
		while(exp!=null){
			sum+=exp.amount;
			exp=expenses.next();
		}
		return sum/expenses.size();
	}
	public float amountSpentOn(String item){
		float sum=0;
		Expense exp=expenses.first();
		while(exp!=null){
			if(item.equals(exp.item)){
				sum+=exp.amount;
			}
			exp=expenses.next();
		}
		return sum;
	}
	public float amountSpentDuring(Calendar from,Calendar to){
		float sum=0;
		Expense exp=expenses.first();
		while(exp!=null){
			if(!((exp.date.before(from))||(exp.date.after(to)))){
				sum+=exp.amount;
			}
			exp=expenses.next();
		}
		return sum;
	}
	public float[] avgminmaxExpense(){
		float min=Float.MAX_VALUE;
		float max=Float.MIN_VALUE;
		float sum=0;
		float[] result=new float[3];
		Expense exp=expenses.first();
		while(exp!=null){
			float amt=exp.amount;
			if(min>amt){
				min=amt;
			}
			if(max<amt){
				max=amt;
			}
			sum+=amt;
			exp=expenses.next();
		}
		result[0]=sum/expenses.size();
		result[1]=min;
		result[2]=max;
		return result;
	}
}
