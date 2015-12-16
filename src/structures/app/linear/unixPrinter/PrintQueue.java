package structures.app.linear.unixPrinter;

import java.io.PrintWriter;
import java.util.NoSuchElementException;

import structures.linear.Queue;



public class PrintQueue {
	Queue<Job> printQ;
	public PrintQueue(){
		printQ=new Queue<Job>();
	}
	
	public void lpr(String owner,int jobId,String file){
		printQ.enqueue(new Job(owner,jobId,file));
	}
	
	public void lpq(PrintWriter pw){
		Job job=printQ.first();
		while(job!=null){
			pw.println(job);
			job=printQ.next();
		}
	}
	
	public void lprm(String owner,int jobId){
		if(printQ.isEmpty()){
			throw new NoSuchElementException();
		}
		printQ.remove(new IdOwnerJob(owner,jobId,null));
	}
	
	public void lprm(String owner){
		if(printQ.isEmpty()){
			throw new NoSuchElementException();
		}
		Job front=printQ.first();
		if(owner.equals(front.owner)){
			printQ.dequeue();
		}
		else{
			throw new NoSuchElementException();
		}
	}
	
	public void lprmId(int jobId){//p6.5 
		Job job=new Job(null,jobId,null);
		printQ.removeAll(job);
	}
	
	public void lprmAll(String owner){
		if(printQ.isEmpty()){
			throw new NoSuchElementException();
		}
		printQ.removeAll(new OwnerJob(owner,0,null));
	}
}
