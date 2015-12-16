package apps.tree;

import structures.linear.Stack;

public class UtilStack {
	public int fact(int n){
		class StackNode{
			int data;
			int milestone;
			StackNode(int data){
				this.data=data;
				milestone=0;
			}
		}
		
		Stack<StackNode> stack=new Stack<StackNode>();
		stack.push(new StackNode(n));
		int sum=1;
		while(!stack.isEmpty()){
			StackNode sn=stack.pop();
			if(sn.milestone==0){
				sum*=sn.data;
				sn.milestone=1;
				stack.push(sn);
				stack.push(new StackNode(sn.data-1));
			}else{
				break;
			}
		}
	}
}
