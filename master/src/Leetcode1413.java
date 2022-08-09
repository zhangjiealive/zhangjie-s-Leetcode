/** 1413. 逐步求和得到正数的最小值 https://leetcode.cn/problems/minimum-value-to-get-positive-step-by-step-sum/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode1413 {
    /**
     * 任何阶段累加的和不小于1，那么只需要计算其中累加最小的是多少
     * @param nums
     * @return
     */
    public int minStartValue(int[] nums) {
        // 求最小值取最大值
        int min=Integer.MAX_VALUE;
        // 累加和
        int count=0;
        // 遍历数组
        for (int a: nums) {
            // 不断更新最小值
            min=Math.min(count=count+a,min);
        }
        // 最小的值大于等于0的话，就从1出发，因为最小的start点为正数，否则就取最小的绝对值+1即可
        return min>=0?1:Math.abs(min)+1;
    }

    public static void main(String[] args) {
        Leetcode1413 leetcode1413 = new Leetcode1413();
        leetcode1413.minStartValue(new int[]{-3,2,-3,4,2});
    }
}
