//  Leetcode303.java

/** 力扣303题 https://leetcode.cn/problems/range-sum-query-immutable/
 * 一维前缀和：维护一个一维数组，第0位为0，第一位为第0位+nums数组的第一位，第二位为第一位+nums数组的第二位，类似于斐波那契数列，每次取找preSum[right+1]的值
 * preSum的长度比nums大1，preSum第一位为空，所以每次取nums前多少位的值应该在索引+1(第6位存前5位的值，第5位存前4位的值)，减去2之前的，是-preSum[2]，第2位存前1位的值
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode303 {
    class NumArray {
        private int[] preSum;

        public NumArray(int[] nums) {
            preSum=new int[nums.length+1];
            for (int i = 1; i < preSum.length; i++) {
                preSum[i]=preSum[i-1]+nums[i-1];
            }
        }

        public int sumRange(int left, int right) {
            return preSum[right+1]-preSum[left];
        }
    }
}
