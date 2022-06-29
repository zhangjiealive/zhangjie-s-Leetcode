package likou;
//: Leetcode111.java

/** 力扣111题二叉树的最小深度 https://leetcode.cn/problems/minimum-depth-of-binary-tree/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode111 {
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        if(root.right==null&&root.left==null){
            return 1;
        }
        int res=Integer.MAX_VALUE;
        if(root.left!=null){
            res=Math.min(minDepth(root.left),res);
        }
        if(root.right!=null){
            res=Math.min(minDepth(root.right),res);
        }
        return res+1;
    }

}
