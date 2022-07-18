/** 309. 最佳买卖股票时机含冷冻期 https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode309 {
    /**
     * 在出售后存在1天的冷静期
     * 错误思路：第一次买入没有冷静期，用标识位标识，是否是第一次交易
     * 正确思路：每次买入操作时，利润都由两天前的利润转移而来，memo[i][1]由memo[i - 2][0] - prices[i]，中间隔的一天就是冷静期
     * 换个思路：只要不在第1天就是i=0时购买股票，都存在冷静期，而且是>=1 例如第2天购买，冷静期为1，第3天购买冷静期为2
     * 所以其实除了第一天购买股票，其余都存在冷静期，所以只需要控制好第1天和第2天的转移即可
     * 当i为1时，如果从price[1]购买股票，是-prices[1],那么状态由memo[i - 1][0]转移而来（需要单独情况保证i不超出数组下标）
     * 当i为2时，如果从price[2]购买股票，是-prices[2],那么状态由memo[i - 2][0]转移而来
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][] memo=new int[n][2];
        for (int i = 0; i < n; i++) {
            // base case 当第一天没有购买股票，利润为0，当第一天购买了股票，利润为-prices[0]
            if(i==0){
                memo[i][0]=0;
                memo[i][1]=-prices[i];
            }
            // base case 当第二天没有购买股票，状态都前一天没有购买股票，和前一天持有股票今天出售转移而来
            // 当第二天购买股票了，状态由前一天购买股票，和前一天没有购买股票今天购买转移而来（因为如果是i-2下标越界（也可以理解为在此冷静期之前没有股票），或第一次操作没有冷静期的原因，都只能从i-1取）
            else if(i==1){
                memo[i][0]=Math.max(memo[i-1][0],memo[i-1][1]+prices[i]);
                memo[i][1]=Math.max(memo[i-1][1],memo[i-1][0]-prices[i]);
            }
            else {
                // 当天不持有股票的状态，应该由昨天持有股票但今天卖掉股票和昨天不持有股票的两种状态转移而来
                memo[i][0] = Math.max(memo[i - 1][0], memo[i - 1][1] + prices[i]);
                // 因为在卖出后到下次买入有一天的冷静期（用前天没有股票时的利润来买股票，达到昨天没有任何操作的目的）
                // 所以当天持有股票的状态，应该由昨天也持有股票和前天没有股票今天买入股票两种状态转移而来
                memo[i][1] = Math.max(memo[i - 1][1], memo[i - 2][0] - prices[i]);
            }
        }
        return memo[n-1][0];
    }

    public static void main(String[] args) {
        Leetcode309 leetcode309 = new Leetcode309();
        leetcode309.maxProfit(new int[]{1,2,3,0,2});
    }
}
