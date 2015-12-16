package structures.linear;

public class TailTraverse {
	static <T> void traverse(Node<T> first){
		if(first==null){
			return;
		}
		System.out.println(first.data);
		traverse(first.next);
	}
	static <T> void printBackwards(Node<T> first){
		if(first.next==null){
			return;
		}
		printBackwards(first.next);
		System.out.println(first.data);
	}
	public static void main(String[] args){
		NCLinkedList<String> list=new NCLinkedList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		Node<String> first=list.head;
		traverse(first);
		System.out.println("-------------------------");
		printBackwards(first);
	}
}
