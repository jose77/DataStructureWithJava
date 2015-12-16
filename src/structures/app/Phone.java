//P5.2
package structures.app;

import java.io.BufferedReader;
import java.io.FileReader;

import structures.linear.OrderedList;

public class Phone implements Comparable<Phone>{
	String pnumber;
	String pname;
	public Phone(String num,String name){
		pnumber=num;
		pname=name;
	}
	public int compareTo(Phone p){
		int c=this.pnumber.compareTo(p.pnumber);
		return c;
	}
	public String toString(){
		return pnumber+"\t"+pname;
	}
	/*public static void main(String[] args) throws Exception{
		OrderedList<Phone> phones=new OrderedList<Phone>();
		FileReader fr=new FileReader("c:/phone.txt");
		BufferedReader br= new BufferedReader(fr);
		String s;
		while((s=br.readLine())!=null){
			String[] sl=s.split("\t");
			phones.insert(new Phone(sl[0],sl[1]));
		}
		br.close();
		for(int i=0;i<phones.size();i++){
			System.out.println(phones.get(i).toString());
		}
		
	}*/
}
