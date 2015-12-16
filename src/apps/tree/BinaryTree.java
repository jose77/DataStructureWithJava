package apps.tree;

public class BinaryTree<T> {
	protected T data;
	public BinaryTree<T> left;
	public BinaryTree<T> right;
	public BinaryTree<T> parent;
	//public BinaryTree<T> curr;//p9.6
	public BinaryTree(){
		data=null;
		left=null;
		right=null;
		parent=null;
	}
	public void makeRoot(T data){
		if(this.data!=null){
			throw new TreeViolationException();
		}
		this.data=data;
	}
	public T getData(){
		return this.data;
	}
	public void setData(T data){
		this.data=data;
	}
	//返回整棵树的根
	public BinaryTree<T> root(){
		if(parent==null){
			return this;
		}
		BinaryTree<T> nextParent=parent;
		while(nextParent.parent!=null){
			nextParent=nextParent.parent;
		}
		return nextParent;
		
	}
	public void attachLeft(BinaryTree<T> tree){
		if(left!=null){
			throw new TreeViolationException();
		}
		if(this!=null){
			tree.parent=this;
			left=tree;
		}
	}
	public void attachRight(BinaryTree<T> tree){
		if(right!=null){
			throw new TreeViolationException();
		}
		if(this!=null){
			tree.parent=this;
			right=tree;
		}
	}
	public BinaryTree<T> detachLeft(){
		BinaryTree<T> retLeft=left;
		left=null;
		return retLeft;
	}
	public BinaryTree<T> detachRight(){
		BinaryTree<T> retRight=right;
		right=null;
		return retRight;
	}
	public boolean isEmpty(){
		return data==null;
	}
	public void clear(){
		left=null;right=null;parent=null;data=null;
	}
	//p9.6
	/*public BinaryTree<T> firstInOrder(){
		if(isEmpty()){
			return null;
		}
		BinaryTree<T> ret=this;
		while(ret.left!=null){
			ret=ret.left;
		}
		curr=ret;
		return curr;
	}
	public BinaryTree<T> nextInOrder(){
		if(curr.right!=null){
			curr=curr.right.firstInOrder();
		}
		else{
			curr=curr.parent;
		}
	}*/
}
