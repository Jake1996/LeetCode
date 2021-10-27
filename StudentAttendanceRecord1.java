public class StudentAttendanceRecord1 {
    class Solution {
        // https://leetcode.com/problems/student-attendance-record-i
        public boolean checkRecord(String s) {
            int ab = 0 ;
            int la = 0;
            for(int i=0;i<s.length();i++) {
                char c = s.charAt(i);
                switch(c) {
                    case 'L': la++;
                    break;
                    case 'A' : ab++;
                    default : 
                        if(la < 3) {
                            la = 0;
                        }
                }
            }
            if(ab > 1 || la >=3) return false;
            return true;
        }
    }
}
