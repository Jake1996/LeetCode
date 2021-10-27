public class FirstBadVersion {
    public static void main(String[] args) {
        System.out.println((new Solution()).firstBadVersion(2126753390));
    }

    // https://leetcode.com/problems/first-bad-version/
    public static class Solution {
        public int firstBadVersion(int n) {
            long low = 0;
            long high = n;
            int bad = -1;
            while (low <= high) {
                int mid = (int) ((low + high) / 2);
                if (isBadVersion(mid)) {
                    high = mid - 1;
                    bad = mid;
                } else {
                    low = mid + 1;
                }
            }
            return bad;
        }

        public boolean isBadVersion(int n) {
            return n >= 1702766719;
        }
    }

}
