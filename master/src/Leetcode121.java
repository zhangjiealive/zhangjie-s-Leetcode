/** 121. 买卖股票的最佳时机 https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode121 {
    /**
     * 股票问题1：只可以进行一次交易
     * 动态规划
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int n=prices.length;
        // 因此交易次数只为1，所以只需要二维数组即可
        // n代表天数，2代表0代表不持有，1代表持有两种状态
        // memo[1][1] 代表第二天持有股票的利润
        int[][] memo=new int[n][2];
        for (int i = 0; i < n; i++) {
            // base case 当i==0时 第1天，不持有股票一定利润为0，第1天持有股票，取为第1天的股票价的负数（钱用来买股票了，所以利润是负的）
            if(i==0){
                memo[i][0]=0;
                memo[i][1]=-prices[i];
                continue;
            }
            // 当天不持有股票的状态，应该由昨天持有股票但今天卖掉股票和昨天不持有股票的两种状态转移而来
            memo[i][0]=Math.max(memo[i-1][0],memo[i-1][1]+prices[i]);
            // 当天持有股票的状态，应该由昨天也持有股票和今天买入股票两种状态转移而来
            // -price[i]代表只能买一次，无论在哪一天买都是此天股票价格的负数，不能从之前卖出的利润上减
            memo[i][1]=Math.max(memo[i-1][1],-prices[i]);
        }
        // 返回第n天，不持有股票的利润
        return memo[n-1][0];
    }
}
