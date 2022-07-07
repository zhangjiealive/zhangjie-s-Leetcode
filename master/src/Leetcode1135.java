import java.util.Arrays;
import java.util.Collections;

/** 力扣1135. 最低成本联通所有城市 https://leetcode.cn/problems/connecting-cities-with-minimum-cost/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode1135 {
    /**
     * 利用并查集，并将权值排序
     * Kruskal最小生成树算法 选最小的边
     * 关联261，1584
     * 最小生成树问题
     * @param n
     * @param connections
     * @return
     */
    public int minimumCost(int n, int[][] connections) {
        UF uf = new UF(n+1);
        // 根据权值排序
        Arrays.sort(connections,(a,b)-> {
            return (a[2] - b[2]);
        });
        int count=0;
        for (int[] edge:connections) {
            int u=edge[0];
            int v=edge[1];
            // 如果已经联通了，则跳过
            if(uf.connected(u,v)){
                continue;
            }
            else {
                // 如果没有联通，则将两点联通
                uf.union(u,v);
                count+=edge[2];
            }
        }
        // 因为城市序号是从1开始，所以有一个0节点是独立的，所以连通分量==2是正确
        return uf.count()==2?count:-1;
    }
}
