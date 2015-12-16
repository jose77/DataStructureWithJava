package apps.linear.postfix;

import java.util.NoSuchElementException;
import java.io.PrintWriter;
import structures.linear.Stack;
public class StackKeeper {
	static final char[] operators={'+','-','*','/'};
	Stack<Float> evalStack;
	StackKeeper(){
		evalStack=new Stack<Float>();
	}
	void init(){
		evalStack.clear();
	}
	int size(){
		return evalStack.size();
	}
	void update(String token){
		if(isOperator(token)){
			evaluate(token.charAt(0));
		}
		else{
			evalStack.push(Float.valueOf(token));
		}
	}
	float getTop(){
		Float top =evalStack.first();
		if(top==null){
			throw new NoSuchElementException();
		}
		return top;
	}
	
	boolean isOperator(String instr){
		if(instr.length()>1){
			return false;
		}
		char c=instr.charAt(0);
		for(int i=0;i<operators.length;i++){
			if(c==operators[i]){
				return true;
			}
		}
		return false;
	}
	
	void evaluate(char op){
		Float topval=evalStack.pop();//
		Float nextval=evalStack.pop();
		float tempval=0;
		switch(op){
		case '+':tempval=nextval+topval;break;
		case '-':tempval=nextval-topval;break;
		case '*':tempval=nextval*topval;break;
		case '/':tempval=nextval/topval;break;
		}
		evalStack.push(tempval);//
	}
	
	void printStack(PrintWriter pw){
		pw.println(" --------------->");
		pw.println(" stack :");
		Stack<Float> tempStack=new Stack<Float>();
		Float obj=evalStack.first();
		while(obj!=null){
			tempStack.push(obj);
			obj=evalStack.next();
		}
		obj=tempStack.first();
		while(obj!=null){
			pw.println(String.format(" | %.2f", obj));
			obj=tempStack.next();
		}
		pw.println();
		pw.println(" ---------------->");
	}
}
