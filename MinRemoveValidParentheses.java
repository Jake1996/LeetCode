public class MinRemoveValidParentheses {
    class Solution {
        public String minRemoveToMakeValid(String s) {
            int o = 0;
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<s.length();i++) {
                char ch = s.charAt(i);
                if(ch=='(') {
                    sb.append(ch);
                    o++;
                }else if(ch == ')' && o>0) {
                    sb.append(ch);
                    o--;
                }else if(ch !='(' &&ch!=')'){
                    sb.append(ch);
                }
            }
            if(o>0) {
                for(int i=sb.length()-1;i>=0&&o>0;i--) {
                    if(sb.charAt(i)=='(') {
                        sb.deleteCharAt(i);
                        o--;
                    }
                }
            }
            return sb.toString();
        }
        
    }
}
