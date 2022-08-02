/** 343. 整数拆分 https://leetcode.cn/problems/integer-break/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode343 {
    /**
     * 思路：自底向下的动态规划
     * 分解思路：i可以分解为1和i-1，2和i-2一直到i/2,i/2
     * 只需要从中找最大的
     * 可以分成1和i-1直接相乘或者1和i-1，在用i-1去分解，只需要找到i-1的分解最大成绩，就是dp[i-1]
     * @param n
     * @return
     */
    public int integerBreak(int n) {
        // dp数组：dp[i]为i拆成几个数的最大乘积
        int[] dp=new int[n+1];
        // base case 2只能拆成2个1相乘
        dp[2]=1;
        // i从3开始循环到n
        for (int i = 3; i <=n; i++) {
            // j从1开始循环，到i的一半，例如8拆为1,7 2,6 3,5 4,4 5,3 6,2 7,1可见后面都是重复的，只需要到中间即可
            for (int j = 1; j<=i/2; j++) {
                // i可以分成1和i-1直接相乘或者1和i-1，在用i-1去分解，只需要找到i-1的分解最大乘积，就是dp[i-1]
                // 所以dp[i]由dp[i-j]转移而来
                dp[i]=Math.max(Math.max(j*(dp[i-j]),j*(i-j)),dp[i]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Leetcode343 leetcode343 = new Leetcode343();
        leetcode343.integerBreak(6);
    }
}
