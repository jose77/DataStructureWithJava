package structures.app;

public class Word {
	public String word;
	public int count;
	
	public Word(String word){
		this.word=word;
		count++;
	}
	public boolean equals(String w){
		if(w.equals(word)){
			count++;
			return true;
		}
		return false;
	}
	public String toString(){
		return word+"\t"+count;
	}

}
