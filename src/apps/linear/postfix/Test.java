package apps.linear.postfix;

import java.util.StringTokenizer;

import structures.linear.Stack;

public class Test {
	static boolean parenMatch(String s){//p7.1
		Stack<Character> parenStack=new Stack<Character>(); 
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)=='('){
				parenStack.push(s.charAt(i));
			}
			if(s.charAt(i)==')'){
				if(parenStack.isEmpty()){
					return false;
				}
				else{
					parenStack.pop();
				}
			}
		}
		if(!parenStack.isEmpty()){
			return false;
		}
		return true;
	}
	
	/*static boolean match(String s){
		Stack<Character> matchStack=new Stack<Character>();
		Stack<Character> tempStack=new Stack<Character>();
		for(int i=0;i<s.length();i++){
			char op=s.charAt(i);
			switch(op){
			case '(':matchStack.push(op);break;
			case '{':matchStack.push(op);break;
			case '[':matchStack.push(op);break;
			case ')':
				
			}
		}
	}*/
	public static void main(String[] args){
		boolean t=parenMatch("1*(2+3)");
		if(t){
			System.out.print("True");
		}else{
			System.out.print("False");
		}
		//String expr=""
	}
}
