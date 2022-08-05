/** 623. 在二叉树中增加一行 https://leetcode.cn/problems/add-one-row-to-tree/
 * @author zhangjie
 * @author www.zj0628.online
 * @version 1.0
 */
public class Leetcode623 {
    /**
     * 二叉树:DFS递归解法
     * 当满足条件是，进行建立节点插入操作
     * 注意，depth=2代表插在1下面，为1，代表插在0下面，就是根节点位置
     * @param root
     * @param val
     * @param depth
     * @return
     */
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        return addOneRowHelp(root,val,1,depth);
    }

    public TreeNode addOneRowHelp(TreeNode root, int val,int reality, int depth) {
        // 节点为空，直接返回null
        if(root==null){
            return null;
        }
        // 有一种情况，depth=1，代表要在根节点插入，只需建立一个节点，将根节点左子树即可
        if(depth==1){
            TreeNode treeNode = new TreeNode(val);
            treeNode.left=root;
            return treeNode;
        }
        // 其他情况，当当前深度等于需要插入的深度减一，建立两个节点，将此节点的左子树插到一个节点的左子树，将此节点的右子树插到另一个节点的右子树
        // 再将新建两个节点分别放进此节点的左右子树上
        if(reality==depth-1){
            TreeNode t1 = new TreeNode(val);
            TreeNode t2 = new TreeNode(val);
            t1.left=root.left;
            t2.right=root.right;
            root.left=t1;
            root.right=t2;
        }
        // DFS递归向下遍历
        else {
            root.left=addOneRowHelp(root.left,val,reality+1,depth);
            root.right=addOneRowHelp(root.right,val,reality+1,depth);
        }
        return root;
    }
}
