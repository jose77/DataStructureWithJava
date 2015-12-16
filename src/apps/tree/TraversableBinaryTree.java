//p9.11
package apps.tree;

import structures.linear.Queue;
import structures.linear.Stack;

class StackNode<T>{
	T data;
	int milestone;
	StackNode(T data){
		this.data=data;
		milestone=0;
	}
}

public class TraversableBinaryTree<T> extends BinaryTree<T> {
	//TraversableBinaryTree<T> curr;
	public TraversableBinaryTree(){
		super();
	}
	
	public void levelOrder(){
		//curr=this;
		Queue<BinaryTree<T>> queue=new Queue<BinaryTree<T>>();
		BinaryTree<T> temTree;
		queue.enqueue(this);
		while(!queue.isEmpty()){
			temTree=queue.dequeue();
			System.out.println(temTree.data);
			if(temTree.left!=null)
				queue.enqueue(temTree.left);
			if(temTree.right!=null)
				queue.enqueue(temTree.right);
		}
	}
	
	public void inOrder(){
		if(this==null||this.isEmpty()){
			return;
		}
		else{
			Stack<StackNode<BinaryTree<T>>> stack=new Stack<StackNode<BinaryTree<T>>>();
			stack.push(new StackNode<BinaryTree<T>>(this));
			while(!stack.isEmpty()){
				StackNode<BinaryTree<T>> sn=stack.pop();
				switch(sn.milestone){
				case 0:
					sn.milestone=1;
					stack.push(sn);
					if(sn.data.left!=null)
						stack.push(new StackNode<BinaryTree<T>>(sn.data.left));
					break;
				case 1:
					sn.milestone=2;
					System.out.println(sn.data.data);
					stack.push(sn);
					if(sn.data.right!=null)
						stack.push(new StackNode<BinaryTree<T>>(sn.data.right));
					break;
				case 2:
					break;
				default:
					break;
				}
			}
		}
	}
}
