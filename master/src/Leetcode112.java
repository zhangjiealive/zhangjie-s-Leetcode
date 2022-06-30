//: Leetcode112.java

import java.util.*;

/** 力扣112题路径总和 https://leetcode.cn/problems/path-sum/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode112 {
    /**
     * 递归方法
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null){
            return false;
        }
        if(root.left==null&&root.right==null){
            return root.val==targetSum;
        }
        return hasPathSum(root.left,targetSum-root.val)||hasPathSum(root.right,targetSum-root.val);
    }
    Set<Integer> set=new HashSet<>();
    int count=0;
    public boolean hasPathSum1(TreeNode root, int targetSum) {
        hasPathSumHelp(root,targetSum);
        if(set.contains(targetSum)){
            return true;
        }
        return false;
    }

    /**
     * 回溯算法：需要在什么时候加入节点？
     * result = []
     * def backtrack(路径, 选择列表):
     *     if 满足结束条件:
     *         result.add(路径)
     *         return
     *
     *     for 选择 in 选择列表: 包含所有的选择
     *         做选择
     *         backtrack(路径, 选择列表)
     *         撤销选择
     * @param root
     * @param targetSum
     */
    public void hasPathSumHelp(TreeNode root, int targetSum) {
        if(root==null){
            return ;
        }
        if(root.left==null&&root.right==null){
            set.add(count+root.val);
            return;
        }
        if(root.left!=null){
            count+=root.val;
            hasPathSumHelp(root.left,targetSum);
            count-=root.val;
        }
        if(root.right!=null){
            count+=root.val;
            hasPathSumHelp(root.right,targetSum);
            count-=root.val;
        }

    }


    public static void main(String[] args) {
        Leetcode112 leetcode112 = new Leetcode112();
        TreeNode t9 = new TreeNode(1);
        TreeNode t8 = new TreeNode(2);
        TreeNode t7 = new TreeNode(7);
        TreeNode t6 = new TreeNode(4,null,t9);
        TreeNode t5 = new TreeNode(13);
        TreeNode t4 = new TreeNode(11,t7,t8);
        TreeNode t3 = new TreeNode(8,t5,t6);
        TreeNode t2 = new TreeNode(4,t4,null);
        TreeNode t1 = new TreeNode(5,t2,t3);
        leetcode112.hasPathSum1(t1,22);
    }
}
