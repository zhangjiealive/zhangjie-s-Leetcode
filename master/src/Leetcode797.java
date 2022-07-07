//797. 所有可能的路径

import java.util.LinkedList;
import java.util.List;

/** 力扣797题 https://leetcode.cn/problems/all-paths-from-source-to-target/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode797 {
    List<List<Integer>> res=new LinkedList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        LinkedList<Integer> path=new LinkedList<>();
        allPathsSourceTargetHelp(graph,0,path);
        return res;
    }

    /**
     * 图的遍历
     * @param graph
     * @param s
     * @param path
     */
    public void allPathsSourceTargetHelp(int[][] graph,int s,LinkedList<Integer> path) {
        // 将节点加入
        path.addLast(s);
        // graph矩阵的长度，代表图中有多少元素，长度3，代表有3个元素
        int n= graph.length;
        // 当s==3-1时，代表已经遍历到n-1的位置，可以把本次遍历顺序加入res
        if(s==n-1){
            res.add(new LinkedList<>(path));
        }
        // 从本节点可选的路径中选一条进行DFS遍历
        for (int a : graph[s]) {
            allPathsSourceTargetHelp(graph,a,path);
        }
        // 在最后移除节点
        path.removeLast();
    }
}
