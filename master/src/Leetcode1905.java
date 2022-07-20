/** 1905. 统计子岛屿 https://leetcode.cn/problems/count-sub-islands/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode1905 {
    int n;
    int m;

    /**
     * 思路：当grid2为陆地的位置grid1为海洋，则此岛屿一定不是子岛屿，直接淹了
     * 剩下的就是子岛屿
     * @param grid1
     * @param grid2
     * @return
     */
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        n=grid1.length;
        m=grid1[0].length;
        int count=0;
        // 把grid2中是陆地，grid1中是海洋的岛屿在grid2中全部淹了
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(grid2[i][j]==1&&grid1[i][j]==0){
                    dfs(grid2,i,j);
                }
            }
        }
        // 对剩余的岛屿计数
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(grid2[i][j]==1){
                    count++;
                    dfs(grid2,i,j);
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
        if(grid[i][j]==0){
            return;
        }
        grid[i][j]=0;
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
    }
}
