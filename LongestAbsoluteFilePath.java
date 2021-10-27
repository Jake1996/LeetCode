public class LongestAbsoluteFilePath {
    public static void main(String[] args) {
        System.out.print((new Solution()).lengthLongestPath("a\n\tb.txt\na2\n\tb2.txt"));
    }
    // https://leetcode.com/problems/longest-absolute-file-path/
    public static class Solution {
        public int lengthLongestPath(String input) {
            String[] arr = input.split("\\n");
            String prefix = "";
            int tc = 0;
            int max = 0;
            for(int i=0;i<arr.length;i++) {
                int j=0;
                while(arr[i].charAt(j)=='\t') {
                    j++;
                }
                if(i>0 && tc < j) {
                    tc = j;
                    prefix = prefix + arr[i-1].substring(arr[i-1].lastIndexOf("/")).trim(); 
                    
                }
                if(j<tc) {
                    for(int k=j;k<tc;k++) {
                        prefix = prefix.substring(0,prefix.lastIndexOf("/"));
                    }
                    tc = j;
                }
                arr[i] = "/" + prefix +"/"+ arr[i].substring(arr[i].lastIndexOf("\t")+1);
                if(arr[i].contains(".")) {
                    max = Math.max(max,arr[i].length());
                }
            }
            return Math.max(0,max-2);
        }
    }
}
