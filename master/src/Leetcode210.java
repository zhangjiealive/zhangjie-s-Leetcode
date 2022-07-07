import java.util.*;

/** 力扣210. 课程表 II https://leetcode.cn/problems/course-schedule-ii/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode210 {
    // 记录遍历过的节点，防止走回头路
    boolean[] visited;
    // 记录一次递归堆栈中的节点
    boolean[] onPath;
    // 记录是否有环标志位
    boolean remark=false;
    List<Integer> res=new ArrayList<>();

    /**
     * DFS找拓扑序列（有向无环图），找拓扑序列看看是否有环
     * 拓扑序列是后序遍历的逆置
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        visited=new boolean[numCourses];
        onPath=new boolean[numCourses];
        List<Integer>[] graph=buildGraph(numCourses,prerequisites);
        for (int i = 0; i < numCourses; i++) {
            // 所有课程挨个遍历，因为是有向图
            canFinishHelp(i,graph);
        }
        // 如果有环，拓扑序列为空
        if(remark){
            return new int[]{};
        }
        // 无环则逆置后续序列
        Collections.reverse(res);
        // 将结果按照要求结构返回
        int[] r=new int[res.size()];
        for (int i = 0; i < r.length; i++) {
            r[i]=res.get(i);
        }
        return r;
    }
    public void canFinishHelp(int s, List<Integer>[] graph) {
        // 判断这一次递归堆栈是否遍历过，遍历过代表有环，标志位置true
        if(onPath[s]){
            remark=true;
        }
        // 如果访问过或者有环，直接跳过这次递归
        if(visited[s]||remark){
            return;
        }
        // 访问位置true
        visited[s]=true;
        // 递归堆栈置true
        onPath[s]=true;
        // 从s可以走的路径重新遍历
        for (int a : graph[s]) {
            canFinishHelp(a,graph);
        }
        res.add(s);
        // 后置位置，堆栈遍历是否遍历置false
        onPath[s]=false;
    }

    /**
     * BFS找拓扑序列
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public int[] findOrder1(int numCourses, int[][] prerequisites) {
        // 初始建图
        List<Integer>[] graph=buildGraph(numCourses,prerequisites);
        int[] res=new int[numCourses];
        // 记录入度
        int[] indegree=new int[numCourses];
        // 计算各个节点的入度，并加入数组
        for (int[] edge:prerequisites) {
            int from=edge[1];
            int to=edge[0];
            indegree[to]++;
        }
        Queue<Integer> q=new LinkedList<>();
        // 将没有入度的当作入口开始遍历
        for (int i = 0; i < numCourses; i++) {
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        // 初始化count
        int count=0;
        while (!q.isEmpty()){
            int cur=q.poll();
            // 弹出栈的顺序就是拓扑序列
            // 因为每次进栈的节点，都是没有入度的节点
            res[count]=cur;
            // 计数遍历节点的个数
            count++;
            for (int next:graph[cur]) {
                // 根据目前cur的出度，将对应的入度值减小
                indegree[next]--;
                // 直到入度为0在加入队列，从该节点开始遍历
                if(indegree[next]==0){
                    q.offer(next);
                }
            }
        }
        if(count==numCourses) return res;
        return new int[]{};
    }
    /**
     * 初始建图
     * 被依赖关系，从小到大，0-1意为想要到1，需要0
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public List<Integer>[] buildGraph(int numCourses,int[][] prerequisites){
        List<Integer>[] graph=new LinkedList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i]=new LinkedList<>();
        }
        for (int[] edge:prerequisites) {
            int from=edge[1],to=edge[0];
            graph[from].add(to);
        }
        return graph;
    }
}
