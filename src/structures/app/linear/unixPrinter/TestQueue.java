package structures.app.linear.unixPrinter;

import java.io.File;
import java.util.NoSuchElementException;
import java.util.Scanner;

import structures.linear.Queue;

public class TestQueue {
	public void readAndEnqList(Scanner sc,Queue<String> q){//p6.1
		while(sc.hasNext()){
			q.enqueue(sc.next());
		}
	}
	
	public void removeLast(Queue<String> q,String str){//p6.2
		int pos=-1;
		String curr=q.first();
		Queue<String> temp=new Queue<String> ();
		for(int i=0;i<q.size();i++){
			if(curr.equals(str)){
				pos=i;
			}
			curr=q.next();
		}
		if(pos<0){
			throw new NoSuchElementException();
		}
		int p=0;
		while(!q.isEmpty()){
			
			String cast=q.dequeue();
			if(p!=pos){
				temp.enqueue(cast);
			}
			p++;
		}
		while(!temp.isEmpty()){
			q.enqueue(temp.dequeue());
		}
	}
	
	public <T> T peek(Queue<T> q){//p6.3
		Queue<T> temp=new Queue<T>();
		T item;
		item=q.dequeue();
		temp.enqueue(item);
		while(!q.isEmpty()){
			temp.enqueue(q.dequeue());
		}
		while(!temp.isEmpty()){
			q.enqueue(temp.dequeue());
		}
		return item;
	}
	
	public <T> void removeAllOccurencesOf(Queue<T> q,T item){//p6.4
		Queue<T> temp=new Queue<T>();
		while(!q.isEmpty()){
			T cust=q.dequeue();
			if(!cust.equals(item)){
				temp.enqueue(cust);
			}
		}
		while(!temp.isEmpty()){
			q.enqueue(temp.dequeue());
		}
	}
	
	public <T> Queue<T> splitQueue(Queue<T> q){//p6.6
		Queue<T> temp=new Queue<T>();
		Queue<T> result=new Queue<T>();
		int pos=0;
		while(!q.isEmpty()){
			if(pos%2==0){
				result.enqueue(q.dequeue());
			}
			else{
				temp.enqueue(q.dequeue());
			}
			pos++;
		}
		while(!temp.isEmpty()){
			q.enqueue(temp.dequeue());
		}
		return result;
	}

	public static void main(String[] args)throws Exception{
		TestQueue tq=new TestQueue();
		Scanner sc=new Scanner(new File("c:/name.txt"));
		Queue<String> q=new Queue<String>();
		tq.readAndEnqList(sc, q);
		tq.removeLast(q, "simon");
		String name=q.first();
		while(name!=null){
			System.out.println(name);
			name=q.next();
		}
		System.out.println("-----------------------");
		System.out.print(tq.peek(q));
		
	}
}
