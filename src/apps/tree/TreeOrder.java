package apps.tree;

import structures.linear.Stack;

public class TreeOrder {
	static void inorder(BinaryTree<String> tree,Visitor<String> visitor){//中序遍历
		class StackNode{
			BinaryTree<String> node;
			int milestone;
			StackNode(BinaryTree<String> node,int milestone){
				this.node=node;
				this.milestone=milestone;
			}
		}
		
		if(tree==null || tree.isEmpty()){
			return;
		}
		
		Stack<StackNode> s=new Stack<StackNode>();
		s.push(new StackNode(tree,0));
		while(!s.isEmpty()){
			StackNode sn=s.pop();
			switch(sn.milestone){
			case 0://born
				sn.milestone=1;
				s.push(sn);
				//visitor.visit(sn.node);//pre-order
				if(sn.node.left!=null){
					s.push(new StackNode(sn.node.left,0));
				}
				break;
			case 1://mid-age
				sn.milestone=2;
				s.push(sn);
				visitor.visit(sn.node);
				if(sn.node.right!=null){
					s.push(new StackNode(sn.node.right,0));
				}
				break;
			case 2://finish
				//visitor.visit(sn.node);//post-order
				break;
			default:
				break;
			}
		}
	}
	
	
	static void preorder(BinaryTree<String> tree,Visitor<String> visitor){//前序遍历
		class StackNode{
			BinaryTree<String> node;
			int milestone;
			StackNode(BinaryTree<String> node,int milestone){
				this.node=node;
				this.milestone=milestone;
			}
		}
		
		if(tree==null || tree.isEmpty()){
			return;
		}
		
		Stack<StackNode> s=new Stack<StackNode>();
		s.push(new StackNode(tree,0));
		while(!s.isEmpty()){
			StackNode sn=s.pop();
			switch(sn.milestone){
			case 0://born
				sn.milestone=1;
				s.push(sn);
				visitor.visit(sn.node);//pre-order
				if(sn.node.left!=null){
					s.push(new StackNode(sn.node.left,0));
				}
				break;
			case 1://mid-age
				sn.milestone=2;
				s.push(sn);
				//visitor.visit(sn.node);
				if(sn.node.right!=null){
					s.push(new StackNode(sn.node.right,0));
				}
				break;
			case 2://finish
				//visitor.visit(sn.node);//post-order
				break;
			default:
				break;
			}
		}
	}
}
