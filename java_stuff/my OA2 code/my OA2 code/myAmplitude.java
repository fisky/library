/*
	Amplitude of Binary Tree; TIme complexity: O(n); Space complexity: O(height of tree)
*/
public class TreeAmplitude {
	public int Solution(TreeNode root) {
		if (root == null)	return 0;
		return helper(root, root.val, root.val);
	}
	private int helper(TreeNode root, int min, int max) {
		if (root == null)	return max - min;
		if (root.val < min)	min = root.val;
		if (root.val > max)	max = root.val;
		return Math.max(helper(root.left, min, max), helper(root.right, min, max));
	}
}

public class amplitudeOfTree{
	public static int Solution(TreeNode root){  
		if(root == null) return 0;
      	if(root.left == null && root.right == null) return root.val;
		Stack<TreeNode> pathNode = new Stack<TreeNode>();
		Stack<int[]> pathMinMax = new Stack<int[]>();
		pathNode.push(root);
		pathMinMax.push(new int[]{root.val, root.val});
		int amplitude = Integer.MIN_VALUE;
		while(!pathNode.empty()){
			TreeNode crtNode = pathNode.pop();
			if(crtNode.left == null && crtNode.right == null){
				int[] crtMinMax = pathMinMax.pop();
				amplitude = amplitude > (crtMinMax[1] - crtMinMax[0]) ? amplitude : (crtMinMax[1] - crtMinMax[0]);
				continue;
			}
			if(crtNode.right != null){
				int[] crtMinMax = new int[2];
				crtMinMax[0] = crtNode.right.val < pathMinMax.peek()[0] ? crtNode.right.val : pathMinMax.peek()[0];
				crtMinMax[1] = crtNode.right.val > pathMinMax.peek()[1] ? crtNode.right.val : pathMinMax.peek()[1];
				pathNode.push(crtNode.right);
				pathMinMax.push(crtMinMax);
			}
			if(crtNode.left != null){
				int[] crtMinMax = new int[2];
				crtMinMax[0] = crtNode.left.val < pathMinMax.peek()[0] ? crtNode.left.val : pathMinMax.peek()[0];
				crtMinMax[1] = crtNode.left.val > pathMinMax.peek()[1] ? crtNode.left.val : pathMinMax.peek()[1];
				pathNode.push(crtNode.left);
				pathMinMax.push(crtMinMax);
			}
			pathMinMax.pop();
		}
		return amplitude;
	}
}