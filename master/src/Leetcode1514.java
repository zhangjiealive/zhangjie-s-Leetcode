import java.util.*;

/** 1514. 概率最大的路径 https://leetcode.cn/problems/path-with-maximum-probability/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode1514 {

    class State{
        int id;
        // 因为题目给出的是double值概率
        double distFromStart;

        public State(int id, double distFromStart) {
            // 图节点的id
            this.id = id;
            // 从start节点到当前节点的距离
            this.distFromStart = distFromStart;
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<double[]>[] graph=bulidGraph(n,edges,succProb);
        int v=n;
        // 构建最大概率数组
        double[] successProb=new double[v];
        // 因为是要最大概率所以先填充不可能的值
        Arrays.fill(successProb,-1);
        // 起点的概率默认为0
        successProb[start]=0;
        // 使用优先队列，递减排列，大的在前小的在后（因为是求概率最大值，所以默认取出概率最大的）
        Queue<State> pq=new PriorityQueue<>((a,b)-> {
            return Double.compare(b.distFromStart,a.distFromStart);
        });
        // 先将起点放入队列
        pq.offer(new State(start,0));
        while (!pq.isEmpty()){
            State curState=pq.poll();
            int curNodeID= curState.id;
            double curDistFromStart=curState.distFromStart;
            // 如果当前队列取出的点就是终点
            if(curNodeID==end){
                // 直接返回此点的最大概率
                return curDistFromStart;
            }
            if(curDistFromStart<successProb[curNodeID]){
                // 如果已经有一条概率更大的路径到达curNode节点了，跳过
                continue;
            }
            // 将该点的邻接点挨个进行计算
            for (double[] edge: graph[curNodeID]) {
                double distToNextNode;
                // 如果该点不为起点，此邻接点的成功率为出发点的成功率与此条路径的成功率相乘
                if(successProb[curNodeID]!=0){
                    distToNextNode=successProb[curNodeID]*edge[1];
                }
                // 如果该点为起点，此邻接点的成功率为此条路径的成功率
                else {
                    distToNextNode=edge[1];
                }
                // 如果此条新路径的成功率大于数组中的成功率
                if(successProb[(int)edge[0]]<distToNextNode){
                    // 则进行更新
                    successProb[(int)edge[0]]=distToNextNode;
                    // 并将此进入队列，因为他是最大的，他更新了最大权值的数组，默认走最大的路径，到下一个节点应该也是最大的（贪心策略）
                    pq.offer(new State((int)edge[0],distToNextNode));
                }
            }
        }
        return successProb[end]==-1?0:successProb[end];
    }

    /**
     * 根据题意建立图的邻接表
     * @param n
     * @param make
     * @param succProb
     * @return
     */
    public List<double[]>[] bulidGraph(int n,int[][] make,double[] succProb){
        List<double[]>[] graph=new LinkedList[n];
        for (int i = 0; i < n; i++) {
            graph[i]=new LinkedList<>();
        }
        int i=0;
        for (int[] edge : make) {
            double from=edge[0];
            double to=edge[1];
            double weight=succProb[i++];
            graph[(int)from].add(new double[]{to,weight});
            graph[(int)to].add(new double[]{from,weight});
        }
        return graph;
    }

    public static void main(String[] args) {
        Leetcode1514 leetcode1514 = new Leetcode1514();
        int[][] a={{0,1}};
        double[] b= {0.5};
        leetcode1514.maxProbability(3,a,b,0,2);
    }
}
