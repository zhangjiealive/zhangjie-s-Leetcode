import java.util.ArrayDeque;
import java.util.Deque;

/** 1161. 最大层内元素和 https://leetcode.cn/problems/maximum-level-sum-of-a-binary-tree/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode1161 {
    /**
     * 找元素和最大的层
     * 层序遍历，基于BFS，广度优先遍历
     * @param root
     * @return
     */
    public int maxLevelSum(TreeNode root) {
        // 核心数据结构：队列
        Deque<TreeNode> queue=new ArrayDeque<>();
        // 根节点加入队尾
        queue.addLast(root);
        // 找最大值预先取最小值
        int max=Integer.MIN_VALUE;
        // 记录深度
        int depth=1;
        // 记录结果
        int res=0;
        // 只要队列不为空
        while (!queue.isEmpty()){
            // 先计算这一层有多少节点
            int size=queue.size();
            // 累加和初始化
            int cur=0;
            // while循环，这一层有多少元素执行多少次，意为此层有多少根节点，执行多少次，要把下一层的都加入进队列
            while (size-->0){
                // 取队头
                TreeNode treeNode=queue.pollFirst();
                // 将队头取出节点的左子树加入
                if(treeNode.left!=null){
                    queue.addLast(treeNode.left);
                }
                // 将队头取出节点的右子树加入
                if(treeNode.right!=null){
                    queue.addLast(treeNode.right);
                }
                // 每一层计算累加
                cur=cur+treeNode.val;
            }
            // 如果大于max，对最大值和深度进行修改
            if(cur>max){
               res=depth;
               max=cur;
            }
            // 每层深度++
            depth++;
        }
        return res;
    }
}
