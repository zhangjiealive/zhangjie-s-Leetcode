import java.util.List;
import java.util.PriorityQueue;

/**
 * Prim算法
 */
public class Prim {
    // 核心数据结构，优先队列
    private PriorityQueue<int[]> pq;
    // 是否访问标识位
    private boolean[] inMST;
    // 权重和
    private int weightSum=0;
    // graph是用邻接表表示的一幅图
    // graph[s]记录节点s所有相邻的边
    // 三元组int[]{from,to,weight}表示一条边
    private List<int[]>[] graph;

    /**
     * prim思想类似于BFS
     * 每次到达一个点后，都将此点加入进来，例如从0出发，可以到（2,3)
     * 从0-2，等于将2加入，现在可以从0或2出发，在0和2的横切边中在选取最小的，在将此点连通并加入，直到所有点连通
     * @param graph
     */
    public Prim(List<int[]>[] graph){
        this.graph=graph;
        // 保证优先队列队头最小
        this.pq=new PriorityQueue<>((a,b)-> {
            // 按照权重从小到大排列
            return (a[2] - b[2]);
        });
        // 节点数，因为图使用邻接表表示
        int n=graph.length;
        this.inMST=new boolean[n];
        // 从节点0开始，将访问表示位置true
        inMST[0]=true;
        // 将0节点的横切边加入优先队列
        cut(0);
        while (!pq.isEmpty()){
            // 从队列中拿出队头，也就是权值最小的
            int[] edge=pq.poll();
            int to=edge[1];
            int weight=edge[2];
            // 如果这条边的终点被访问过，则开始下一次循环
            if(inMST[to]){
                continue;
            }
            // 权值的和
            weightSum+=weight;
            // 在将本次走的点置true
            inMST[to]=true;
            // 再从这个点将横切边加入队列
            cut(to);
        }
    }

    private void cut(int s){
        // 在s的邻接点中找没有被访问过的
        for(int[] edge:graph[s]){
            int to=edge[1];
            // 如果被访问过则进行下一次循环
            if(inMST[to]){
                continue;
            }
            // 横切边终点没被访问过的，都加入队列
            pq.offer(edge);
        }
    }

    public int getWeightSum(){
        return weightSum;
    }

    public boolean allConnected(){
        // 判断整个图是否连通，就判断所有点是否都被走过了
        for (int i = 0; i < inMST.length; i++) {
            if(!inMST[i]){
                return false;
            }
        }
        return true;
    }
}
