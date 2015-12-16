//p9.1
//空二叉树或只有一个节点的二叉树是同构的，或者两个二叉树具有同构的左子树和右子树
package apps.tree;

public class IsomorphicBinaryTree {
	public <T> boolean ismorphic(BinaryTree<T> tree1,BinaryTree<T> tree2){
		if(tree1.isEmpty() && tree2.isEmpty()){
			return true;
		}
		if(!tree1.isEmpty() && !tree2.isEmpty()){
			return ismorphic(tree1.left,tree2.left) && ismorphic(tree1.right,tree2.right);
		}
		return false;
		
	}
}
