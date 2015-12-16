//p9.13
package apps.tree;

public class GeneralTree<T>  {
	public BinaryTree<T> biTree;
	public GeneralTree(){
		biTree=new BinaryTree<T>();
	}
	public GeneralTree(BinaryTree<T> biTree){
		this.biTree=biTree;
	}
	public void makeRoot(T data){
		biTree.makeRoot(data);
	}
	public void setData(T data){
		biTree.setData(data);
	}
	public T getData(){
		return biTree.getData();
	}
	public GeneralTree<T> root(){
		return new GeneralTree<T>(biTree.root());
	}
	public boolean isEmpty(){
		return biTree.isEmpty();
	}
	public void clear(){
		biTree.clear();
	}
	public int numKids(){
		int count=0;
		BinaryTree<T> tree=biTree.root();
		if(tree.left==null){
			return count;
		}else{
			count=1;
			tree=tree.left;
			while(tree.right!=null){
				count++;
				tree=tree.right;
			}
			return count;
		}
		
	}
	
	public GeneralTree<T> getChild(int i){
		if(i>numKids()){
			throw new TreeViolationException();
		}
		if(i==1){
			return new GeneralTree<T>(biTree.left);
		}
		BinaryTree<T> tree=biTree.left;
		for(int j=2;j<=i;j++){
			tree=tree.right;
		}
		return new GeneralTree<T>(tree);
	}
	
	public GeneralTree<T> getParent(){
		BinaryTree<T> tree=biTree;
		while(tree.parent!=null){
			if(tree.equals(tree.parent.left)){
				tree=tree.parent;
				break;
			}
			tree=tree.parent;
		}
		return new GeneralTree<T>(tree);
	}
	
	public void attachChild(GeneralTree<T> tree,int i){
		if(i==1){
			tree.biTree.right=biTree.left;
			biTree.left=tree.biTree;
		}else{
			BinaryTree<T> curr=biTree.left;
			for(int j=2;j<=i;j++){
				if(curr.right==null){
					break;
				}
				curr=curr.right;
			}
			tree.biTree.right=curr;
			curr.parent.right=tree.biTree;
		}
	}
	
	public GeneralTree<T> detachChild(int i){
		if(i>numKids()){
			throw new TreeViolationException();
		}
		BinaryTree<T> tree=biTree;
		if(i==1){
			BinaryTree<T> dChild=tree.left;
			tree.left=tree.left.right;
			return new GeneralTree<T>(dChild);
		}
		for(int j=2;j<=i;j++){
			tree=tree.right;
		}
		BinaryTree<T> dChild=tree;
		tree.parent.right=tree.right;
		return new GeneralTree<T>(dChild);
	}
	
	private BinaryTree<T> buildTree(T pre[],int i,T in[],int lo,int hi){
		if(pre.length!=in.length){
			throw new TreeViolationException();
		}
		if(i>=pre.length || lo>hi){
			return null;
		}
		BinaryTree<T> myTree=new BinaryTree<T>();
		myTree.makeRoot(pre[i]);
		
		int j;
		for(j=lo;j<=hi;j++){
			if(pre[i].equals(in[j]))
				break;
		}
		
		BinaryTree<T> leftSub=buildTree(pre,i+1,in,lo,j-1);
		BinaryTree<T> rightSub=buildTree(pre,i+j-lo+1,in,j+1,hi);
		
		myTree.attachLeft(leftSub);
		myTree.attachRight(rightSub);
		return myTree;
	}
	public void buildTree(T pre[],T post[]){
		biTree=buildTree(pre,0,post,0,post.length);
	}
}
