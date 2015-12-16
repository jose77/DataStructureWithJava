//Huffman coding
package apps.tree;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import structures.linear.Queue;

public class Huffman {
	char[] symbols;//输入符号
	float[] probs;//输入概率
	ArrayList<BinaryTree<Float>> locations;//叶节点位置
	String[] codes;//编码
	
	Queue<BinaryTree<Float>> leaves;
	Queue<BinaryTree<Float>> trees;
	BinaryTree<Float> huffman;
	
	public Huffman(char[] symbols,float[] probs){
		this.symbols=symbols;
		this.probs=probs;
		locations=new ArrayList<BinaryTree<Float>>(symbols.length);
		
		if(symbols.length==0){
			huffman=null;
			return;
		}
		if(symbols.length==1){
			BinaryTree<Float> leaf=new BinaryTree<Float>();
			leaf.makeRoot(0f);
			locations.add(leaf);
			huffman=new BinaryTree<Float>();
			huffman.makeRoot(probs[0]);
			huffman.attachLeft(leaf);
			return;
		}
		
		leaves=new Queue<BinaryTree<Float>>();
		trees=new Queue<BinaryTree<Float>>();
		
		buildLeaves();//构建叶节点的队列
		
		//提取前两个节点
		BinaryTree<Float> first=leaves.dequeue();
		BinaryTree<Float> second=leaves.dequeue();
		
		//构建新树并将其将其加入到树队列
		buildTree(first,second);
		
		//构建其余部分
		buildAll();
		
		//构建最终的树
		huffman=trees.dequeue();
		
		//读取并存储代码
		processCodes();
		
	}
	public String decode(String code){
		StringBuffer decoded=new StringBuffer();
		int i=0;
		while(i<code.length()){
			BinaryTree<Float> node=huffman;
			while(node.left!=null && node.right!=null){
				if(code.charAt(i++)=='0'){
					node=node.left;
				}else{
					node=node.right;
				}
			}
			//reach a leaf
			float index=node.getData();
			decoded.append(symbols[(int)index]);
		}
		return decoded.toString();
	}
	public String getCode(char symbol){
		int i;
		for(i=symbols.length-1;i>=0;i--){
			if(symbol==symbols[i]){
				break;
			}
		}
		if(i<0){
			throw new NoSuchElementException();
		}
		return codes[i];
	}
	
	void buildLeaves(){
		for(int i=0;i<symbols.length;i++){
			BinaryTree<Float> leaf=new BinaryTree<Float>();
			leaf.makeRoot((float)i);
			locations.add(leaf);
			leaves.enqueue(leaf);
		}
	}
	void buildTree(BinaryTree<Float> first,BinaryTree<Float> second){
		float prob1=getProb(first);
		float prob2=getProb(second);
		BinaryTree<Float> both=new BinaryTree<Float>();
		both.makeRoot(prob1+prob2);
		both.attachLeft(first);
		both.attachRight(second);
		trees.enqueue(both);	
	}
	BinaryTree<Float> selectMin(){
		BinaryTree<Float> first=leaves.first();
		BinaryTree<Float> second=trees.first();
		if(getProb(first)<getProb(second)){
			leaves.dequeue();
			return first;
		}
		else{
			trees.dequeue();
			return second;
		}
	}
	float getProb(BinaryTree<Float> tree){
		if(tree.left==null && tree.right==null){
			float index=tree.getData();
			return probs[(int)index];
		}
		return tree.getData();
	}
	void buildAll(){
		while(!leaves.isEmpty()){
			BinaryTree<Float> first=selectMin();
			BinaryTree<Float> second =null;
			if(!leaves.isEmpty()){
				second=selectMin();
			}else{
				second=trees.dequeue();
			}
			buildTree(first,second);
		}
		//树队列中还有剩余
		while(trees.size()>1){
			BinaryTree<Float> first=trees.dequeue();
			BinaryTree<Float> second=trees.dequeue();
			buildTree(first,second);
		}
	}
	int treeHeight(BinaryTree<Float> tree){
		if(tree==null){
			return -1;
		}
		return Math.max(treeHeight(tree.left), treeHeight(tree.right))+1; 
	}
	void processCodes(){
		int height =treeHeight(huffman);
		char[] codeString=new char[height];
		codes=new String[symbols.length];
		for(int i=0;i<locations.size();i++){
			int index=height;
			BinaryTree<Float> node=locations.get(i);
			BinaryTree<Float> parent=node.parent;
			while(parent!=null){
				index--;
				if(node==parent.left){
					codeString[index]='0';
				}else{
					codeString[index]='1';
				}
				node=parent;
				parent=node.parent;
			}
			codes[i]=new String(codeString,index,height-index);
		}
		
	}
	
}
