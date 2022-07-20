/** 200. 岛屿数量 https://leetcode.cn/problems/number-of-islands/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode200 {
    int n;
    int m;

    /**
     * 计算岛屿数量
     * 当遇到陆地，岛屿数+1,并用dfs把此陆地的所有邻接邻接的陆地都淹了
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        n=grid.length;
        m=grid[0].length;
        int count=0;
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <m ; j++) {
                // 当遇到陆地
                if(grid[i][j]=='1'){
                    // 岛屿数+1
                    count++;
                    // 并将此陆地，和邻接的陆地都淹了
                    dfs(grid,i,j);
                }
            }
        }
        return count;
    }

    // 二维矩阵的dfs，向上下左右蔓延
    public void dfs(char[][] grid,int i,int j){
        // 超出边界，直接返回
        if(i<0||j<0||i>=n||j>=m){
            return;
        }
        // 如果本来就是海洋，直接返回
        if(grid[i][j]=='0'){
            return;
        }
        // 把这里淹了，在去蔓延上下左右
            grid[i][j]='0';
            dfs(grid,i,j+1);
            dfs(grid,i,j-1);
            dfs(grid,i+1,j);
            dfs(grid,i-1,j);
    }
}
