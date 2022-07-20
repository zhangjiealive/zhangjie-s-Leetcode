/** 1254. 统计封闭岛屿的数目 https://leetcode.cn/problems/number-of-closed-islands/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode1254 {
    int n;
    int m;

    /**
     * 计算封闭岛屿的数量
     * 将所有在边界岛屿全部淹了，剩余的就是封闭的岛屿
     * @param grid
     * @return
     */
    public int closedIsland(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        int count = 0;
        // 把所有在边界的岛屿都淹了
        for (int j = 0; j < m; j++) {
            if (grid[0][j] == 0) {
                dfs(grid, 0, j);
            }
            if (grid[n - 1][j] == 0) {
                dfs(grid, n - 1, j);
            }
        }
        // 把所有在边界的岛屿都淹了
        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 0) {
                dfs(grid, i, 0);
            }
            if (grid[i][m - 1] == 0) {
                dfs(grid, i, m - 1);
            }
        }
        // 在计算剩余的岛屿数
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                if (grid[i][j] == 0) {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    // 二维矩阵的dfs，向上下左右蔓延
    public void dfs(int[][] grid,int i,int j){
        if(i<0||j<0||i>=n||j>=m){
            return;
        }
        if(grid[i][j]==1){
            return;
        }
        grid[i][j]=1;
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
    }
}
