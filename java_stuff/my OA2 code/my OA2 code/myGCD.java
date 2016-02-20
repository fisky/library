/*
	Greatest Common Divisor
	time complexity: O(n)
	space complexity: O(1)
	
*/
public class GCD {
	public static int Solution(int[] nums){
		if(nums == null || nums.length == 0 || nums[0] == 0) return 0;
		if(nums.length == 1) return nums[0];
		int divisor = nums[0];
		for(int i = 1; i < nums.length; ++i) {
          	if(nums[i] == 0) return 0;
			int divident = nums[i];
			while( divident % divisor != 0){
				int tmp = divisor;
				divisor = divident % divisor;
				divident = tmp;
			}
		}
		return divisor;
	}
}