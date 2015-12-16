//p9.14
//Unix File System
package apps.tree;


public class FileTree extends GeneralTree<String>{
	private GeneralTree<String> currTree;
	public FileTree(){
		super();
		currTree=this.root();
	}
	public FileTree(String[] pre,String[] post){
		this.buildTree(pre, post);
		currTree=this.root();
	}
	public void mkdir(String dir){
		String[] dirArray=dir.split("/");
		GeneralTree<String> pTree=currTree;
		GeneralTree<String> cTree;
		for(int i=0;i<dirArray.length;i++){
			cTree=new GeneralTree<String>();
			cTree.makeRoot(dirArray[i]);
			pTree.attachChild(cTree, 0);
			pTree=cTree;
		}
	}
	
	private void rmR(GeneralTree<String> fTree,String[] dir,int i){
		if(i>=dir.length-1){
			return;
		}
		int j;
		for(j=1;;j++){//子节点从1开始编号
			if(j>fTree.numKids())
				throw new DirNotFoundException(dir[i]);
			if(fTree.getChild(j).getData().equals(dir[i])){
				break;
			}
		}
		rmR(fTree.getChild(j),dir,i++);
		fTree.detachChild(j);
		
		
	}
	public void rmR(String dir){
		String[] s=dir.split("/");
		rmR(currTree,s,0);
	}
	
	public static String baseName(String file){
		String[] s=file.split(".");
		return s[0];
	}
	
	public void ls(String dir){
		GeneralTree<String> fTree=currTree;
		String[] s=dir.split("/");
		for(String sd:s){
			for(int j=1;;j++){
				if(j>fTree.numKids())
					throw new DirNotFoundException(dir);
				if(fTree.getChild(j).getData().equals(sd)){
					fTree=fTree.getChild(j);
					break;
				}
			}
		}
		for(int i=0;i<fTree.numKids();i++){
			System.out.println(baseName(fTree.getData()));
		}
	}
	
	public void mv(String fromDir,String toDir){
		GeneralTree<String> fromTree=currTree;
		GeneralTree<String> toTree=currTree;
		for(String s:fromDir.split("/")){
			for(int i=1;;i++){
				if(i>fromTree.numKids())
					throw new DirNotFoundException(fromDir);
				if(fromTree.getChild(i).getData().equals(s)){
					fromTree=fromTree.getChild(i);
					break;
				}
			}
		}
		for(String s:toDir.split("/")){
			for(int i=1;;i++){
				if(i>toTree.numKids())
					throw new DirNotFoundException(toDir);
				if(toTree.getChild(i).getData().equals(s)){
					toTree=toTree.getChild(i);
					break;
				}
			}
		}
		for(int i=1;i<=fromTree.getParent().numKids();i++){
			if(fromTree.getParent().getChild(i).equals(fromTree)){
				fromTree.getParent().detachChild(i);
			}
		}
		toTree.attachChild(fromTree, toTree.numKids()+1);
		
	}
	
	public void cd(String toDir){
		for(String s:toDir.split("/")){
			for(int i=0;;i++){
				if(i>currTree.numKids()){
					currTree=this.root();//roll back
					throw new DirNotFoundException(toDir);
				}
				if(currTree.getChild(i).getData().equals(s)){
					currTree=currTree.getChild(i);
					break;
				}
			}
		}
	}
}
