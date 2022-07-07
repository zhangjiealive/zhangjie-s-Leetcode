//: Leetcode230.java

/** 力扣230.二叉搜索树中第K小的元素 https://leetcode.cn/problems/kth-smallest-element-in-a-bst/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode230 {
    /**
     * 二叉搜索树的中序遍历是有序的，递增，所以第一个数就是第1小
     * 使用一个全局变量进行计数，当i=k，将res==root.val，解决问题
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        kthSmallestHelp(root,k);
        return res;
    }
    int i=0;
    int res=Integer.MAX_VALUE;
    public void kthSmallestHelp(TreeNode root, int k) {
        if(root==null){
            return;
        }
        kthSmallestHelp(root.left,k);
        i++;
        if(i==k){
            res= root.val;
            return;
        }
        kthSmallestHelp(root.right,k);
    }
}
