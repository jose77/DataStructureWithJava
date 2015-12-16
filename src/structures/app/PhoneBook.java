package structures.app;

import structures.linear.OrderedList;

public class PhoneBook {
	OrderedList<Phone> phones;
	public PhoneBook(){
		phones=new OrderedList<Phone>();
	}
	public void insert(Phone p){
		phones.insert(p);
	}
	public void remove(Phone p){
		phones.remove(p);
	}
	public String getName(String num){
		Phone p=new Phone(num,null);
		int c=phones.binarySearch(p);
		if(c<0){
			return "The number does not exist";
		}
		else{
			return phones.get(c).pname;
		}
		
	}
}
