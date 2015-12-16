//p8.6
package structures.linear;

public class ReverseContainer {
	static <T> boolean contains(Node<T> l, T item){
		if(l.data.equals(item)){
			return true;
		}
		else if(l.next==null){
			return false;
		}
		else{
			return contains(l.next,item);
		}
	}
	
	public static void main(String[] args){
		NCLinkedList<String> list=new NCLinkedList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		Node<String> l=list.head;
		if(contains(l,"c"))
		{
			System.out.println("Found");
		}else{
			System.out.println("Not Found");
		}
	}
}
