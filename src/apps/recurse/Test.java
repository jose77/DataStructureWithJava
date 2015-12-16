package apps.recurse;

public class Test {
	static void hanoi(int n,char src, char interm,char dest){//ººÅµËşÎÊÌâ
		if(n==1){
			System.out.println("move a disk from "+src+" to "+dest);
		}else{
			hanoi(n-1,src,dest,interm);
			System.out.println("move a disk from "+src+" to "+dest);
			hanoi(n-1,interm,src,dest);
		}
	}
	public static void main(String[] args){
		hanoi(64,'A','B','C');
	}
}
