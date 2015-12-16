package structures.linear;

import java.util.NoSuchElementException;

class Node<T>{
	T data;
	Node<T> next;
	Node(T dat){
		data=dat;
		next=null;
	}
}
public class LinkedList<T> {
	Node<T> tail;
	int count;
	public LinkedList(){
		tail=null;
		count=0;
	}
	public int size(){return count;}
	public boolean isEmpty(){return count==0;}
	public boolean contains(T item){return indexOf(item)>=0;}
	public void clear(){tail=null;count=0;}
	public void add(T item){
		Node<T> itemnode =new Node<T>(item);
		if(count==0){//empty list
			itemnode.next=itemnode;
		}
		else{
			itemnode.next=tail.next;
			tail.next=itemnode;
		}
		tail=itemnode;
		count++;
	}
	public void insertAt(T item,int index){
		if(index<0 || index>=count){
			throw new IndexOutOfBoundsException(index+"<0 or >="+count);
		}
		Node<T> prev=tail;
		for(int i=0;i<index;i++){
			prev=prev.next;
		}
		Node<T> itemnode=new Node<T>(item);
		itemnode.next=prev.next;
		prev.next=itemnode;
		count++;
	}
	public void removeAll(T item){//can not fully understand this
		if(count==0){
			throw new NoSuchElementException();
		}
		Node<T> prev=tail;
		Node<T> curr=tail.next;
		int oldcount=count;
		for(int i=0;i<count;i++){
			if(item.equals(curr.data)){
				prev.next=curr.next;
				curr.data=null;
				curr.next=null;
				count--;
			}
			else{
				prev=curr;
			}
			curr=prev.next;
				
		}
		if(count==oldcount){
			throw new NoSuchElementException();
		}
		if(count==0){tail=null;}
		else{tail=prev;}
	}
	public T removeAt(int index){
		if(index<0 || index>=count){
			throw new IndexOutOfBoundsException(index+"<0 or >="+count);
		}
		T ret=null;
		if(index==0){
			ret=tail.next.data;
			if(count==1){
				tail=null;
			}
			else{
				tail.next=tail.next.next;
			}
			count--;
		}
		else{
			Node<T> prev=tail.next;
			for(int i=0;i<index-1;i++){
				prev=prev.next;
			}
			Node<T> curr=prev.next;
			ret=curr.data;
			prev.next=curr.next;
			curr.next=null;
			count--;
			if(curr==tail){
				tail=prev;
			}
		}
		return ret;
	}
	public void remove(T item){
		int i=indexOf(item);
		if(i==-1){
			throw new NoSuchElementException();
		}
		removeAt(i);
	}
	public void setAt(T item,int index){
		if(index<0 || index>=count){
			throw new IndexOutOfBoundsException(index+"<0 or >="+count);
		}
		Node<T> curr=tail.next;
		for(int i=0;i<index;i++){
			curr=curr.next;
		}
		curr.data=item;
	}
	public int indexOf(T item){
		if(count==0){
			return -1;
		}
		Node<T> curr=tail.next;
		for(int i=0;i<count;i++){
			if(item.equals(curr.data)){
				return i;
			}
			curr=curr.next;
		}
		return -1;
		
	}
	public T getAt(int index){
		if(index<0 || index>=count){
			throw new IndexOutOfBoundsException(index+"<0 or >="+count);
		}
		Node<T> curr=tail.next;
		for(int i=0;i<index;i++){
			curr=curr.next;
		}
		return curr.data;
	}
} 
