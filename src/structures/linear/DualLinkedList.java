package structures.linear;

import java.util.NoSuchElementException;

class DLLNode<T>{
	T data;
	DLLNode<T> prev;
	DLLNode<T> next;
	DLLNode(T data){
		this.data=data;
		prev=null;next=null;
	}
}
public class DualLinkedList<T> {
	DLLNode front;
	int count;
	public DualLinkedList(){front=null;count=0;}
	public DLLNode<T> addFront(T item){
		DLLNode newnode=new DLLNode(item);
		newnode.next=front;
		front.prev=newnode;
		front=newnode;
		count++;
		return front;
	}
	public DLLNode<T> deleteFront(){
		if(count==0){
			throw new NoSuchElementException();
		}
		front=front.next;
		front.prev=null;
		count--;
		return front;
	}
	public DLLNode<T> delete(T item){
		if(count==0){
			throw new NoSuchElementException();
		}
		DLLNode<T> curr=front;
		for(int i=0;i<indexOf(item);i++){
			curr=curr.next;
		}
		curr.prev.next=curr.next;
		curr.next.prev=curr.prev;
		curr.data=null;curr.prev=null;curr.next=null;
		count--;
		return front;
	}
	private int indexOf(T item){
		if(count==0){
			return -1;
		}
		DLLNode<T> curr=front;
		for(int i=0;i<count;i++){
			if(item.equals(curr.data)){
				return i;
			}
			curr=curr.next;
		}
		return -1;
	}
	public DLLNode<T> deleteAll(T item){
		if(count==0){
			throw new NoSuchElementException();
		}
		DLLNode<T> curr=front;
		for(int i=0;i<count;i++){
			if(item.equals(curr.data)){
				curr.prev.next=curr.next;
				curr.next.prev=curr.prev;
				curr.data=null;
				count--;
			}
			curr=curr.next;
		}
		if(count==0){
			return front=null;
		}
		else{
			while(curr.prev!=null){
				curr=curr.prev;
			}
			return front=curr;
		}
	}
}