import java.util.*
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}
//********************************************************************
// my version
//********************************************************************
public class Subtree {
	public static boolean isSubTree(TreeNode T1, TreeNode T2) {
		if (T2 == null)	return true;
		if (T1 == null)	return false;
      	if(T1.val == T2.val)
          if(matchTree(T1, T2) return true;
        return (isSubTree(T1.left, T2) || isSubTree(T1.right, T2));
	}
	public static boolean matchTree(TreeNode T1, TreeNode T2) {
		if (T1 == null && T2 == null)	return true;
		if (T1 == null || T2 == null)	return false;
		if (T1.val != T2.val)	return false;
		return (matchTree(T1.left, T2.left) && matchTree(T1.right, T2.right));
	}
}
//*********************************************************************
//参考
//*********************************************************************
public class Subtree2 {
	public boolean isSubTree(TreeNode T1, TreeNode T2) {
		if (T2 == null)	return true;
		if (T1 == null)	return false;
		return (isSameTree(T1,T2) || isSubTree(T1.left, T2) || isSubTree(T1.right, T2));
	}
	public boolean isSameTree(TreeNode T1, TreeNode T2) {
		if (T1 == null && T2 == null)	return true;
		if (T1 == null || T2 == null)	return false;
		if (T1.val != T2.val)	return false;
		return (isSameTree(T1.left, T2.left) && isSameTree(T1.right, T2.right));
	}
}