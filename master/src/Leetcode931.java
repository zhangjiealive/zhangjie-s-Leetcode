import java.util.Arrays;

/** 931. 下降路径最小和 https://leetcode.cn/problems/minimum-falling-path-sum/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode931 {
    // 备忘录
    int[][] memo;

    /**
     * 动态规划（自顶向下的递归）
     * 从第一行任意一个元素到最后一行任意一个元素的最短路径
     * 思路：
     * base case：当从第0行到第0行的任意元素时，路径为matrix[0][j]
     * 状态：列不断向base case靠近
     *         选择：
     *         因为有三种选择，向下走，向左下走，向右下走
     *         dp(matrix, i-1, j)对应向下走
     *         dp(matrix,i-1,j-1)对应向左下走
     *         dp(matrix, i-1, j+1)对应向右下走
     * 通过递归到最底层，得到base case从而逐层返回计算
     * @param matrix
     * @return
     */
    public int minFallingPathSum(int[][] matrix) {
        // 矩阵的长和宽
        int n=matrix.length;
        // 创建对应大小的备忘录，每一格计算着从第一行任意元素到当前格的距离
        memo=new int[n][n];
        // 由于求最小值，预先设置为Integer的最大值
        int res=Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            // 数组填充为不可能的元素（为了区分备忘录中是否为有效值）
            Arrays.fill(memo[i],66666);
        }
        // 因为可以从第0行的任意一列出发，所以循环求出最小值
        for (int i = 0; i < n; i++) {
            res=Math.min(res,dp(matrix,n-1,i));
        }
        return res;
    }

    public int dp(int[][] matrix,int i,int j){
        // 防止数组下标越界产生错误的值
        if(i<0||j<0||i>=matrix.length||j>=matrix[0].length){
            return 66666;
        }
        // base case:当从第0行到第0行时，距离就为matrix[0][j]
        if(i==0){
            return matrix[0][j];
        }
        // 如果备忘录中当前格的结果是有效值，直接返回
        if(memo[i][j]!=66666){
            return memo[i][j];
        }
        /*
        将到一格的最小值存入备忘录(动态规划优化方法)
        选择：
        因为有三种选择，向下走，向左下走，向右下走
        dp(matrix, i-1, j)对应向下走
        dp(matrix,i-1,j-1)对应向左下走
        dp(matrix, i-1, j+1)对应向右下走
         */
        memo[i][j]= matrix[i][j]+Math.min(dp(matrix, i-1, j),Math.min(dp(matrix,i-1,j-1),dp(matrix, i-1, j+1)));
        // 返回备忘录中的值
        return memo[i][j];
    }
}
