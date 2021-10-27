import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {
    // https://leetcode.com/problems/restore-ip-addresses/
    class Solution {
        public List<String> out;

        public List<String> restoreIpAddresses(String s) {
            out = new ArrayList<String>();
            if (s.length() >= 4 && s.length() <= 12)
                helper(s, "", 0);
            return out;
        }

        public void helper(String sub, String prev, int count) {
            if (sub.length() == 0)
                return;
            if (count == 3) {
                if (isValid(sub))
                    this.out.add(prev + "." + sub);
                return;
            }
            if (sub.charAt(0) == '0') {
                if (count == 0) {
                    helper(sub.substring(1), "0", count + 1);
                } else {
                    helper(sub.substring(1), prev + ".0", count + 1);
                }
                return;
            }
            int i = 1;
            while (i < sub.length()) {
                if (isValid(sub.substring(0, i))) {
                    if (count == 0)
                        helper(sub.substring(i), sub.substring(0, i), count + 1);
                    else
                        helper(sub.substring(i), prev + "." + sub.substring(0, i), count + 1);
                    i++;
                } else {
                    break;
                }
            }
        }

        public boolean isValid(String n) {
            long num = Long.parseLong(n);
            if (num != 0 && n.charAt(0) == '0')
                return false;
            if (num == 0 && n.length() > 1)
                return false;
            if (num > 255)
                return false;
            return true;
        }
    }
}
