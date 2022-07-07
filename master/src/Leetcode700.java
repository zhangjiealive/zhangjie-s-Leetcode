//: Leetcode700.java

/** 力扣700. 二叉搜索树中的搜索 https://leetcode.cn/problems/search-in-a-binary-search-tree/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode700 {
    /**
     * 利用二叉树中序遍历有序的规则
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBST(TreeNode root, int val) {
        searchBSTHelp1(root,val);
        return treeNode;
    }
    TreeNode treeNode=null;

    /**
     * 利用中序遍历遍历整个二叉树
     * @param root
     * @param val
     */
    public void searchBSTHelp(TreeNode root, int val) {
        if(root==null){
            return;
        }
        searchBSTHelp(root.left,val);
        if(root.val==val){
            treeNode=root;
            return;
        }
        searchBSTHelp(root.right,val);
    }

    /**
     * 通过val和root.val比较决定遍历左子树还是右子树
     * @param root
     * @param val
     */
    public void searchBSTHelp1(TreeNode root, int val) {
        if(root==null){
            return;
        }
        if(root.val==val){
            treeNode=root;
            return;
        }
        if(root.val>val){
            searchBSTHelp1(root.left,val);
        }
        if(root.val<val){
            searchBSTHelp1(root.right,val);
        }
    }
}
