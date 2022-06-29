//144. 二叉树的前序遍历

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
// 二叉树的前序遍历  思想：将所有节点当成新二叉树
/** 力扣144题 https://leetcode.cn/problems/binary-tree-preorder-traversal/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<Integer> integers = new LinkedList<>();
        preorderTraversalHelp(root,integers);
        return integers;
    }
    public void preorderTraversalHelp(TreeNode root,List<Integer> integers){  // 递归算法
        if(root!=null){
            integers.add(root.val);
            preorderTraversalHelp(root.left,integers);
            preorderTraversalHelp(root.right,integers);
        }
    }

    /**先往左边找，不为空就放进链表，为空就将栈顶出栈，往右边找，不空就放进链表循环此操作，达到中左右的遍历顺序
     *
     * @param root
     * @param integers
     */

    public void preorderTraversalHelp1(TreeNode root,List<Integer> integers){  // 非递归算法
        Stack<TreeNode> treeNodes = new Stack<>();
        while(root!=null||!treeNodes.isEmpty()){
            if(root!=null){
                integers.add((root.val));
                treeNodes.push(root);
                root=root.left;
            }
            else {
                root=treeNodes.pop();
                root=root.right;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode t7 = new TreeNode(7);
        TreeNode t6 = new TreeNode(6);
        TreeNode t5 = new TreeNode(5);
        TreeNode t4 = new TreeNode(4);
        TreeNode t3 = new TreeNode(3,t6,t7);
        TreeNode t2 = new TreeNode(2,t4,t5);
        TreeNode t1 = new TreeNode(1,t2,t3);
        Leetcode144 leetcode144 = new Leetcode144();
        leetcode144.preorderTraversal(t1);
        System.out.println(t1.NodeCount(t1));
        t1.levelOrder(t1);
    }
}
