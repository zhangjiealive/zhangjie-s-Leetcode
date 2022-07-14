/** 518. 零钱兑换 II https://leetcode.cn/problems/coin-change-2/
 * 完全背包问题：每个物品数量是无限的
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode518 {
    /**
     * 动态规划：自底向下的递归
     * @param amount
     * @param coins
     * @return
     */
    public int change(int amount, int[] coins) {
        int n=coins.length;
        // dp[i][j] i代表选择的东西，j代表背包的容量
        int[][] dp=new int[n+1][amount+1];
        // base case当j==0背包是装满的，因为要记录次数，这种情况背包装满的方式为1
        // base case当i==0已经没有东西可以选，这种情况背包装满的方式为0，因为int数组默认值为0，不用赋值
        for (int i = 0; i <= coins.length; i++) {
            dp[i][0]=1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                // 当目前背包剩余容量装不下此物品，选择不装此物品，此状态通过没装此物品，容量相同的状态得来也就是dp[i][j]=dp[i-1][j];
                if(j-coins[i-1]<0){
                    dp[i][j]=dp[i-1][j];
                }
                /* 当目前背包剩余容量装的下此物品，此时有两种选择：
                1、选择不装此物品，此状态通过没装此物品，容量相同的状态得来，状态就是dp[i][j]=dp[i-1][j];
                2、选择装此物品，此状态通过装此物品，容量减去此物品的重量(因为可以选择重复的物品，所以i不变)，状态转移为dp[i][j]=dp[i][j-coins[i-1]];
                而此次是计算方式的总和，应该由两种状态相加而来
                 */
                else {
                    dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[n][amount];
    }

    public static void main(String[] args) {
        int[] a={1,2,5};
        Leetcode518 leetcode518 = new Leetcode518();
        leetcode518.change(5,a);
    }
}
