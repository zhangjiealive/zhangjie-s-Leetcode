import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Dijkstra {
    class State{
        int id;
        int distFromStart;

        public State(int id, int distFromStart) {
            // 图节点的id
            this.id = id;
            // 从start节点到当前节点的距离
            this.distFromStart = distFromStart;
        }
    }

    public int[] dijkstra(int start,List<int[]>[] graph){
        int v= graph.length;
        // 记录最短路径的权值，可以理解为dp table
        // distTo[i]的值就是节点start到达节点i的最短路径权重
        int[] distTo=new int[v];
        // 求最小值所以填充正无穷
        Arrays.fill(distTo,Integer.MAX_VALUE);
        // start到start的权值为0
        distTo[start]=0;
        // 优先级队列，根据distFromStart大小排，小的在前面
        Queue<State> pq=new PriorityQueue<>((a,b)->(a.distFromStart-b.distFromStart));
        // 从起点start开始BFS
        pq.offer(new State(start,0));
        while (!pq.isEmpty()){
            State curState=pq.poll();
            int curNodeID= curState.id;;
            int curDistFromStart=curState.distFromStart;

            if(curDistFromStart>distTo[curNodeID]){
                // 如果已经有一条更短的路径到达curNode节点了
                continue;
            }
            // 邻接表表示，graph[i]为i点的邻接点，因为有权值所以取出来应该还是数组，我默认将nextNodeID[0]为节点名，nextNodeID[1]为这条边的权值
            for (int[] nextNodeID:graph[curNodeID]) {
                // 到这个点的权值应该等于到上个点的最短的权值加上上个点到这个点的边的权值
                int distToNextNode=distTo[curNodeID]+nextNodeID[1];
                // 如果保存最短权值的数组中，此位置的值比本次的大，代表数组中的已经不是最短权值了
                if(distTo[nextNodeID[0]]>distToNextNode){
                    // 进行更新
                    distTo[nextNodeID[0]]=distToNextNode;
                    // 并将此进入队列，因为他是最小的，他更新了最小权值的数组，默认走最小的路径，到下一个节点应该也是最小的（贪心策略）
                    pq.offer(new State(nextNodeID[0],distToNextNode));
                }
                // 如果本次的值比数组中的最短路径大，不进行任何操作
            }
        }
        return distTo;
    }
}
