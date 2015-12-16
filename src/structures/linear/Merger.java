package structures.linear;

public class Merger {
	private Merger(){}
	private static <T extends Comparable<T>> void append(OrderedList<T> LOut,OrderedList<T> LIn,int pos){
		while(pos<LIn.size()){
			LOut.add(LIn.get(pos++));
		}
	}
	public static <T extends Comparable<T>> OrderedList<T> union(OrderedList<T> first,OrderedList<T> second){
		if(first.isEmpty()){
			OrderedList<T> result =new OrderedList<T> (second.size());
			append(result,second,0);
			return result;
		}
		if(second.isEmpty()){
			OrderedList<T> result =new OrderedList<T>(first.size());
			append(result,first,0);
			return result;
		}
		int size1=first.size();
		int size2=second.size();
		OrderedList<T> result=new OrderedList<T> ();
		int firstFinger=0;int secondFinger=0;
		while(firstFinger<size1 && secondFinger<size2){
			T firstItem=first.get(firstFinger);
			T secondItem=second.get(secondFinger);
			int c=firstItem.compareTo(secondItem);
			if(c==0){
				result.add(firstItem);
				firstFinger++;
				secondFinger++;
			}
			else if(c<0){
				result.add(firstItem);
				firstFinger++;
			}
			else{
				result.add(secondItem);
				secondFinger++;
			}
		}
		if(firstFinger<first.size()){
			append(result,first,firstFinger);
		}
		if(secondFinger<second.size()){
			append(result,second,secondFinger);
		}
		return result;
		
	}
}
