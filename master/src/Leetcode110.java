/** 110. 平衡二叉树 https://leetcode.cn/problems/balanced-binary-tree/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode110 {
    /**
     * 判断是否是平衡二叉树
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        // 当root为空，就是平衡二叉树
        if(root==null){
            return true;
        }
        // 左侧深度
        int left=DFS(root.left);
        // 右侧深度
        int right=DFS(root.right);
        // 左右两侧深度差小于2就是平衡二叉树，在递归调用判断左子树和右子树的是否是平衡二叉树
        return Math.abs(left-right)<2&& isBalanced(root.left) && isBalanced(root.right);
    }

    /**
     * DFS深度优先遍历
     * @param root
     * @return
     */
    public int DFS(TreeNode root){
        // base case 递归出口，当root为null返回0，意思为深度为0
        if(root==null){
            return 0;
        }
        // 递归左子树
        int left=DFS(root.left);
        // 递归右子树
        int right=DFS(root.right);
        // 在左子树和右子树的最大值上+1
        return Math.max(left,right)+1;
    }
}
