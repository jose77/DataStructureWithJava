package structures.app;

import structures.linear.List;

public class WordList {
	List<Word> wlst;
	public WordList(){
		wlst=new List<Word> ();
	}
	public void add(String word){
		Word newWord=new Word(word);
		wlst.add(newWord);
	}
	public boolean contains(String word){
		Word wrd=wlst.first();
		while(wrd!=null){
			if(wrd.equals(word)){
				return true;
			}
			wrd=wlst.next();
		}
		return false;
	}
	public Word first(){
		return wlst.first();
	}
	public Word next(){
		return wlst.next();
	}
}
