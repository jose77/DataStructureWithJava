package apps.linear.postfix;

import java.io.PrintWriter;

public class StatusKeeper {
	StringBuffer status;
	public StatusKeeper(){
		status=new StringBuffer();
	}
	void init(){
		status.setLength(0);
	}
	void update(String token){
		status.append(token+" ");
	}
	String getStatus(){
		return status.toString();
	}
	void printStatus(PrintWriter pw){
		pw.println(" Processed: "+status);
	}
}
