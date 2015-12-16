package structures.app;

import java.util.ArrayList;


public class myPolynomal {
	//private double var;
	private ArrayList<Element> elements;
	public myPolynomal(){
		elements=new ArrayList<Element>();
	}
	public void add(int par,int pow){
		int pos=binarySearch(pow);
		if(pos>=0){
			throw new ElementAlreadyExistExeption();
		}
		else{
			elements.add(-pos-1,new Element(par,pow));
		}
		
	}
	public double valueOf(double var){
		double sum=0;
		for(Element ele:elements){
			sum+=ele.par*Math.pow(var, ele.pow);
		}
		return sum;
		
	}
	public String toString(){
		String s="";
		for(Element ele:elements){
			s+=ele.par+"x^"+ele.pow+" + ";
		}
		return s;
	}
	public int binarySearch(int pow){
		if(elements.size()==0){
			return -1;
		}
		int low=0;
		int high=elements.size()-1;
		int mid=0;
		while(low<=high){
			mid=(low+high)/2;
			int c=pow-elements.get(mid).pow;
			if(c==0){return mid;}
			if(c>0){low=mid+1;}
			else{high=mid-1;}
		}
		if(pow<elements.get(mid).pow){
			return (-mid-1);
		}
		else{
			return (-mid-2);
		}
	}
}
