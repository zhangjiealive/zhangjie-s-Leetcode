/** 714. 买卖股票的最佳时机含手续费 https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode714 {
    /**
     * 思路：参考Leetcode122
     * 只需要从Leetcode122中在购买时扣除手续费即可
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfit(int[] prices, int fee) {
        int n= prices.length;
        int[][] memo=new int[n][2];
        for (int i = 0; i < n; i++) {
            if(i==0){
                memo[i][0]=0;
                memo[i][1]=-prices[i]-fee;
                continue;
            }
            memo[i][0]=Math.max(memo[i-1][0],memo[i-1][1]+prices[i]);
            memo[i][1]=Math.max(memo[i-1][1],memo[i-1][0]-prices[i]-fee);
        }
        return memo[n-1][0];
    }
}
