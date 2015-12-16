package structures.app;

public class NormalPhone extends Phone {
	public NormalPhone(String name,String num){
		super(num,name);
	}
	public int compareTo(Phone p){
		return this.pname.compareTo(p.pname);
	}
	public String toString(){
		return pname+"\t"+pnumber;
	}
}
