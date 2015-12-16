package structures.app;

interface MyComparable<T> extends Comparable<T>{
	public int compareTo(T item);
}
public class Element implements MyComparable<Element>{
	int par;
	int pow;
	public Element(int par,int pow){
		this.par=par;this.pow=pow;
	}
	public int compareTo(Element item){
		return item.pow-this.pow;
	}
	public String toString(){
		return par+"x^"+pow;
	}

}
