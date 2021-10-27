import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    // https://leetcode.com/problems/group-anagrams/
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            HashMap<SpecialString, ArrayList<String>> hm = new HashMap<>();
            for (String s : strs) {
                SpecialString sp = new SpecialString(s);
                if (hm.get(sp) != null) {
                    hm.get(sp).add(s);
                } else {
                    hm.put(sp, new ArrayList<String>());
                    hm.get(sp).add(s);
                }
            }
            List<List<String>> ret = new ArrayList<>();
            for (ArrayList<String> sets : hm.values()) {
                ret.add(sets);
            }
            return ret;
        }

        class SpecialString {
            int a[];

            public SpecialString(String s) {
                a = new int[26];
                for (Character c : s.toCharArray()) {
                    a[c - 'a']++;
                }
            }

            @Override
            public boolean equals(Object s) {
                SpecialString k = (SpecialString) s;
                return Arrays.equals(this.a, k.a);
            }

            @Override
            public int hashCode() {
                return Arrays.hashCode(this.a);
            }
        }
    }
}