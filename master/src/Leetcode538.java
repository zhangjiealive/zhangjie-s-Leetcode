//: Leetcode538.java

/** 力扣538. 把二叉搜索树转换为累加树 https://leetcode.cn/problems/convert-bst-to-greater-tree/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode538 {
    /**
     * 二叉搜索树中序遍历是递增，因为先遍历左子树，二叉搜索树的特性是右>中>左，如果想递减遍历的话只需要先递归遍历right
     * 使用一个count计算val的和，解决问题
     * @param root
     * @return
     */
    public TreeNode convertBST(TreeNode root) {
        TreeNode treeNode=root;
        convertBSTHelp(root);
        return root;
    }
    int count=0;
    public void convertBSTHelp(TreeNode root) {
        if(root==null){
            return;
        }
        convertBSTHelp(root.right);
        count+=root.val;
        root.val=count;
        convertBSTHelp(root.left);
    }
}
