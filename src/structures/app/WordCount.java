package structures.app;

import java.io.*;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.FileNotFoundException;

public class WordCount {
	
	public static void main(String[] args) throws FileNotFoundException,IOException{
		WordList words=new WordList();
		try{
			FileReader fr=new FileReader("c:/word.txt");
			BufferedReader br=new BufferedReader(fr);
			String line;
			while((line=br.readLine())!=null){
				StringTokenizer st=new StringTokenizer(line);
				while(st.hasMoreTokens()){
					String s=st.nextToken();
					if(!(words.contains(s))){
						words.add(s);
					}
				}
			}
			br.close();
		}catch(Exception e){
			System.out.print(e.toString());
		}
		Word word=words.first();
		while(word!=null){
			System.out.println(word.toString());
			word=words.next();
		}
	}
}
