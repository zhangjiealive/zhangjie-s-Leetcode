import com.sun.corba.se.pept.transport.ReaderThread;

import java.util.Arrays;

/** 64. 最小路径和 https://leetcode.cn/problems/course-schedule-ii/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode64 {
    /**
     * 动态规划：自底向上的迭代
     * 思路：只能向右和下走，可知dp[i][j]由dp[i-1][j]和dp[i][j-1]状态转移而来
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        // 构建dp数组
        int[][] dp=new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // base case:当目标值为原点，路径长度就为此点的权值
                if(i==0&&j==0){
                    dp[i][j]=grid[i][j];
                }
                // 边界情况最上边的一条边没有上侧元素，所以只能根据左侧转移而来
                else if(i==0&&j!=0){
                    dp[i][j]=dp[i][j-1]+grid[i][j];
                }
                // 边界情况最左边的一条边没有左侧元素，所以只能根据上方状态转移而来
                else if(j==0&&i!=0){
                    dp[i][j]=dp[i-1][j]+grid[i][j];
                }
                // 其余正常通过上侧和左侧元素中权值较小的转移而来
                else {
                    dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
                }
            }
        }
        return dp[n-1][m-1];
    }

    /**
     * 动态规划：自顶向上的递归
     */
    int[][] memo;
    public int minPathSum1(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        memo=new int[n][m];
        for (int[] a: memo) {
            Arrays.fill(a,-666);
        }
        return dp(grid,n-1,m-1);
    }

    public int dp(int[][] grid,int i,int j){
        // base case
        if(i==0&&j==0){
            memo[i][j]=grid[i][j];
            return memo[i][j];
        }
        // 当备忘录中为有效值，直接取出，避免重复计算
        if(memo[i][j]!=-666){
            return memo[i][j];
        }
        // 边界情况最上边的一条边没有上侧元素，所以只能根据左侧转移而来
        if(i==0&&j!=0){
            memo[i][j]=dp(grid,i,j-1)+grid[i][j];
        }
        // 边界情况最左边的一条边没有左侧元素，所以只能根据上方状态转移而来
        else if(j==0&&i!=0){
            memo[i][j]=dp(grid,i-1,j)+grid[i][j];
        }
        // 其余正常通过上侧和左侧元素中权值较小的转移而来
        else {
            memo[i][j]=Math.min(dp(grid,i-1,j),dp(grid,i,j-1))+grid[i][j];
        }
        return memo[i][j];
    }

    public static void main(String[] args) {
        Leetcode64 leetcode64 = new Leetcode64();
        int[][] a={
                {1,2,3},{4,5,6}};
        leetcode64.minPathSum(a);
    }
}
