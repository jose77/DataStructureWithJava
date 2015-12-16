package apps.tree;

public class Process implements Comparable<Process>{
	int pid;//process id
	int execTime;//剩余执行时间
	int arrivalTime;//项进入堆的时间
	int priority;
	
	Process(int pid,int execTime,int priority){
		this.pid=pid;
		this.execTime=execTime;
		this.arrivalTime=0;
		this.priority=priority;
	}
	
	public String toString(){
		return "("+pid+","+execTime+","+priority+","+arrivalTime+")";
	}
	public int compareTo(Process p){
		int c=priority-p.priority;
		if(c!=0){
			return c;
		}
		return arrivalTime-p.arrivalTime;
	}
}
