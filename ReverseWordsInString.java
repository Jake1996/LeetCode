import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ReverseWordsInString {
    public static void main(String[] args) {
        System.out.println((new Solution()).reverseWords("a good   example"));
    }

    // https://leetcode.com/problems/reverse-words-in-a-string/
    static class Solution {
        public String reverseWords(String s) {
            ArrayList<String> l = new ArrayList<>(Arrays.asList(s.trim().split(" ")));
            l.removeIf((k) -> "".compareTo(k) == 0);
            Collections.reverse(l);
            return String.join(" ", l);
        }
    }
}
