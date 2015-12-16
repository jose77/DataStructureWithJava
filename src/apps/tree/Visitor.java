package apps.tree;

public class Visitor<T> {
	public void visit(BinaryTree<T> tree){
		System.out.println(tree.getData());
	}
}
