package apps.tree;

public class DirNotFoundException extends RuntimeException {
	public DirNotFoundException(String s){
		System.out.println("The directory "+s+" does not exist.");
	}
}
