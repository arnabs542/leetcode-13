
import java.util.HashMap;
import java.util.Map.Entry;

public class MaxPointOfLine {
	
	 public	static class Point {
	 		
		     public int x;
		     public int y;
		     Point() { x = 0; y = 0; }
		     Point(int a, int b) { x = a; y = b; }
		}
	 
	 public static int maxPoints(Point[] points) {
		
		 if(points.length==0 || points.length==1 || points.length == 2)
		 {
			 return points.length;
		 }
		 
		 
		 int max = 2;
		 
		 HashMap<Integer,Integer> xequalMap = new HashMap<Integer,Integer>();
		 HashMap<Integer,Integer> yequalMap = new HashMap<Integer,Integer>();
		 HashMap<String,Integer> otherMap = new HashMap<String,Integer>();
		 
		 for(int i = 0;i<points.length;i++)
		 {
			// 相同点需要注意
			 int identity = 0;
			 
			 int localMax = 0;
			 for(int j=i+1;j<points.length;j++)
			 {
				 
				 
				 int dx = points[j].x -points[i].x;
				 int dy = points[j].y -points[i].y;
				 if(dx == 0 && dy ==0)
				 {
					 identity = identity+1;
					 					 
					 
				 }else  if(dx == 0)
				 {
					 int key = points[j].x;
					 if(xequalMap.containsKey(key))
					 {
						int number = xequalMap.get(key);
						xequalMap.put(key, number+1);
					 }else{
						xequalMap.put(key, 2);
					 }
				 }else if ( dy == 0)
				 {
					 int key = points[j].y;
					 if(yequalMap.containsKey(key))
					 {
						int number = yequalMap.get(key);
						yequalMap.put(key, number+1);
					 }else{
						yequalMap.put(key, 2);
					 }
					 
				 }else{
					 
					 int gcd = gcd(dx,dy);
					 
					 int xdiv = dx/gcd;
					 int ydiv = dy/gcd;
					 
					 String key = String.valueOf(xdiv)+String.valueOf(ydiv);
					 
					 if(otherMap.containsKey(key))
					 {
						 int number = otherMap.get(key);
						 otherMap.put(key, number+1);
					 }else{
						 otherMap.put(key, 2);
					 }
					 
					 					 
				 }
				 
			 }
			 
			 
			 
			 for(Entry<Integer, Integer> item: xequalMap.entrySet())
			 {
				 int value = item.getValue();
				 localMax=localMax > value ? localMax:value;
			 }
			 
			 xequalMap.clear();
			 for(Entry<Integer, Integer> item: yequalMap.entrySet())
			 {
				 int value = item.getValue();
				 localMax = localMax > value ? localMax:value;
			 }
			 
			 yequalMap.clear();
			 
			 for(Entry<String, Integer> item: otherMap.entrySet())
			 {
				 int value = item.getValue();
				 localMax = localMax > value ? localMax:value;
			 }
			 if(localMax==0)
			 {
				 localMax = identity+1;
			 }else{
				 localMax = localMax + identity;
			 }
		 
			 otherMap.clear();
			 
			 max = max>localMax?max:localMax;
			 
		 }
		 
		 return max;
	 
	 }
	 
	 
	 public static int gcd(int a, int b)
	 {
	   while(a!=0 && b!=0) // until either one of them is 0
	   {
	      int c = b;
	      b = a%b;
	      a = c;
	   }
	   return a+b; // either one is 0, so return the non-zero value
	 }

	 
	 public static void main(String[] args)
	 {
		 //Point[] points = new Point[]{new Point(0,0),new Point(-1,-1),new Point(2,2),new Point(3,3)};
		 
//		 Point[] points = new Point[]{new Point(0,0),new Point(-1,-1),new Point(0,0)};
		 
//		 Point[] points = new Point[]{new Point(2,3),new Point(3,3),new Point(5,3)};	 
		 
		 Point[] points = new Point[]{new Point(1,1),new Point(1,1),new Point(1,1)};
		 System.out.println(maxPoints(points));
	 }

}
