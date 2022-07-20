/** 695. 岛屿的最大面积 https://leetcode.cn/problems/max-area-of-island/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode695 {
    int n;
    int m;

    /**
     * 计算最大岛屿的面积
     * @param grid
     * @return
     */
    public int maxAreaOfIsland(int[][] grid) {
        n=grid.length;
        m=grid[0].length;
        int max=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 对所有点dfs，取最大值
                max=Math.max(max,dfs(grid,i,j));
            }
        }
        return max;
    }

    // dfs，返回此点加上下左右的陆地数量
    public int dfs(int[][] grid,int i,int j){
        // 递归出口，超出边界
        if(i<0||j<0||i>=n||j>=m){
            return 0;
        }
        // 递归出口，此点为海洋
        if(grid[i][j]==0){
            return 0;
        }
        // 将此点淹了
        grid[i][j]=0;
        // 递归去上下左右继续dfs，在返回值+1，因为此点是陆地
        return dfs(grid,i,j+1)+dfs(grid,i,j-1)+dfs(grid,i+1,j)+dfs(grid,i-1,j)+1;
    }
}
