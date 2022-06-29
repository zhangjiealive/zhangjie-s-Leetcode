import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BFS1 {
    /**
     * 利用BFS计算从start到target的距离
     * @param start
     * @param target
     * @return
     */
    public int BFS(TreeNode start,TreeNode target){
        Queue<TreeNode> queue=new LinkedList<>();
        Set<TreeNode> visited=new HashSet<>();
        queue.offer(start);
        visited.add(start);
        int step=0;
        while (!queue.isEmpty()){
            int size= queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode=queue.poll();
                if(treeNode==target&&treeNode.equals(target)){
                    return step;
                }
                // 这个new TreeNode[2]代表接下来可以走的几个地方
                for (TreeNode a :new TreeNode[2]) {
                    if(!visited.contains(a)){
                        queue.offer(a);
                        visited.add(a);
                    }
                }
            }
            step++;
        }
        return step;
    }
}
