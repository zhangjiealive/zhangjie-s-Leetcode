package likou;
//: Leetcode543.java

/** 力扣543题 https://leetcode.cn/problems/diameter-of-binary-tree/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode543 {
    int max=0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }

    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        else {
            int a=maxDepth(root.left);
            int b=maxDepth(root.right);
            int myMax=a+b;
            max=Math.max(myMax,max);
            return 1+Math.max(a,b);
        }
    }

    public static void main(String[] args) {
        Leetcode543 leetcode543 = new Leetcode543();
        TreeNode t5 = new TreeNode(5);
        TreeNode t4 = new TreeNode(4);
        TreeNode t3 = new TreeNode(3);
        TreeNode t2 = new TreeNode(2,t4,t5);
        TreeNode t1 = new TreeNode(1,t2,t3);
        leetcode543.diameterOfBinaryTree(t1);

    }
}
