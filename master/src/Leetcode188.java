/** 188. 买卖股票的最佳时机 IV https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iv/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode188 {
    /**
     * 思路：今天买入今天买出是没有意义的，最高频率的也就是今天买入明天卖出，需要两天时间，所以当交易次数大于天数除以2的话
     * 等于是无限交易次数，直接使用122的方法，如果不是则执行本方法（与123基本一致）
     * 其他细节参考123
     * @param k
     * @param prices
     * @return
     */
    public int maxProfit(int k,int[] prices) {
        int n=prices.length;
        if(n<=0){
            return 0;
        }
        // 当交易次数大于天数的一半，代表交易次数可以理解为无限次了
        if(k>n/2){
            return maxProfit(prices);
        }
        int[][][] memo=new int[n][k+1][2];
        for (int i = 0; i < n; i++) {
            for (int j=1; j <=k ; j++) {
                // base case
                if(i==0){
                    memo[i][j][0]=0;
                    memo[i][j][1]=-prices[i];
                    continue;
                }
                memo[i][j][0]=Math.max(memo[i-1][j][0],memo[i-1][j][1]+prices[i]);
                memo[i][j][1]=Math.max(memo[i-1][j][1],memo[i-1][j-1][0]-prices[i]);
            }
        }
        return memo[n-1][k][0];
    }


    public int maxProfit(int[] prices) {
        int n= prices.length;
        int[][] memo=new int[n][2];
        for (int i = 0; i < n; i++) {
            if(i==0){
                memo[i][0]=0;
                memo[i][1]=-prices[i];
                continue;
            }
            memo[i][0]=Math.max(memo[i-1][0],memo[i-1][1]+prices[i]);
            memo[i][1]=Math.max(memo[i-1][1],memo[i-1][0]-prices[i]);
        }
        return memo[n-1][0];
    }
}
