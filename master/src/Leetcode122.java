/** 122. 买卖股票的最佳时机 II https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode122 {
    /**
     * 股票问题2：可以进行n次交易
     * 动态规划：全部参考 Leetcode121
     * @param prices
     * @return
     */
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
            // 唯一与121题的区别，因为可以进行无数次交易，所以可以从之前卖出后的状态上获取利润
            // memo[i-1][0]-prices[i]代表每次都可以在之前获得利润的基础上继续买卖（也就是n次交易）
            memo[i][1]=Math.max(memo[i-1][1],memo[i-1][0]-prices[i]);
        }
        return memo[n-1][0];
    }
}
