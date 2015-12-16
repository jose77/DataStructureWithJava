package apps.tree;

public class CountVisitor<T extends Comparable<T>> extends Visitor<T> {
	private int count;
	private T key;
	public CountVisitor(T key){
		count=0;
		this.key=key;
	}
	
	public void visit(BinaryTree<T> node){
		if(node.getData().compareTo(key)<0)
			count++;
	}
	
	public int getCount(){
		return count;
	}
	
}
