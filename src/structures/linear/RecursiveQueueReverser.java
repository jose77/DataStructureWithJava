//p8.7
package structures.linear;

public class RecursiveQueueReverser {
	static <T> void reverse(Queue<T> queue){
		T item;
		if(queue.isEmpty()){
			return;
		}
		item=queue.dequeue();
		reverse(queue);
		queue.enqueue(item);
		
	}
	public static void main(String[] args){
		Queue<String> queue=new Queue<String>();
		queue.enqueue("a");
		queue.enqueue("b");
		queue.enqueue("c");
		reverse(queue);
		System.out.println(queue.first());
		String s;
		while((s=queue.next())!=null){
			System.out.println(s);
		}
	}
}
