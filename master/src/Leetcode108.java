/** 108. 将有序数组转换为二叉搜索树 https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return DFS(nums,0,nums.length-1);
    }

    /**
     * 深度优先遍历
     * 递归思维 思路：二叉搜索树的中序遍历一定为升序，因此题目给你一个有序数组让你转为二叉搜索树题意就是从中序遍历构建一个二叉搜索树
     * 但是只通过中序遍历确定的二叉搜索树不唯一
     * @param nums
     * @param lo
     * @param hi
     * @return
     */
    public TreeNode DFS(int[] nums,int lo,int hi){
        // base case 当左指针大于右指针，则代表中间没有元素
        if(lo>hi){
            return null;
        }
        // 找到中间值
        int mid=(hi-lo)/2+lo;
        // 根节点为中间值
        TreeNode root=new TreeNode(nums[mid]);
        // 深搜数组左侧
        // 从此会去找左子树，进入递归后，又会把左侧当成一个新的树构建，但是最后会返回到root.left上
        root.left=DFS(nums,lo,mid-1);
        // 深搜数组右侧
        // 从此会去找右子树，进入递归后，又会把右侧当成一个新的树构建，但是最后会返回到root.right上
        root.right=DFS(nums,mid+1,hi);
        // 返回根节点
        return root;
    }
}
