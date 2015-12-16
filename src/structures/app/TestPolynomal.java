package structures.app;

import structures.linear.OrderedList;

public class TestPolynomal {
	public static double valueOf(double var,OrderedList<Element> pl){
		double sum=0;
		for(int i=0;i<pl.size();i++)
			sum+=pl.get(i).par*Math.pow(var, pl.get(i).pow);
		return sum;
	}
	public static void main(String args[]){
		OrderedList<Element> pl=new OrderedList<Element>();
		pl.insert(new Element(3,1));
		pl.insert(new Element(4,7));
		pl.insert(new Element(18,3));
		for(int i=0;i<pl.size()-1;i++){
			System.out.print(pl.get(i).toString()+" + ");
		}
		System.out.print(pl.get(pl.size()-1).toString());
		System.out.println();
		double value=valueOf(5,pl);
		System.out.print(value);
	}
}
