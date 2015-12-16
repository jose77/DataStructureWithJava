//p8.8 odd number only
package apps.recurse;

public class RecursivePrinter {
	static void printX(int N,int n){
		for(int i=0;i<N;i++){
			if((i==N/2-n/2) || (i==N/2+n/2)){
				System.out.print("x");
			}else{
				System.out.print(" ");
			}
		}
		System.out.println();
		if(n==1 || n==0){
			return;
		}
		printX(N,n-2);
		for(int i=0;i<N;i++){
			if((i==N/2-n/2) || (i==N/2+n/2)){
				System.out.print("x");
			}else{
				System.out.print(" ");
			}
		}
		System.out.println();
	}
	
	public static void main(String[] args){
		printX(7,7);
	}
}
