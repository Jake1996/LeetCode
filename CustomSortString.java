import java.util.Arrays;
import java.util.HashMap;

public class CustomSortString {
    // https://leetcode.com/problems/custom-sort-string/
    class Solution {
        public String customSortString(String order, String s) {
            HashMap<Character, Integer> hm = new HashMap<>();
            for (int i = 0; i < order.length(); i++) {
                hm.put(order.charAt(i), i);
            }

            Character arr[] = new Character[s.length()];
            for (int i = 0; i < s.length(); i++) {
                arr[i] = s.charAt(i);
            }
            Arrays.sort(arr, (c1, c2) -> hm.getOrDefault(c1, 0) - hm.getOrDefault(c2, 0));
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arr.length; i++) {
                sb.append(arr[i]);
            }
            return sb.toString();
        }
    }
}
