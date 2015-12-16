package apps.tree;

public class Processor {
	int timeSlice;
	int clock;
	boolean busy;
	Process currProc;//正在执行或已经运行完毕但还没有移走的过程
	
	Processor(int timeSlice){
		this.timeSlice=timeSlice;
	}
	
	void startUp(Process currProc){
		this.currProc=currProc;
		clock=0;
		busy=true;
	}
	
	void stepTime(){
		if(!busy){
			return;
		}
		clock++;
		if(clock==timeSlice || clock==currProc.execTime){
			clock=0;
			busy=false;
		}
	}
	boolean isIdle(){
		return !busy;
	}
	Process getProcess() throws BusyInterruptionException{
		if(busy){
			throw new BusyInterruptionException();
		}
		Process ret=currProc;
		currProc=null;
		return ret;
	}
	int getClockTime(){
		return clock;
	}
	public String toString(){
		return currProc+"<"+clock+","+timeSlice+">";
	}
	
	
	
}
