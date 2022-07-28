/** 62. 不同路径 https://leetcode.cn/problems/unique-paths/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode62 {
    /**
     * 自底向上的动态规划
     * 求路径的数量，只能向下和向右走
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        // dp数组，dp[i][j]意为，i行，j列到终点的路径数量
        int[][] dp=new int[m][n];
        // base case 当行为最后一行，只能往右走，只有一种方式
        for(int i=n-1;i>=0;i--){
            dp[m-1][i]=1;
        }
        //base case 当列为最后一列，只能往下走，只有一种方式
        for(int i=m-1;i>=0;i--){
            dp[i][n-1]=1;
        }
        // 除了最后一行，最后一列，其他的遍历顺序为按列逆序
        for (int j =n-2 ; j >=0; j--) {
            for (int i = m-2; i >=0; i--) {
                // dp[i][j]由dp[i+1][j]+dp[i][j+1]转移而来，意为有往下走和往右走两种选择
                dp[i][j]=dp[i+1][j]+dp[i][j+1];
            }
        }
        // 返回从0，0点到达终点的路径数量
        return dp[0][0];
    }

    public static void main(String[] args) {
        Leetcode62 leetcode62 = new Leetcode62();
        leetcode62.uniquePaths(1,1);
    }
}
