package apps.linear.postfix;

public class IllegalExpressionException extends Exception {
	public IllegalExpressionException(){
		super();
	}
	public IllegalExpressionException(String s){
		super(s);
	}
}
