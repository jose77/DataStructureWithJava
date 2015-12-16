package structures.linear;

import java.util.NoSuchElementException;

public class List<T> {
	LinkedList<T> elements;
	int cursor;
	
	public List(){
		elements=new LinkedList<T> ();
		cursor=-1;
	}
	public void add(T item){
		elements.add(item);
	}
	public int size(){return elements.size();}
	public boolean isEmpty(){return elements.isEmpty();}
	public boolean contains(T item){return elements.contains(item);}
	public void remove(T item){elements.remove(item);}
	public void removeAll(T item){elements.removeAll(item);}
	public void clear(){elements.clear();}
	public T first(){
		if(elements.count==0){
			return null;
		}
		cursor=0;
		return elements.getAt(cursor);
	}
	public T next(){
		if(cursor<0 || cursor==(elements.size()-1)){
			return null;
		}
		cursor++;
		return elements.getAt(cursor);
	}
}
