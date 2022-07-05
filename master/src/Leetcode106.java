//: Leetcode106.java

import java.util.HashMap;

/** 力扣106. 从中序与后序遍历序列构造二叉树 https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode106 {
    HashMap<Integer,Integer> map;

    /**
     * 关联105，654，889
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n=inorder.length;
        map=new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        return buildTreeHelp(inorder,0, n-1,postorder,0,n-1 );
    }

    public TreeNode buildTreeHelp(int[] inorder,int inStart,int inEnd, int[] postorder,int postStart,int postEnd) {
        if(inStart>inEnd){
            return null;
        }
        int rootVal=postorder[postEnd];
        int index=map.get(rootVal);
        int leftBound=index-inStart;

        TreeNode treeNode=new TreeNode(rootVal);
        treeNode.left=buildTreeHelp(inorder,inStart,index-1,postorder,postStart,postStart+leftBound-1);
        treeNode.right=buildTreeHelp(inorder,index+1,inEnd,postorder,postStart+leftBound,postEnd-1);
        return treeNode;
    }
}
