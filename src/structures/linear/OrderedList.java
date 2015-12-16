package structures.linear;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class OrderedList<T extends Comparable<T>> {
	ArrayList<T> elements;
	int cursor;
	public OrderedList(){
		elements=new ArrayList<T>();
		cursor=-1;
	}
	public OrderedList(int capacity){
		elements=new ArrayList<T>(capacity);
		cursor=-1;
	}
	public void add(T item){
		int pos= elements.size();
		if(pos>0){
			T pred=elements.get(pos-1);
			if(item.compareTo(pred)<=0){
				throw new OrderViolationException();
			}
		}
		elements.add(item);
	}
	public void add(int pos,T item){
		if(pos<0||pos>=elements.size()){
			throw new IndexOutOfBoundsException(pos+"<0 or >="+elements.size()+1);
		}
		if(pos>0){//´æÔÚÇ°Ç÷
			if(item.compareTo(elements.get(pos-1))<=0){
				throw new OrderViolationException();
			}
		}
		if(pos<(elements.size()-1)){
			if(item.compareTo(elements.get(pos))>=0){
				throw new OrderViolationException();
			}
		}
		elements.add(pos,item);
	}
	public void insert(T item){
		if(elements.size()==0){
			elements.add(item);
			return;
		}
		int pos=binarySearch(item);
		if(pos>=0){
			throw new OrderViolationException();
		}
		else{
			elements.add(-pos-1,item);
		}
		
	}
	public int size(){return elements.size();}
	public boolean isEmpty(){return elements.isEmpty();}
	public int binarySearch(T item){
		if(elements.size()==0){
			return -1;
		}
		int low=0,high=elements.size()-1;
		int mid=0;
		while(low<=high){
			mid=(low+high)/2;
			int c=item.compareTo(elements.get(mid));
			if(c==0){return mid;}
			if(c<0){high=mid-1;}
			else{low=mid+1;}
		}
		if(item.compareTo(elements.get(mid))<0){
			return (-(mid+1));
		}
		else{
			return (-(mid+2));
		}
	}
	public T get(int pos) {
		if(pos<0||pos>=elements.size()){
			throw new IndexOutOfBoundsException(pos+"<0 or >="+elements.size());
		}
		return elements.get(pos);
	}
	public void remove(T item){
		if(elements.size()==0){
			throw new NoSuchElementException();
		}
		int pos=binarySearch(item);
		if(pos<0){
			throw new NoSuchElementException();
		}
		elements.remove(pos);
	}
	public void remove(int pos){
		if(pos<0 || pos>=elements.size()){
			throw new IndexOutOfBoundsException(pos+"<0 || >="+elements.size());
		}
		elements.remove(pos);
		
	}
	public void clear(){elements.clear();}
	public T first(){
		if(elements.size()==0)
			return null;
		cursor=0;
		return elements.get(cursor);
	}
	public T next(){
		if(cursor<0||cursor==(elements.size()-1))
			return null;
		cursor++;
		return elements.get(cursor);
		
					
	}
	
	
} 
