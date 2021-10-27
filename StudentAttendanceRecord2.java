public class StudentAttendanceRecord2 {
    // https://leetcode.com/problems/student-attendance-record-ii
    class Solution {
        int mod = 1000000007;
        public int checkRecord(int n) {
            // i+1 characters, no of absent days, ending with consecutive L
            int dp[][][] = new int[n][2][3];
            dp[0][0][0] = 1;
            dp[0][0][1] = 1;
            dp[0][0][2] = 0;
            dp[0][1][0] = 1;
            dp[0][1][1] = 0;
            dp[0][1][2] = 0;

            for(int i=1;i<n;i++) {
                dp[i][0][0] = add(add(dp[i-1][0][0], dp[i-1][0][1]), dp[i-1][0][2]);
                dp[i][0][1] = dp[i-1][0][0];
                dp[i][0][2] = dp[i-1][0][1];
                dp[i][1][0] = add(dp[i-1][0][0], add( dp[i-1][0][1], add( dp[i-1][0][2], add( dp[i-1][1][0] ,add( dp[i-1][1][1],dp[i-1][1][2])))));
                dp[i][1][1] = dp[i-1][1][0];
                dp[i][1][2] = dp[i-1][1][1];
    
            }
            int res = 0;
            for(int i=0;i<2;i++) {
                for(int j=0;j<3;j++) {
                    res = add(res , dp[n-1][i][j]);
                }
            }
            return res;
        }
        public int add(int a, int b) {
            return (int)((long)a+b)%this.mod;
        }
    }
}
