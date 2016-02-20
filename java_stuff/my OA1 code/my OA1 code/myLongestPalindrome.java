public class Solution {
  	public static String longestPalindrome(String s){
    	if(s == null || s.length() == 0) return null;
    	int size = s.length();
    	int maxLen = 0, right = 0;
    	for(int i = 0; i < size; ++i) {
          if(isPalim(s, i - maxLen, i)){
              maxLen += 1;
              right = i;
          }
          else if((i - maxLen - 1 >= 0) && isPalim(s, i - maxLen - 1, i)){
              maxLen +=2 ;
              right = i;
          }
    	}
    	return s.substring(right + 1 - maxLen, right + 1);
  	}
  	public static boolean isPalim(String s, int start, int end){
    	for(;start < end; ++start, --end)
      	if(s.charAt(start) != s.charAt(end))
      		return false;
    	return true;
  	}
}