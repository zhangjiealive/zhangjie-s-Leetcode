//222. 完全二叉树的节点个数

/** 力扣222题 https://leetcode.cn/problems/count-complete-tree-nodes/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode222 {
    /**
     * 先计算左子树和右子树的深度，深度相同当成满二叉树处理，不同的话递归执行左子树右子树+1
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        TreeNode l=root;
        TreeNode r=root;
        int hl=0;
        int hr=0;
        while (l!=null){
            l=l.left;
            hl++;
        }
        while (r!=null){
            r=r.right;
            hr++;
        }
        if(hl==hr){
            return (int) Math.pow(2,hl)-1;
        }
        return 1+countNodes(root.left)+countNodes(root.right);
    }
}
