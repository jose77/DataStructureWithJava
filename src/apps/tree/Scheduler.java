package apps.tree;

import java.io.PrintWriter;

public class Scheduler {
	ProcessSource source;//��������
	Processor cpu;
	Heap<Process> procHeap;//���̵����ȶ���
	int thruPut,intervalThruPut;//���̲���
	int numProcs,intervalNumProcs;//���������
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
