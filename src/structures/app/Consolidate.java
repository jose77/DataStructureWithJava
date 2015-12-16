package structures.app;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import structures.linear.Merger;
import structures.linear.OrderedList;


public class Consolidate {
	static <T extends Comparable<T>> void printList(OrderedList<T> ol){
		T item =ol.first();
		if(item==null){return;}
		System.out.print(item);
		while((item=ol.next())!=null){
			System.out.print("-"+item);
		}
		System.out.println();
	}
	
	public static void main(String[] args)throws IOException{
		Scanner sc=new Scanner(new File(args[0]));
		OrderedList<String> YInsList=new OrderedList<String>();
		while(sc.hasNext()){
			YInsList.add(sc.next());
		}
	    sc=new Scanner(new File(args[1]));
		OrderedList<String> RmInsList=new OrderedList<String>();
		while(sc.hasNext()){
			RmInsList.add(sc.next());
		}
		sc=new Scanner(new File(args[2]));
		OrderedList<String> YDelList=new OrderedList<String> ();
		while(sc.hasNext()){
			YDelList.add(sc.next());
		}
		sc=new Scanner(new File(args[3]));
		OrderedList<String> RmDelList=new OrderedList<String>();
		while(sc.hasNext()){
			RmDelList.add(sc.next());
		}
		OrderedList<String> MergedInsList=Merger.union(YInsList, RmInsList);
		OrderedList<String> MergedDelList=Merger.union(YDelList, RmDelList);
		OrderedList<String> FinalList=Merger.difference(MergedInsList,MergedDelList);
		printList(FinalList);
	}
}
