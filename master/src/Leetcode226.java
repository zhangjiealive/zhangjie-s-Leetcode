//226. 翻转二叉树

/** 力扣26题 https://leetcode.cn/problems/invert-binary-tree/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode226 {
    /**
     * 递归，通过交换每个二叉树的左右子树，达到翻转的效果
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        invertTreeHelp(root);
        return root;
    }
    public void invertTreeHelp(TreeNode root) {
        if(root==null){
            return;
        }
        invertTreeHelp(root.left);
        invertTreeHelp(root.right);
        TreeNode temp = root.left;
        root.left=root.right;
        root.right=temp;
    }

}
