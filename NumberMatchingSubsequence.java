import java.util.ArrayList;
import java.util.HashMap;

public class NumberMatchingSubsequence {
    public static void main(String[] args) {
        System.out.println((new Solution()).numMatchingSubseq("abcde", new String[]{"a","bb","acd","ace"}));
    }
    // https://leetcode.com/problems/number-of-matching-subsequences/
    static class Solution {
        public int numMatchingSubseq(String s, String[] words) {
            HashMap<Character,ArrayList<Integer>> hm = new HashMap<>();
            for(int i=0;i<s.length();i++) {
                ArrayList<Integer> arr = hm.getOrDefault(s.charAt(i),new ArrayList<Integer>());
                arr.add(i);
                hm.put(s.charAt(i),arr);
            }
            int count = 0;
            for( int i=0; i < words.length; i++) {
                boolean tw = true;
                int ind = 0;
                String word = words[i];
                for(int j=0;j<word.length();j++) {
                    ArrayList<Integer> arr = hm.get(word.charAt(j));
                    if(arr == null) {
                        tw = false;
                        break;
                    }
                    int low = lowestIndex(ind,arr);
                    if(low == -1) {
                         tw = false;
                        break;
                    }else {
                        ind = low+1;
                    }
                }
                if(tw) count++;
            }
            return count;
        }
        public int lowestIndex(int gt, ArrayList<Integer> list) {
            int low = 0;
            int high = list.size()-1;
            int ans = -1;
            while(low <= high) {
                int mid = low+high;
                mid /= 2;
                if(list.get(mid) == gt) {
                   ans = list.get(mid);
                   break;
                } else if(list.get(mid) < gt) {
                    low = mid+1;
                } else {
                    ans = list.get(mid);
                    high = mid-1;
                }
            }
            return ans;
        }
    }
}
