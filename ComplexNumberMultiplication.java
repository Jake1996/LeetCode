public class ComplexNumberMultiplication {
    // https://leetcode.com/problems/complex-number-multiplication/
    class Solution {
        public String complexNumberMultiply(String num1, String num2) {
            int cn1[] = new int[2];
            int cn2[] = new int[2];
            int ans[] = new int[2];
            parseComplexNumber(cn1, num1);
            parseComplexNumber(cn2, num2);
            ans[0] = cn1[0] * cn2[0] - 1 * (cn1[1] * cn2[1]);
            ans[1] = cn1[0] * cn2[1] + cn1[1] * cn2[0];
            StringBuilder sb = new StringBuilder();
            sb.append(ans[0] + "");
            sb.append("+");
            sb.append(ans[1] + "");
            sb.append("i");
            return sb.toString();
        }

        public void parseComplexNumber(int[] n, String s) {
            int i = 0;
            int sign = 1;
            if (s.charAt(0) == '-') {
                sign = -1;
                i++;
            }
            if (s.charAt(0) == '+') {
                i++;
            }
            int start = i;
            while (i < s.length() && Character.isDigit(s.charAt(i))) {
                i++;
            }
            n[0] = sign * Integer.parseInt(s.substring(start, i));
            if (s.charAt(i) == '-') {
                sign = -1;
                i++;
            }
            if (s.charAt(i) == '+') {
                sign = 1;
                i++;
            }
            if (s.charAt(i) == '-') {
                sign = -1;
                i++;
            }
            if (s.charAt(i) == '+') {
                sign = 1;
                i++;
            }
            start = i;
            while (i < s.length() && Character.isDigit(s.charAt(i))) {
                i++;
            }
            n[1] = sign * Integer.parseInt(s.substring(start, i));
        }
    }
}
