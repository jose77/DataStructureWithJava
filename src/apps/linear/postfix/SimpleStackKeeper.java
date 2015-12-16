package apps.linear.postfix;//p7.6

import structures.linear.Stack;

public class SimpleStackKeeper extends StackKeeper{
	Operator opr;
	SimpleStackKeeper(){
		super();
	}
	boolean isOperator(String instr){
		return Operator.isOperator(instr);
	}
	void evaluate(char op){
		opr=new Operator(String.valueOf(op));
		Float topval=evalStack.pop();
		Float nextval=evalStack.pop();
		evalStack.push(opr.evaluate(topval, nextval));
	}
}
