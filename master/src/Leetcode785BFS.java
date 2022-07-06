import java.util.LinkedList;
import java.util.Queue;

public class Leetcode785BFS {
    /**
     * BFS方法判定二分图
     * @param graph
     * @return
     */
    public boolean isBipartite(int[][] graph) {
        int n= graph.length;
        boolean[] visited=new boolean[n];
        boolean[] color=new boolean[n];
        boolean remark=true;
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
}
