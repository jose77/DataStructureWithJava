//p8.5
package structures.linear;

public class ReverseInsert {
	static <T> void insert(Node<T> l,Node<T> newNode){
		if(l.next==null){
			l.next=newNode;
			return;
		}
		insert(l.next,newNode);
			
	}
	
	public static void main(String[] args){
		NCLinkedList<String> list=new NCLinkedList<String> ();
		Node<String> newNode=new Node<String> ("new");
		list.add("a");
		list.add("b");
		list.add("c");
		Node<String> l=list.head;
		insert(l,newNode);
		while(l!=null){
			System.out.println(l.data);
			l=l.next;
		}
 	}
}
