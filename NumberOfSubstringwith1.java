public class NumberOfSubstringwith1 {
    // https://leetcode.com/problems/number-of-substrings-with-only-1s/
    class Solution {
        public int numSub(String s) {
            int i=0;
            int j=0;
            long total = 0;
            int mod = 1000000007; 
            while(j<s.length()) {
                while(j < s.length() && s.charAt(i)==s.charAt(j)){
                    j++;
                }
                if(s.charAt(i)=='1') {   
                    long length = j-i;
                    total = total + (length*(length+1))/2;
                    total%=mod;
                }
                i=j;
            }
            return (int)total;
        }
    }
}
