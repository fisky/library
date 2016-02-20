import java.util.Comparator;
import java.util.PriorityQueue;
public class Point{
  public int x;
  public int y;
  public Point(int x, int y){
    this.x = x;
    this.y = y;
  }
  public Point(){}
}

public class kNearestPoint {
	public static int getDistance(Point p1, Point p2) {
		return (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y);
	}
	public static Point[] Solution(Point[] array, Point origin, int k) {
      if(array == null || array.length <= k) return array;
		Point[] result = new Point[k];
		PriorityQueue<Point> myPQ = new PriorityQueue<Point>(k, new Comparator<Point> () {
			@Override
			public int compare(Point p1, Point p2) {
				return getDistance(p2, origin) - getDistance(p1, origin);
			}
		});
		for(int i = 0; i < array.length; ++i){
			myPQ.offer(array[i]);
			if(i >= k)
				myPQ.poll();
		}
		int index = k;
		while(!myPQ.isEmpty())
			result[--index] = myPQ.poll();
		return result;
	}
}