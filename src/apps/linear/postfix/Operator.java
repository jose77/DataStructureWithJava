package apps.linear.postfix;//p7.5

public class Operator {
	static final char[] operators={'+','-','*','/'};
	char operator;
	Operator(String s){
		if(s.length()==1){
			for(char op:operators){
				if(s.charAt(0)==op){
					operator=s.charAt(0);
					break;
				}
				throw new NoSuchOperatorException();
			}
		}else{
			throw new NoSuchOperatorException();
		}
	}
	static final boolean isOperator(String s){
		if(s.length()==1){
			for(char op:operators){
				if(s.charAt(0)==op){
					return true;
				}
			}	
		}
		return false;
	}
	float evaluate(float p,float q){
		float r=0;
		switch(operator){
		case '+': r=q+p;break;
		case '-': r=q-p;break;
		case '*': r=q*p;break;
		case '/': r=q/p;break;
		}
		return r;
	}
}
