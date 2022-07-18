/** 877. 石子游戏 https://leetcode.cn/problems/stone-game/
 *  486. 预测赢家 https://leetcode.cn/problems/predict-the-winner/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode877 {
    /**
     * 动态规划:自底向上
     * 思路:正手在进行自己的一步后会成为反手
     * @param piles
     * @return
     */
    public boolean stoneGame(int[] piles) {
        int len = piles.length;
        // dp数组含义：dp[2][3]代表在piles[2-3]区间，先手和反手的分差
        int[][] dp = new int[len][len];
        // base case 当[1][1]区间中，只有一个元素，先手对反手的差值就为piles[1]，反手没有元素可以拿
        for (int i = 0; i < len; i++) {
            dp[i][i] = piles[i];
        }
        // 从右下角，从下往上，从里往外遍历
        for (int i = len - 2; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                // dp[i][j]由dp[i + 1][j]和dp[i][j - 1]转移而来
                // piles[i] - dp[i + 1][j]意为，piles[i]代表i位置（最左侧）被目前的先手拿走了，但是为什么要减去dp[i+1][j]呢，因为先手已经拿完了此时dp[i+1][j]已经成为这个正手的反手与正手分差
                //（在进入子问题后，此反手就成为了正手，我们所谓的正手就成为了反手）所以对于我们来说，应该减去，因为他只有是负数才代表这个开局的正手领先开局的反手
                // piles[i] - dp[i + 1][j]意同上代表j位置（最右侧）被目前的先手拿走了
                dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
            }
        }
        // 只要最后差值大于1，则先手赢
        return dp[0][len - 1] >= 0;
    }

    public static void main(String[] args) {
        Leetcode877 leetcode877 = new Leetcode877();
        leetcode877.stoneGame(new int[]{3,2,10,4});
    }
}
