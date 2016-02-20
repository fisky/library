/*
	int[] A = {2,5,2,3,4,6,8,10,12,9,8,7,6,2,4,8};
	OA2: find out number of arithmetic sequence in array
	time complexity: O(n)
	space complexity: O(1)
*/
public class ArithmaticSlice{
	public static int Solution(int[] nums) {
		if(nums == null || nums.length < 3) return 0;
		int left = 0, right = 1, diff = nums[1] - nums[0], count = 0;
		while(right < nums.length - 1){
			if(diff != nums[right + 1] - nums[right]){
				count += (right - left - 1) * (right - left) / 2;
				if(count > 1000000000) return -1;
				diff = nums[right + 1] - nums[right];
				left = right;
			}
			++right;	
		}
		count += (right - left - 1) * (right - left) / 2;
		return count > 1000000000 ? -1 : count;
	}
}