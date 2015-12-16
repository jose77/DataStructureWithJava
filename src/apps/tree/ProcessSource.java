package apps.tree;

import java.util.Random;

public class ProcessSource {
	float probOfArrival;//��������һ��ʱ�����䵽��ĸ���
	int maxExecTime;//���̵����ִ��ʱ��
	int maxPriority;
	Random randomizer;
	int pid;
	
	ProcessSource(float arrivalProb,int maxExecTime,int maxPriority){
		if(arrivalProb<=0 || arrivalProb>1){
			throw new IllegalArgumentException(arrivalProb+"<=0 or >1");
		}
		probOfArrival=arrivalProb;
		this.maxExecTime=maxExecTime;
		this.maxPriority=maxPriority;
		randomizer=new Random();
		pid=0;
		
	}
	
	Process getProcess(){
		if(randomizer.nextFloat()>probOfArrival){
			return null;
		}
		pid++;
		int ptime=(int)(Math.random()*maxExecTime);
		if(ptime==0)
			ptime++;
		int priority=(int)(Math.random()*maxPriority);
		if(priority==0)
			priority++;
		return new Process(pid,ptime,priority);
	}
}
