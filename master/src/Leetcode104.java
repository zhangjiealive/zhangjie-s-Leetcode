package likou;
//: Leetcode104.java

/** 力扣104题 https://leetcode.cn/problems/maximum-depth-of-binary-tree/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode104 {
    int res = 0;
    // 记录遍历到的节点的深度
    int depth = 0;
    public int maxDepth(TreeNode root) {

        traverse(root);
        return res;
    }


    // 二叉树遍历框架
    public void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        // 前序位置
        depth++;
        if (root.left == null && root.right == null) {
            // 到达叶子节点，更新最大深度
            res = Math.max(res, depth);
        }
        traverse(root.left);
        traverse(root.right);
        // 后序位置
        depth--;

    }

    public static void main(String[] args) {
        TreeNode t5 = new TreeNode(7);
        TreeNode t4 = new TreeNode(15);
        TreeNode t3 = new TreeNode(20,t4,t5);
        TreeNode t2 = new TreeNode(9);
        TreeNode t1 = new TreeNode(3,t2,t3);
        Leetcode104 leetcode104 = new Leetcode104();
        leetcode104.maxDepth(t1);
    }
}
