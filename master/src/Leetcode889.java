//: Leetcode889.java

import java.util.HashMap;

/** 力扣889. 根据前序和后序遍历构造二叉树 https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-postorder-traversal/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode889 {
    HashMap<Integer,Integer> map;
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        map=new HashMap<>();
        int n=preorder.length;
        // 将后序遍历的索引存入map
        for (int i = 0; i < n; i++) {
            map.put(postorder[i],i);
        }
        return constructFromPrePostHelp(preorder,0,n-1,postorder,0,n-1);
    }

    public TreeNode constructFromPrePostHelp(int[] preorder,int preStart,int preEnd, int[] postorder,int postStart,int postEnd) {
        if(preStart>preEnd){
            return null;
        }
        // 注意，这里与其他两种不同，因为后面要用到preStart+1,所以如果preStart==preEnd时，此时区间只有一个元素，preStart+1会异常
        // 而正好preStart==preEnd时只有一个元素，直接返回这个下标的元素的节点即可
        if(preStart==preEnd){
            return new TreeNode(preorder[preStart]);
        }
        int rootVal=preorder[preStart];
        int index=map.get(preorder[preStart+1]);
        //边界是从0到index，例如index为2，012有3个元素，所以+1
        int leftBound=index-postStart+1;
        TreeNode treeNode = new TreeNode(rootVal);
        treeNode.left=constructFromPrePostHelp(preorder,preStart+1,preStart+leftBound,postorder,postStart,index);
        treeNode.right=constructFromPrePostHelp(preorder,preStart+leftBound+1,preEnd,postorder,index+1,postEnd-1);
        return treeNode;
    }

    public static void main(String[] args) {
        Leetcode889 leetcode889 = new Leetcode889();
        int[] a=new int[]{1,2,4,5,3,6,7};
        int[] b=new int[]{4,5,2,6,7,3,1};
        leetcode889.constructFromPrePost(a,b);
    }
}
