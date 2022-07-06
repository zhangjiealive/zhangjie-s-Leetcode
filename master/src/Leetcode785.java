import java.util.LinkedList;
import java.util.Queue;

/** 785. 判断二分图 https://leetcode.cn/problems/is-graph-bipartite/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode785 {
    // 访问标志数组
    boolean[] visited;
    // 颜色标志
    boolean[] color;
    // 是否是二分图的标志
    boolean remark;

    /**
     * DFS判断二分图，都是使用了涂色发
     * @param graph
     * @return
     */
    public boolean isBipartite(int[][] graph) {
        int n= graph.length;
        visited=new boolean[n];
        color=new boolean[n];
        remark=true;
        // 从所有点开始遍历，因为可能不是连通图
        for (int i = 0; i < n; i++) {
            isBipartiteHelp(graph,i);
        }
        return remark;
    }

    public void isBipartiteHelp(int[][] graph,int s) {
        // 如果remark已经为false了，直接返回
        if(!remark){
            return;
        }
        // s的访问标志置为true
        visited[s]=true;
        // 遍历s的邻接点
        for (int a: graph[s]) {
            // 如果他们没被访问过，给他们和s相反的颜色
            if(!visited[a]){
                color[a]=!color[s];
                // 在从其中的邻接点开始遍历
                isBipartiteHelp(graph,a);
            }
            else {
                // 如果已经被访问过了，并且颜色与s相同，代表不是二分图
                if(color[s]==color[a]){
                    remark=false;
                }
            }
        }
    }

    /**
     * BFS方法解决二分图
     * @param graph
     * @return
     */
    public boolean isBipartite1(int[][] graph) {
        int n= graph.length;
        visited=new boolean[n];
        color=new boolean[n];
        remark=true;
        for (int i = 0; i < n; i++) {
            if(!visited[i]){
                bfs(graph,i);
            }
        }
        return remark;
    }

    public void bfs(int[][] graph,int start){
        Queue<Integer> q=new LinkedList<>();
        visited[start]=true;
        q.offer(start);
        while (!q.isEmpty()&&remark){
            int a=q.poll();
            for (int w : graph[a]) {
                if(!visited[w]){
                    color[w]=!color[a];
                    visited[w]=true;
                    q.offer(w);
                }
                else {
                    if(color[w]==color[a]){
                        remark=false;
                    }
                }
            }
        }
    }

    public boolean isBipartite2(int[][] graph) {
        int n= graph.length;
        visited=new boolean[n];
        color=new boolean[n];
        remark=true;
        Queue<Integer> q=new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if(!visited[i]){
                visited[i]=true;
                q.offer(i);
                while (!q.isEmpty()&&remark){
                    int a=q.poll();
                    for (int w : graph[a]) {
                        if(!visited[w]){
                            color[w]=!color[a];
                            visited[w]=true;
                            q.offer(w);
                        }
                        else {
                            if(color[w]==color[a]){
                                remark=false;
                            }
                        }
                    }
                }
            }
        }
        return remark;
    }

    public static void main(String[] args) {
        Leetcode785 leetcode785 = new Leetcode785();
        int[][] a={{1,3},{0,2},{1,3},{0,2}};
        leetcode785.isBipartite1(a);
    }

}
