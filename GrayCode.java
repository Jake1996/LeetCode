import java.util.ArrayList;
import java.util.List;

public class GrayCode {
    // https://leetcode.com/problems/gray-code/
    static class Solution {
        public List<Integer> grayCode(int n) {
            if(n==1){
                List<Integer> list = new ArrayList<>();
                list.add(0);
                list.add(1);
                return list;
            }
            
            List<Integer> prev = grayCode(n-1);
            List<Integer> ans = new ArrayList<Integer>();
            for(int i=0;i<prev.size();i++){
                ans.add((prev.get(i)<< 1) + 0);
            }
            for(int i=prev.size()-1 ; i>=0;i--){
                ans.add((prev.get(i)<< 1) + 1);
            }
            
            return ans;
        }
    }
}
