import java.util.Arrays;
import java.util.HashMap;

public class HandOfStraights {
    // https://leetcode.com/problems/hand-of-straights/
    static class Solution {

        public boolean isNStraightHand(int[] hand, int groupSize) {
            HashMap<Integer,Integer> hm = new HashMap<>();
            if(hand.length < groupSize) return false;
            for(int num : hand) {
                hm.put(num,hm.getOrDefault(num,0)+1);
            }
            Arrays.sort(hand);
            for(int num : hand) {
                int f0 = hm.getOrDefault(num,0);
                if(f0 == 0) 
                    continue;
                for(int i=1;i<groupSize;i++) {
                    int fi = hm.getOrDefault(num+i,0);
                    if(fi<f0 )
                        return false;
                    else
                        hm.put(num+i,fi-f0);

                }
                hm.put(num,0);
            }
            return true;
        }
    }
}