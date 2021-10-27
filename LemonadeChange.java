public class LemonadeChange {
    // https://leetcode.com/problems/lemonade-change
    class Solution {
        public boolean lemonadeChange(int[] bills) {
            int five = 0;
            int ten = 0;
            for (int i = 0; i < bills.length; i++) {
                switch (bills[i]) {
                    case 5:
                        five++;
                        break;
                    case 10: {
                        if (five > 0) {
                            five--;
                            ten++;
                        } else {
                            return false;
                        }
                    }
                        break;
                    case 20: {
                        if (ten > 0 && five > 0) {
                            ten--;
                            five--;
                        } else if (five >= 3) {
                            five -= 3;
                        } else {
                            return false;
                        }
                    }
                        break;
                    default:
                }
            }
            return true;
        }
    }

}
