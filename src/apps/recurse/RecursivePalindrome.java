//p8.90
package apps.recurse;

import java.util.ArrayList;

public class RecursivePalindrome {
	static boolean isPalindrome(char[] arr,int s,int n){
		if(n-s==0 || n-s==1){
			return true;
		}
		if(arr[s]==arr[n-1]){
			return isPalindrome(arr,s+1,n-1);
		}
		else{
			return false;
		}
	}
	
	public static void main(String[] args){
		String str="assa";
		char[] arr=new char[str.length()];
		for(int i=0;i<str.length();i++){
			arr[i]=str.charAt(i);
		}
		if(isPalindrome(arr,0,arr.length)){
			System.out.print("Is Palindrome");
		}else{
			System.out.print("Not Palindrome");
		}
	}
}
