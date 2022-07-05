//: Leetcode654.java

/** 力扣654题最大二叉树 https://leetcode.cn/problems/maximum-binary-tree/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode654 {
    /**
     * 分解问题的递归思想
     * 此函数给定一个数组，返回一个节点
     * 关联105，106，889
     * @param nums
     * @return
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTreeHelp(nums,0,nums.length-1);
    }

    /**
     * 在区间内找最大值，作为根节点
     * 在根节点左右两侧在递归寻找根节点
     * @param nums
     * @param start
     * @param end
     * @return
     */
    public TreeNode constructMaximumBinaryTreeHelp(int[] nums,int start,int end) {
        // 当start>end时区间已经没有数了
        if(start>end){
            return null;
        }
        // 先把最大值置为Integer最小值
        int max=Integer.MIN_VALUE;
        // 下标
        int index=-1;
        // 找最大值，并更新下标
        for (int i = start; i <= end; i++) {
            if(nums[i]>max){
                index=i;
                max=nums[i];
            }
        }
        // 建立用区间内最大值构建根节点
        TreeNode treeNode=new TreeNode(max);
        // 在用最大值的左边区间构建左子树（递归过程）每次都把一个小的区间，看作重新构建一个二叉树
        treeNode.left=constructMaximumBinaryTreeHelp(nums,start,index-1);
        // 在用最大值的右边区间构建右子树（递归过程）
        treeNode.right=constructMaximumBinaryTreeHelp(nums,index+1,end);
        return treeNode;
    }
}
