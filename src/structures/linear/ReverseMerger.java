//p8.4
package structures.linear;

public class ReverseMerger {
	public static Node<Integer> merge(Node<Integer> l1,Node<Integer> l2){
		Node<Integer> l=null;
		if(l1==null){
			return l2;
		}
		if(l2==null){
			return l1;
		}
		if(l1.data.compareTo(l2.data)<0){
			l=l1;
			l.next=merge(l1.next,l2);
		}
		else{
			l=l2;
			l.next=merge(l1,l2.next);
		}
		return l;
	}
	
	public static void main(String[] args){
		NCLinkedList<Integer> list1=new NCLinkedList<Integer>();
		NCLinkedList<Integer> list2=new NCLinkedList<Integer>();
		list1.add(1);
		list1.add(3);
		list1.add(5);
		list2.add(2);
		list2.add(6);
		Node<Integer> l1=list1.head;
		Node<Integer> l2=list2.head;
		Node<Integer>l=merge(l1,l2);
		while(l!=null){
			System.out.println(l.data);
			l=l.next;
		}
	}
		
}
