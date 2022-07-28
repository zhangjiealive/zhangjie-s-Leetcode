/** 63. 不同路径 II https://leetcode.cn/problems/unique-paths-ii/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode63 {
    /**
     * 自底向上的动态规划
     * 出现了障碍物
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[][] dp=new int[m][n];
        // 在最后一行逆序遍历
        for(int i=n-1;i>=0;i--){
            // 当在最后一行任意位置遇到石头，直接结束循环，使还未遍历到的地方直接为0（因为int默认为0，直接结束，代表此位置0条路径，此路不通
            // 因为最后一行只能向右，但是此路径出现了石头）
            if(obstacleGrid[m-1][i]==1){
                break;
            }
            dp[m-1][i]=1;
        }
        // 在最后一列逆序遍历
        for(int i=m-1;i>=0;i--){
            // 当在最后一列任意位置遇到石头，直接结束循环，使还未遍历到的地方直接为0（因为int默认为0，直接结束，代表此位置0条路径，此路不通
            // 因为最后一列只能向下，但是此路径出现了石头）
            if(obstacleGrid[i][n-1]==1){
                break;
            }
            dp[i][n-1]=1;
        }
        // 除了最后一行，最后一列，其他的遍历顺序为按列逆序
        for (int j =n-2 ; j >=0; j--) {
            for (int i = m-2; i >=0; i--) {
                // 如果往下的位置和往右的位置都有石头，或者此位置就有石头，都是0条路径
                if((obstacleGrid[i+1][j]==1&&obstacleGrid[i][j+1]==1)||obstacleGrid[i][j]==1){
                    dp[i][j]=0;
                }
                // 如果往下有石头，只能向右
                else if(obstacleGrid[i+1][j]==1){
                    dp[i][j]=dp[i][j+1];
                }
                // 如果往右有石头，只能向下
                else if(obstacleGrid[i][j+1]==1){
                    dp[i][j]=dp[i+1][j];
                }
                // 以上都不满足才可以有往下或往右两种选择
                else {
                    dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
                }
            }
        }
        // 返回从0，0点到达终点的路径数量
        return dp[0][0];
    }
}
