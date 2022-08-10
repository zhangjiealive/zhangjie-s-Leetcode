/** 剑指 Offer 10- II. 青蛙跳台阶问题 https://leetcode.cn/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class LeetcodeJ10 {
    /**
     *
     * @param n
     * @return
     */
    public int numWays(int n) {
        // 阶梯数小于2，都只有一种方式
        if(n<2){
            return 1;
        }
        // dp数组含义：dp[i]为从0到i阶梯的方式有多少种
        int[] dp=new int[n+1];
        // base case
        // 0层阶梯，本来就在，1种
        dp[0]=1;
        // 1层阶梯，只有1种，下一层
        dp[1]=1;
        // 2层阶梯，有2种，下2个一层，和一个两层
        dp[2]=2;
        // 循环从3开始，dp[i]由dp[i-1]和dp[i-2]转移而来，意为两种选择存在方式的总和
        // 可以选择下一层，也可以下两层，下一层和下两层的和为此位置的方式
        for (int i = 3; i <=n ; i++) {
            // 根据题目要求进行取余，避免溢出
            dp[i]=(dp[i-1]+dp[i-2])%1000000007;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        LeetcodeJ10 leetcodeJ10 = new LeetcodeJ10();
        leetcodeJ10.numWays(46);
    }
}
