public class MedianSortedArrays {
    public static void main(String[] args) {
        System.out.print((new Solution()).findMedianSortedArrays(new int[] { 1, 3 }, new int[] { 2 }));
    }

    // https://leetcode.com/problems/median-of-two-sorted-arrays
    static class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            // Shorter array = nums1
            if (nums1.length > nums2.length) {
                int[] temp = nums1;
                nums1 = nums2;
                nums2 = temp;
            }
            int start = 0;
            int end = nums1.length - 1;
            int rm = (nums1.length + nums2.length) / 2;
            while (true) {
                int i = end < 0 ? end : (start + end) / 2;
                int j = rm - i - 2;
                int nums1Left = i >= 0 ? nums1[i] : Integer.MIN_VALUE;
                int nums1Right = i < nums1.length - 1 ? nums1[i + 1] : Integer.MAX_VALUE;
                int nums2Left = j >= 0 ? nums2[j] : Integer.MIN_VALUE;
                int nums2Right = j < nums2.length - 1 ? nums2[j + 1] : Integer.MAX_VALUE;
                if (nums1Left <= nums2Right && nums2Left <= nums1Right) {
                    if ((nums1.length + nums2.length) % 2 != 0) {
                        return Math.min(nums1Right, nums2Right);
                    } else {
                        return (Math.max(nums1Left, nums2Left) + Math.min(nums1Right, nums2Right)) / 2.0;
                    }
                } else if (nums1Left > nums2Right) {
                    end = i - 1;
                } else if (nums2Left > nums1Right) {
                    start = i + 1;
                }
            }
        }
    }
}
