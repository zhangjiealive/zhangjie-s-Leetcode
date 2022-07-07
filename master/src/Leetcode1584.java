import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** 力扣1584. 连接所有点的最小费用 https://leetcode.cn/problems/min-cost-to-connect-all-points/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode1584 {
    /**
     * 思路:先根据给出的点坐标计算边的权值，然后利用并查集连通并计算最小费用
     * Kruskal最小生成树算法 选最小的边
     * 关联261，1135
     * 最小生成树问题
     * @param points
     * @return
     */
    public int minCostConnectPoints(int[][] points) {
        int n=points.length;
        List<int[]> graph=new ArrayList<>();
        // 根据题意计算两点间边的权值
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int xi=points[i][0];
                int yi=points[i][1];
                int xj=points[j][0];
                int yj=points[j][1];
                graph.add(new int[]{i,j,Math.abs(xi-xj)+Math.abs(yi-yj)});
            }
        }
        // 根据权值排序
        Collections.sort(graph,(a,b)-> {
            return (a[2] - b[2]);
        });

        int count=0;
        UF uf = new UF(n);
        for (int[] a: graph) {
            int u=a[0];
            int v=a[1];
            if(uf.connected(u,v)){
                continue;
            }
            else {
                uf.union(u,v);
                count+=a[2];
            }
        }
        return count;
    }
}
