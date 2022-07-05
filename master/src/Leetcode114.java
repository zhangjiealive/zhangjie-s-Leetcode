//: Leetcode114.java

/** 力扣114题二叉树展开为链表 https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode114 {
    /**
     * 通过分解问题的递归
     * @param root
     */
    // 此函数意为输入一个节点，而后此函数将此二叉树展开为一个链表
    public void flatten(TreeNode root) {
        if(root==null){
            return;
        }
        // 分解问题，先将左子树展开为一个链表
        flatten(root.left);
        // 分解问题，再将右子树展开为一个链表
        flatten(root.right);
        // 此时当作真的已经转换成功，思考接下来要做的

        // 题目意为前序遍历，将所有节点插到右子树
        // left保存左子树的地址
        TreeNode left=root.left;
        // right保存右子树的地址
        TreeNode right=root.right;
        // 全部插到右子树，所以左子树为空
        root.left=null;
        // 将原本的左子树差到右子树的位置上
        root.right=left;

        // 回到根节点
        TreeNode p=root;
        // 一直往右子树找
        while (p.right!=null){
            p=p.right;
        }
        // 而后把原本右子树的地址接到原本最后一个左子树的右子树上
        p.right=right;
    }
}
