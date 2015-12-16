package structures.linear;

import java.util.NoSuchElementException;


public class NCLinkedList<T> {
	Node<T> head;
	int count;
	public NCLinkedList(){
		head=null;
		count=0;
	}
	public int size(){
		return count;
	}
	public boolean isEmpty(){
		return count==0;
	}
	public void clear(){
		head=null;
		count=0;
	}
	public void add(Node<T> node){
		Node<T> curr=head;
		while(curr.next!=null){
			curr=curr.next;
		}
		curr.next=node;
		count++;
	}
	public void add(T item){
		Node<T> itemnode=new Node<T>(item);
		if(count==0){
			head=itemnode;
			count++;
		}
		else{
			add(itemnode);
		}
	}
	public void insertAt(Node<T> node,int n){
		if(n==0){
			node.next=head;
			head=node;
		}
		else{
			Node<T> curr=indexOf(n);
			node.next=curr.next;
			curr.next=node;
		}
	}
	public void removeAll(T item){
		Node<T> curr=head;
		Node<T> prev=head;
		while(curr.next!=null){
			if(item.equals(curr.data)){
				prev.next=curr.next;
				curr.data=null;
			}
			else{
				prev=curr;
			}
			curr=curr.next;
		}
	}
	
	public void remove(T item){
		Node<T> curr=head;
		Node<T> prev=head;
		while(!(item.equals(curr.data))){
			prev=curr;
			curr=curr.next;
		}
		prev.next=curr.next;
		curr.data=null;
		curr.next=null;
	}
	public void removeAt(int n){
		if(count==0){
			throw new NoSuchElementException();
		}
		if(n<0||n>=count){
			throw new IndexOutOfBoundsException(n+"<0 or >="+count);
		}
		if(n==0){
			head=head.next;
		}
		else{
			Node<T> prev=head;
				for(int i=0;i<n-1;i++){
					prev=prev.next;
				}
				prev.next=prev.next.next;
			}
	}
	public T getAt(int n){
		Node<T> curr=indexOf(n);
		return curr.data;
	}
	
	private Node<T> indexOf(int n){
		if(n<0 || n>=count){
			throw new IndexOutOfBoundsException(n+"<0 or >="+count);
		}
		Node<T> curr=head;
		for(int i=0;i<n;i++){
			curr=curr.next;
		}
		return curr;
	}
	public void setAt(T item,int n){
		Node<T> curr=indexOf(n);
		curr.data=item;
	}
	
}
