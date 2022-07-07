//207. 课程表

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/** 力扣207题 https://leetcode.cn/problems/course-schedule/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode207 {
    // 记录遍历过的节点，防止走回头路
    boolean[] visited;
    // 记录一次递归堆栈中的节点
    boolean[] onPath;
    // 记录是否有环标志位
    boolean remark=false;
    /**
     * 基于DFS的环检测：判断是否有有环，用visited数组和onPath数组实现
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visited=new boolean[numCourses];
        onPath=new boolean[numCourses];
        List<Integer>[] graph=buildGraph(numCourses,prerequisites);
        for (int i = 0; i < numCourses; i++) {
            // 所有课程挨个遍历，因为是有向图
            canFinishHelp(i,graph);
        }
        return !remark;
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
        // 后置位置，堆栈遍历是否遍历置false
        onPath[s]=false;
    }
    // 基于DFS的环检测


    /**
     * 基于BFS的环检测
     * 计算入度，没有入度的节点，没有入度的节点才可以被遍历，否则会形成环
     * 如果遍历完了所有元素，则代表无环
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish1(int numCourses,int[][] prerequisites){
        // 初始建图
        List<Integer>[] graph=buildGraph(numCourses,prerequisites);
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
        // 最后遍历节点的个数count=numCourses的话，则遍历了整个图，代表图无环
        return count==numCourses;
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
