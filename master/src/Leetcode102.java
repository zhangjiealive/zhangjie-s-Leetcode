//: Leetcode102.java

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/** 力扣102题二叉树的层序遍历 https://leetcode.cn/problems/binary-tree-level-order-traversal/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> deque=new LinkedList<>();
        List<List<Integer>> res=new LinkedList<>();
        if(root==null){
            return res;
        }
        deque.offer(root);
        while (!deque.isEmpty()){
            int size=deque.size();
            List<Integer> track=new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode=deque.poll();
                track.add(treeNode.val);
                if(treeNode.left!=null){
                    deque.offer(treeNode.left);
                }
                if(treeNode.right!=null){
                    deque.offer(treeNode.right);
                }
            }
            res.add(track);
        }
        return res;
    }
}
