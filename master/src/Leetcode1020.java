/** 1020. 飞地的数量 https://leetcode.cn/problems/number-of-enclaves/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode1020 {
    int n;
    int m;
    int count=0;

    /**
     * 题意：计算所有不在边界的岛屿的面积
     * 用两个dfs方法，一个只负责淹，一个负责计数
     * 用淹的方法把在在边界的岛屿都淹了
     * 在用计数的方法，对剩余的陆地进行计数
     * @param grid
     * @return
     */
    public int numEnclaves(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        // 把在边界的岛屿都淹了
        for (int j = 0; j < m; j++) {
            if (grid[0][j] == 1) {
                dfs1(grid, 0, j);
            }
            if (grid[n - 1][j] == 1) {
                dfs1(grid, n - 1, j);
            }
        }
        // 把在边界的岛屿都淹了
        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 1) {
                dfs1(grid, i, 0);
            }
            if (grid[i][m - 1] == 1) {
                dfs1(grid, i, m - 1);
            }
        }

        // 对剩下的用计数dfs进行计数
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    // 计数的方法
    public void dfs(int[][] grid,int i,int j){
        if(i<0||j<0||i>=n||j>=m){
            return;
        }
        if(grid[i][j]==0){
            return;
        }
        grid[i][j]=0;
        count++;
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
    }

    // 淹的方法
    public void dfs1(int[][] grid,int i,int j){
        if(i<0||j<0||i>=n||j>=m){
            return;
        }
        if(grid[i][j]==0){
            return;
        }
        grid[i][j]=0;
        dfs1(grid,i,j+1);
        dfs1(grid,i,j-1);
        dfs1(grid,i+1,j);
        dfs1(grid,i-1,j);
    }
}
