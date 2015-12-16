//p9.1
//�ն�������ֻ��һ���ڵ�Ķ�������ͬ���ģ�������������������ͬ������������������
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
