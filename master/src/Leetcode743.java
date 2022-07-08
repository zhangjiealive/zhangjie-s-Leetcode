import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/** 743. 网络延迟时间 https://leetcode.cn/problems/network-delay-time/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode743 {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] graph=bulidGraph(n,times);
        Dijkstra dijkstra = new Dijkstra();
        // 结果返回数组
        int[] res = dijkstra.dijkstra(k, graph);
        // 对数组进行排序
        Arrays.sort(res);
        // 因为填充的最大值，并且下标从1开始，0是废弃的，所以0必为最大值，所以排序后数组最后一位必为最大值，我们这时只需要判定倒数第二位是否为最大值
        // 如果为最大值，代表有目标不可达返回-1，不为最大值就正常返回倒数第二位
        return res[res.length-2]==Integer.MAX_VALUE?-1:res[res.length-2];
    }
    // 初始建图，根据题意
    public List<int[]>[] bulidGraph(int n,int[][] make){
        List<int[]>[] graph=new LinkedList[n+1];
        for (int i = 0; i < n+1; i++) {
            graph[i]=new LinkedList<>();
        }
        for (int[] edge : make) {
            int from=edge[0];
            int to=edge[1];
            int weight=edge[2];
            graph[from].add(new int[]{to,weight});
        }
        return graph;
    }

    public static void main(String[] args) {
        Leetcode743 leetcode743 = new Leetcode743();
        int[][] a={{2,1,1},{2,3,1},{3,4,1}};
        leetcode743.networkDelayTime(a,4,2);
    }
}
