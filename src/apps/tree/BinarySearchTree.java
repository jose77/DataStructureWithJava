package apps.tree;

import java.util.NoSuchElementException;

import structures.linear.LinkedList;
import structures.linear.OrderViolationException;

public class BinarySearchTree <T extends Comparable<T>>{
	BinaryTree<T> tree;
	int size;
	
	public BinarySearchTree(){
		tree=new BinaryTree<T>();
		size=0;
	}
	public boolean isEmpty(){
		return tree.isEmpty();
	}
	public int size(){
		return size;
	}
	public T search(T key){
		if(tree.isEmpty()){
			return null;
		}
		return recursiveSearch(tree,key).data;
	}
	
	public BinaryTree<T> recursiveSearch(BinaryTree<T> root,T key){
		if(root.isEmpty()){
			return null;
		}
		int c=key.compareTo(root.data);
		if(c==0){
			return root;
		}
		if(c<0){
			return recursiveSearch(root.left,key);
		}else{
			return recursiveSearch(root.right,key);
		}
	}
	
	public BinaryTree<T> nonRecursiveSearch(BinaryTree<T> root,T key){//p10.1
		
		while(root!=null){
			int c=key.compareTo(root.data);
			if(c==0)
				return root;
			if(c<0)
				root=root.left;
			else
				root=root.right;
		}
		return null;
		
	}
	public void insert(T item){
		if(tree.isEmpty()){
			tree.makeRoot(item);
			size=1;
			return;
		}
		BinaryTree<T> root=tree;
		boolean done=false;
		BinaryTree<T> newNode=null;
		while(!done){
			int c=item.compareTo(root.data);
			if(c==0){
				throw new OrderViolationException();
			}
			if(c<0){
				if(root.left==null){
					newNode=new BinaryTree<T>();
					root.attachLeft(newNode);
					done=true;
				}else{
					root=root.left;
				}
			}else{
				if(root.right==null){
					newNode=new BinaryTree<T>();
					root.attachRight(newNode);
					done=true;
				}else{
					root=root.right;
				}
			}
		}
		newNode.data=item;
		size++;
	}
	
	public void recursiveInsert(BinaryTree<T> root,T item){
		if(root.isEmpty()){
			root.makeRoot(item);
			size=1;
			return;
		}
		int c=item.compareTo(root.data);
		BinaryTree<T> newNode=null;
		if(c==0){
			throw new OrderViolationException();
		}
		if(c<0){
			if(root.left==null){
				newNode=new BinaryTree<T>();
				root.attachLeft(newNode);
				newNode.data=item;
				size++;
				return;
			}
			recursiveInsert(root.left,item);
		}else{
			if(root.right==null){
				newNode=new BinaryTree<T>();
				root.attachRight(newNode);
				newNode.data=item;
				size++;
				return;
			}
			recursiveInsert(root.right,item);
		}
		
	}
	
	BinaryTree<T> findPredecessor(BinaryTree<T> node){ //寻找前趋
		if(node.left==null){
			return null;
		}
		BinaryTree<T> pred=node.left;
		while(pred.right!=null){
			pred=pred.right;
		}
		return pred;
	}
	
	void deleteHere(BinaryTree<T> deleteNode,BinaryTree<T> attach){//删除有一棵子树的节点
		BinaryTree<T> parent=deleteNode.parent;
		deleteNode.clear();
		if(parent==null){
			return;
		}
		if(deleteNode==parent.left){
			parent.detachLeft();
			parent.attachLeft(attach);
		}else{
			parent.detachRight();
			parent.attachRight(attach);
		}
	}
	
	public T delete(T key){
		if(tree.isEmpty()){
			throw new NoSuchElementException();
		}
		BinaryTree<T> deleteNode=recursiveSearch(tree,key);
		if(deleteNode==null){
			throw new NoSuchElementException();
		}
		BinaryTree<T> hold;
		//有两棵子树
		if(deleteNode.left!=null && deleteNode.right!=null){
			hold=findPredecessor(deleteNode);
			deleteNode.data=hold.data;
			deleteNode=hold;//落到情况a或情况b
		}
		if(deleteNode.left==null && deleteNode.right==null){
			deleteHere(deleteNode,null);
			size--;
			return deleteNode.data;
		}
		if(deleteNode.right!=null){
			hold=deleteNode.right;
			deleteNode.right=null;
		}else{
			hold=deleteNode.left;
			deleteNode.left=null;
		}
		deleteHere(deleteNode,hold);
		if(tree==deleteNode){//删除根
			tree=hold;
		}
		size--;
		return deleteNode.data;

		
	}
	
	public T minKey(){
		if(tree.data==null){
			throw new NoSuchElementException();
		}
		BinaryTree<T> root=tree;
		T min=root.data;
		while(root.left!=null){
			//min=root.data;
			root=root.left;
			min=root.data;
		}
		return min;
	}
	
	public T maxKey(){
		if(tree.data==null){
			throw new NoSuchElementException();
		}
		BinaryTree<T> root=tree;
		T max=root.data;
		while(root.right!=null){
			root=root.right;
			max=root.data;
		}
		return max;
	}
	
	void recursivePreOrder(BinaryTree<T> tree,Visitor<T> visitor){
		if(tree.left==null && tree.right==null){
			return;
		}
		visitor.visit(tree);
		recursivePreOrder(tree.left,visitor);
		recursivePreOrder(tree.right,visitor);
	}
	
	public void preOrder(Visitor<T> visitor){
		recursivePreOrder(tree,visitor);
	}
	
	void recursiveInOrder(BinaryTree<T> tree,Visitor<T> visitor){
		if(tree.left==null && tree.right==null){
			return;
		}
		recursiveInOrder(tree.left,visitor);
		visitor.visit(tree);
		recursiveInOrder(tree.right,visitor);
	}
	public void inOrder(Visitor<T> visitor){
		recursiveInOrder(tree,visitor);
	}
	
	void recursiveSort(BinaryTree<T> root,LinkedList<T> list){
		if(root==null){
			return;
		}
		recursiveSort(root.left,list);
		list.add(root.data);
		recursiveSort(root.right,list);
	}
	public LinkedList<T> sort(){//p10.4
		LinkedList<T> list=new LinkedList<T>();
		recursiveSort(tree,list);
		return list;
	}
	
	public int countLess(T key){//p10.5 O(logn)
		LinkedList<T> list=sort();
		//二分查找
		int min=0;
		int max=list.size()-1;
		int mid=0;
		while(min<=max){
			mid=(min+max)/2;
			if(key.equals(list.getAt(mid)))
				break;
			if(key.compareTo(list.getAt(mid))>0){
				min=mid+1;
			}else{
				max=mid-1;
			}
		}
		return mid;
	}
}
