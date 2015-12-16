package apps.tree;

import java.io.PrintWriter;

public class Scheduler {
	ProcessSource source;//创建进程
	Processor cpu;
	Heap<Process> procHeap;//进程的优先队列
	int thruPut,intervalThruPut;//进程产量
	int numProcs,intervalNumProcs;//到达进程数
	int clock,intervalClock;
	
	public Scheduler(){
		procHeap=new Heap<Process>();
	}
	public void init(float probOfArrival,int maxExecTime,int maxPriority,int timeSlice){
		source=new ProcessSource(probOfArrival,maxExecTime,maxPriority);
		cpu=new Processor(timeSlice);
		procHeap.clear();
		clock=0;
		numProcs=0;
		thruPut=0;
	}
	
	public void printStatus(PrintWriter pw){
		pw.println("Interval Cumulative:");
		pw.println("Process Arrived "+intervalNumProcs+" "+numProcs);
		pw.println("Throughput "+intervalThruPut+" "+thruPut);
		pw.flush();
	}
}
