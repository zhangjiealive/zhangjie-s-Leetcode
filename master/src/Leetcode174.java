import sun.nio.cs.ext.MacHebrew;

/** 174. 地下城游戏 https://leetcode.cn/problems/dungeon-game/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode174 {
    /**
     * 求最小初始健康值
     * 从骑士所在位置去找公主，行不通
     * 只能从公主的位置去找骑士
     * @param dungeon
     * @return
     */
    public int calculateMinimumHP(int[][] dungeon) {
        int n=dungeon.length;
        int m=dungeon[0].length;
        int[][] dp=new int[n][m];
        // 逆序遍历(公主救王子)
        for (int i = n-1; i >=0; i--) {
            for (int j = m-1; j >=0; j--) {
                // base case此位置为正，则最小初始健康值为1，如果为负，则是此值的绝对值+1（因为如果为-5，则需要6点血才能活）
                if(i==n-1&&j==m-1){
                    dp[i][j]=Math.max(1,1-dungeon[i][j]);
                }
                // 处理最后一行的状态，只能由右侧转移而来，（dp[i][j+1]-dungeon[i][j]中如果dp[i][j+1]不为1
                // 代表之前那一格需要这么多血才能活，如果dungeon[i][j]为负数，那么根据-dungeon[i][j]，又需要在需要的血量上加dungeon[i][j]才能活
                // 如果为正数，又要用dp[i][j+1]-此数
                // 总之如果dp[i][j+1]-dungeon[i][j]大于1，则代表需要这么多血才能活，dp[i][j+1]-dungeon[i][j]小于等于0，则代表多出来这么多血量
                // 但是要保留的是最小初始健康值，当dp[i][j+1]-dungeon[i][j]小于等于0则代表多出来这么多血量，所以会取1，因为多出来这些血量对我们没有作用，我们只知道需要保留一点血可以保证活着
                // dp[i][j+1]-dungeon[i][j]大于1,则代表需要这么多血才能活会去除此值
                else if(i==n-1){
                    dp[i][j]=Math.max(1,dp[i][j+1]-dungeon[i][j]);
                }
                // 处理最后一列的状态，只能由下侧转移而来，其余思想同上
                else if(j==m-1){
                    dp[i][j]=Math.max(1,dp[i+1][j]-dungeon[i][j]);
                }
                else {
                    // 因为需要最小初始健康值所以从两个状态中取出最小的，其余思想同上
                    dp[i][j]= Math.max(1,Math.min(dp[i][j+1],dp[i+1][j])-dungeon[i][j]);
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        Leetcode174 leetcode174 = new Leetcode174();
        int[][] a={{-2,-3,3},{-5,-10,1},{10,30,-5}};
        leetcode174.calculateMinimumHP(a);
    }
}
