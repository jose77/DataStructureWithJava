//P5.1 
package structures.app;

import structures.linear.OrderedList;

public class Point implements Comparable<Point> {
	double x,y;
	public Point(){
		x=0;y=0;
	}
	public Point(double x,double y){
		this.x=x;this.y=y;
	}
	public double getDistance(){
		return Math.sqrt(x*x+y*y);
	}
	public int compareTo(Point p){
		double c=this.getDistance()-p.getDistance();
		if(c<0){
			return -1;
		}
		if(c==0){
			return 0;
		}
		return 1;
	}
	public String toString(){
		return "("+x+","+y+")";
	}
	public static void main(String[] args){// used for test only
		OrderedList<Point> points=new OrderedList<Point>();
		points.insert(new Point(2,3));
		points.insert(new Point(1,2));
		points.insert(new Point(4,9));
		for(int i=0;i<points.size();i++){
			System.out.print(points.get(i).toString()+" ");
		}
	}
}
