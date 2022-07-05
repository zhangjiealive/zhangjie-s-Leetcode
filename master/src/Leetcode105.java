//: Leetcode105.java

import java.util.HashMap;

/** 力扣105题从前序与中序遍历序列构造二叉树 https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode105 {
    HashMap<Integer, Integer> map;

    /**
     * 通过前序和中序构建二叉树
     * 难点：寻找每个子树的边界
     * 关联106，654，889
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        int n=inorder.length;
        // 因为使用for找下标效率低，而题目给出提示，元素不重复，所以用map存下标值
        for (int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return buildTreeHelp(preorder,0, n-1, inorder,0, n-1);
    }
    public TreeNode buildTreeHelp(int[] preorder,int preStart,int preEnd, int[] inorder,int inStart,int inEnd) {
        // 如果前序的起点比终点大代表区间没有元素
        if(preStart>preEnd){
            return null;
        }
        // 前序的根节点就是第一个
        int rootVal=preorder[preStart];
        // 找在中序中根节点的下标
        int index=map.get(rootVal);
        // 从而得到左子树的元素个数
        int leftBound=index-inStart;

        TreeNode treeNode=new TreeNode(rootVal);
        // 再将左子树递归执行（注意区间划分）
        treeNode.left=buildTreeHelp(preorder,preStart+1,preStart+leftBound,inorder,inStart,index-1);
        // 再将右子树递归执行
        treeNode.right=buildTreeHelp(preorder,preStart+leftBound+1,preEnd,inorder,index+1,inEnd);
        return treeNode;
    }
}
