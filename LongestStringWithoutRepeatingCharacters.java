import java.util.HashMap;

public class LongestStringWithoutRepeatingCharacters {
    // https://leetcode.com/problems/longest-substring-without-repeating-characters/
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            int max = 0;
            int i=0,j=0;
            HashMap<Character,Integer> hm = new HashMap<>();
            while(j < s.length()) {
                if(hm.get(s.charAt(j))!=null) {
                     i = Math.max(i, hm.get(s.charAt(j))+1);
                }
                
                hm.put(s.charAt(j),j);
                max = Math.max(j-i+1,max);
                j++;
            }
            return max;
        }
    }
}