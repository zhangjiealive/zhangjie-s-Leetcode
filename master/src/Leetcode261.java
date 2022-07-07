/** 力扣261. 以图判树 https://leetcode.cn/problems/graph-valid-tree/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode261 {
    /**
     * 利用并查集，构建树，如果两个点在连接前已经连通，则成环直接返回false
     * 如果最后只有一个连通子图则是树返回true
     * 最小生成树问题
     * 关联1135，1584
     * @param n
     * @param edges
     * @return
     */
    public boolean validTree(int n, int[][] edges) {
        UF uf = new UF(n);
        for (int[] a: edges) {
            int from=a[0];
            int to=a[1];
            if(uf.connected(from,to)){
                return false;
            }
            else {
                uf.union(from,to);
            }
        }
        return uf.count()==1;
    }
}
