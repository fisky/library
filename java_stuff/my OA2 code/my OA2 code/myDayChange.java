/*
	Day change
	time complexity: O(n*days)
	space complexity: O(n)
*/
public class DaysChange {
	public static int[] Solution(int[] nums, int days) {
		if(nums == null || nums.length <= 1 || days <= 0) return nums;
		int len = nums.length;
		// preNum represents previous day's list
		int[] preNum = new int[len];
      	preNum = nums;
		for(int count = 0; count < days; ++count) {
			int[] crtNum = new int[len];
			crtNum[0] = preNum[1];
			crtNum[len - 1] = preNum[len - 2];
			for(int i = 1; i < len - 1; ++i)
				crtNum[i] = preNum[i - 1] ^ preNum[i + 1];
			preNum = crtNum;
		}
		return preNum;
	}
}