import java.util.LinkedList;
import java.util.List;

/** 886. 可能的二分法 https://leetcode.cn/problems/possible-bipartition/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode886 {
    boolean[] color;
    boolean[] visited;
    boolean remark;

    /**
     * 通过涂色法解决二分图，关联785
     * 注意本题标志从1开始，所以在构造图时就把每个减去1
     * 涂色法核心思想：让一个节点的所有邻接点都与节点是不同的颜色，如果链接点与节点存在相同的颜色了，代表不是二分图
     * @param n
     * @param dislikes
     * @return
     */
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<Integer>[] graph=buildGraph(n,dislikes);
        // 访问标志数组
        visited=new boolean[n];
        // 颜色标志数组
        color=new boolean[n];
        remark=true;
        for (int i = 0; i < n; i++) {
            // 因为可能不是连通图，所以在所有节点上都进行dfs
            possibleBipartitionHelp(i,graph);
        }
        return remark;
    }

    public void possibleBipartitionHelp(int a, List<Integer>[] graph) {
        if(!remark){
            return;
        }
        visited[a]=true;
        for (int s: graph[a]) {
            // 如果邻接点列表中的节点没访问过
            if(!visited[s]){
                // 则将邻接点颜色置为此节点的反
                color[s]=!color[a];
                // 在邻接点上dfs遍历
                possibleBipartitionHelp(s,graph);
            }
            else {
                // 如果节点和邻接点的颜色相同，则不是二分图
                if(color[s]==color[a]){
                    remark=false;
                }
            }
        }
    }

    public List<Integer>[] buildGraph(int n,int[][] matrix){
        List<Integer>[] graph=new LinkedList[n];
        for (int i = 0; i < n; i++) {
            // 每个list数组位置新建一个LinkedList
            graph[i]=new LinkedList<>();
        }
        // 从题目给的表中构建图
        for (int[] edge : matrix) {
            int from=edge[1];
            int to=edge[0];
            // 无向图就是双向的，两边互相构建即可
            graph[from].add(to);
            graph[to].add(from);
        }
        return graph;
    }
}
