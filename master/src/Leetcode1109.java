//1109. 航班预订统计

/** 力扣1109题 https://leetcode.cn/problems/corporate-flight-bookings/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode1109 {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] nums=new int[n];
        DifferenceArray diff = new DifferenceArray(nums);
        for (int i = 0; i < bookings.length; i++) {
            diff.increment(bookings[i][0]-1,bookings[i][1]-1,bookings[i][2]);
            }
        return diff.result();
        }

    public static void main(String[] args) {
        int[][] a=new int[][]{
                {1,2,10},{2,3,20},{2,5,25}};
        Leetcode1109 leetcode1109 = new Leetcode1109();
        leetcode1109.corpFlightBookings(a,5);
    }
    }

