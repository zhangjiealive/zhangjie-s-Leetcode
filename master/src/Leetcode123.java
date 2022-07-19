/** 123. 买卖股票的最佳时机 III https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iii/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode123 {
    /**
     * 思路：由二维dp转为三维dp
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int n=prices.length;
        // 最大交易次数
        int max=2;
        // 三维dp数组
        int[][][] memo=new int[n][max+1][2];
        for (int i = 0; i < n; i++) {
            // 从一次到max次交易机会遍历
            // base case当k=0，没有交易机会，利润默认为0，因为int数组默认初始化为0
            // 关于k正序还是倒序遍历没那么重要，因为他状态都是从i-1就是昨天转移而来，无论倒序还是正序，昨天的状态都已经被计算出来了
            for (int k = 1; k <=max ; k++) {
                // base case当第一天，不持有股票的利润为0，持有股票的利润为当天股票价格的负数
                if(i==0){
                    memo[i][k][0]=0;
                    memo[i][k][1]=-prices[i];
                    continue;
                }
                // 第i天k次机会没有持有股票由昨天k次机会没有持有股票和昨天k次机会持有股票今天卖出的状态转移而来（因为我是在购买股票时就开始一段交易）
                memo[i][k][0]=Math.max(memo[i-1][k][0],memo[i-1][k][1]+prices[i]);
                // 第i天k次机会持有股票，由昨天k次机会持有股票和昨天没有持有股票今天买入交易次数-1的状态转移而来
                memo[i][k][1]=Math.max(memo[i-1][k][1],memo[i-1][k-1][0]-prices[i]);
            }
        }
        return memo[n-1][max][0];
    }

    public static void main(String[] args) {
        Leetcode123 leetcode123 = new Leetcode123();
        leetcode123.maxProfit(new int[]{3,3,5,0,0,3,1,4});
    }
}
