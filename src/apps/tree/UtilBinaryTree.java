package apps.tree;

import structures.linear.Queue;

public class UtilBinaryTree {
	//p9.1
	//�ն�������ֻ��һ���ڵ�Ķ�������ͬ���ģ�������������������ͬ������������������
	public <T> boolean ismorphic(BinaryTree<T> tree1,BinaryTree<T> tree2){
		if(tree1.isEmpty() && tree2.isEmpty()){
			return true;
		}
		if(!tree1.isEmpty() && !tree2.isEmpty()){
			return ismorphic(tree1.left,tree2.left) && ismorphic(tree1.right,tree2.right);
		}
		return false;
		
	}
	//p9.2
	public <T> void mirror(BinaryTree<T> tree){
		if(tree==null){
			return;
		}
		if(tree.left==null && tree.right==null){
			return;
		}
		BinaryTree<T> temp;
		temp=tree.left;
		tree.left=tree.right;
		tree.right=temp;
		if(tree.left!=null){
			mirror(tree.left);
		}
		if(tree.right!=null){
			mirror(tree.right);
		}
	}
	//p9.3
	//�ն������ĸ߶�Ϊ-1����һ�ڵ�������ĸ߶�Ϊ1������������ĸ߶ȵ������������߶Ⱥ��������߶ȵ����ֵ +1
	public <T> int height(BinaryTree<T> tree){
		if(tree==null){
			return -1;
		}
		if(tree.left==null && tree.right==null){
			return 1;
		}
		return Math.max(height(tree.left), height(tree.right))+1;
	}
	
	//p9.4
	//�߶�ƽ���������������ֻ��һ���ڵ�Ķ������Ǹ߶�ƽ������������������������������߶����С�ڵ���1
	public <T> boolean heightBalance(BinaryTree<T> tree){
		if(tree==null){
			return true;
		}
		if(tree.left==null && tree.right==null){
			return true;
		}
		return Math.abs(height(tree.left)-height(tree.right))<2;
	}
	
	//p9.5 
	public <T> void levelOrder(BinaryTree<T> tree){
		Queue<BinaryTree<T>> queue=new Queue<BinaryTree<T>>();
		queue.enqueue(tree);
		while(!queue.isEmpty()){
			BinaryTree<T> temTree=queue.dequeue();
			System.out.println(temTree.data);
			if(temTree.left!=null)
				queue.enqueue(temTree.left);
			if(temTree.right!=null)
				queue.enqueue(temTree.right);
		}
	}
	
	
	
	
	//**********************************************************************
	//test
	public static void main(String[] args){
		UtilBinaryTree ubt=new UtilBinaryTree();
		BinaryTree<String> t1=new BinaryTree<String> ();
		BinaryTree<String> t2=new BinaryTree<String> ();
		BinaryTree<String> t3=new BinaryTree<String> ();
		BinaryTree<String> t4=new BinaryTree<String> ();
		BinaryTree<String> t5=new BinaryTree<String> ();
		t1.makeRoot("a");
		t2.makeRoot("b");
		t3.makeRoot("c");
		t4.makeRoot("d");
		t5.makeRoot("e");
		t1.attachLeft(t2);
		t1.attachRight(t3);
		t2.attachLeft(t4);
		t2.attachRight(t5);
		new UtilBinaryTree().mirror(t1);
		int h=new UtilBinaryTree().height(t1);
		TreeOrder.inorder(t1, new Visitor<String>());
		System.out.println(h);
		if(ubt.heightBalance(t1)){
			System.out.println("Height Balance");
		}else{
			System.out.println("Not Height Balance");
		}
		System.out.println("*****************result of p9.5*********************");
		ubt.levelOrder(t1);
	}
}
