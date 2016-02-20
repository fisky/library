/*
	LRU count miss
	time complexity: O(n); space complexity: O(size)
*/
import java.util.*;
public class Node{
	public int val;
	public Node pre;
	public Node next;
	public Node(int _val) {
		val = _val;
	}
}
public class CacheMiss {
	public static int Solution(int[] array, int size) {
		if(array.length == 0 || array == null) return 0;
		if(size == 0) return array.length;
		HashMap<Integer, Node> cache = new HashMap<Integer, Node>();
		int countMiss = 0;
		int len = array.length;
		Node fakeHead = new Node(-1);
		Node fakeTail = new Node(-1);
		fakeHead.next = fakeTail;
		fakeTail.pre = fakeHead;
		for(int i = 0; i < len; ++i) {
			if(cache.containsKey(array[i])){
				Node tmp = cache.get(array[i]);
				removeNode(tmp);    // remove node from original position
				addNode(tmp, fakeTail);   // push back to the end of list
			}
			else{
				if(cache.size() == size){
					Node tmp = fakeHead.next;
					removeNode(tmp);   // remove the head node
					cache.remove(tmp.val);
				}
				cache.put(array[i], new Node(array[i]));
				addNode(cache.get(array[i]), fakeTail);  // push back new Node to list
				++countMiss;
			}
		}
		return countMiss;
	}
    public static void addNode(Node n, Node fakeTail) {
      fakeTail.pre.next = n;
      n.pre = fakeTail.pre;
      fakeTail.pre = n;
      n.next = fakeTail;
    }
    public static void removeNode(Node n) {
        n.pre.next = n.next;
        n.next.pre = n.pre;
    }
}