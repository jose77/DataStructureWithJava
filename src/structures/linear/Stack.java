package structures.linear;

import java.util.NoSuchElementException;

public class Stack<T> {
	LinkedList<T> list;
	int cursor;
	public Stack(){
		list=new LinkedList<T>();
		cursor=-1;
	}
	public void push(T item){
		if(list.size()==0){
			list.add(item);
		}
		else{
			list.insertAt(item, 0);
		}
	}
	public T pop(){
		if(list.isEmpty()){
			throw new NoSuchElementException();
		}
		else{
			return list.removeAt(0);
		}
	}
	public int size(){
		return list.size();
	}
	public boolean isEmpty(){
		return list.isEmpty();
	}
	public void clear(){
		list.clear();
	}
	public T first(){
		if(list.size()==0){
			return null;
		}
		cursor=0;
		return list.getAt(cursor);
		
	}
	public T next(){
		if(cursor<0 || cursor==list.size()-1){
			return null;
		}
		cursor++;
		return list.getAt(cursor);
	}
}
