/** 剑指 Offer 14- I. 剪绳子 https://leetcode.cn/problems/jian-sheng-zi-lcof/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class LeetcodeJ14 {
    /**
     * 思路：动态规划
     * @param n
     * @return
     */
    public int cuttingRope(int n) {
        // dp数组
        int[] dp=new int[n+1];
        // base case 当绳子长度为2，只能分割成2个1的绳子1*1=1
        dp[2]=1;
        // 从3开始计算，到n
        for (int i = 3; i <= n; i++) {
            // 遍历从1到i-1所有可能（可以分割为1-(i-1)长度的绳子）
            for (int j = 1; j < i-1; j++) {
                // dp[i]由dp[i-j]*j转移而来，可以认为是每次分割的都是最大的，那么可以从dp数组中取，分割长度i-j的乘积在乘上此次分割绳子的长度
                dp[i]=Math.max(dp[i],Math.max((i-j)*j,dp[i-j]*j));
            }
        }
        return dp[n];
    }
}
