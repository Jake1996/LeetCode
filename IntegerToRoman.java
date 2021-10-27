public class IntegerToRoman {
    // https://leetcode.com/problems/integer-to-roman/
    class Solution {
        public String intToRoman(int num) {
            int[] vals = new int[] { 1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000 };
            String[] roms = new String[] { "I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M" };
            StringBuilder sb = new StringBuilder();
            int i = roms.length - 1;
            while (num != 0) {
                if (num == vals[i]) {
                    sb.append(roms[i]);
                    break;
                } else if (num < vals[i]) {
                    i--;
                } else {
                    sb.append(roms[i]);
                    num -= vals[i];
                }
            }
            return sb.toString();
        }
    }
}
